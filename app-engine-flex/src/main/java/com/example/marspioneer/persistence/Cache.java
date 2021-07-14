package com.example.marspioneer.persistence;

import com.google.gson.Gson;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Cache {

    private static Jedis INSTANCE = null;

    public static class Keys {
        public static final String WORLD = "WORLD";
    }

    public static synchronized Jedis getJedis(final HttpServletRequest request) throws SocketException {
        if (INSTANCE == null) {
            JedisPool jedisPool = (JedisPool) request.getServletContext().getAttribute("jedisPool");
            if (jedisPool == null) {
                throw new SocketException("Error connecting to Jedis pool");
            }
            INSTANCE = jedisPool.getResource();
        }
        return INSTANCE;
    }

    public static synchronized Jedis getJedis(final ServletContext servletContext) throws SocketException {
        JedisPool jedisPool = (JedisPool) servletContext.getAttribute("jedisPool");
        if (jedisPool == null) {
            throw new SocketException("Error connecting to Jedis pool");
        }
        return jedisPool.getResource();
    }

    static synchronized String getObjectKey(final String id, final Class<?> aClass) {
        return aClass.getSimpleName() + "/" + id;
    }

    static synchronized String getListKey(final Class<?> aClass) {
        return aClass.getSimpleName() + "_LIST";
    }

    static synchronized void setObject(final Jedis jedis, final String id, final Object object) {
        String objectData = new Gson().toJson(object);
        jedis.set(getObjectKey(id, object.getClass()), objectData);
        jedis.sadd(getListKey(object.getClass()), id);
    }

    static synchronized <T> T getObject(final Jedis jedis, final String id, final Class<T> objectClass) {
//        System.out.println("Jedis -> [getObject]: " + getObjectKey(id, objectClass));
        final String objectData = jedis.get(getObjectKey(id, objectClass));
        if (objectData == null) {
            return null;
        }
        return new Gson().fromJson(objectData, objectClass);
    }

    static synchronized <T> T get(final Jedis jedis, final String key, final Class<T> objectClass) {
//        System.out.println("Jedis -> [get]: " + key);
        final String objectData = jedis.get(key);
        if (objectData == null) {
            return null;
        }
        return new Gson().fromJson(objectData, objectClass);
    }

    static synchronized void set(final Jedis jedis, final String key, final Object object) {
        String objectData = new Gson().toJson(object);
        jedis.set(key, objectData);
    }

    static synchronized void remove(final Jedis jedis, final String key) {
        jedis.del(key);
    }

    static synchronized <T> void removeObject(final Jedis jedis, final String id, final Class<T> objectClass) {
        jedis.del(getObjectKey(id, objectClass));
        jedis.srem(getListKey(objectClass), id);
    }

    static synchronized List<String> list(final Jedis jedis, final Class<?> objectClass) {
        return new ArrayList<>(jedis.smembers(getListKey(objectClass)));
    }

    static synchronized <T> void addAsList(final Jedis jedis, String key, Collection<String> ids) {
        StringBuilder jsonBuilder = new StringBuilder();
        for (String s : ids) {
            jsonBuilder.append(s).append("\n");
        }
        jedis.set(key, jsonBuilder.toString());
    }

    static synchronized void addToList(final Jedis jedis, String key, String id) {
        final String value = jedis.get(key);
        String[] itemsArray;
        if (value == null) {
            itemsArray = new String[0];
        }
        else {
             itemsArray = value.split("\n");
        }
        ArrayList<String> list = new ArrayList<>(Arrays.asList(itemsArray));
        if (!list.contains(id)) {
            list.add(id);
            addAsList(jedis, key, list);
        }
    }

    static synchronized void removeFromList(final Jedis jedis, String key, String id) {
        final String[] asList = getAsList(jedis, key);
        final List<String> items = Arrays.asList(asList);
        items.remove(id);
        addAsList(jedis, key, items);
    }

    static synchronized String[] getAsList(final Jedis jedis, String key) {
        final String value = jedis.get(key);
        if (value == null) {
            return new String[0];
        }
        return value.split("\n");
    }

}
