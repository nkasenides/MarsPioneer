package com.example.marspioneer;

import com.example.marspioneer.model.*;
import com.example.marspioneer.persistence.DBManager;
import com.example.marspioneer.state.State;
import com.raylabz.firestorm.Firestorm;
import com.raylabz.firestorm.util.FirebaseUtils;
import com.raylabz.objectis.Objectis;
import com.raylabz.objectis.exception.ClassRegistrationException;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class StateRetrievalTimeExperiment {

    private static final AtomicInteger chunksGenerated = new AtomicInteger(0);

    public static void main(String[] args) throws ClassRegistrationException {
        //Init Firestore:
//        final String SERVICE_ACCOUNT = "{\n" +
//                "  \"type\": \"service_account\",\n" +
//                "  \"project_id\": \"mars-pioneer\",\n" +
//                "  \"private_key_id\": \"7b13c8886c566f1493c5bb54767a8017f349975b\",\n" +
//                "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDE1b3eqTyuLStp\\nfUYX/rbJpoHIKtDInK9Ul02r8w03tOpgj8Y9yIl4WDtbF5TXjiIjfWVd6Kjgt78D\\nZHGM30NbBuE+EH2lyaSpM4w/+eRAka+9ZDEnRKZn+/Y6MitEqptCzx+tYW2tDKU7\\nhdtixJ3o+n1HK8r01N8nCnacjWkqi5rtMqpk4nW6e1WyXJjMOWVl35mYR+M8uq7q\\nAN8YEIt3ieKUAM0OyxTU/Xcgvv+4NnKVRXvgMIZ9tTrgfRs1zh7gFfhdCjH0fbXm\\ninuN+AGbG15gfGn/Gc23VIDMiDmglr6Z82wy70czQ+PZQKLDThE5kWLy2kWWeBHe\\nqrB6W/HDAgMBAAECggEANHigJV+rD+l1pajiCxp5IrdS6IfVYW03Zg7xgzGHJ/7/\\n7d7V43l2gBDRPd7C7FV0704JvCd+AW2qK17W0E1iGL10RQXDYPMohHx72kAk4zuT\\nBCNV4RhxXc3ynR/rneH3Aq/RS3hp8tQopf3wdltglw9TXyoi7/JhTHiDFwexbcgS\\nTLz7wFb/Cp9FGnpsql7eQYgZZuoHNjJPWvelxiMELAjGrFMqmBOo3v2Ase58Jth0\\n5yNlhYldLn+038ZbiSEiQjy69fYMXC1J/jRRMjjrkIPvAXwoKM/Eyu2eoMXw+EN6\\npu3AizIpHGNTl2z4uSz2gpIdaQ21oEzVjeiw/EYiBQKBgQD1V2xZBaAF3r8nCXA3\\nvQhXDD5oYn5UNix7dcFzt5UEDjYT2IY0qBI2aadLURUdhnYIfInEyL6ZnZcEHPwx\\nYJ8Y1FGbMZCBnDP2b7DfApeBydNs4PS/0OJPLbHmGyOyUfpuBPSrSoTYjc+V7lp1\\nL0FBMLzEIPm6zJ7IjoK7i7DUDwKBgQDNYtm0TIdtIY+Jqu4xrHUW31mn6oO2R0dW\\nRgYhAeJTD9cxbY/9gznzRMkjU/GB7qF2jO3oW1t3SPL9FrOSkpyDtt27sf4EkY7m\\nyzJyy/PEjpRQ3sQ5gTEl3EfqEj/zTlcbzWHgQmJEDkylRPUMhpS58baS+j7Asp3Y\\n9oD2WMsDDQKBgQCuKVhNvbOCV0SE9qtFthhEivmGalzZdPeQ0N/6QFk1Xs0+u1dR\\n6/m5zLiou69snTYPAjFek07Sh89baSQR/VATdS1VKRM3Hua4S0NYnGNnDBndUbgM\\nrsDoijyeZ6eof49yKGxzaFvzyn+RJHnsdBYzq+Bkri/5TiZtotTlQ93MOwKBgQCd\\nHvodDE6uFfaRAsqmBaCtlsAnzShl0bGpNniJ178kfAHMNlzpO/KhQAX/mMAw/jVX\\nVAjMsNcQMiZxp2RIxRAnU0XdyRTiudfwh5JYb95UiB6+nyzOMR9AL3x0fPGfWFcb\\nVcuCnEZAeg/4fwBYTLyKY3egiQBoujw3Np0B2Hu2IQKBgAwx+IWZXsfkBzRhQpMg\\n0cEAojRAXPnroFllgDWEkp4B1a8V92On3plZjdK6FoPTvElcBENmIcR8sDhsbCkl\\n/awMpITREuve1X3ldDuapbBs/taDYimULj8AfCnlssDb7k3r/cGIElrsIo2xxrq3\\nZ5o3ku6P9Mtqs4bO4egcq6Od\\n-----END PRIVATE KEY-----\\n\",\n" +
//                "  \"client_email\": \"firebase-adminsdk-192t0@mars-pioneer.iam.gserviceaccount.com\",\n" +
//                "  \"client_id\": \"111770469574465439736\",\n" +
//                "  \"auth_uri\": \"https://accounts.google.com/o/oauth2/auth\",\n" +
//                "  \"token_uri\": \"https://oauth2.googleapis.com/token\",\n" +
//                "  \"auth_provider_x509_cert_url\": \"https://www.googleapis.com/oauth2/v1/certs\",\n" +
//                "  \"client_x509_cert_url\": \"https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-192t0%40mars-pioneer.iam.gserviceaccount.com\"\n" +
//                "}\n";

        final String SERVICE_ACCOUNT = "{\n" +
                "  \"type\": \"service_account\",\n" +
                "  \"project_id\": \"terrastates\",\n" +
                "  \"private_key_id\": \"6d8c06155fdc90463afae68351e5c37db5e8cf74\",\n" +
                "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCuWmOFBIn9ILdE\\nkg6TN2Aon2IkUaMdgM7Z6RGcO2EHBAPkum4dUTQe5Aw+0scH3/Rynt2+AAg93r7c\\nLoNlpZk1OPuLnR9T99tKREtbZJnVq4UBsS5Y6Kaxmupe+EYH28onzIYzAcVJroxz\\ne3l9IyADYQRWn+VfYxkt4gpmSblu7uxLoF/ZaZw2O3h5olbWCYDBYQ+3KNOBkSRA\\nRROPWxjFxy79yhnntu14JRQRWCcT+eB71mzMvcvlNSPCct46gjlM4r+i1NmdA0Kf\\nUmVHmLIwjXRWP5WBfZNpDuw+wKZJQsuHi/dkwCRYQEMUP7QBRJExJXCzydcypya1\\nVYNcCx7bAgMBAAECggEACP1nIT4v1pSVGTIwvIgqlfL14//Y7xYA/xJkko+AkWnf\\nFjBDVOamzyryCLE54EmSDfDsEmESYQz2/rJf8GHz/t8JH/9CKhm0aGVnafcgyXgh\\nEQpvjy0GdKTouGyJFob6KvLW6T1fofd1OCUh3qvCJE/LIfj3ojihXTtzpCeL/1C4\\n+NB9PwpiGCMr2apNCXOikLPx56j1pYdM9akBRfKGXaXnsAIczUckHNjAKJxaihNz\\nxo83oPyatPifeoWzqDo73GN4LWQ0yTP7lWRgEd4rbJcR/Ouu3u++NPHaSER511Uz\\nMc9SVMJMRBptmrrjV4+WW+mOuXqJBThiKbADh6kU9QKBgQDabZ/siaoZeO7MWkvg\\niNtjSgETejFIe2yoz9Trt4kiys9GaHfiPQSmJV6EdQgKnO3ianC5cBC518QeSQcu\\n8yrw8wT0FScdgPWZJADPMta64wA+sDvNq2WgLaiYhpXQ27Z8aeJUyrZWbiKy6qVB\\ntViJ8lHNahaZ6vcnAqtr5hRTHQKBgQDMV/AOib5wmz0XoseUSFtAzqXTiQ0cZ7Xp\\n74m6p1Zmi0rwgbCNCsZgH1vUaN9B/vh1QppTZg1roYlhqULP5eLZFzZAJ/GtNGbl\\ncPfaePFK+JBVwhH9DCav1+lyjnsNtKGrusv7G0jr+QmsaIvh/lNX7ZUNFOb1Bm3R\\n9bJ4wlhgVwKBgQCo2swhiD6V2HYKRdeYaVPoCqKQUwrcNIXIbnn0CvsZiVz42fOr\\nUm5QnlzV2r7vrWb8fDpOMELN1+3FV8EU22ibwdJXei610SaLT1jM1ElJSgi7bXOd\\nx90VGZbW6lvQjLkirpwH3nlckWGDnH9KL42Vfl0cheGY9RpA7wBjtgaKRQKBgQC2\\n+D6xJdFqDvbDBTRjp+5dtytwoBUnTA3tbFkM0u1gYHU3qUim4fEC/NFC/qx58Y4T\\noRGCf6ygpUHYOrDiatuWu1wOUjXqezNvWpnz+7tDABJtV5q31HuHlHMp6j5w5T6m\\nAFrJe4LuGE37HJm0P//siYWe8wpid+E50SB/VLXBfQKBgCO81MtsEnT7aqYjuVMv\\nzADWdSLeoVfVHh6UWRdbpyHKlXduIdIZd1/wEQ0uwH7a0CX0fj4se6/HeidlNeng\\nrC6DFW8fBN19gpZTWxYIMxFMugZ8ewDpFn6dBJZy/jdtG/FoMgRW+iTXU0R5MVTz\\nqYqtNXebBJPQmVZYnW8TACeu\\n-----END PRIVATE KEY-----\\n\",\n" +
                "  \"client_email\": \"firebase-adminsdk-inoj2@terrastates.iam.gserviceaccount.com\",\n" +
                "  \"client_id\": \"115521931411720005333\",\n" +
                "  \"auth_uri\": \"https://accounts.google.com/o/oauth2/auth\",\n" +
                "  \"token_uri\": \"https://oauth2.googleapis.com/token\",\n" +
                "  \"auth_provider_x509_cert_url\": \"https://www.googleapis.com/oauth2/v1/certs\",\n" +
                "  \"client_x509_cert_url\": \"https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-inoj2%40terrastates.iam.gserviceaccount.com\"\n" +
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

        Objectis.init();
        Objectis.register(BuildingEntity.class);
        Objectis.register(MPGameSession.class);
        Objectis.register(MPWorld.class);
        Objectis.register(MPWorldSession.class);
        Objectis.register(MPTeam.class);
        Objectis.register(MPPlayer.class);
        Objectis.register(MPTerrainChunk.class);
        Objectis.register(MPTerrainIdentifier.class);

        MPWorld world = new MPWorld();
        world.setMaxCols(-1);
        world.setMaxRows(-1);
        world.setSeed(1234);
        world.setName("myWorld");
        world.setHeightLimit(-1);
        world.setCreatedOn(System.currentTimeMillis());
        world.setId("myWorld");
        DBManager.world.create(world);

        //Generate:
//        for (int i = 512; i <= 1023; i++) {
//            State.forWorld(world.getId()).requestChunk(0, i);
//        }


        //Retrieve:
        final long t = System.currentTimeMillis();
        final MPTerrainChunk chunk = State.forWorld(world.getId()).requestChunk(0, 0);
        System.out.println("Time taken: " + (System.currentTimeMillis() - t) + "ms");

        System.out.println(chunk.getPosition().getRow() + " " + chunk.getPosition().getRow());

    }

}
