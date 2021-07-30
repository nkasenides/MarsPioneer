package com.example.marspioneer.client;

import com.example.marspioneer.model.MPGameSession;
import com.example.marspioneer.model.MPPlayer;
import com.example.marspioneer.model.MPWorld;
import com.example.marspioneer.model.MPWorldSession;
import com.example.marspioneer.proto.MPEntityProto;
import com.example.marspioneer.proto.MPPartialStateProto;
import com.example.marspioneer.proto.MPTerrainCellProto;
import com.nkasenides.athlos.client.ServerlessGameClient;

public class DumpClient extends ServerlessGameClient<MPPartialStateProto, MPGameSession, MPWorldSession, MPPlayer, MPWorld, MPEntityProto, MPTerrainCellProto> {

    public DumpClient() {
    }

    @Override
    protected void onStart() {
        System.out.println("Started");
    }

    @Override
    protected void onStop() {
        System.out.println("Stopped");
    }

    public static void main(String[] args) {
        new DumpClient().start();
    }

}
