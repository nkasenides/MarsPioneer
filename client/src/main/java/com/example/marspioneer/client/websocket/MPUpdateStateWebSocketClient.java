//package com.example.marspioneer.client.websocket;
//
//import com.example.marspioneer.client.MPClient;
//import com.example.marspioneer.proto.UpdateStateResponse;
//import com.google.protobuf.InvalidProtocolBufferException;
//import com.neovisionaries.ws.client.WebSocketException;
//import com.raylabz.mocha.binary.client.BinaryWebSocketClient;
//
//import java.io.IOException;
//
////TODO - Abstract in framework
//public class MPUpdateStateWebSocketClient extends BinaryWebSocketClient {
//
//    MPClient client;
//
//    public MPUpdateStateWebSocketClient(MPClient client) throws IOException, WebSocketException {
//        super("ws://localhost:8080/api/state/update");
//        this.client = client;
//    }
//
//    @Override
//    public void onReceive(byte[] bytes) {
//        try {
//            UpdateStateResponse response = UpdateStateResponse.parseFrom(bytes);
//            if (response.getStatus() == UpdateStateResponse.Status.OK) {
//                System.out.println("State update received.");
//                client.getEntities().putAll(response.getPartialState().getEntitiesMap());
//                client.getStateCells().putAll(response.getPartialState().getCellsMap());
//                client.getGameCanvas().repaint();
//            }
//            else {
//                System.err.println(response.getMessage());
//            }
//        } catch (InvalidProtocolBufferException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
