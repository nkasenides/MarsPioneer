/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Project Editor, v1.0 BETA
-------------------------------------------------------------------------------- */

package com.example.marspioneer.websocket;

import com.example.marspioneer.auth.Auth;
import com.example.marspioneer.model.BuildingEntity;
import com.example.marspioneer.model.BuildingType;
import com.example.marspioneer.model.MPPlayer;
import com.example.marspioneer.model.MPWorldSession;
import com.example.marspioneer.persistence.Cache;
import com.example.marspioneer.persistence.DBManager;
import com.example.marspioneer.proto.*;
import com.example.marspioneer.state.State;
import com.google.protobuf.InvalidProtocolBufferException;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

@WebSocket(maxIdleTime = -1)
public class BuildSandPitWebSocket {

    private Session session;
    private final HttpServletRequest request;

    private static final ConcurrentHashMap<Session, String> CONNECTED_SESSIONS = new ConcurrentHashMap<>();

    public Session getSession() {
        return session;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public BuildSandPitWebSocket(HttpServletRequest request) {
        this.request = request;
    }

    @OnWebSocketConnect
    public void onConnect(Session session) {
        this.session = session;
        session.setIdleTimeout(-1);
        CONNECTED_SESSIONS.put(session, "");
    }

    @OnWebSocketMessage
    public void onMessage(byte[] bytes, int offset, int length) throws IOException {
        BuildSandPitRequest request = BuildSandPitRequest.parseFrom(bytes);
        handleMessage(request);
    }

    /**
     * Handles a request.
     * @param request The incoming request.
     */
    public void handleMessage(BuildSandPitRequest request) throws IOException {
        //Retrieve the session:
        final MPWorldSession worldSession = DBManager.worldSession.get(request.getWorldSessionID());

        //Verify session:

        if (worldSession == null) {
            send(BuildResponse.newBuilder()
                    .setStatus(BuildResponse.Status.INVALID_WORLD_SESSION)
                    .setMessage("INVALID_WORLD_SESSION")
                    .build());
            return;
        }

        final MPPlayer player = Auth.verifyWorldSessionID(worldSession.getId());
        if (player == null) {
            send(BuildResponse.newBuilder()
                    .setStatus(BuildResponse.Status.CANNOT_BUILD)
                    .setMessage("NOT_AUTHORIZED")
                    .build());
            return;
        }

        //+++++++++++++ Resource rules ++++++++++++++
        //Check resources:
        if (player.getSand() < BuildingType.SAND_PIT.getSandCost() ||
                player.getFood() < BuildingType.SAND_PIT.getFoodCost() ||
                player.getWater() < BuildingType.SAND_PIT.getWaterCost() ||
                player.getMetal() < BuildingType.SAND_PIT.getMetalCost()) {
            send(BuildResponse.newBuilder()
                    .setStatus(BuildResponse.Status.INSUFFICIENT_FUNDS)
                    .setMessage("NOT_ENOUGH_RESOURCES")
                    .build());
            return;
        }

        //+++++++++++++ Terrain-building rules: ++++++++++++++
        final Map<String, MPTerrainCellProto> terrain = State.forWorld(worldSession.getWorldID(), Cache.getJedis(getRequest())).getTerrain(request.getPosition().toObject(), 10);

        //Cannot build anything on lava:
        final MPTerrainCellProto cell = terrain.get(State.identify(request.getPosition()));
        if (cell.getType() == CellType.LAVA_CellType) {
            send(BuildResponse.newBuilder()
                    .setStatus(BuildResponse.Status.CANNOT_BUILD)
                    .setMessage("CANNOT_BUILD_ON_LAVA")
                    .build());
            return;
        }

        //Can build sand pit only on sand:
        if (cell.getType() != CellType.SAND_CellType) {
            send(BuildResponse.newBuilder()
                    .setStatus(BuildResponse.Status.CANNOT_BUILD)
                    .setMessage("CANNOT_BUILD")
                    .build());
            return;
        }

        //Cannot build too far away from a hub:
        final Collection<BuildingEntity> playerBuildings = DBManager.buildingEntity.listForPlayerAndWorld(worldSession.getWorldID(), player.getId());
        boolean hubWithinDistance = false;
        for (BuildingEntity e : playerBuildings) {
            if (e.getBuildingType() == EBuildingType.HUB_EBuildingType) {
                double distance = e.getPosition().distanceTo(request.getPosition().toObject());
                if (distance <= 20) {
                    hubWithinDistance = true;
                }
            }
        }

        if (!hubWithinDistance) {
            send(BuildResponse.newBuilder()
                    .setStatus(BuildResponse.Status.CANNOT_BUILD)
                    .setMessage("TOO_FAR_FROM_HUB")
                    .build());
            return;
        }

        //Cannot build on a cell that already has a building:
        final Collection<BuildingEntity> allBuildings = DBManager.buildingEntity.listForWorld(worldSession.getWorldID());
        for (BuildingEntity e : allBuildings) {
            if (e.getPosition().equals(request.getPosition().toObject())) {
                send(BuildResponse.newBuilder()
                        .setStatus(BuildResponse.Status.CANNOT_BUILD)
                        .setMessage("BUILDING_EXISTS")
                        .build());
                return;
            }
        }

        //Cannot build if prerequisite buildings are not owned:
        final ArrayList<EBuildingType> prerequisites = BuildingType.SAND_PIT.getPrerequisites();
        for (EBuildingType prerequisiteType : prerequisites) {
            boolean owned = false;
            for (BuildingEntity e : playerBuildings) {
                if (e.getBuildingType() == prerequisiteType) {
                    owned = true;
                    break;
                }
            }
            if (!owned) {
                send(BuildResponse.newBuilder()
                        .setStatus(BuildResponse.Status.CANNOT_BUILD)
                        .setMessage("PREREQUISITE_MISSING")
                        .build());
                return;
            }
        }

        //Deduct resources:
        player.setFood(player.getFood() - BuildingType.SAND_PIT.getFoodCost());
        player.setWater(player.getWater() - BuildingType.SAND_PIT.getWaterCost());
        player.setSand(player.getSand() - BuildingType.SAND_PIT.getSandCost());
        player.setMetal(player.getMetal() - BuildingType.SAND_PIT.getMetalCost());

        //Create building:
        BuildingEntity building = new BuildingEntity();
        building.setDirection(Direction4.NORTH);
        building.setBuildingType(EBuildingType.SAND_PIT_EBuildingType);
        building.setAreaOfInterest(BuildingType.SAND_PIT.getAreaOfInterest());
        building.setPosition(request.getPosition().toObject());
        building.setPlayerID(player.getId());
        building.setWorldID(worldSession.getWorldID());

        DBManager.buildingEntity.create(building);
        DBManager.player.update(player);

        send(BuildResponse.newBuilder()
                .setStatus(BuildResponse.Status.OK)
                .setMessage("OK")
                .build());

        UpdateStateWebSocket.filteredUpdate(worldSession, building.getPosition(), 20, Cache.getJedis(getRequest()), player);

    }

    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {
        CONNECTED_SESSIONS.remove(session);
    }

    @OnWebSocketError
    public void onError(Throwable cause) {
        //TODO - Handle the error
        System.err.println("WebSocket error -> " + cause);
        cause.printStackTrace();
    }

    /**
     * Sends a message to the requester and waits for the message to be sent.
     * @param response The response to send.
     * @throws IOException when data cannot be converted into bytes.
     */
    private void sendAndWait(BuildResponse response) throws IOException {
        session.getRemote().sendBytes(ByteBuffer.wrap(response.toByteArray()));
    }

    /**
     * Sends a message to the requester and continues without waiting.
     * @param response The response to send.
     * @throws IOException when data cannot be converted into bytes.
     */
    private Future<Void> send(BuildResponse response) throws IOException {
        return session.getRemote().sendBytesByFuture(ByteBuffer.wrap(response.toByteArray()));
    }

    /**
     * Sends a message to an arbitrary session and continues without waiting.
     * @param response The response to send.
     * @throws IOException when data cannot be converted into bytes.
     */
    private void send(Session session, BuildResponse response) throws IOException {
        session.getRemote().sendBytes(ByteBuffer.wrap(response.toByteArray()));
    }

    /**
     * Sends a message to an arbitrary session and waits for the message to be sent.
     * @param response The response to send.
     * @throws IOException when data cannot be converted into bytes.
     */
    private Future<Void> sendAndWait(Session session, BuildResponse response) throws IOException {
        return session.getRemote().sendBytesByFuture(ByteBuffer.wrap(response.toByteArray()));
    }

    /**
     * Sends a message to a collection of sessions and continues without waiting.
     * @param response The response to send.
     * @throws IOException when data cannot be converted into bytes.
     */
    private void send(Collection<Session> sessions, BuildResponse response) throws IOException {
        for (Session session : sessions) {
            session.getRemote().sendBytes(ByteBuffer.wrap(response.toByteArray()));
        }
    }

    /**
     * Sends a message to a collection of sessions and waits for the message to be sent.
     * @param response The response to send.
     * @throws IOException when data cannot be converted into bytes.
     */
    private void sendAndWait(Collection<Session> sessions, BuildResponse response) throws IOException {
        for (Session session : sessions) {
            session.getRemote().sendBytesByFuture(ByteBuffer.wrap(response.toByteArray()));
        }
    }

}


