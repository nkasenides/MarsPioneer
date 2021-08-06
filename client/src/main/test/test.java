//import com.example.marspioneer.model.MPPlayer;
//import com.raylabz.objectis.Objectis;
//import com.raylabz.objectis.exception.ClassRegistrationException;
//import redis.clients.jedis.JedisPool;
//
//import java.util.List;
//
//public class test {
//
//    public static void main(String[] args) throws ClassRegistrationException {
//        Objectis.init(new JedisPool("localhost", 6379));
//        Objectis.register(MPPlayer.class);
//        final List<MPPlayer> items = Objectis.filter(MPPlayer.class)
//                .whereEqualTo("name", "player")
//                .limit(1)
//                .fetch().getItems();
//    }
//
//}
