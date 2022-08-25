import com.example.marspioneer.model.MPPlayer;
import com.example.marspioneer.proto.*;
import com.google.gson.Gson;
import com.google.protobuf.InvalidProtocolBufferException;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.UUID;

public class Test {

    static class WrapperObjectJSON {
        private ArrayList<MPPlayer> players = new ArrayList<>();

        public ArrayList<MPPlayer> getPlayers() {
            return players;
        }

        public void setPlayers(ArrayList<MPPlayer> players) {
            this.players = players;
        }
    }

    public static void main(String[] args) throws InvalidProtocolBufferException {

        for (int xx = 0; xx < 4; xx++) {

            final int NUM_OF_OBJECTS = 1;

            ArrayList<MPPlayer> players = new ArrayList<>();
            for (int i = 0; i < NUM_OF_OBJECTS; i++) {
                MPPlayer p = new MPPlayer();
                p.setId(UUID.randomUUID().toString());
                p.setCreatedOn(System.currentTimeMillis());
                p.setFarmingResearch(FarmResearchLevel.LEVEL_1_FarmResearchLevel);
                p.setMiningResearch(MineResearchLevel.LEVEL_1_MineResearchLevel);
                p.setSandResearch(SandPitResearchLevel.LEVEL_1_SandPitResearchLevel);
                p.setWaterResearch(WellResearchLevel.LEVEL_1_WellResearchLevel);
                p.setFood(100);
                p.setSand(100);
                p.setMetal(100);
                p.setWater(100);
                p.setLastCollected(System.currentTimeMillis());
                p.setPassword(UUID.randomUUID().toString());
                p.setName("Random player");
                p.setTeamID(UUID.randomUUID().toString());
                players.add(p);
            }

            Gson gson = new Gson();

            WrapperObjectJSON wrapper = new WrapperObjectJSON();
            wrapper.setPlayers(players);

            long jsonStartTime = System.nanoTime();
            String s = gson.toJson(wrapper);
            long jsonFinishTime = System.nanoTime();

            System.out.println(NUM_OF_OBJECTS + " OBJECTS");

            long protoStartTime = System.nanoTime();
            ArrayList<MPPlayerProto> playerProtos = new ArrayList<>();
            for (MPPlayer p : players) {
                playerProtos.add(p.toProto().build());
            }
            long protoFinishTime = System.nanoTime();

            ArrayList<byte[]> protoBytes = new ArrayList<>();

            long protoSizeCount = 0;
            for (MPPlayerProto p : playerProtos) {
                int length = p.toByteArray().length;
                protoSizeCount += length;
                protoBytes.add(p.toByteArray());
            }

            //---

            long jsonDeserializationStart = System.nanoTime();
            WrapperObjectJSON wrapperObjectJSON = gson.fromJson(s, WrapperObjectJSON.class);
            long jsonDeserializationFinish = System.nanoTime();

            long protoDeserializationStart = System.nanoTime();
            for (byte[] bytes : protoBytes) {
                MPPlayerProto proto = MPPlayerProto.parseFrom(bytes);
            }
            long protoDeserializationFinish = System.nanoTime();

            if (xx != 0) {

                System.out.println("JSON SERIALIZATION TIME: " + (jsonFinishTime - jsonStartTime));
                System.out.println("JSON DE-SERIALIZATION TIME: " + (jsonDeserializationFinish - jsonDeserializationStart));
                System.out.println("JSON SIZE: " + s.getBytes(StandardCharsets.UTF_8).length);

                System.out.println("PROTO SERIALIZATION TIME: " + (protoFinishTime - protoStartTime));
                System.out.println("PROTO DE-SERIALIZATION TIME: " + (protoDeserializationFinish - protoDeserializationStart));
                System.out.println("PROTO SIZE: " + (protoSizeCount));
            }

            System.out.println();
            System.out.println();

        }

    }

}
