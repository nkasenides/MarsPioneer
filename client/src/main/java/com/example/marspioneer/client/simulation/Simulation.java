package com.example.marspioneer.client.simulation;

import com.example.marspioneer.client.stubs.Stubs;
import com.example.marspioneer.client.tools.CleanUp;
import com.example.marspioneer.model.MPPlayer;
import com.example.marspioneer.proto.*;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.gson.Gson;
import com.raylabz.firestorm.Firestorm;
import com.raylabz.firestorm.FirestormConfig;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Simulation {

    private static String adminGameSessionID;
    private static MPPlayer adminPlayer;
    private static String worldID;

    public static void main(String[] args) throws FileNotFoundException {

        setupSimulation();

        Scanner scanner = new Scanner(new File("simConfig.cfg"));
        String input = scanner.nextLine();
        SimulationConfig config = new Gson().fromJson(input, SimulationConfig.class);

        int playerNameCounter = 0;
        Vector<Bot> threads = new Vector<>();

        long startTime = System.currentTimeMillis();
        long finishTime = startTime + config.getTimeLimit();
        while (System.currentTimeMillis() < finishTime || config.getTimeLimit() <= 0) {
            ArrayList<SimulationEvent> eventsToRemove = new ArrayList<>();
            for (SimulationEvent event : config.getEvents()) {
                if (startTime + event.getTime() < System.currentTimeMillis()) {
                    if (event.getType() == SimulationEventType.PLAYER_JOIN) {
                        playerNameCounter++;
                        final String playerName = "Bot-" + playerNameCounter;
                        System.out.println("Bot-" + playerNameCounter + " started @ " + System.currentTimeMillis());
                        Bot playerThread = new Bot(playerName, config.getDelay(), System.currentTimeMillis(), System.currentTimeMillis() + event.getDuration());
                        playerThread.setName(playerName);
                        threads.add(playerThread);
                        playerThread.start();
                    }
                    eventsToRemove.add(event);
                }
            }
            for (SimulationEvent eventToRemove : eventsToRemove) {
                config.getEvents().remove(eventToRemove);
            }
        }

        try {

            for (Bot bot : threads) {
                bot.stopRunning();
            }

            System.out.println("Writing results to file. Please wait...");
            FileWriter fileWriter = new FileWriter("MP-SimulationResults.csv");
            StringBuilder builder = new StringBuilder();
            builder.append("Simulation results for MP with ").append(threads.size()).append(" bots:").append((System.lineSeparator())).append(System.lineSeparator());

            builder.append("Start time,").append(startTime).append(System.lineSeparator());
            builder.append("Finish time,").append(finishTime).append(System.lineSeparator());
            builder.append("Total duration (s),").append((finishTime - startTime) / 1000).append(System.lineSeparator()).append(System.lineSeparator());

            builder.append("Bot name,Join time,Exit time,CreatePlayer,Authenticate,GetPlayer,ListWorlds,JoinWorld,GetState,Subscribe").append(System.lineSeparator());
            for (Bot bot : threads) {
                builder.append(bot.getBotName()).append(",")
                        .append(bot.getJoinTime()).append(",")
                        .append(bot.getExitTime()).append(",")
                        .append(bot.getCreatePlayerLatency()).append(",")
                        .append(bot.getAuthenticateLatency()).append(",")
                        .append(bot.getGetPlayerLatency()).append(",")
                        .append(bot.getListWorldsLatency()).append(",")
                        .append(bot.getJoinWorldLatency()).append(",")
                        .append(bot.getGetInitialStateLatency()).append(",")
                        .append(bot.getSubscribeLatency()).append(",")
                        .append(System.lineSeparator());
            }

            builder.append("State update latencies").append(System.lineSeparator());
            for (Bot bot : threads) {
                builder.append(bot.getBotName()).append(",");
                for (Long latency : bot.getStateUpdateLatencies()) {
                    builder.append(latency).append(",");
                }
                builder.append(System.lineSeparator());
            }
            builder.append(System.lineSeparator());



//            builder.append("Bot name,Join time,/play latency (ms)").append(System.lineSeparator());
//
//            for (Bot t : threads) {
//                t.stopRunning();
//
//                builder.append(t.getBotName()).append(",").append(t.getJoinTime() - startTime).append(",");
//                for (long l : t.getStateUpdateLatencies()) {
//                    builder.append(l).append(",");
//                }
//                builder.delete(builder.length() - 1, builder.length());
//                builder.append(System.lineSeparator());
//            }

            fileWriter.write(builder.toString());
            fileWriter.close();
            System.out.println("Results written to file.");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        CleanUp.main(new String[]{});
    }

    private static void setupSimulation() {
        //Create admin:
        Stubs.createPlayerStub().sendAndWait(
                CreatePlayerRequest.newBuilder()
                        .setPlayer(MPPlayerProto.newBuilder()
                                .setPassword("1234")
                                .setName("admin")
                                .build())
                        .build(),
                createPlayerResponse -> {
                    if (createPlayerResponse.getStatus() == CreatePlayerResponse.Status.OK) {
                        System.out.println("Player '" + createPlayerResponse.getPlayer().getName() + "' created, ID: " + createPlayerResponse.getPlayer().getId());
                    } else {
                        System.err.println(createPlayerResponse.getMessage());
                    }
                }
        );

        //Sign in admin:
        Stubs.authenticateStub().sendAndWait(
                AuthenticateRequest.newBuilder()
                        .setPlayerName("admin")
                        .setPassword("1234")
                        .build(),
                authResponse -> {
                    if (authResponse.getStatus() == AuthenticateResponse.Status.OK) {
                        System.out.println("Game session ID: " + authResponse.getGameSession().getId());
                        adminGameSessionID = authResponse.getGameSession().getId();
                        Stubs.getPlayerStub().sendAndWait(
                                GetPlayerRequest.newBuilder()
                                        .setGameSessionID(adminGameSessionID)
                                        .setPlayerID(authResponse.getGameSession().getPlayerID())
                                        .build(),
                                getPlayerResponse -> {
                                    if (getPlayerResponse.getStatus() == GetPlayerResponse.Status.OK) {
                                        System.out.println("Player with ID '" + getPlayerResponse.getPlayer().getId() + "' retrieved.");
                                        adminPlayer = getPlayerResponse.getPlayer().toObject();
                                    } else {
                                        System.err.println("Failed to get player with ID " + getPlayerResponse.getPlayer().getId());
                                        System.err.println(getPlayerResponse.getMessage());
                                    }
                                }
                        );
                    } else {
                        System.err.println(authResponse.getMessage());
                    }
                }
        );

        //Create world:
        Stubs.createWorldStub().sendAndWait(
                CreateWorldRequest.newBuilder()
                        .setWorld(MPWorldProto.newBuilder()
                                .setSeed(333)
                                .setName("world")
                                .setMaxRows(-1)
                                .setMaxCols(-1)
                                .setOwnerID(adminPlayer.getId())
                                .setHeightLimit(100)
                                .build())
                        .setGameSessionID(adminGameSessionID)
                        .build(),
                createWorldResponse -> {
                    if (createWorldResponse.getStatus() == CreateWorldResponse.Status.OK) {
                        System.out.println("World '" + createWorldResponse.getWorld().getName() + "' created, ID: " + createWorldResponse.getWorld().getId());
                        worldID = createWorldResponse.getWorld().getId();
                    } else {
                        System.err.println(createWorldResponse.getMessage());
                    }
                }
        );
    }


}
