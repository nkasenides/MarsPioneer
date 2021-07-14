/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Project Editor, v1.0 BETA
-------------------------------------------------------------------------------- */

package com.example.marspioneer.persistence;


import com.nkasenides.athlos.persistence.*;
import com.example.marspioneer.model.*;
import com.raylabz.firestorm.Firestorm;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;


public class BuildingEntityDAO implements WorldBasedDAO<BuildingEntity> {


    @Override
    public boolean create(BuildingEntity object) {
        Firestorm.create(object);
        return true;
    }

    @Override
    public boolean update(BuildingEntity object) {
        Firestorm.update(object);
        return true;
    }

    @Override
    public boolean delete(BuildingEntity object) {
        Firestorm.delete(object);
        return true;
    }

//    @Override
    public BuildingEntity get(String s) {
        return Firestorm.get(BuildingEntity.class, s);
    }

    @Override
    public BuildingEntity getForWorld(String worldID, String itemID) {
        final ArrayList<BuildingEntity> items = Firestorm.filter(BuildingEntity.class)
                .whereEqualTo("worldID", worldID)
                .whereEqualTo("id", itemID)
                .limit(1)
                .fetch()
                .getItems();
        if (items.size() == 0) {
            return null;
        }
        return items.get(0);
    }

    @Override
    public Collection<BuildingEntity> listForWorld(String worldID) {
        return Firestorm.filter(BuildingEntity.class)
                .whereEqualTo("worldID", worldID)
                .limit(1)
                .fetch()
                .getItems();
    }

/**
     * Retrieves a player's entities within a specific world.
     * @param worldID The world.
     * @param playerID The player.
     * @return Returns a collection of entities.
     */
    public Collection<BuildingEntity> listForPlayerAndWorld(String worldID, String playerID) {
        return Firestorm.filter(BuildingEntity.class)
                .whereEqualTo("worldID", worldID)
                .whereEqualTo("playerID", playerID)
                .fetch()
                .getItems();
    }
    /**
     * Retrieves a player's entities.
     * @param playerID The player.
     * @return Returns a collection of entities.
     */
    public Collection<BuildingEntity> listForPlayer(String playerID) {
        return Firestorm.filter(BuildingEntity.class)
                .whereEqualTo("playerID", playerID)
                .fetch()
                .getItems();
    }

    /**
     * Retrieves the entities in a world which are not belonging to a particular player.
     * @param worldID The world ID
     * @param excludedPlayerID The excluded player ID.
     * @return Returns a collection of entities.
     */
    public Collection<BuildingEntity> listForWorldExcludingPlayer(String worldID, String excludedPlayerID) {
        final ArrayList<BuildingEntity> entities = Firestorm.filter(BuildingEntity.class)
                .whereEqualTo("worldID", worldID)
                .fetch()
                .getItems();

        final ArrayList<BuildingEntity> oEntities = new ArrayList<>();
        for (BuildingEntity entity : entities) {
            if (!entity.getPlayerID().equals(excludedPlayerID)) {
                oEntities.add(entity);
            }
        }
        return oEntities;
    }

}


