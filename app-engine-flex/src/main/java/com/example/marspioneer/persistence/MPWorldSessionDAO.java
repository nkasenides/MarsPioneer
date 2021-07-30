/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Project Editor, v1.0 BETA
-------------------------------------------------------------------------------- */

package com.example.marspioneer.persistence;


import com.example.marspioneer.model.MPGameSession;
import com.example.marspioneer.model.MPPlayer;
import com.example.marspioneer.model.MPWorld;
import com.example.marspioneer.model.MPWorldSession;
import com.nkasenides.athlos.persistence.WorldBasedDAO;
import com.raylabz.firestorm.Firestorm;
import com.raylabz.objectis.Objectis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;


public class MPWorldSessionDAO implements WorldBasedDAO<MPWorldSession> {


    @Override
    public boolean create(MPWorldSession object) {
        String uuid = UUID.randomUUID().toString();
        object.setId(uuid);
        Objectis.create(object, uuid);
        new Thread(() -> Firestorm.create(object, uuid)).start();
        return true;
    }

    @Override
    public boolean update(MPWorldSession object) {
        Objectis.update(object);
        new Thread(() -> Firestorm.update(object)).start();
        return true;
    }

    @Override
    public boolean delete(MPWorldSession object) {
        Firestorm.delete(object);
        return true;
    }

//    @Override
    public MPWorldSession get(String s) {
        return Objectis.get(MPWorldSession.class, s);
    }

    public List<MPWorldSession> getMany(List<String> ids) {
        return Objectis.getMany(MPWorldSession.class, ids);
    }

    @Override
    public MPWorldSession getForWorld(String worldID, String itemID) {
        final List<MPWorldSession> items = Objectis.filter(MPWorldSession.class)
                .whereEqualTo("worldID", worldID)
                .whereEqualTo("id", itemID)
                .fetch().getItems();
        if (items.size() == 0) {
            return null;
        }
        return items.get(0);
    }

    @Override
    public Collection<MPWorldSession> listForWorld(String worldID) {
        return Objectis.filter(MPWorldSession.class)
                .whereEqualTo("worldID", worldID)
                .fetch().getItems();
    }

    /**
     * Retrieves the player of the provided session.
     * @param worldSessionID The session's ID.
     * @return Returns a player object
     */
    public MPPlayer getPlayer(final String worldSessionID) {
//        System.out.println("DAO wsid -> " + worldSessionID);
        final MPWorldSession worldSession = Objectis.get(MPWorldSession.class, worldSessionID);
        if (worldSession == null) {
            return null;
        }
        return Objectis.get(MPPlayer.class, worldSession.getPlayerID());
    }

    /**
     * Retrieves the world sessions owned by the provided player.
     * @param playerID The player's ID.
     * @return Returns a WorldSession, or null.
     */
    public Collection<MPWorldSession> listForPlayer(final String playerID) {
        return Objectis.filter(MPWorldSession.class)
                .whereEqualTo("playerID", playerID)
                .fetch().getItems();
    }

    /**
     * Retrieves the world session for the specific player in a specific world.
     * @param playerID The player ID.
     * @param worldID The world ID.
     * @return Returns a WorldSession.
     */
    public MPWorldSession getForPlayerAndWorld(final String playerID, final String worldID) {
        final List<MPWorldSession> items = Objectis.filter(MPWorldSession.class)
                .whereEqualTo("playerID", playerID)
                .whereEqualTo("worldID", worldID)
                .limit(1)
                .fetch().getItems();
        if (items.size() == 0) {
            return null;
        }
        return items.get(0);
    }

}

