/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Project Editor, v1.0 BETA
-------------------------------------------------------------------------------- */

package com.example.marspioneer.client.websocket;

import com.example.marspioneer.client.Benchmarking;
import com.example.marspioneer.client.MPClient;
import com.example.marspioneer.model.MPTerrainCell;
import com.example.marspioneer.proto.MPEntityProto;
import com.example.marspioneer.proto.MPTerrainCellProto;
import com.example.marspioneer.proto.UpdateStateResponse;
import com.google.protobuf.InvalidProtocolBufferException;
import com.neovisionaries.ws.client.WebSocketException;
import com.raylabz.mocha.binary.client.BinaryWebSocketClient;

import java.io.IOException;
import java.util.Map;

public class UpdateStateStub extends BinaryWebSocketClient {

    private MPClient client;

    public UpdateStateStub(MPClient client) throws IOException, WebSocketException {
        super("ws://localhost:8080/api/state/update");
        this.client = client;
    }

    @Override
    public void onReceive(byte[] bytes) {
        try {
            UpdateStateResponse response = UpdateStateResponse.parseFrom(bytes);
            handleResponse(response);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }
    
    public void handleResponse(UpdateStateResponse response) {
        Benchmarking.actionFinishedTime = System.currentTimeMillis();
//        System.out.println("Action latency: " + (Benchmarking.actionFinishedTime - Benchmarking.actionInitiatedTime) + "ms");
        if (response.getStatus() == UpdateStateResponse.Status.OK) {
            System.out.println(client.getPlayer().getName() + ": State update received.");

            client.setPlayerResourceSet(response.getResourceSet().toObject());

            for (MPEntityProto value : response.getStateUpdate().getNewEntitiesMap().values()) {
                client.getEntities().put(value.getId(), value);
            }

            for (MPEntityProto value : response.getStateUpdate().getUpdatedEntitiesMap().values()) {
                client.getEntities().put(value.getId(), value);
            }

            for (String entityID : response.getStateUpdate().getRemovedEntitiesList()) {
                client.getEntities().remove(entityID);
            }

            for (MPTerrainCellProto value : response.getStateUpdate().getNewTerrainCellsMap().values()) {
                client.getTerrain().put(value.getPosition().toHash(), value);
            }

            for (MPTerrainCellProto value : response.getStateUpdate().getUpdatedTerrainCellsMap().values()) {
                client.getTerrain().put(value.getPosition().toHash(), value);
            }

            for (String entityID : response.getStateUpdate().getRemovedTerrainCellsList()) {
                client.getTerrain().remove(entityID);
            }

            client.getGameCanvas().repaint();
        } else {
            System.err.println(response.getMessage());
        }
    }

}

