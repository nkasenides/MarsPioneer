package com.example.marspioneer.contextlistener;

import com.example.marspioneer.model.*;
import com.raylabz.firestorm.Firestorm;
import com.raylabz.firestorm.util.FirebaseUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;

@WebListener
public class FirestormContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //Init Firestore:
        final String SERVICE_ACCOUNT = "{\n" +
                "  \"type\": \"service_account\",\n" +
                "  \"project_id\": \"mars-pioneer\",\n" +
                "  \"private_key_id\": \"735ed8c2a2ce7affad69d832fdb290d9df30cfa5\",\n" +
                "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCcGz6RVvj7CMpg\\nlQ7ycJHLv5kJ+dqnWK/W/kXjtnP4vbba/Q/EIYb+VWaltvgMb+84XCh1ohZGNjkw\\nA5xbZ5nNOevdC0dA5BlNq4yPPbMrqRqIRqFdxxhMNiIH9rlPMpoLsDAAiUDN4AHh\\nn7MWtG8ebMtdhArE9ydzQIr+nCkV/SzpJLpW4acr+exGkHkwS616UDU8DVhAsIP2\\negZ83gCiEcI7Z6SEvVpSqScCe4BRKQ8A0fsXPFAjoL1bs1OL7TVLH4u2BS4PSd7/\\nFlxrr+wM1fdtCYiounDDW0XyySpKhAOC7jSVPqBA8vOm/re4YX7lY8x+xCnHkRyI\\nj5ayHauxAgMBAAECggEAQSdZ2N1c86F6ng74exWitFBWdoRyzy/DzE66Ks1m3+WG\\noSXH48s+hX5tZjLUmpRJWtOUC2zIMSvGeJS5OKkn1zEakVp4tcu+B93Wv5433rwo\\nl8Iq7XIAYSai04IVW8m547D4h/DBPGwHPP0jiRFr413zDyfiOs0RCRhiKtxQhZ1L\\nM2FtGCZBGhd5XOoQLtKa3j/FvnAZKriyQj+7DKvcwh4a4ICSzMbhKXHgbitgkcgY\\nR4wY2PZzOSMKAxazLddZUqiRB0dUazdpoBVWEeM+zxxPB/9DzbaFjySSKgOTmSJE\\ns4qta0KTLuGWGjCPIFBJg36pJSqeG4URMCa37/dBxQKBgQDYOLL51EZz5HNiDWMh\\nnOE/8hEB2Jm16LBcscerlP52xa8v/7GWsmLCWbbpV8a8dhrMOmD6OsqHXEz2G/Ft\\n01m7n3ZNQMTPSqCLWp0zo53UXj+IW/HSvDnCTGYjyWcvoST2Uwv620GdnxPFdtaw\\nkDnleydepdaq5Cn/RDSLdGf87wKBgQC401RLXbWXNnyPEVc5JoFx4E9pKfz5PEoe\\nYxX66jRWZTBGflps5dCCf+UhQu8aV4HO1nXw+AEZR8AqNhBmLeDa3WyxgtjOFJlo\\niWg1YHZXQ7b5ZEYRdzFB6VC/OvPFEIwnl0U1ObGNi6L9+NZ4Ob73R5ZC5AB0ZTsZ\\n4uZmftQhXwKBgFjWmvq49CWD1MCRvYw+9/GdFM3MYAN00pmTVfWypwbH3F39UcsY\\nCinOUK/5J6ehYwtMZTIK29HX46su+fhk4TaMoz/Ef9in0eTP200vSZbLDpGJLYen\\nXJfvafwEMUhJjnVC0+ZDFeecR7RXSoiLCa629gsWWmgmjPbb4Db4Ig2zAoGAYrbk\\nb7hmM5QzZMpTNr/9JRAz+awmZAuyXpZ3d+M8/uPeq9fyffUkr36Vp3UzdXNFbm6W\\n4ZPkKldrKGBl090vGlZnJkwHddIEuZOiJ9gUfLk68ep/jfaGRXjS2sAm0Jrs8HxX\\nx3y/+ySYcmNEUUQuXa5LcACMyZ4Duei5PAcDT6sCgYEAgC2adZvK/GWRqXf5FbYz\\nFBpCC8QOr59Mtb54UxQsvqhdqxskSpQA9tuLnSFCL5pfQ8Fu2a7ZxI9TgtWmkR/5\\nNFRBN6Ar+TNdRl5vbH8xX3HoNqqDLh02lbZjjFOhUS0s6bZVS/9Lkv8mYXORu86q\\n11MJfOYTSI0/2bZJoPSZEeo=\\n-----END PRIVATE KEY-----\\n\",\n" +
                "  \"client_email\": \"firebase-adminsdk-192t0@mars-pioneer.iam.gserviceaccount.com\",\n" +
                "  \"client_id\": \"111770469574465439736\",\n" +
                "  \"auth_uri\": \"https://accounts.google.com/o/oauth2/auth\",\n" +
                "  \"token_uri\": \"https://oauth2.googleapis.com/token\",\n" +
                "  \"auth_provider_x509_cert_url\": \"https://www.googleapis.com/oauth2/v1/certs\",\n" +
                "  \"client_x509_cert_url\": \"https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-192t0%40mars-pioneer.iam.gserviceaccount.com\"\n" +
                "}\n";

