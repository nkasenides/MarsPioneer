/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Project Editor, v1.0 BETA
-------------------------------------------------------------------------------- */

package com.example.marspioneer.persistence;


import com.example.marspioneer.model.BuildingEntity;
import com.example.marspioneer.model.MPEntity;
import com.nkasenides.athlos.persistence.WorldBasedDAO;
import com.raylabz.firestorm.Firestorm;

import java.util.ArrayList;
import java.util.Collection;


public class MPEntityDAO implements WorldBasedDAO<MPEntity> {


    @Override
    public boolean create(MPEntity object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean update(MPEntity object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(MPEntity object) {
        throw new UnsupportedOperationException();
    }

//    @Override
    public MPEntity get(String s) {
        throw new UnsupportedOperationException();
    }

    @Override
    public MPEntity getForWorld(String worldID, String itemID) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<MPEntity> listForWorld(String worldID) {
        final ArrayList<BuildingEntity> items = Firestorm.filter(BuildingEntity.class)
                .whereEqualTo("worldID", worldID)
                .limit(1)
                .fetch()
                .getItems();
        return new ArrayList<>(items);
    }

    /**
     * Retrieves a player's entities within a specific world.
     * @param worldID The world.
     * @param playerID The player.
     * @return Returns a collection of entities.
     */
    public Collection<MPEntity> listForPlayerAndWorld(String worldID, String playerID) {
        final ArrayList<BuildingEntity> items = Firestorm.filter(BuildingEntity.class)
                .whereEqualTo("worldID", worldID)
                .whereEqualTo("playerID", playerID)
                .fetch()
                .getItems();
        return new ArrayList<>(items);
    }

    /**
     * Retrieves a player's entities.
     * @param playerID The player.
     * @return Returns a collection of entities.
     */
    public Collection<MPEntity> listForPlayer(String playerID) {
        final ArrayList<BuildingEntity> items = Firestorm.filter(BuildingEntity.class)
                .whereEqualTo("playerID", playerID)
                .fetch()
                .getItems();
        return new ArrayList<>(items);
    }

    /**
     * Retrieves the entities in a world which are not belonging to a particular player.
     * @param worldID The world ID
     * @param excludedPlayerID The excluded player ID.
     * @return Returns a collection of entities.
     */
    public Collection<MPEntity> listForWorldExcludingPlayer(String worldID, String excludedPlayerID) {
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
        return new ArrayList<>(oEntities);
    }

}


