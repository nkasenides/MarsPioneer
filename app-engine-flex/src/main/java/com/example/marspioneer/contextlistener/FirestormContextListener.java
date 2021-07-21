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
