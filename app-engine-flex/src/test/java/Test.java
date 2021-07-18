import com.example.marspioneer.model.MPGameSession;
import com.example.marspioneer.model.MPPlayer;
import com.raylabz.objectis.Objectis;
import com.raylabz.objectis.exception.ClassRegistrationException;

public class Test {

    public static void main(String[] args) throws ClassRegistrationException {
        Objectis.init();
        Objectis.register(MPPlayer.class);
        Objectis.register(MPGameSession.class);
        final MPPlayer mpPlayer = Objectis.get(MPPlayer.class, "fc152ef3-dd6a-4ecf-8008-5bc9231b87cc");
        System.out.println(mpPlayer.getId());

        final MPGameSession gameSession = Objectis.get(MPGameSession.class, "135609e9-1fa6-4741-959c-69e921c495d0");
        System.out.println(gameSession.getId());
        System.out.println(gameSession.getPlayerID());

    }

}
