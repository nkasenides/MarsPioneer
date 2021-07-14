package com.example.marspioneer.client.ui;

import com.example.marspioneer.client.MPClient;
import com.example.marspioneer.model.MPWorld;
import com.example.marspioneer.model.MatrixPosition;
import com.neovisionaries.ws.client.WebSocketException;

import java.io.IOException;

public class ClientTest {

    public static void main(String[] args) throws WebSocketException, IOException {

        MPWorld world = new MPWorld();
        world.setId("world");
        world.setName("world");
        world.setOwnerID("abcd");
        world.setSeed(1234);
        MPClient client = new MPClient("p1", world.getId());
        client.setCameraPosition(new MatrixPosition(0, 0));
        client.setWorld(world.toProto().build());

        MPCanvas canvas = new MPCanvas(client);
        new MPGameForm(client, canvas);
    }

}
