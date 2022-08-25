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
//public class MaxStateExperiment {
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
//        new Thread(() -> {
//            for (int row = 151; row < 151+150; row++) {
//                for (int col = 151; col < 151+150; col++) {
//                    State.forWorld(world.getId()).requestChunk(row, col);
//                    chunksGenerated.set(chunksGenerated.get() + 1);
//                    System.out.println(chunksGenerated.get());
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
//
//        new Thread(() -> {
//            for (int row = -151; row >= -151-150; row--) {
//                for (int col = -151; col >= -151-150; col--) {
//                    State.forWorld(world.getId()).requestChunk(row, col);
//                    chunksGenerated.set(chunksGenerated.get() + 1);
//                    System.out.println(chunksGenerated.get());
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
//
//    }
//
//}
