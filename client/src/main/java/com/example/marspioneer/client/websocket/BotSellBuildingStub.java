/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Project Editor, v1.0 BETA
-------------------------------------------------------------------------------- */

package com.example.marspioneer.client.websocket;

import com.example.marspioneer.client.MPClient;
import com.example.marspioneer.client.simulation.Bot;
import com.example.marspioneer.proto.SellBuildingResponse;
import com.google.protobuf.InvalidProtocolBufferException;
import com.neovisionaries.ws.client.WebSocketException;
import com.raylabz.mocha.binary.client.BinaryWebSocketClient;

import java.io.IOException;

public class BotSellBuildingStub extends BinaryWebSocketClient {

    private Bot bot;

    public BotSellBuildingStub(Bot bot) throws IOException, WebSocketException {
        super("ws://localhost:8080/api/action/sellBuilding");
        this.bot = bot;
    }

    @Override
    public void onReceive(byte[] bytes) {
        try {
            SellBuildingResponse response = SellBuildingResponse.parseFrom(bytes);
            handleResponse(response);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
            bot.getCanvas().showMessage(e.getMessage());
        }
    }
    
    public void handleResponse(SellBuildingResponse response) {
        if (response.getStatus() == SellBuildingResponse.Status.OK) {
            System.out.println("Building sold by " + bot.getWorldSession().getId());
        } else {
            bot.getCanvas().showMessage(response.getMessage());
            System.err.println(response.getMessage());
        }
    }

}
