/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Project Editor, v1.0 BETA
-------------------------------------------------------------------------------- */

package com.example.marspioneer.client;
import com.example.marspioneer.client.stubs.Stubs;
import com.example.marspioneer.client.ui.MPCanvas;
import com.example.marspioneer.client.ui.MPGameForm;
import com.example.marspioneer.client.websocket.UpdateStateStub;
import com.example.marspioneer.model.*;
import com.example.marspioneer.proto.*;
import com.neovisionaries.ws.client.WebSocketException;
import com.nkasenides.athlos.client.ServerlessGameClient;
import com.raylabz.mocha.Mocha;

import java.io.IOException;
import java.util.HashMap;


public class MPClient extends ServerlessGameClient<MPPartialStateProto, MPGameSession, MPWorldSession, MPPlayer, MPWorld> {

    private static String adminGameSessionID;
    private static MPPlayer adminPlayer;
    private static String WORLD_ID;


    private MPWorldProto world = null;

    private HashMap<String, MPEntityProto> entities = new HashMap<>();
    private HashMap<String, MPTerrainCellProto> stateCells = new HashMap<>();
    private HashMap<String, MPTerrainCellProto> generatedCells = new HashMap<>();
    private MatrixPosition cameraPosition;
    private MatrixPosition selectedCellPosition = new MatrixPosition();

    private ResourceSet playerResourceSet;

    private String playerName;
    private String worldID;
    private MPCanvas gameCanvas;

    public MPClient(String playerName, String worldID) throws WebSocketException, IOException {
        this.playerName = playerName;
        this.worldID = worldID;
    }

    public MPCanvas getGameCanvas() {
        return gameCanvas;
    }

    public MatrixPosition getCameraPosition() {
        return cameraPosition;
    }

    public HashMap<String, MPEntityProto> getEntities() {
        return entities;
    }

    public void setEntities(HashMap<String, MPEntityProto> entities) {
        this.entities = entities;
    }

    public HashMap<String, MPTerrainCellProto> getStateCells() {
        return stateCells;
    }

    public void setStateCells(HashMap<String, MPTerrainCellProto> stateCells) {
        this.stateCells = stateCells;
    }

    public HashMap<String, MPTerrainCellProto> getGeneratedCells() {
        return generatedCells;
    }

    public void setGeneratedCells(HashMap<String, MPTerrainCellProto> generatedCells) {
        this.generatedCells = generatedCells;
    }

    public ResourceSet getPlayerResourceSet() {
        return playerResourceSet;
    }

    public void setPlayerResourceSet(ResourceSet playerResourceSet) {
        this.playerResourceSet = playerResourceSet;
    }

    public String getWorldSessionID() {
        return worldSessionID;
    }

    public MPWorldProto getWorld() {
        return world;
    }

    public void setWorld(MPWorldProto world) {
        this.world = world;
    }

    public void setCameraPosition(MatrixPosition cameraPosition) {
        this.cameraPosition = cameraPosition;
    }

    public MatrixPosition getSelectedCellPosition() {
        return selectedCellPosition;
    }

    public void setSelectedCellPosition(MatrixPosition selectedCellPosition) {
        this.selectedCellPosition = selectedCellPosition;
    }

    private static boolean[] createPlayer(String name) {
        final boolean[] result = {true};
        Stubs.createPlayerStub().send(CreatePlayerRequest.newBuilder()
                        .setPlayer(MPPlayerProto.newBuilder()
                                .setName(name)
                                .setPassword("1234")
                                .build())
                        .build()
                , createPlayerResponse -> {
                    if (createPlayerResponse.getStatus() == CreatePlayerResponse.Status.OK) {
                        System.out.println("Player '" + name + "' created.");
                    }
                    else {
                        result[0] = false;
                        System.err.println("Player not created -> " + createPlayerResponse.getMessage());
                    }
                }
        );
        return result;
    }

