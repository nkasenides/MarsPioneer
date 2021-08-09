/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Project Editor, v1.0 BETA
-------------------------------------------------------------------------------- */

package com.example.marspioneer.client.stubs;

import com.example.marspioneer.client.MPClient;
import com.example.marspioneer.client.simulation.Bot;
import com.example.marspioneer.client.websocket.*;
import com.neovisionaries.ws.client.WebSocketException;
import com.raylabz.mocha.Mocha;

import java.io.IOException;
import java.util.HashMap;

public final class Stubs {

    public static final String BASE_URL = "http://mars-pioneer-322210.oa.r.appspot.com";

    public static class Actions {
        private static BuildHubStub buildHubStub = null;
        public static BuildHubStub getBuildHubStub(MPClient client) throws WebSocketException, IOException {
            if (buildHubStub == null) {
                buildHubStub = new BuildHubStub(client);
            }
            return buildHubStub;
        }

        private static HashMap<String, SellBuildingStub> sellBuildingStubs = new HashMap<>();
        public static SellBuildingStub getSellBuildingStub(MPClient client) throws WebSocketException, IOException {
            if (sellBuildingStubs.get(client.getPlayer().getName()) == null) {
                sellBuildingStubs.put(client.getPlayer().getName(), new SellBuildingStub(client));
            }
            return sellBuildingStubs.get(client.getPlayer().getName());
        }

        private static HashMap<String, BuildSandPitStub> buildSandPitStubs = new HashMap<>();
        public static BuildSandPitStub getBuildSandPitStub(MPClient client) throws WebSocketException, IOException {
            if (buildSandPitStubs.get(client.getPlayer().getName()) == null) {
                buildSandPitStubs.put(client.getPlayer().getName(), new BuildSandPitStub(client));
            }
            return buildSandPitStubs.get(client.getPlayer().getName());
        }

        private static HashMap<String, BuildMineStub> buildMineStubs = new HashMap<>();
        public static BuildMineStub getBuildMineStub(MPClient client) throws WebSocketException, IOException {
            if (buildMineStubs.get(client.getPlayer().getName()) == null) {
                buildMineStubs.put(client.getPlayer().getName(), new BuildMineStub(client));
            }
            return buildMineStubs.get(client.getPlayer().getName());
        }

        private static HashMap<String, BuildFarmStub> buildFarmStubs = new HashMap<>();
        public static BuildFarmStub getBuildFarmStub(MPClient client) throws WebSocketException, IOException {
            if (buildFarmStubs.get(client.getPlayer().getName()) == null) {
                final BuildFarmStub stub = new BuildFarmStub(client);
                Mocha.start(stub);
                buildFarmStubs.put(client.getPlayer().getName(), stub);
            }
            return buildFarmStubs.get(client.getPlayer().getName());
        }

        private static HashMap<String, BuildWellStub> buildWellStubs = new HashMap<>();
        public static BuildWellStub getBuildWellStub(MPClient client) throws WebSocketException, IOException {
            if (buildWellStubs.get(client.getPlayer().getName()) == null) {
                buildWellStubs.put(client.getPlayer().getName(), new BuildWellStub(client));
            }
            return buildWellStubs.get(client.getPlayer().getName());
        }

        //Simulation:
        private final static HashMap<String, BotBuildHubStub> botBuildHubStubMap = new HashMap<>();
        public static BotBuildHubStub getBotBuildHubStub(Bot bot) throws WebSocketException, IOException {
            if (botBuildHubStubMap.get(bot.getPlayer().getName()) == null) {
                botBuildHubStubMap.put(bot.getPlayer().getName(), new BotBuildHubStub(bot));
            }
            return botBuildHubStubMap.get(bot.getPlayer().getName());
        }

        private final static HashMap<String, BotSellBuildingStub> botSellBuildingStubMap = new HashMap<>();
        public static BotSellBuildingStub getBotSellBuildingStub(Bot bot) throws WebSocketException, IOException {
            if (botSellBuildingStubMap.get(bot.getPlayer().getName()) == null) {
                botSellBuildingStubMap.put(bot.getPlayer().getName(), new BotSellBuildingStub(bot));
            }
            return botSellBuildingStubMap.get(bot.getPlayer().getName());
        }

        private static final HashMap<String, BotBuildSandPitStub> botBuildSandPitStubMap = new HashMap<>();
        public static BotBuildSandPitStub getBotBuildSandPitStub(Bot bot) throws WebSocketException, IOException {
            if (botBuildSandPitStubMap.get(bot.getPlayer().getName()) == null) {
                botBuildSandPitStubMap.put(bot.getPlayer().getName(), new BotBuildSandPitStub(bot));
            }
            return botBuildSandPitStubMap.get(bot.getPlayer().getName());
        }

        private static final HashMap<String, BotBuildMineStub> botBuildMineStubMap = new HashMap<>();
        public static BotBuildMineStub getBotBuildMineStub(Bot bot) throws WebSocketException, IOException {
            if (botBuildMineStubMap.get(bot.getPlayer().getName()) == null) {
                botBuildMineStubMap.put(bot.getPlayer().getName(), new BotBuildMineStub(bot));
            }
            return botBuildMineStubMap.get(bot.getPlayer().getName());
        }

