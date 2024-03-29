/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Project Editor, v1.0 BETA
-------------------------------------------------------------------------------- */

package com.example.marspioneer.client.websocket;

import com.example.marspioneer.client.Benchmarking;
import com.example.marspioneer.client.MPClient;
import com.example.marspioneer.client.simulation.Bot;
import com.example.marspioneer.proto.MPEntityProto;
import com.example.marspioneer.proto.MPTerrainCellProto;
import com.example.marspioneer.proto.UpdateStateResponse;
import com.google.protobuf.InvalidProtocolBufferException;
import com.neovisionaries.ws.client.WebSocketException;
import com.raylabz.mocha.binary.client.BinaryWebSocketClient;

import java.io.IOException;
import java.util.Map;

public class BotUpdateStateStub extends BinaryWebSocketClient {

    private Bot bot;

    public BotUpdateStateStub(Bot bot) throws IOException, WebSocketException {
        super("ws://localhost:8080/api/state/update");
        this.bot = bot;
    }

    @Override
    public void onReceive(byte[] bytes) {

        long latency = System.currentTimeMillis() - bot.getLastSendTime();
        bot.getStateUpdateLatencies().add(latency);
        System.out.println("~~ Egress network: " + latency);

        try {
            long t = System.currentTimeMillis();
            UpdateStateResponse response = UpdateStateResponse.parseFrom(bytes);
            System.out.println("~~ De-serialization: " + (System.currentTimeMillis() - t));
            handleResponse(response);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }
    
    public void handleResponse(UpdateStateResponse response) {

        if (response.getStatus() == UpdateStateResponse.Status.OK) {
//            System.out.println("[" + bot.getBotName() + "] State update received.");

            for (Map.Entry<String, MPTerrainCellProto> entry : response.getStateUpdate().getPartialState().getTerrainMap().entrySet()) {
                bot.getTerrain().put(entry.getKey(), entry.getValue());
            }

            for (Map.Entry<String, MPEntityProto> entry : response.getStateUpdate().getPartialState().getEntitiesMap().entrySet()) {
                bot.getEntities().put(entry.getKey(), entry.getValue());
            }

            bot.setResourceSet(response.getStateUpdate().getPartialState().getResourceSet().toObject());

            for (MPEntityProto value : response.getStateUpdate().getPartialState().getEntitiesMap().values()) {
                bot.getEntities().put(value.getId(), value);
            }

            for (String entityID : response.getStateUpdate().getRemovedEntitiesList()) {
                bot.getEntities().remove(entityID);
            }

            for (MPTerrainCellProto value : response.getStateUpdate().getPartialState().getTerrainMap().values()) {
                bot.getTerrain().put(value.getPosition().toHash(), value);
            }

            for (String terrainHash : response.getStateUpdate().getRemovedTerrainList()) {
                bot.getTerrain().remove(terrainHash);
            }

//            bot.getCanvas().repaint();

        } else {
//            System.err.println(response.getMessage());
        }
    }

}

