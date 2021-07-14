package com.example.marspioneer.client.tools;

import com.example.marspioneer.client.stubs.Stubs;
import com.example.marspioneer.model.MPGameSession;
import com.example.marspioneer.model.MPPlayer;
import com.example.marspioneer.proto.*;
import com.nkasenides.athlos.client.stubs.OnRequestSuccessListener;
import com.raylabz.javahttp.OnFailureListener;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Simulation {

    public static final int NUM_OF_PLAYERS = 2;

    public static MPGameSessionProto adminGameSession;
    public static String redTeamID;
    public static String blueTeamID;
    public static String worldID;
    public static ConcurrentHashMap<String, MPPlayerProto> players = new ConcurrentHashMap<>(); //Player ID -> Player
    public static ConcurrentHashMap<String, MPGameSessionProto> playerGameSessions = new ConcurrentHashMap<>(); //Player ID -> Game Session
    public static ConcurrentHashMap<String, MPWorldSessionProto> playerWorldSessions = new ConcurrentHashMap<>(); //Player ID -> World Session

    public static void setup() {

        CleanUp.main(null);


        //Admin (use for managing the game's items only):
        createAdmin();
        signInAdmin();

        new Scanner(System.in).nextLine();

        //Create world, teams:
        createWorld("MyWorld", 1993);
        createRedTeam();
        createBlueTeam();

        new Scanner(System.in).nextLine();

        //Create the players:
        for (int i = 0; i < NUM_OF_PLAYERS; i++) {
            createPlayer("Player-" + (i + 1));
        }

        new Scanner(System.in).nextLine();

        //Sign the players in, join them to a team and the game world:
        for (Map.Entry<String, MPPlayerProto> entry : players.entrySet()) {
            signInPlayer(entry.getValue().getId());
            playerJoinTeam(entry.getValue().getId());
            playerJoinWorld(entry.getValue().getId());
        }

        for (Map.Entry<String, MPPlayerProto> entry : players.entrySet()) {
            long time = System.currentTimeMillis();
            requestState(entry.getValue().getId());
            System.out.println("Time taken: " + (System.currentTimeMillis() - time) + "ms");
        }

        new Scanner(System.in).nextLine();

        for (Map.Entry<String, MPPlayerProto> entry : players.entrySet()) {
            long time = System.currentTimeMillis();
            requestState(entry.getValue().getId());
            System.out.println("Time taken: " + (System.currentTimeMillis() - time) + "ms");
        }


    }

    public static void createAdmin() {
        Stubs.createPlayerStub().sendAndWait(
                CreatePlayerRequest.newBuilder()
                        .setPlayer(
                                MPPlayerProto.newBuilder()
                                        .setName("admin")
                                        .setPassword("1234")
                                        .build()
                        )
                        .build(),
                response -> {
                    if (response.getStatus() == CreatePlayerResponse.Status.OK) {
                        System.out.println("Created admin");
                    }
                    else {
                        System.err.println("Failed to create admin -> " + response.getMessage());
                    }
                }
        );
    }

    public static void createPlayer(String playerName) {
        Stubs.createPlayerStub().sendAndWait(
                CreatePlayerRequest.newBuilder()
                        .setPlayer(
                                MPPlayerProto.newBuilder()
                                        .setName(playerName)
                                        .setPassword("1234")
                                        .build()
                        )
                        .build(),
                response -> {
                    if (response.getStatus() == CreatePlayerResponse.Status.OK) {
                        System.out.println("Created player: " + response.getPlayer().getName() + " ID:" + response.getPlayer().getId());
                        players.put(response.getPlayer().getId(), response.getPlayer());
                    }
                    else {
                        System.err.println("Failed to create player: " + playerName + " -> " + response.getMessage());
                    }
                }
        );
    }

    public static void signInAdmin() {
        Stubs.authenticateStub().sendAndWait(
                AuthenticateRequest.newBuilder()
                        .setPlayerName("admin")
                        .setPassword("1234")
                        .build(),
                response -> {
                    if (response.getStatus() == AuthenticateResponse.Status.OK) {
                        System.out.println("Authenticated admin - Game session ID: [" + response.getGameSession().getPlayerID() + "]");
                        adminGameSession = response.getGameSession();
                    }
                    else {
                        System.err.println("Failed to authenticate admin -> " + response.getMessage());
                    }
                }
        );
    }

    public static void signInPlayer(String playerID) {
        Stubs.authenticateStub().sendAndWait(
                AuthenticateRequest.newBuilder()
                        .setPlayerName(players.get(playerID).getName())
                        .setPassword("1234")
                        .build(),
                response -> {
                    if (response.getStatus() == AuthenticateResponse.Status.OK) {
                        System.out.println("Authenticated player " + players.get(playerID).getName() + " - Game session ID: [" + response.getGameSession().getPlayerID() + "]");
                        playerGameSessions.put(playerID, response.getGameSession());
                    }
                    else {
                        System.err.println("Failed to authenticate player: " + players.get(playerID).getName() + " -> " + response.getMessage());
                    }
                }
        );
    }

    public static void createWorld(String worldName, long seed) {
        Stubs.createWorldStub().sendAndWait(
                CreateWorldRequest.newBuilder()
                        .setWorld(
                                MPWorldProto.newBuilder()
                                        .setName(worldName)
                                        .setHeightLimit(100)
                                        .setMaxCols(-1)
                                        .setMaxRows(-1)
                                        .setSeed(seed)
                                        .build()
                        )
                        .setGameSessionID(adminGameSession.getId())
                        .build(),
                response -> {
                    if (response.getStatus() == CreateWorldResponse.Status.OK) {
                        System.out.println("Created world " + worldName);
                        worldID = response.getWorld().getId();
                    }
                    else {
                        System.err.println("Failed to create world: " + worldName + " -> " + response.getMessage());
                    }
                }
        );
    }

    public static void createBlueTeam() {
        Stubs.createTeamStub().sendAndWait(
                CreateTeamRequest.newBuilder()
                        .setGameSessionID(adminGameSession.getId())
                        .setTeam(MPTeamProto.newBuilder()
                                .setName("Blue team")
                                .setColor(TeamColor.BLUE_TeamColor)
                                .setOwnerID(adminGameSession.getPlayerID())
                                .setPlayerLimit(-1)
                                .build())
                        .build(),
                response -> {
                    if (response.getStatus() == CreateTeamResponse.Status.OK) {
                        System.out.println("Created Blue team - ID:" + response.getTeam().getId());
                        blueTeamID = response.getTeam().getId();
                    }
                    else {
                        System.err.println("Failed to create Blue team: -> " + response.getMessage());
                    }
                }
        );
    }

    public static void createRedTeam() {
        Stubs.createTeamStub().sendAndWait(
                CreateTeamRequest.newBuilder()
                        .setGameSessionID(adminGameSession.getId())
                        .setTeam(MPTeamProto.newBuilder()
                                .setName("Red team")
                                .setColor(TeamColor.RED_TeamColor)
                                .setOwnerID(adminGameSession.getPlayerID())
                                .setPlayerLimit(-1)
                                .build())
                        .build(),
                response -> {
                    if (response.getStatus() == CreateTeamResponse.Status.OK) {
                        System.out.println("Created Red team - ID:" + response.getTeam().getId());
                        redTeamID = response.getTeam().getId();
                    }
                    else {
                        System.err.println("Failed to create Red team -> " + response.getMessage());
                    }
                }
        );
    }

    public static void playerJoinTeam(String playerID) {

        //Select random team:
        String teamName;
        String teamID;

        final double random = Math.random();
        if (random > 0.5) {
            teamName = "Blue";
            teamID = blueTeamID;
        }
        else {
            teamName = "Red";
            teamID = redTeamID;
        }

        Stubs.addPlayerToTeamStub().sendAndWait(
                AddPlayerToTeamRequest.newBuilder()
                        .setGameSessionID(playerGameSessions.get(playerID).getId())
                        .setTeamID(teamID)
                        .setPlayerID(playerID)
                        .build(),
                response -> {
                    if (response.getStatus() == AddPlayerToTeamResponse.Status.OK) {
                        System.out.println("Player '" + playerID +"' joined the " + teamName + " team.");
                    }
                    else {
                        System.err.println("Failed to add player to team -> " + response.getMessage());
                    }
                }
        );
    }

    public static void playerJoinWorld(String playerID) {
        Stubs.joinWorldStub().sendAndWait(
                JoinWorldRequest.newBuilder()
                        .setGameSessionID(playerGameSessions.get(playerID).getId())
                        .setWorldID(worldID)
                        .build(),
                response -> {
                    if (response.getStatus() == JoinWorldResponse.Status.OK) {
                        System.out.println("Player '" + playerID +"' joined the world -> WorldSession.id = " + response.getWorldSession().getId());
                        playerWorldSessions.put(playerID, response.getWorldSession());
                    }
                    else {
                        System.err.println("Player '" + playerID + "' failed to join the world -> " + response.getMessage());
                    }
                }
        );
    }

    public static void requestState(String playerID) {

        Stubs.getStateStub().sendAndWait(
                GetStateRequest.newBuilder()
                        .setWorldSessionID(playerWorldSessions.get(playerID).getId())
                        .build(),
                response -> {
                    if (response.getStatus() == GetStateResponse.Status.OK) {
                        System.out.println("State retrieved for player " + playerID);
                        final MPPartialStateProto partialState = response.getPartialState();
                        final Map<String, MPTerrainCellProto> cellsMap = partialState.getCellsMap();
                        System.out.println("Total cells: " + cellsMap.size());
                        for (Map.Entry<String, MPTerrainCellProto> cellEntry : cellsMap.entrySet()) {
                            System.out.print(cellEntry.getValue().getType() + " ");
                        }
                        System.out.println();
                    }
                    else {
                        System.err.println("Failed to retrieve game state for player with ID: " + playerID);
                    }
                }
        );
    }

    public static void main(String[] args) {

        final ListPlayersRequest build = ListPlayersRequest.newBuilder().build();

        long time = System.currentTimeMillis();

        Stubs.listPlayersStub().sendAndWait(build, listPlayersResponse -> System.out.println("Time: " + (System.currentTimeMillis() - time)));

        long time2 = System.currentTimeMillis();
        Stubs.listPlayersStub().sendAndWait(build, listPlayersResponse -> System.out.println("Time: " + (System.currentTimeMillis() - time2)));

        long time3 = System.currentTimeMillis();
        Stubs.listPlayersStub().sendAndWait(build, listPlayersResponse -> System.out.println("Time: " + (System.currentTimeMillis() - time3)));

//        setup();

    }

}
