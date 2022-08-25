import com.example.marspioneer.contextlistener.FirestormContextListener;
import com.example.marspioneer.model.*;
import com.example.marspioneer.persistence.MPPlayerDAO;
import com.example.marspioneer.persistence.MPWorldDAO;
import com.example.marspioneer.proto.*;
import com.raylabz.firestorm.Firestorm;
import com.raylabz.firestorm.util.FirebaseUtils;
import com.raylabz.objectis.Objectis;
import com.raylabz.objectis.exception.ClassRegistrationException;

import javax.servlet.ServletContextEvent;
import java.io.IOException;
import java.util.ArrayList;

public class DAOTest {

    public static void main(String[] args) throws ClassRegistrationException {
        //Init Firestore:
        try {
            FirebaseUtils.initialize(SERVICE_ACCOUNT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Firestorm.init();

        Firestorm.register(BuildingEntity.class);
        Firestorm.register(MPGameSession.class);
        Firestorm.register(MPWorld.class);
        Firestorm.register(MPWorldSession.class);
        Firestorm.register(MPTeam.class);
        Firestorm.register(MPPlayer.class);
        Firestorm.register(MPTerrainChunk.class);

        MPTerrainChunk c = new MPTerrainChunk();
        Firestorm.create(c);

    }

}
