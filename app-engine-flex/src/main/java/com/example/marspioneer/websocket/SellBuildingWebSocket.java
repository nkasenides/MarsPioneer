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
import com.example.marspioneer.persistence.DBManager;
import com.example.marspioneer.proto.*;
import com.example.marspioneer.state.State;
import com.example.marspioneer.state.StateUpdateBuilder;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

@WebSocket(maxIdleTime = -1)
public class SellBuildingWebSocket {

    private Session session;
    private final HttpServletRequest request;

    private static final ConcurrentHashMap<Session, String> CONNECTED_SESSIONS = new ConcurrentHashMap<>();

    public Session getSession() {
        return session;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public SellBuildingWebSocket(HttpServletRequest request) {
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
        SellBuildingRequest request = SellBuildingRequest.parseFrom(bytes);
        handleMessage(request);
    }

    /**
     * Handles a request.
     * @param request The incoming request.
     */
    public void handleMessage(SellBuildingRequest request) throws IOException {

        //Retrieve the session:
        final MPWorldSession worldSession = DBManager.worldSession.get(request.getWorldSessionID());

        //Verify session:

        if (worldSession == null) {
            send(SellBuildingResponse.newBuilder()
                    .setStatus(SellBuildingResponse.Status.CANNOT_SELL)
                    .setMessage("INVALID_WORLD_SESSION")
                    .build());
            return;
        }

        final MPPlayer player = Auth.verifyWorldSessionID(worldSession.getId());
        if (player == null) {
            send(SellBuildingResponse.newBuilder()
                    .setStatus(SellBuildingResponse.Status.CANNOT_SELL)
                    .setMessage("NOT_AUTHORIZED")
                    .build());
            return;
        }


        //Retrieve the building:
        final BuildingEntity building = DBManager.buildingEntity.get(request.getBuildingID());
        if (building == null) {
            send(SellBuildingResponse.newBuilder()
                    .setStatus(SellBuildingResponse.Status.CANNOT_SELL)
                    .setMessage("NO_BUILDING_HERE")
                    .build());
            return;
        }

        //Check if current player is the owner:
        if (!building.getPlayerID().equals(player.getId())) {
            send(SellBuildingResponse.newBuilder()
                    .setStatus(SellBuildingResponse.Status.CANNOT_SELL)
                    .setMessage("NOT_AN_OWNER")
                    .build());
            return;
        }

        //Give the player 50% of the building's build resources:
        int foodGain = 0;
        int waterGain = 0;
        int sandGain = 0;
        int metalGain = 0;

        switch (building.getBuildingType()) {
            case HUB_EBuildingType:
                foodGain = BuildingType.HUB.getFoodCost() / 2;
                waterGain = BuildingType.HUB.getWaterCost() / 2;
                sandGain = BuildingType.HUB.getSandCost() / 2;
                metalGain = BuildingType.HUB.getMetalCost() / 2;
                break;
            case FARM_EBuildingType:
                foodGain = BuildingType.FARM.getFoodCost() / 2;
                waterGain = BuildingType.FARM.getWaterCost() / 2;
                sandGain = BuildingType.FARM.getSandCost() / 2;
                metalGain = BuildingType.FARM.getMetalCost() / 2;
                break;
            case WELL_EBuildingType:
                foodGain = BuildingType.WELL.getFoodCost() / 2;
                waterGain = BuildingType.WELL.getWaterCost() / 2;
                sandGain = BuildingType.WELL.getSandCost() / 2;
                metalGain = BuildingType.WELL.getMetalCost() / 2;
                break;
            case MINE_EBuildingType:
                foodGain = BuildingType.MINE.getFoodCost() / 2;
                waterGain = BuildingType.MINE.getWaterCost() / 2;
                sandGain = BuildingType.MINE.getSandCost() / 2;
                metalGain = BuildingType.MINE.getMetalCost() / 2;
                break;
            case SAND_PIT_EBuildingType:
                foodGain = BuildingType.SAND_PIT.getFoodCost() / 2;
                waterGain = BuildingType.SAND_PIT.getWaterCost() / 2;
                sandGain = BuildingType.SAND_PIT.getSandCost() / 2;
                metalGain = BuildingType.SAND_PIT.getMetalCost() / 2;
                break;
            case UNRECOGNIZED:
                break;
        }

        player.setFood(player.getFood() + foodGain);
        player.setWater(player.getWater() + waterGain);
        player.setSand(player.getSand() + sandGain);
        player.setMetal(player.getMetal() + metalGain);

        //Sell the building:
        DBManager.buildingEntity.delete(building);
        DBManager.player.update(player);

        send(SellBuildingResponse.newBuilder()
                .setStatus(SellBuildingResponse.Status.OK)
                .setMessage("OK")
                .build());

        //Define and send the state update:
        final StateUpdateBuilder stateUpdateBuilder = StateUpdateBuilder.create().addUpdatedEntity(building);
        State.sendUpdate(worldSession, stateUpdateBuilder, worldSession.getWorldID(), building.getPosition(), 10, false, false);

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
    private void sendAndWait(SellBuildingResponse response) throws IOException {
        session.getRemote().sendBytes(ByteBuffer.wrap(response.toByteArray()));
    }

    /**
     * Sends a message to the requester and continues without waiting.
     * @param response The response to send.
     * @throws IOException when data cannot be converted into bytes.
     */
    private Future<Void> send(SellBuildingResponse response) throws IOException {
        return session.getRemote().sendBytesByFuture(ByteBuffer.wrap(response.toByteArray()));
    }

    /**
     * Sends a message to an arbitrary session and continues without waiting.
     * @param response The response to send.
     * @throws IOException when data cannot be converted into bytes.
     */
    private void send(Session session, SellBuildingResponse response) throws IOException {
        session.getRemote().sendBytes(ByteBuffer.wrap(response.toByteArray()));
    }

    /**
     * Sends a message to an arbitrary session and waits for the message to be sent.
     * @param response The response to send.
     * @throws IOException when data cannot be converted into bytes.
     */
    private Future<Void> sendAndWait(Session session, SellBuildingResponse response) throws IOException {
        return session.getRemote().sendBytesByFuture(ByteBuffer.wrap(response.toByteArray()));
    }

    /**
     * Sends a message to a collection of sessions and continues without waiting.
     * @param response The response to send.
     * @throws IOException when data cannot be converted into bytes.
     */
    private void send(Collection<Session> sessions, SellBuildingResponse response) throws IOException {
        for (Session session : sessions) {
            session.getRemote().sendBytes(ByteBuffer.wrap(response.toByteArray()));
        }
    }

    /**
     * Sends a message to a collection of sessions and waits for the message to be sent.
     * @param response The response to send.
     * @throws IOException when data cannot be converted into bytes.
     */
    private void sendAndWait(Collection<Session> sessions, SellBuildingResponse response) throws IOException {
        for (Session session : sessions) {
            session.getRemote().sendBytesByFuture(ByteBuffer.wrap(response.toByteArray()));
        }
    }

}


