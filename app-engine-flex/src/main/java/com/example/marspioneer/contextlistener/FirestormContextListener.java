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
