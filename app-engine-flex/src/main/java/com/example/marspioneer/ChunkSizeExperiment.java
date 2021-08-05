package com.example.marspioneer;

import com.example.marspioneer.model.*;
import com.example.marspioneer.persistence.DBManager;
import com.example.marspioneer.state.State;
import com.raylabz.firestorm.Firestorm;
import com.raylabz.firestorm.util.FirebaseUtils;
import com.raylabz.objectis.Objectis;
import com.raylabz.objectis.exception.ClassRegistrationException;

import java.io.IOException;
import java.util.HashSet;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;

public class ChunkSizeExperiment {

    private static final HashSet<MatrixPosition> chunkQueries = new HashSet<>();
    private static final Vector<Long> latencies = new Vector<>();

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
                "  \"project_id\": \"rvgvb-mmog\",\n" +
                "  \"private_key_id\": \"781a74fac7795658119ce72c056eb861dc6ee6bc\",\n" +
                "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDzqF7doV77Amds\\nt9udZ/BwTjDtBjIg3wKHk7ckEQrucO/4vJy/AFEIeFVqphdMEoQsElrDQJd+XDjJ\\nnxCaI6Z11F0+J1CMjNBaw1is8Y5gG9bszDVozvzr7s1KUSmXQMmMnOtAPCbWY0yt\\ngkyBBGMn02tNEXDe2B3LPPgLDI5GRvRr5oVg+StHrHIcDjTuNzX7vH+QqSA7VyuA\\n6Al090IU6PwHIAe4jknOYBTRpyzyGhIhP4ZTUuAAnqiqPuIF4TcAVIilHRGd2gQ0\\nu4fkr11DA1U5VmxOyafFKZEx6+X9/U7QoUIZr1rmXvxNA9N+kmBL8z6eBonhkzDo\\n8zy0HzClAgMBAAECggEABNASE6Gg3SdmgJS/H0RS0P0SZVQmgFS3WZM23l0B0MTl\\nUI31MKaicx7hXQpr0mJZPv+b0FiBxYqvyne8XbcPjitELjqbkjMj2G8cXMomrEpQ\\ne/vqoCfaghSE9I9W2Xh7oq3kza+CeuCaPqEgvrml9b7s0yhhiN1O9Vk+cwVr+AJb\\n6oDgAyDSGVzEuJ4Dmbf7gRjkzXbI2WB0/TEQ+s5DqC2vf4ktvqWtzEvLeLjgA2U5\\nCVXjp6AaxBYd4OMsIjqPF3diamFLEUDzCg0F4WL9FDCiWZaYY2LlJw2YtdXQPSyW\\nZqSfjyc3K2O1B/PHjmZx9JD+VDHqACZFBW/2n0SoPwKBgQD9b5L5fJerWLQi8K1b\\n696+pIAISs96s0SN7JHEtPrJB4li4hbMmUhtpmRSFxpZnGZz5Psf4ChmdTqhlj5N\\nrDf/3BEmUeQZ+PRhA5i4uXHwIiI4JF2fBso4wu5zofm2IduaYsqo5PvqTp5XLZjZ\\n00imOX0SwkPuYVRShtrdPt/u8wKBgQD2H3hToPpStYwE7uqLV6maOsdpdTJHqaGf\\nVHMbitbn6Gxq7IppVWAS8MpEjfxQwoWNtgDErfK6XzbyBBKSSxZqD04vctKjF7F4\\nRyyDWI2Gmqg/8Ul+FQTD9O6HxdS0wcPaWnP5qG9YvfHN1GfPNs6mZIrCUPvR+KC5\\n2wdBQPu4BwKBgQDmPrt0VbElRk1BgQ6+eCfBY4m9/tlITB14Ivi7kQBWKrayU10L\\nPCcFFyoFOmACEYkyuVE8wFVz4AUIUIsB3fhyRuh9u+BTiE3c5XuWN0RAOYKFJuS3\\nWV/W+aHRA9LtmQz90cr0bjQ/xnUsFozLOJzEB26N4Ff+9gW5hDLK1hhz6QKBgHCY\\nyRWJSbvY7mu7WXXR7vdt+JiYUx5Rzmzz1408IUELJb5s5I13z3Ia0o42Xr4bn7nL\\nD+LqqWb19E8X6d8fluuCgQRYBWEzj6808HpOYsC3tE08d6DEwN9dCFr4+GyRUKZu\\nRyxqEDaK/zpo9+zmZ/fbe1eWcP4IPo+IUnNZ5U61AoGBAI3BNdMDrSyc7AnjrEXD\\nBVDsUFGpunRd9Q7b374fXlVr3/Of2DDTR0iZeViTUNscyHWkC5oN/i47ejL7kVEw\\nFNz45k/gBqeLLWSkQWLMrRWM9ndVUZaMMmkyJdczBefH9YJNfnYbmGzujqwqgoWO\\nzHkmePkY2JNv6DHlu3TL3SkH\\n-----END PRIVATE KEY-----\\n\",\n" +
                "  \"client_email\": \"firebase-adminsdk-jdmre@rvgvb-mmog.iam.gserviceaccount.com\",\n" +
                "  \"client_id\": \"100259596455481900396\",\n" +
                "  \"auth_uri\": \"https://accounts.google.com/o/oauth2/auth\",\n" +
                "  \"token_uri\": \"https://oauth2.googleapis.com/token\",\n" +
                "  \"auth_provider_x509_cert_url\": \"https://www.googleapis.com/oauth2/v1/certs\",\n" +
                "  \"client_x509_cert_url\": \"https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-jdmre%40rvgvb-mmog.iam.gserviceaccount.com\"\n" +
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
        world.setName("myWorld2");
        world.setHeightLimit(-1);
        world.setCreatedOn(System.currentTimeMillis());
        world.setId("myWorld2");
        DBManager.world.create(world);

        //Generate:
//        for (int i = 512; i <= 1023; i++) {
//            State.forWorld(world.getId()).requestChunk(0, i);
//        }

        //Retrieve:
        for (int col = 0; col < 1000; col++) {
            final MatrixPosition chunkPosition = MPTerrainChunk.getChunkPosition(0, col);
            chunkQueries.add(chunkPosition);
            final long t = System.currentTimeMillis();
            State.forWorld(world.getId()).requestChunk(chunkPosition.getRow(), chunkPosition.getCol());
            latencies.add((System.currentTimeMillis() - t));
        }

        int sumLatency = 0;
        for (Long latency : latencies) {
            sumLatency += latency;
        }

        double averageLatency = sumLatency / (double) latencies.size();
        double averageLatencyPerGeneration = sumLatency / (double) chunkQueries.size();

        System.out.println("Number of queries: " + chunkQueries.size());
        System.out.println("Average latency: " + averageLatency);
        System.out.println("Average latency per generation: " + averageLatencyPerGeneration);

    }

}
