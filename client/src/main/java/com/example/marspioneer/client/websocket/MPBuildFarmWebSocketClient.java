//package com.example.marspioneer.client.websocket;
//
//import com.example.marspioneer.client.MPClient;
//import com.example.marspioneer.proto.BuildResponse;
//import com.google.protobuf.InvalidProtocolBufferException;
//import com.neovisionaries.ws.client.WebSocketException;
//import com.raylabz.mocha.binary.client.BinaryWebSocketClient;
//
//import java.io.IOException;
//
////TODO - Abstract in framework
//public class MPBuildFarmWebSocketClient extends BinaryWebSocketClient {
//
//    MPClient client;
//
//    public MPBuildFarmWebSocketClient(MPClient client) throws IOException, WebSocketException {
//        super("ws://localhost:8080/api/action/buildFarm");
//        this.client = client;
//    }
//
//    @Override
//    public void onReceive(byte[] bytes) {
//        try {
//            BuildResponse response = BuildResponse.parseFrom(bytes);
//            handleResponse(response);
//        } catch (InvalidProtocolBufferException e) {
//            e.printStackTrace();
//            //TODO - Handle exception
//        }
//    }
//
//    public void handleResponse(BuildResponse response) {
//        //TODO - Implement handling of the response.
//        if (response.getStatus() == BuildResponse.Status.OK) {
//            System.out.println("Farm built by " + client.getWorldSessionID());
//        }
//        else {
//            System.err.println(response.getMessage());
//        }
//    }
//
//}