//        final String SERVICE_ACCOUNT = "{\n" +
//                "  \"type\": \"service_account\",\n" +
//                "  \"project_id\": \"rvgvb-mmog\",\n" +
//                "  \"private_key_id\": \"781a74fac7795658119ce72c056eb861dc6ee6bc\",\n" +
//                "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDzqF7doV77Amds\\nt9udZ/BwTjDtBjIg3wKHk7ckEQrucO/4vJy/AFEIeFVqphdMEoQsElrDQJd+XDjJ\\nnxCaI6Z11F0+J1CMjNBaw1is8Y5gG9bszDVozvzr7s1KUSmXQMmMnOtAPCbWY0yt\\ngkyBBGMn02tNEXDe2B3LPPgLDI5GRvRr5oVg+StHrHIcDjTuNzX7vH+QqSA7VyuA\\n6Al090IU6PwHIAe4jknOYBTRpyzyGhIhP4ZTUuAAnqiqPuIF4TcAVIilHRGd2gQ0\\nu4fkr11DA1U5VmxOyafFKZEx6+X9/U7QoUIZr1rmXvxNA9N+kmBL8z6eBonhkzDo\\n8zy0HzClAgMBAAECggEABNASE6Gg3SdmgJS/H0RS0P0SZVQmgFS3WZM23l0B0MTl\\nUI31MKaicx7hXQpr0mJZPv+b0FiBxYqvyne8XbcPjitELjqbkjMj2G8cXMomrEpQ\\ne/vqoCfaghSE9I9W2Xh7oq3kza+CeuCaPqEgvrml9b7s0yhhiN1O9Vk+cwVr+AJb\\n6oDgAyDSGVzEuJ4Dmbf7gRjkzXbI2WB0/TEQ+s5DqC2vf4ktvqWtzEvLeLjgA2U5\\nCVXjp6AaxBYd4OMsIjqPF3diamFLEUDzCg0F4WL9FDCiWZaYY2LlJw2YtdXQPSyW\\nZqSfjyc3K2O1B/PHjmZx9JD+VDHqACZFBW/2n0SoPwKBgQD9b5L5fJerWLQi8K1b\\n696+pIAISs96s0SN7JHEtPrJB4li4hbMmUhtpmRSFxpZnGZz5Psf4ChmdTqhlj5N\\nrDf/3BEmUeQZ+PRhA5i4uXHwIiI4JF2fBso4wu5zofm2IduaYsqo5PvqTp5XLZjZ\\n00imOX0SwkPuYVRShtrdPt/u8wKBgQD2H3hToPpStYwE7uqLV6maOsdpdTJHqaGf\\nVHMbitbn6Gxq7IppVWAS8MpEjfxQwoWNtgDErfK6XzbyBBKSSxZqD04vctKjF7F4\\nRyyDWI2Gmqg/8Ul+FQTD9O6HxdS0wcPaWnP5qG9YvfHN1GfPNs6mZIrCUPvR+KC5\\n2wdBQPu4BwKBgQDmPrt0VbElRk1BgQ6+eCfBY4m9/tlITB14Ivi7kQBWKrayU10L\\nPCcFFyoFOmACEYkyuVE8wFVz4AUIUIsB3fhyRuh9u+BTiE3c5XuWN0RAOYKFJuS3\\nWV/W+aHRA9LtmQz90cr0bjQ/xnUsFozLOJzEB26N4Ff+9gW5hDLK1hhz6QKBgHCY\\nyRWJSbvY7mu7WXXR7vdt+JiYUx5Rzmzz1408IUELJb5s5I13z3Ia0o42Xr4bn7nL\\nD+LqqWb19E8X6d8fluuCgQRYBWEzj6808HpOYsC3tE08d6DEwN9dCFr4+GyRUKZu\\nRyxqEDaK/zpo9+zmZ/fbe1eWcP4IPo+IUnNZ5U61AoGBAI3BNdMDrSyc7AnjrEXD\\nBVDsUFGpunRd9Q7b374fXlVr3/Of2DDTR0iZeViTUNscyHWkC5oN/i47ejL7kVEw\\nFNz45k/gBqeLLWSkQWLMrRWM9ndVUZaMMmkyJdczBefH9YJNfnYbmGzujqwqgoWO\\nzHkmePkY2JNv6DHlu3TL3SkH\\n-----END PRIVATE KEY-----\\n\",\n" +
//                "  \"client_email\": \"firebase-adminsdk-jdmre@rvgvb-mmog.iam.gserviceaccount.com\",\n" +
//                "  \"client_id\": \"100259596455481900396\",\n" +
//                "  \"auth_uri\": \"https://accounts.google.com/o/oauth2/auth\",\n" +
//                "  \"token_uri\": \"https://oauth2.googleapis.com/token\",\n" +
//                "  \"auth_provider_x509_cert_url\": \"https://www.googleapis.com/oauth2/v1/certs\",\n" +
//                "  \"client_x509_cert_url\": \"https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-jdmre%40rvgvb-mmog.iam.gserviceaccount.com\"\n" +
//                "}\n";

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

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