        private static final HashMap<String, BotBuildFarmStub> botBuildFarmStubMap = new HashMap<>();
        public static BotBuildFarmStub getBotBuildFarmStub(Bot bot) throws WebSocketException, IOException {
            if (botBuildFarmStubMap.get(bot.getPlayer().getName()) == null) {
                botBuildFarmStubMap.put(bot.getPlayer().getName(), new BotBuildFarmStub(bot));
            }
            return botBuildFarmStubMap.get(bot.getPlayer().getName());
        }

        private static final HashMap<String, BotBuildWellStub> botBuildWellStubMap = new HashMap<>();
        public static BotBuildWellStub getBotBuildWellStub(Bot bot) throws WebSocketException, IOException {
            if (botBuildWellStubMap.get(bot.getPlayer().getName()) == null) {
                botBuildWellStubMap.put(bot.getPlayer().getName(), new BotBuildWellStub(bot));
            }
            return botBuildWellStubMap.get(bot.getPlayer().getName());
        }

    }

    public static ListTeams listTeamsStub() {

        return new ListTeams();
    }
    public static UpdatePlayer updatePlayerStub() {

        return new UpdatePlayer();
    }
    public static GetWorld getWorldStub() {

        return new GetWorld();
    }
    public static UpdateTeam updateTeamStub() {

        return new UpdateTeam();
    }
    public static Subscribe subscribeStub() {

        return new Subscribe();
    }
    public static ListPlayers listPlayersStub() {

        return new ListPlayers();
    }
    public static GetTeam getTeamStub() {

        return new GetTeam();
    }
    public static RemovePlayerFromTeam removePlayerFromTeamStub() {

        return new RemovePlayerFromTeam();
    }
    public static GetBuildingType getBuildingTypeStub() {

        return new GetBuildingType();
    }
    public static Authenticate authenticateStub() {

        return new Authenticate();
    }
    public static UpdateBuildingType updateBuildingTypeStub() {

        return new UpdateBuildingType();
    }
    public static Unsubscribe unsubscribeStub() {

        return new Unsubscribe();
    }
    public static CreateWorld createWorldStub() {

        return new CreateWorld();
    }
    public static DeleteWorld deleteWorldStub() {

        return new DeleteWorld();
    }
    public static ListWorlds listWorldsStub() {

        return new ListWorlds();
    }
    public static UpdateWorld updateWorldStub() {

        return new UpdateWorld();
    }
    public static ListTeamPlayers listTeamPlayersStub() {

        return new ListTeamPlayers();
    }
    public static CreatePlayer createPlayerStub() {

        return new CreatePlayer();
    }
    public static JoinWorld joinWorldStub() {

        return new JoinWorld();
    }
    public static DeAuthenticate deAuthenticateStub() {

        return new DeAuthenticate();
    }
    public static DeletePlayer deletePlayerStub() {

        return new DeletePlayer();
    }
    public static LeaveWorld leaveWorldStub() {

        return new LeaveWorld();
    }
    public static GetPlayer getPlayerStub() {

        return new GetPlayer();
    }
    public static AddPlayerToTeam addPlayerToTeamStub() {

        return new AddPlayerToTeam();
    }
    public static DeleteBuildingType deleteBuildingTypeStub() {

        return new DeleteBuildingType();
    }
    public static ListBuildingTypes listBuildingTypesStub() {

        return new ListBuildingTypes();
    }
    public static CreateTeam createTeamStub() {

        return new CreateTeam();
    }
    public static DeleteTeam deleteTeamStub() {

        return new DeleteTeam();
    }
    public static GetState getStateStub() {

        return new GetState();
    }
    public static CreateBuildingType createBuildingTypeStub() {

        return new CreateBuildingType();
    }

//    private static UpdateStateStub updateStateStub = null;

    private static HashMap<String, UpdateStateStub> updateStateStubs = new HashMap<>();

    public static UpdateStateStub getUpdateStateStub(MPClient client) throws WebSocketException, IOException {
        if (updateStateStubs.get(client.getPlayer().getName()) == null) {
            final UpdateStateStub stub = new UpdateStateStub(client);
            Mocha.start(stub);
            updateStateStubs.put(client.getPlayer().getName(), stub);
        }
        return updateStateStubs.get(client.getPlayer().getName());
    }

    //Simulation:
    private static HashMap<String, BotUpdateStateStub> botUpdateStateStubs = new HashMap<>();
    public static BotUpdateStateStub getBotUpdateStateStub(Bot bot) throws WebSocketException, IOException {
        if (botUpdateStateStubs.get(bot.getPlayer().getName()) == null) {
            final BotUpdateStateStub stub = new BotUpdateStateStub(bot);
            Mocha.start(stub);
            botUpdateStateStubs.put(bot.getPlayer().getName(), stub);
        }
        return botUpdateStateStubs.get(bot.getPlayer().getName());
    }


}
