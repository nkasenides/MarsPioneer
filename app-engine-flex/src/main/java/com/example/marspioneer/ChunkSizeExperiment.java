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
//import java.util.HashSet;
//import java.util.Vector;
//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.concurrent.atomic.AtomicLongArray;
//
//public class ChunkSizeExperiment {
//
//    private static final HashSet<MatrixPosition> chunkQueries = new HashSet<>();
//    private static final Vector<Long> latencies = new Vector<>();
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
//        world.setName("myWorld2");
//        world.setHeightLimit(-1);
//        world.setCreatedOn(System.currentTimeMillis());
//        world.setId("myWorld2");
//        DBManager.world.create(world);
//
//        //Generate:
////        for (int i = 512; i <= 1023; i++) {
////            State.forWorld(world.getId()).requestChunk(0, i);
////        }
//
//        //Retrieve:
//        for (int col = 0; col < 1000; col++) {
//            final MatrixPosition chunkPosition = MPTerrainChunk.getChunkPosition(0, col);
//            chunkQueries.add(chunkPosition);
//            final long t = System.currentTimeMillis();
//            State.forWorld(world.getId()).requestChunk(chunkPosition.getRow(), chunkPosition.getCol());
//            latencies.add((System.currentTimeMillis() - t));
//        }
//
//        int sumLatency = 0;
//        for (Long latency : latencies) {
//            sumLatency += latency;
//        }
//
//        double averageLatency = sumLatency / (double) latencies.size();
//        double averageLatencyPerGeneration = sumLatency / (double) chunkQueries.size();
//
//        System.out.println("Number of queries: " + chunkQueries.size());
//        System.out.println("Average latency: " + averageLatency);
//        System.out.println("Average latency per generation: " + averageLatencyPerGeneration);
//
//    }
//
//}
