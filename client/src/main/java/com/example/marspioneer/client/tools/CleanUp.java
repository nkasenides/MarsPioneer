package com.example.marspioneer.client.tools;

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
                "  \"project_id\": \"mars-pioneer-322210\",\n" +
                "  \"private_key_id\": \"ec4484485fbd92f2f52c9bb6b965cdedaa20b0d5\",\n" +
                "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDowuo/O+at1gXY\\noUQt8C2NHO/XRExVHruJxf+Ktww1l6ttQ9rcAK1nY+e327cVN1tHRCHsCBFDBDAp\\nX6JitKNnFvQ4L/f2FYw9pXj1phIhmfDtX1xLCSHy7p+o/3uBKHDZd2QIIBoUFqaL\\nXxvgHXmEEEOc1BMLNYhXk/o5g99lboVaBnpre0BsLWEdQG0H3tTk4fXueeazLfNV\\nd4WZKDNb84x/JSBpPjYbY55bWLsaZXHLxSfOV7Hh8MhysUEGNoffi7SCtJsZbpmF\\nXRMbFQF2v5/8uJ/IXq8kmKgxbe4ay/+PCpJVnNIkKI5tTKWNdgcLApkgAqVki92Z\\nFdXGWS6jAgMBAAECggEABNq9KvNzX1sa2nFGluoERoX8zzxf69iNExWw5jI6IXYC\\nf8VjWk+d+OLhsXkgy42mLDQqEZ5QydkxA0k40vPZ1+u9IoeG6uLOfsylhgNgK8OQ\\n/Z+4W4zwYHzZ50WTdwFNFTlYZJOoJ5TEsBxxhuORJhAhcN26xfLoXzc5XUYNpzO0\\nNFfP9HFzTN5qm/JitDO4/hsq5c/CA3sB6ha0NPVDR2dGGCkLybawKSb4dq7zFey8\\nXRu9gOyjfaju8W3esG11vRwnBHMiuzLcHcXG5TkbQfU6zUIrkRsO8RqJq7HBgPZh\\ng+SSCIyYzV3ISBUx25iFbTrMkqqm7xJninKuk8gs0QKBgQD62vHnp15UW5MCYBDI\\nFXY+dJyTCR7l83M3ub3khB8vmYsTPTY1ZLsHphQFgtBc2UFaNWxSLJqJwwasT4ua\\n//yThOsMroVmJuOVVnAGAn5mYHGli0+A2Ibtf+/aNp9BQN9gZcJzdCYliquZ+ghc\\n6e3ax80czmOgmKaqolxq1dLNcQKBgQDtiPj8OjBC8NjmNaYEa1oZK7j6M8148nty\\nc68102zsSQgUeXCRCVr3zFjQsW+IU1eLRUqkP7nlG2655V//7qltBVXev9WVd1lL\\nDKPRoVAP2l9xEJ2wiaZ9OCBPM1JOUghgbci+PuYkYZCf0YrnoN661xEQCbhw0sMH\\nKiBEzPxDUwKBgG6c0IIXOO71mjM37O5tGECd5tSm9urqmGmAC42R/LZefAa1vQt6\\nKUZMIxPzBLGMUtbWK7doV5RbXLvqL2LfcZ4SxBpJciUDDOMyxB7CRr4Z1MLsVNg5\\nofVjrn2IDF0Xn+e/tyh1lMSFCvnQWJOvyuPnqjgDgca0yPkAssOhGVzhAoGAH8/N\\nULJWTlDFK6eZsVPTQDW70z5m0UDgSYa2u2WyW764J03QRoxTM4aZinGI91/6BHvm\\nMDMcqVNQM/NFNRh4dlJVmrxkVV0jh0qNEgEhoM3lJFZOWBtHQdPnd9PuvPB9kLSD\\nQv9XgR3T6aN9j+HaknlFHrm+itWfKvF4Wt59FmMCgYEA7YcKUNSs+mJ9OjHyfiyT\\nP0+t29jZbATPpruKD70O6xyLm2cYma+roDnTWX4LFkDG0OhWaq4OBRV95WpVHoH0\\njtEL2PrkCvCiaXPtxrFjohx8OkmsoDeVBZCUrC6+EFOVcw7bhbOxJCZ5juzhJNv4\\nAR47AggrJXwki1isPtUIZpQ=\\n-----END PRIVATE KEY-----\\n\",\n" +
                "  \"client_email\": \"firebase-adminsdk-gp1dp@mars-pioneer-322210.iam.gserviceaccount.com\",\n" +
                "  \"client_id\": \"105419803481578948461\",\n" +
                "  \"auth_uri\": \"https://accounts.google.com/o/oauth2/auth\",\n" +
                "  \"token_uri\": \"https://oauth2.googleapis.com/token\",\n" +
                "  \"auth_provider_x509_cert_url\": \"https://www.googleapis.com/oauth2/v1/certs\",\n" +
                "  \"client_x509_cert_url\": \"https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-gp1dp%40mars-pioneer-322210.iam.gserviceaccount.com\"\n" +
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

        System.out.println("--- CLEAN UP FINISHED ---");

    }

}
