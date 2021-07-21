import com.example.marspioneer.model.*;
import com.raylabz.firestorm.Firestorm;
import com.raylabz.firestorm.util.FirebaseUtils;

import java.io.IOException;
import java.util.ArrayList;

public class CleanUp {

    public static void main(String[] args) {
        //Init Firestore:
        final String SERVICE_ACCOUNT = "{\n" +
                "  \"type\": \"service_account\",\n" +
                "  \"project_id\": \"mars-pioneer\",\n" +
                "  \"private_key_id\": \"7b13c8886c566f1493c5bb54767a8017f349975b\",\n" +
                "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDE1b3eqTyuLStp\\nfUYX/rbJpoHIKtDInK9Ul02r8w03tOpgj8Y9yIl4WDtbF5TXjiIjfWVd6Kjgt78D\\nZHGM30NbBuE+EH2lyaSpM4w/+eRAka+9ZDEnRKZn+/Y6MitEqptCzx+tYW2tDKU7\\nhdtixJ3o+n1HK8r01N8nCnacjWkqi5rtMqpk4nW6e1WyXJjMOWVl35mYR+M8uq7q\\nAN8YEIt3ieKUAM0OyxTU/Xcgvv+4NnKVRXvgMIZ9tTrgfRs1zh7gFfhdCjH0fbXm\\ninuN+AGbG15gfGn/Gc23VIDMiDmglr6Z82wy70czQ+PZQKLDThE5kWLy2kWWeBHe\\nqrB6W/HDAgMBAAECggEANHigJV+rD+l1pajiCxp5IrdS6IfVYW03Zg7xgzGHJ/7/\\n7d7V43l2gBDRPd7C7FV0704JvCd+AW2qK17W0E1iGL10RQXDYPMohHx72kAk4zuT\\nBCNV4RhxXc3ynR/rneH3Aq/RS3hp8tQopf3wdltglw9TXyoi7/JhTHiDFwexbcgS\\nTLz7wFb/Cp9FGnpsql7eQYgZZuoHNjJPWvelxiMELAjGrFMqmBOo3v2Ase58Jth0\\n5yNlhYldLn+038ZbiSEiQjy69fYMXC1J/jRRMjjrkIPvAXwoKM/Eyu2eoMXw+EN6\\npu3AizIpHGNTl2z4uSz2gpIdaQ21oEzVjeiw/EYiBQKBgQD1V2xZBaAF3r8nCXA3\\nvQhXDD5oYn5UNix7dcFzt5UEDjYT2IY0qBI2aadLURUdhnYIfInEyL6ZnZcEHPwx\\nYJ8Y1FGbMZCBnDP2b7DfApeBydNs4PS/0OJPLbHmGyOyUfpuBPSrSoTYjc+V7lp1\\nL0FBMLzEIPm6zJ7IjoK7i7DUDwKBgQDNYtm0TIdtIY+Jqu4xrHUW31mn6oO2R0dW\\nRgYhAeJTD9cxbY/9gznzRMkjU/GB7qF2jO3oW1t3SPL9FrOSkpyDtt27sf4EkY7m\\nyzJyy/PEjpRQ3sQ5gTEl3EfqEj/zTlcbzWHgQmJEDkylRPUMhpS58baS+j7Asp3Y\\n9oD2WMsDDQKBgQCuKVhNvbOCV0SE9qtFthhEivmGalzZdPeQ0N/6QFk1Xs0+u1dR\\n6/m5zLiou69snTYPAjFek07Sh89baSQR/VATdS1VKRM3Hua4S0NYnGNnDBndUbgM\\nrsDoijyeZ6eof49yKGxzaFvzyn+RJHnsdBYzq+Bkri/5TiZtotTlQ93MOwKBgQCd\\nHvodDE6uFfaRAsqmBaCtlsAnzShl0bGpNniJ178kfAHMNlzpO/KhQAX/mMAw/jVX\\nVAjMsNcQMiZxp2RIxRAnU0XdyRTiudfwh5JYb95UiB6+nyzOMR9AL3x0fPGfWFcb\\nVcuCnEZAeg/4fwBYTLyKY3egiQBoujw3Np0B2Hu2IQKBgAwx+IWZXsfkBzRhQpMg\\n0cEAojRAXPnroFllgDWEkp4B1a8V92On3plZjdK6FoPTvElcBENmIcR8sDhsbCkl\\n/awMpITREuve1X3ldDuapbBs/taDYimULj8AfCnlssDb7k3r/cGIElrsIo2xxrq3\\nZ5o3ku6P9Mtqs4bO4egcq6Od\\n-----END PRIVATE KEY-----\\n\",\n" +
                "  \"client_email\": \"firebase-adminsdk-192t0@mars-pioneer.iam.gserviceaccount.com\",\n" +
                "  \"client_id\": \"111770469574465439736\",\n" +
                "  \"auth_uri\": \"https://accounts.google.com/o/oauth2/auth\",\n" +
                "  \"token_uri\": \"https://oauth2.googleapis.com/token\",\n" +
                "  \"auth_provider_x509_cert_url\": \"https://www.googleapis.com/oauth2/v1/certs\",\n" +
                "  \"client_x509_cert_url\": \"https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-192t0%40mars-pioneer.iam.gserviceaccount.com\"\n" +
                "}\n";

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
        Firestorm.register(MPTerrainIdentifier.class);

        System.out.println("--- STARTING CLEANUP ---");

        {
            final ArrayList<BuildingEntity> items = Firestorm.listAll(BuildingEntity.class);
            for (BuildingEntity i : items) {
                System.out.println("Deleting " + i.getId());
                Firestorm.delete(i);
            }
        }

        {
            final ArrayList<MPGameSession> items = Firestorm.listAll(MPGameSession.class);
            for (MPGameSession i : items) {
                System.out.println("Deleting " + i.getId());
                Firestorm.delete(i);
            }
        }

        {
            final ArrayList<MPWorld> items = Firestorm.listAll(MPWorld.class);
            for (MPWorld i : items) {
                System.out.println("Deleting " + i.getId());
                Firestorm.delete(i);
            }
        }

        {
            final ArrayList<MPWorldSession> items = Firestorm.listAll(MPWorldSession.class);
            for (MPWorldSession i : items) {
                System.out.println("Deleting " + i.getId());
                Firestorm.delete(i);
            }
        }

        {
            final ArrayList<MPTeam> items = Firestorm.listAll(MPTeam.class);
            for (MPTeam i : items) {
                System.out.println("Deleting " + i.getId());
                Firestorm.delete(i);
            }
        }

        {
            final ArrayList<MPPlayer> items = Firestorm.listAll(MPPlayer.class);
            for (MPPlayer i : items) {
                System.out.println("Deleting " + i.getId());
                Firestorm.delete(i);
            }
        }

        {
            final ArrayList<MPTerrainChunk> items = Firestorm.listAll(MPTerrainChunk.class);
            for (MPTerrainChunk i : items) {
                System.out.println("Deleting " + i.getId());
                Firestorm.delete(i);
            }
        }
        {
            final ArrayList<MPTerrainIdentifier> items = Firestorm.listAll(MPTerrainIdentifier.class);
            for (MPTerrainIdentifier i : items) {
                System.out.println("Deleting " + i.getId());
                Firestorm.delete(i);
            }
        }

        System.out.println("--- CLEAN UP FINISHED ---");

    }

}
