//package com.example.marspioneer;
//
//import com.example.marspioneer.model.*;
//import com.example.marspioneer.persistence.DBManager;
//import com.example.marspioneer.state.State;
//import com.raylabz.firestorm.Firestorm;
//import com.raylabz.firestorm.util.FirebaseUtils;
//import com.raylabz.objectis.Objectis;
//import com.raylabz.objectis.exception.ClassRegistrationException;
//
//import java.io.IOException;
//import java.util.concurrent.atomic.AtomicInteger;
//
//public class StateRetrievalTimeExperiment {
//
//    private static final AtomicInteger chunksGenerated = new AtomicInteger(0);
//
//    public static void main(String[] args) throws ClassRegistrationException {
//        //Init Firestore:
//
//        try {
//            FirebaseUtils.initialize(SERVICE_ACCOUNT);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Firestorm.init();
//
//        Firestorm.register(BuildingEntity.class);
//        Firestorm.register(MPGameSession.class);
//        Firestorm.register(MPWorld.class);
//        Firestorm.register(MPWorldSession.class);
//        Firestorm.register(MPTeam.class);
//        Firestorm.register(MPPlayer.class);
//        Firestorm.register(MPTerrainChunk.class);
//        Firestorm.register(MPTerrainIdentifier.class);
//
//        Objectis.init();
//        Objectis.register(BuildingEntity.class);
//        Objectis.register(MPGameSession.class);
//        Objectis.register(MPWorld.class);
//        Objectis.register(MPWorldSession.class);
//        Objectis.register(MPTeam.class);
//        Objectis.register(MPPlayer.class);
//        Objectis.register(MPTerrainChunk.class);
//        Objectis.register(MPTerrainIdentifier.class);
//
//        MPWorld world = new MPWorld();
//        world.setMaxCols(-1);
//        world.setMaxRows(-1);
//        world.setSeed(1234);
//        world.setName("myWorld");
//        world.setHeightLimit(-1);
//        world.setCreatedOn(System.currentTimeMillis());
//        world.setId("myWorld");
//        DBManager.world.create(world);
//
//        //Generate:
////        for (int i = 512; i <= 1023; i++) {
////            State.forWorld(world.getId()).requestChunk(0, i);
////        }
//
//
//        //Retrieve:
//        final long t = System.currentTimeMillis();
//        final MPTerrainChunk chunk = State.forWorld(world.getId()).requestChunk(0, 0);
//        System.out.println("Time taken: " + (System.currentTimeMillis() - t) + "ms");
//
//        System.out.println(chunk.getPosition().getRow() + " " + chunk.getPosition().getRow());
//
//    }
//
//}
