package com.example.marspioneer.contextlistener;

import com.example.marspioneer.model.*;
import com.raylabz.firestorm.Firestorm;
import com.raylabz.objectis.Objectis;
import com.raylabz.objectis.exception.ClassRegistrationException;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.util.Properties;

@WebListener
public class RedisContextListener implements ServletContextListener {

    private Properties config = new Properties();

    private JedisPool createJedisPool() throws IOException {
        String host;
        Integer port;
        config.load(
                Thread.currentThread()
                        .getContextClassLoader()
                        .getResourceAsStream("application.properties"));
        host = config.getProperty("redis.host");
        port = Integer.valueOf(config.getProperty("redis.port", "6379"));

        JedisPoolConfig poolConfig = new JedisPoolConfig();
        // Default : 8, consider how many concurrent connections into Redis you will need under load
        poolConfig.setMaxTotal(10000);

        return new JedisPool(poolConfig, host, port);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        JedisPool jedisPool = (JedisPool) event.getServletContext().getAttribute("jedisPool");
        if (jedisPool != null) {
            jedisPool.destroy();
            event.getServletContext().setAttribute("jedisPool", null);
        }
    }

    // Run this before web application is started
    @Override
    public void contextInitialized(ServletContextEvent event) {
        JedisPool jedisPool = (JedisPool) event.getServletContext().getAttribute("jedisPool");
        if (jedisPool == null) {
            try {

                System.out.println("Redis context init");
                jedisPool = createJedisPool();

                Objectis.init(jedisPool.getResource());
                Objectis.register(BuildingEntity.class);
                Objectis.register(MPGameSession.class);
                Objectis.register(MPWorld.class);
                Objectis.register(MPWorldSession.class);
                Objectis.register(MPTeam.class);
                Objectis.register(MPPlayer.class);
                Objectis.register(MPTerrainChunk.class);

                event.getServletContext().setAttribute("jedisPool", jedisPool);
            } catch (IOException | ClassRegistrationException e) {
                e.printStackTrace();
            }
        }
    }
}