    public static void main(String[] args) throws WebSocketException, IOException {

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
                        WORLD_ID = createWorldResponse.getWorld().getId();
                    } else {
                        System.err.println(createWorldResponse.getMessage());
                    }
                }
        );

        final int NUM_OF_PLAYERS = 1;

        for (int i = 0; i < NUM_OF_PLAYERS; i++) {
            MPClient client = new MPClient("Player-" + (i + 1), WORLD_ID);
            client.start();
        }

    }

    @Override
    protected void onStart() {

        //Create the player:
        Stubs.createPlayerStub().sendAndWait(
                CreatePlayerRequest.newBuilder()
                        .setPlayer(MPPlayerProto.newBuilder()
                                .setPassword("1234")
                                .setName(playerName)
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

        //Sign in:
        Stubs.authenticateStub().sendAndWait(
                AuthenticateRequest.newBuilder()
                        .setPlayerName(playerName)
                        .setPassword("1234")
                        .build(),
                authResponse -> {
                    if (authResponse.getStatus() == AuthenticateResponse.Status.OK) {
                        System.out.println("Player '" + playerName + "' created, ID: " + authResponse.getGameSession().getPlayerID());
                        System.out.println("Game session ID: " + authResponse.getGameSession().getId());
                        gameSessionID = authResponse.getGameSession().getId();
                        Stubs.getPlayerStub().sendAndWait(
                                GetPlayerRequest.newBuilder()
                                        .setGameSessionID(gameSessionID)
                                        .setPlayerID(authResponse.getGameSession().getPlayerID())
                                        .build(),
                                getPlayerResponse -> {
                                    if (getPlayerResponse.getStatus() == GetPlayerResponse.Status.OK) {
                                        System.out.println("Player with ID '" + authResponse.getGameSession().getPlayerID() + "' retrieved.");
                                        player = getPlayerResponse.getPlayer().toObject();
                                    } else {
                                        System.err.println("Failed to get player with ID " + authResponse.getGameSession().getPlayerID());
                                    }
                                }
                        );
                    } else {
                        System.err.println(authResponse.getMessage());
                    }
                }
        );

        //Join world:
        Stubs.joinWorldStub().sendAndWait(
                JoinWorldRequest.newBuilder()
                        .setWorldID(worldID)
                        .setGameSessionID(gameSessionID)
                        .build(),
                joinWorldResponse -> {
                    if (joinWorldResponse.getStatus() == JoinWorldResponse.Status.OK) {
                        System.out.println("Player '" + player.getName() + "' joined world '" + joinWorldResponse.getWorld().getId() + "'.");
                        System.out.println("World session ID: " + joinWorldResponse.getWorldSession().getId());
                        this.worldSessionID = joinWorldResponse.getWorldSession().getId();
                        this.world = joinWorldResponse.getWorld();
                        this.cameraPosition = joinWorldResponse.getWorldSession().getCameraPosition().toObject();

                        //Get the initial state:
                        Stubs.getStateStub().sendAndWait(
                                GetStateRequest.newBuilder()
                                        .setWorldSessionID(worldSessionID)
                                        .build(),
                                getStateResponse -> {
                                    if (getStateResponse.getStatus() == GetStateResponse.Status.OK) {
                                        System.out.println("Initial state retrieved for player '" + player.getName() + "'.");
                                        setStateCells(new HashMap<>(getStateResponse.getPartialState().getCellsMap()));
                                        setEntities(new HashMap<>(getStateResponse.getPartialState().getEntitiesMap()));
                                        setPlayerResourceSet(getStateResponse.getResourceSet().toObject());
                                        selectedCellPosition = getStateResponse.getPartialState().getWorldSession().getCameraPosition().toObject();
                                        try {

                                            //Subscribe:
                                            Stubs.subscribeStub().sendAndWait(
                                                    SubscribeRequest.newBuilder()
                                                            .setWorldSessionID(worldSessionID)
                                                            .build(),
                                                    subscribeResponse -> {
                                                        if (subscribeResponse.getStatus() == SubscribeResponse.Status.OK) {
                                                            System.out.println("World session " + worldSessionID + " successfully subscribed to world.");
                                                        }
                                                        else {
                                                            System.err.println(subscribeResponse.getMessage());
                                                        }
                                                    }
                                            );

                                            //Connect to the state update stub:
                                            final UpdateStateStub updateStateStub = Stubs.getUpdateStateStub(this);
                                            Mocha.start(updateStateStub);
                                            //Send a request to be acknowledged as a client:
                                            final byte[] bytes = UpdateStateRequest.newBuilder().setWorldSessionID(worldSessionID).build().toByteArray();
                                            updateStateStub.send(bytes);
                                        } catch (WebSocketException | IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    else {
                                        System.err.println(getStateResponse.getMessage());
                                    }
                                }
                        );


                        //Launch the UI:
                        this.gameCanvas = new MPCanvas(this);
                        new MPGameForm(this, gameCanvas);
                    }
                    else {
                        System.err.println(joinWorldResponse.getMessage());
                    }
                }
        );

    }

}
