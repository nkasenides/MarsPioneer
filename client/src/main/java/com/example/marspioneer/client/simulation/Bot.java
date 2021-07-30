package com.example.marspioneer.client.simulation;

import com.example.marspioneer.client.stubs.Stubs;
import com.example.marspioneer.client.ui.MPGameForm;
import com.example.marspioneer.client.websocket.BotUpdateStateStub;
import com.example.marspioneer.model.*;
import com.example.marspioneer.proto.*;
import com.neovisionaries.ws.client.WebSocketException;
import com.raylabz.mocha.Mocha;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Bot extends Thread {

    private boolean running = true;
    private BotCanvas canvas;


    private final String botName;
    private MPPlayer player;
    private MPWorld world;
    private MPWorldSession worldSession;
    private MPGameSession gameSession;

    private ResourceSet resourceSet;
    private ConcurrentHashMap<String, MPEntityProto> entities = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, MPTerrainCellProto> terrain = new ConcurrentHashMap<>();

    private final long delay;
    private final long joinTime;
    private final long exitTime;

    private long lastSendTime = 0;

    private Vector<Long> stateUpdateLatencies = new Vector<>();
    private long createPlayerLatency;
    private long authenticateLatency;
    private long getPlayerLatency;
    private long listWorldsLatency;
    private long joinWorldLatency;
    private long getInitialStateLatency;
    private long subscribeLatency;

    public Bot(String botName, long delay, long joinTime, long exitTime) {
        this.botName = botName;
        this.delay = delay;
        this.joinTime = joinTime;
        this.exitTime = exitTime;
    }

    public String getBotName() {
        return botName;
    }

    public void stopRunning() {
        running = false;
    }

    public long getJoinTime() {
        return joinTime;
    }

    @Override
    public void run() {

        final boolean[] success = new boolean[1];

        //Create the player:
        final CreatePlayerRequest createPlayerRequest = CreatePlayerRequest.newBuilder()
                .setPlayer(MPPlayerProto.newBuilder()
                        .setPassword("1234")
                        .setName(botName)
                        .build())
                .build();

        final long createPlayerTimer = System.currentTimeMillis();
        Stubs.createPlayerStub().sendAndWait(
                createPlayerRequest,
                createPlayerResponse -> {
                    if (createPlayerResponse.getStatus() == CreatePlayerResponse.Status.OK) {
                        createPlayerLatency = System.currentTimeMillis() - createPlayerTimer;
                        success[0] = true;
                        System.out.println("Player '" + createPlayerResponse.getPlayer().getName() + "' created, ID: " + createPlayerResponse.getPlayer().getId());
                        player = createPlayerResponse.getPlayer().toObject();
                    } else {
                        createPlayerLatency = System.currentTimeMillis() - createPlayerTimer;
                        success[0] = false;
                        System.err.println(createPlayerResponse.getMessage());
                    }
                }
        );

        if (!success[0]) {
            System.err.println("[" + botName + "] - Failed to create player.");
            return;
        }

        //Authenticate - aka join game:
        final AuthenticateRequest authenticateRequest = AuthenticateRequest.newBuilder()
                .setPlayerName(player.getName())
                .setPassword("1234")
                .build();

        final long authenticateTimer = System.currentTimeMillis();
        Stubs.authenticateStub().sendAndWait(
                authenticateRequest,
                authResponse -> {
                    if (authResponse.getStatus() == AuthenticateResponse.Status.OK) {
                        authenticateLatency = System.currentTimeMillis() - authenticateTimer;
                        success[0] = true;
                        System.out.println("Player '" + player.getName() + "' created, ID: " + authResponse.getGameSession().getPlayerID());
                        System.out.println("Game session ID: " + authResponse.getGameSession().getId());
                        gameSession = authResponse.getGameSession().toObject();
                    } else {
                        authenticateLatency = System.currentTimeMillis() - authenticateTimer;
                        success[0] = false;
                        System.err.println(authResponse.getMessage());
                    }
                }
        );

        if (!success[0]) {
            System.err.println("[" + botName + "] - Failed to authenticate player.");
            return;
        }


        //Get player data:
        final GetPlayerRequest getPlayerRequest = GetPlayerRequest.newBuilder()
                .setGameSessionID(gameSession.getId())
                .setPlayerID(gameSession.getPlayerID())
                .build();

        long getPlayerTimer = System.currentTimeMillis();
        Stubs.getPlayerStub().sendAndWait(
                getPlayerRequest,
                getPlayerResponse -> {
                    if (getPlayerResponse.getStatus() == GetPlayerResponse.Status.OK) {
                        getPlayerLatency = System.currentTimeMillis() - getPlayerTimer;
                        success[0] = true;
                        System.out.println("Player with ID '" + getPlayerResponse.getPlayer().getName() + "' retrieved.");
                        player = getPlayerResponse.getPlayer().toObject();
                    } else {
                        getPlayerLatency = System.currentTimeMillis() - getPlayerTimer;
                        success[0] = false;
                        System.err.println("Failed to get player with ID " + getPlayerRequest.getPlayerID());
                    }
                }
        );

        if (!success[0]) {
            System.err.println("[" + botName + "] - Failed to retrieve player data.");
            return;
        }


        //List worlds:
        final ArrayList<MPWorldProto>[] worldsList = new ArrayList[1];
        final ListWorldsRequest listWorldsRequest = ListWorldsRequest.newBuilder()
                .setGameSessionID(gameSession.getId())
                .build();

        long listWorldsTimer = System.currentTimeMillis();
        Stubs.listWorldsStub().sendAndWait(
                listWorldsRequest,
                listWorldsResponse -> {
                    if (listWorldsResponse.getStatus() == ListWorldsResponse.Status.OK) {
                        listWorldsLatency = System.currentTimeMillis() - listWorldsTimer;
                        success[0] = true;
                        System.out.println("Listed worlds");
                        worldsList[0] = new ArrayList<>(listWorldsResponse.getWorldsList());
                    } else {
                        listWorldsLatency = System.currentTimeMillis() - listWorldsTimer;
                        success[0] = false;
                        System.err.println("Failed to list worlds.");
                    }
                }
        );

        if (!success[0]) {
            System.err.println("[" + botName + "] - Failed to list worlds.");
            return;
        }

        //Join world:
        if (worldsList[0].isEmpty()) {
            System.err.println("[" + botName + "] - No world to join.");
            return;
        }

        final JoinWorldRequest joinWorldRequest = JoinWorldRequest.newBuilder()
                .setWorldID(worldsList[0].get(0).getId())
                .setGameSessionID(gameSession.getId())
                .build();

        long joinWorldTimer = System.currentTimeMillis();
        Stubs.joinWorldStub().sendAndWait(
                joinWorldRequest,
                joinWorldResponse -> {
                    if (joinWorldResponse.getStatus() == JoinWorldResponse.Status.OK) {
                        joinWorldLatency = System.currentTimeMillis() - joinWorldTimer;
                        success[0] = true;
                        System.out.println("Player '" + player.getName() + "' joined world '" + joinWorldResponse.getWorld().getId() + "'.");
                        System.out.println("World session ID: " + joinWorldResponse.getWorldSession().getId());
                        this.worldSession = joinWorldResponse.getWorldSession().toObject();
                        this.world = joinWorldResponse.getWorld().toObject();
                    } else {
                        joinWorldLatency = System.currentTimeMillis() - joinWorldTimer;
                        success[0] = false;
                        System.err.println("Could not join world with ID '" + worldsList[0].get(0).getId() + "'");
                    }
                }
        );

        if (!success[0]) {
            System.err.println("[" + botName + "] - Failed to join world.");
            return;
        }

        //Get initial state:
        final GetStateRequest getStateRequest = GetStateRequest.newBuilder()
                .setWorldSessionID(worldSession.getId())
                .build();

        long getStateTimer = System.currentTimeMillis();
        Stubs.getStateStub().sendAndWait(
                getStateRequest,
                getStateResponse -> {
                    if (getStateResponse.getStatus() == GetStateResponse.Status.OK) {
                        getInitialStateLatency = System.currentTimeMillis() - getStateTimer;
                        success[0] = true;
                        System.out.println("Initial state retrieved for player '" + player.getName() + "'.");
                        terrain = new ConcurrentHashMap<>(getStateResponse.getPartialState().getTerrainMap());
                        entities = new ConcurrentHashMap<>(getStateResponse.getPartialState().getEntitiesMap());
                        resourceSet = getStateResponse.getResourceSet().toObject();
                    } else {
                        getInitialStateLatency = System.currentTimeMillis() - getStateTimer;
                        success[0] = false;
                        System.err.println("Failed to retrieve state for player '" + player.getName() + "'");
                    }
                }
        );

        if (!success[0]) {
            System.err.println("[" + botName + "] - Failed to retrieve initial state.");
            return;
        }


        //Subscribe to world updates:
        final SubscribeRequest subscribeRequest = SubscribeRequest.newBuilder()
                .setWorldSessionID(worldSession.getId())
                .build();

        long subscribeTimer = System.currentTimeMillis();
        Stubs.subscribeStub().sendAndWait(
                subscribeRequest,
                subscribeResponse -> {
                    if (subscribeResponse.getStatus() == SubscribeResponse.Status.OK) {
                        subscribeLatency = System.currentTimeMillis() - subscribeTimer;
                        success[0] = true;
                        System.out.println("Successfully subscribed to world.");

                        //Connect to the state update stub:
                        try {
                            final BotUpdateStateStub updateStateStub = Stubs.getBotUpdateStateStub(this);
                            Mocha.start(updateStateStub);
                            //Send a request to be acknowledged as a client:
                            final byte[] bytes = UpdateStateRequest.newBuilder().setWorldSessionID(worldSession.getId()).build().toByteArray();
                            updateStateStub.send(bytes);
                        } catch (WebSocketException | IOException e) {
                            e.printStackTrace();
                            success[0] = false;
                        }

                    } else {
                        subscribeLatency = System.currentTimeMillis() - subscribeTimer;
                        success[0] = false;
                        System.err.println(subscribeResponse.getMessage());
                    }
                }
        );


        if (!success[0]) {
            System.err.println("Failed to subscribe to world.");
            return;
        }

        //Launch the UI:
        this.canvas = new BotCanvas(this);
        new BotForm(this, canvas);

        Random random = new Random();

        while (exitTime > System.currentTimeMillis() && running) {

            boolean hasHub = false;
            for (MPEntityProto value : entities.values()) {
                if (value.getBuildingEntity().getBuildingType() == EBuildingType.HUB_EBuildingType) {
                    hasHub = true;
                    break;
                }
            }

            if (!hasHub) {
                //Find position for a hub:
                MatrixPosition hubPos = null;
                for (MPTerrainCellProto value : terrain.values()) {
                    if (value.getType() == CellType.SAND_CellType || value.getType() == CellType.ROCK_CellType || value.getType() == CellType.GRAVEL_CellType) {
                        hubPos = value.getPosition().toObject();
                        break;
                    }
                }

                if (hubPos != null) {
                    System.out.println("Player '" + botName + "' decided to build a Hub.");
                    final BuildHubRequest buildRequest = BuildHubRequest.newBuilder()
                            .setPosition(hubPos.toProto())
                            .setWorldSessionID(worldSession.getId())
                            .build();
                    lastSendTime = System.currentTimeMillis();
                    try {
                        Stubs.Actions.getBotBuildHubStub(this).send(buildRequest.toByteArray());
                    } catch (WebSocketException | IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                final int randomMove = random.nextInt(4);
                switch (randomMove) {
                    case 0:

                        //Find position for a farm:
                        MatrixPosition farmPos = findFarmPosition();

                        if (farmPos != null) {
                            System.out.println("Player '" + botName + "' decided to build a Farm at " + farmPos.getRow() + "," + farmPos.getCol());
                            BuildFarmRequest farmRequest = BuildFarmRequest.newBuilder()
                                    .setPosition(farmPos.toProto())
                                    .setWorldSessionID(worldSession.getId())
                                    .build();
                            try {
                                lastSendTime = System.currentTimeMillis();
                                Stubs.Actions.getBotBuildFarmStub(this).send(farmRequest.toByteArray());
                            } catch (WebSocketException | IOException webSocketException) {
                                webSocketException.printStackTrace();
                            }
                        }
                        break;
                    case 1:

                        //Find position for a mine:
                        MatrixPosition minePos = findMinePosition();

                        if (minePos != null) {
                            System.out.println("Player '" + botName + "' decided to build a Mine at " + minePos.getRow() + "," + minePos.getCol());
                            BuildMineRequest mineRequest = BuildMineRequest.newBuilder()
                                    .setPosition(minePos.toProto())
                                    .setWorldSessionID(worldSession.getId())
                                    .build();
                            try {
                                lastSendTime = System.currentTimeMillis();
                                Stubs.Actions.getBotBuildMineStub(this).send(mineRequest.toByteArray());
                            } catch (WebSocketException | IOException webSocketException) {
                                webSocketException.printStackTrace();
                            }
                        }
                        break;
                    case 2:
                        //Find position for a sand pit:
                        MatrixPosition sandPos = findSandPitPosition();

                        if (sandPos != null) {
                            System.out.println("Player '" + botName + "' decided to build a Sand pit at" + sandPos.getRow() + "," + sandPos.getCol());
                            BuildSandPitRequest sandPitRequest = BuildSandPitRequest.newBuilder()
                                    .setPosition(sandPos.toProto())
                                    .setWorldSessionID(worldSession.getId())
                                    .build();
                            try {
                                lastSendTime = System.currentTimeMillis();
                                Stubs.Actions.getBotBuildSandPitStub(this).send(sandPitRequest.toByteArray());
                            } catch (WebSocketException | IOException webSocketException) {
                                webSocketException.printStackTrace();
                            }
                        }
                        break;
                    case 3:
                        //Find position for a well:
                        MatrixPosition wellPos = findWellPosition();

                        if (wellPos != null) {
                            System.out.println("Player '" + botName + "' decided to build a Well at" + wellPos.getRow() + "," + wellPos.getCol());
                            BuildWellRequest wellRequest = BuildWellRequest.newBuilder()
                                    .setPosition(wellPos.toProto())
                                    .setWorldSessionID(worldSession.getId())
                                    .build();
                            try {
                                lastSendTime = System.currentTimeMillis();
                                Stubs.Actions.getBotBuildWellStub(this).send(wellRequest.toByteArray());
                            } catch (WebSocketException | IOException webSocketException) {
                                webSocketException.printStackTrace();
                            }
                        }
                        break;
                    case 4:
                        if (!entities.isEmpty()) {
                            ArrayList<MPEntityProto> entitiesList = new ArrayList<>(entities.values());
                            final int randomEntityIndex = random.nextInt(entitiesList.size());
                            Collections.shuffle(entitiesList);
                            MPEntityProto selectedEntity = entitiesList.get(randomEntityIndex);
                            SellBuildingRequest sellRequest = SellBuildingRequest.newBuilder()
                                    .setBuildingID(selectedEntity.getId())
                                    .setWorldSessionID(worldSession.getId())
                                    .build();
                            try {
                                lastSendTime = System.currentTimeMillis();
                                Stubs.Actions.getBotSellBuildingStub(this).send(sellRequest.toByteArray());
                            } catch (WebSocketException | IOException webSocketException) {
                                webSocketException.printStackTrace();
                            }
                        }
                        break;
                }
            }

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        System.out.println("Player '" + botName + "' stopped");


    }

    private MatrixPosition findFarmPosition() {
        for (MPTerrainCellProto cell : terrain.values()) {
            if (cell.getType() == CellType.SAND_CellType || cell.getType() == CellType.GRAVEL_CellType) {

                //Find if ANY entity has the same position
                boolean entityWithSamePos = false;
                for (MPEntityProto entity : entities.values()) {
                    if (entity.getPosition().toObject().equals(cell.getPosition().toObject())) {
                        entityWithSamePos = true;
                        break;
                    }
                }

                if (!entityWithSamePos) {
                    return cell.getPosition().toObject();
                }
            }
        }
        return null;
    }

    private MatrixPosition findMinePosition() {
        for (MPTerrainCellProto cell : terrain.values()) {
            if (cell.getType() == CellType.ROCK_CellType || cell.getType() == CellType.GRAVEL_CellType) {

                //Find if ANY entity has the same position
                boolean entityWithSamePos = false;
                for (MPEntityProto entity : entities.values()) {
                    if (entity.getPosition().toObject().equals(cell.getPosition().toObject())) {
                        entityWithSamePos = true;
                        break;
                    }
                }

                if (!entityWithSamePos) {
                    return cell.getPosition().toObject();
                }
            }
        }
        return null;
    }

    private MatrixPosition findSandPitPosition() {
        for (MPTerrainCellProto cell : terrain.values()) {
            if (cell.getType() == CellType.SAND_CellType) {

                //Find if ANY entity has the same position
                boolean entityWithSamePos = false;
                for (MPEntityProto entity : entities.values()) {
                    if (entity.getPosition().toObject().equals(cell.getPosition().toObject())) {
                        entityWithSamePos = true;
                        break;
                    }
                }

                if (!entityWithSamePos) {
                    return cell.getPosition().toObject();
                }
            }
        }
        return null;
    }

    private MatrixPosition findWellPosition() {
        for (MPTerrainCellProto cell : terrain.values()) {
            if (cell.getType() == CellType.ICE_CellType) {

                //Find if ANY entity has the same position
                boolean entityWithSamePos = false;
                for (MPEntityProto entity : entities.values()) {
                    if (entity.getPosition().toObject().equals(cell.getPosition().toObject())) {
                        entityWithSamePos = true;
                        break;
                    }
                }

                if (!entityWithSamePos) {
                    return cell.getPosition().toObject();
                }
            }
        }
        return null;
    }

    private MatrixPosition getRandomPositionInKnownTerrain() {
        Random random = new Random();
        final int randomPos = random.nextInt(terrain.values().size());
        ArrayList<MPTerrainCellProto> cells = new ArrayList<>(terrain.values());
        return cells.get(randomPos).getPosition().toObject();
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }


    public Vector<Long> getStateUpdateLatencies() {
        return stateUpdateLatencies;
    }

    public boolean isRunning() {
        return running;
    }

    public MPPlayer getPlayer() {
        return player;
    }

    public MPWorldSession getWorldSession() {
        return worldSession;
    }

    public MPGameSession getGameSession() {
        return gameSession;
    }

    public long getDelay() {
        return delay;
    }

    public long getLastSendTime() {
        return lastSendTime;
    }

    public long getCreatePlayerLatency() {
        return createPlayerLatency;
    }

    public long getAuthenticateLatency() {
        return authenticateLatency;
    }

    public long getListWorldsLatency() {
        return listWorldsLatency;
    }

    public long getJoinWorldLatency() {
        return joinWorldLatency;
    }

    public long getSubscribeLatency() {
        return subscribeLatency;
    }

    public MPWorld getWorld() {
        return world;
    }

    public ResourceSet getResourceSet() {
        return resourceSet;
    }

    public ConcurrentHashMap<String, MPEntityProto> getEntities() {
        return entities;
    }

    public ConcurrentHashMap<String, MPTerrainCellProto> getTerrain() {
        return terrain;
    }

    public long getGetPlayerLatency() {
        return getPlayerLatency;
    }

    public long getGetInitialStateLatency() {
        return getInitialStateLatency;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void setPlayer(MPPlayer player) {
        this.player = player;
    }

    public void setWorld(MPWorld world) {
        this.world = world;
    }

    public void setWorldSession(MPWorldSession worldSession) {
        this.worldSession = worldSession;
    }

    public void setGameSession(MPGameSession gameSession) {
        this.gameSession = gameSession;
    }

    public void setResourceSet(ResourceSet resourceSet) {
        this.resourceSet = resourceSet;
    }

    public void setEntities(ConcurrentHashMap<String, MPEntityProto> entities) {
        this.entities = entities;
    }

    public void setTerrain(ConcurrentHashMap<String, MPTerrainCellProto> terrain) {
        this.terrain = terrain;
    }

    public void setLastSendTime(long lastSendTime) {
        this.lastSendTime = lastSendTime;
    }

    public void setStateUpdateLatencies(Vector<Long> stateUpdateLatencies) {
        this.stateUpdateLatencies = stateUpdateLatencies;
    }

    public void setCreatePlayerLatency(long createPlayerLatency) {
        this.createPlayerLatency = createPlayerLatency;
    }

    public void setAuthenticateLatency(long authenticateLatency) {
        this.authenticateLatency = authenticateLatency;
    }

    public void setGetPlayerLatency(long getPlayerLatency) {
        this.getPlayerLatency = getPlayerLatency;
    }

    public void setListWorldsLatency(long listWorldsLatency) {
        this.listWorldsLatency = listWorldsLatency;
    }

    public void setJoinWorldLatency(long joinWorldLatency) {
        this.joinWorldLatency = joinWorldLatency;
    }

    public void setGetInitialStateLatency(long getInitialStateLatency) {
        this.getInitialStateLatency = getInitialStateLatency;
    }

    public void setSubscribeLatency(long subscribeLatency) {
        this.subscribeLatency = subscribeLatency;
    }

    public BotCanvas getCanvas() {
        return canvas;
    }
}
