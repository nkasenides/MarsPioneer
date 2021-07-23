/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Project Editor, v1.0 BETA
-------------------------------------------------------------------------------- */

package com.example.marspioneer.websocket;

import com.example.marspioneer.proto.*;
import com.example.marspioneer.model.*;
import com.example.marspioneer.persistence.DBManager;
import com.example.marspioneer.state.State;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

@WebSocket(maxIdleTime = -1)
public class UpdateStateWebSocket {

    private Session session;
    private String worldSessionID;
    private final HttpServletRequest request;

    private static final ConcurrentHashMap<String, Session> CONNECTED_SESSIONS = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, UpdateStateWebSocket> SOCKET_INSTANCES = new ConcurrentHashMap<>();

    public Session getSession() {
        return session;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public String getWorldSessionID() {
        return worldSessionID;
    }

    public UpdateStateWebSocket(HttpServletRequest request) {
        this.request = request;
    }

    @OnWebSocketConnect
    public void onConnect(Session session) {
        this.session = session;
        session.setIdleTimeout(-1);
    }

    @OnWebSocketMessage
    public void onMessage(byte[] bytes, int offset, int length) throws IOException {
        UpdateStateRequest request = UpdateStateRequest.parseFrom(bytes);
        handleMessage(request);
    }

    /**
     * Handles a request.
     * @param request The incoming request.
     */
    public void handleMessage(UpdateStateRequest request) throws IOException {
        this.worldSessionID = request.getWorldSessionID();
        CONNECTED_SESSIONS.put(request.getWorldSessionID(), session);
        SOCKET_INSTANCES.put(request.getWorldSessionID(), this);
    }

    /**
     * Runs a <b>lightweight</b> state update across sessions that should be receiving this update, based on the filtering function defined in State.filterUpdateSessions().
     * The state sent to the client will contain only what is defined in parameter <i>stateUpdate</i>, as defined by the caller of this method.
     * Use this method to <b>update</b> the existing states of clients. To refresh the entire client state, use <i>sendRefresh()</i> instead.
     * @param worldSession The world session initiating the state update.
     * @param actionPosition The position of the action that initiated the state update.
     * @param areaOfEffect The area of effect (AoE) of the action that initiated the state update.
     * @throws IOException thrown when the message cannot be sent via the socket.
     */
    public static void sendUpdate(final MPWorldSession worldSession, MPStateUpdateProto stateUpdate, final MatrixPosition actionPosition, final float areaOfEffect) throws IOException {
        final Collection<MPWorldSession> allSessions = State.forWorld(worldSession.getWorldID()).getSubscribedSessions();
        final Collection<MPWorldSession> sessionsToUpdate = State.filterUpdateSessions(allSessions, actionPosition, areaOfEffect);
        for (MPWorldSession session : sessionsToUpdate) {
            final Session socketSession = CONNECTED_SESSIONS.get(session.getId());
            final UpdateStateWebSocket socket = SOCKET_INSTANCES.get(session.getId());
            final UpdateStateResponse response = UpdateStateResponse.newBuilder()
                    .setStatus(UpdateStateResponse.Status.OK)
                    .setMessage("OK")
                    .setStateUpdate(stateUpdate)
                    .build();
            socket.send(socketSession, response);
        }
    }

    /**
     * Broadcasts a state update to all subscribed sessions.
     * @param worldSession The world session initiating the state update.
     * @param stateUpdate The state update.
     * @throws IOException thrown when the message cannot be sent via the socket.
     */
    public static void broadcastUpdate(final MPWorldSession worldSession, final MPStateUpdateProto stateUpdate) throws IOException {
        final Collection<MPWorldSession> allSessions = State.forWorld(worldSession.getWorldID()).getSubscribedSessions();
        for (MPWorldSession session : allSessions) {
            final Session socketSession = CONNECTED_SESSIONS.get(session.getId());
            final UpdateStateWebSocket socket = SOCKET_INSTANCES.get(session.getId());
            final UpdateStateResponse response = UpdateStateResponse.newBuilder()
                    .setStatus(UpdateStateResponse.Status.OK)
                    .setMessage("OK")
                    .setStateUpdate(stateUpdate)
                    .build();
            socket.send(socketSession, response);
        }
    }

    /**
     * Multicasts a state update to the provided sessions.
     * @param worldSession The world session initiating the state update.
     * @param stateUpdate The state update.
     * @param worldSessionIDs The IDs of the sessions to receive the state updates.
     * @throws IOException thrown when the message cannot be sent via the socket.
     */
    public static void multicastUpdate(final MPWorldSession worldSession, final MPStateUpdateProto stateUpdate, Collection<String> worldSessionIDs) throws IOException {
        final Collection<MPWorldSession> allSessions = State.forWorld(worldSession.getWorldID()).getSubscribedSessions();
        for (MPWorldSession session : allSessions) {
            if (worldSessionIDs.contains(session.getId())) {
                final Session socketSession = CONNECTED_SESSIONS.get(session.getId());
                final UpdateStateWebSocket socket = SOCKET_INSTANCES.get(session.getId());
                final UpdateStateResponse response = UpdateStateResponse.newBuilder()
                        .setStatus(UpdateStateResponse.Status.OK)
                        .setMessage("OK")
                        .setStateUpdate(stateUpdate)
                        .build();
                socket.send(socketSession, response);
            }
        }
    }

    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {
        CONNECTED_SESSIONS.remove(worldSessionID);
        SOCKET_INSTANCES.remove(worldSessionID);
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
    private void sendAndWait(UpdateStateResponse response) throws IOException {
        session.getRemote().sendBytes(ByteBuffer.wrap(response.toByteArray()));
    }

    /**
     * Sends a message to the requester and continues without waiting.
     * @param response The response to send.
     * @throws IOException when data cannot be converted into bytes.
     */
    private Future<Void> send(UpdateStateResponse response) throws IOException {
        return session.getRemote().sendBytesByFuture(ByteBuffer.wrap(response.toByteArray()));
    }

    /**
     * Sends a message to an arbitrary session and continues without waiting.
     * @param response The response to send.
     * @throws IOException when data cannot be converted into bytes.
     */
    private void send(Session session, UpdateStateResponse response) throws IOException {
        session.getRemote().sendBytes(ByteBuffer.wrap(response.toByteArray()));
    }

    /**
     * Sends a message to an arbitrary session and waits for the message to be sent.
     * @param response The response to send.
     * @throws IOException when data cannot be converted into bytes.
     */
    private Future<Void> sendAndWait(Session session, UpdateStateResponse response) throws IOException {
        return session.getRemote().sendBytesByFuture(ByteBuffer.wrap(response.toByteArray()));
    }

    /**
     * Sends a message to a collection of sessions and continues without waiting.
     * @param response The response to send.
     * @throws IOException when data cannot be converted into bytes.
     */
    private void send(Collection<Session> sessions, UpdateStateResponse response) throws IOException {
        for (Session session : sessions) {
            session.getRemote().sendBytes(ByteBuffer.wrap(response.toByteArray()));
        }
    }

    /**
     * Sends a message to a collection of sessions and waits for the message to be sent.
     * @param response The response to send.
     * @throws IOException when data cannot be converted into bytes.
     */
    private void sendAndWait(Collection<Session> sessions, UpdateStateResponse response) throws IOException {
        for (Session session : sessions) {
            session.getRemote().sendBytesByFuture(ByteBuffer.wrap(response.toByteArray()));
        }
    }

}


