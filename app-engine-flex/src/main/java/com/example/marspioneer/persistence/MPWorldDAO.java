/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Project Editor, v1.0 BETA
-------------------------------------------------------------------------------- */

package com.example.marspioneer.persistence;


import com.example.marspioneer.model.MPPlayer;
import com.example.marspioneer.model.MPWorld;
import com.nkasenides.athlos.persistence.MultiDAO;
import com.raylabz.firestorm.Firestorm;
import com.raylabz.firestorm.FirestormBatch;
import com.raylabz.objectis.Objectis;

import java.util.*;


public class MPWorldDAO implements MultiDAO<MPWorld> {

    @Override
    public boolean create(MPWorld object) {
        String uuid = UUID.randomUUID().toString();
        object.setId(uuid);
        Objectis.create(object, uuid);
        new Thread(() -> Firestorm.create(object, uuid)).start();
        return true;
    }

    @Override
    public boolean update(MPWorld object) {
        Objectis.update(object);
        new Thread(() -> Firestorm.update(object)).start();
        return true;
    }

    @Override
    public boolean delete(MPWorld object) {
        Objectis.update(object);
        new Thread(() -> Firestorm.update(object)).start();
        return true;
    }

    @Override
    public MPWorld get(String id) {
        return Objectis.get(MPWorld.class, id);
    }

    @Override
    public Collection<MPWorld> getMany(String... ids) {
        return Objectis.filter(MPWorld.class)
                .whereArrayContainsAny("id", Arrays.asList(ids))
                .fetch().getItems();
    }

    @Override
    public Collection<MPWorld> list() {
        return Objectis.list(MPWorld.class);
    }

    @Override
    public boolean create(Collection<MPWorld> objects) {
        Firestorm.runBatch(new FirestormBatch() {
            @Override
            public void execute() {
                for (MPWorld g : objects) {
                    create(g);
                    Objectis.create(g);
                }
            }

            @Override
            public void onFailure(Exception e) {

            }

            @Override
            public void onSuccess() {

            }
        });
        return true;
    }

    @Override
    public boolean update(Collection<MPWorld> objects) {
        for (MPWorld object : objects) {
            Objectis.update(object);
        }

        new Thread(() -> Firestorm.runBatch(new FirestormBatch() {
            @Override
            public void execute() {
                for (MPWorld g : objects) {
                    update(g);
                }
            }

            @Override
            public void onFailure(Exception e) {

            }

            @Override
            public void onSuccess() {

            }
        })).start();


        return true;
    }

    @Override
    public boolean delete(Collection<MPWorld> objects) {
        for (MPWorld object : objects) {
            Objectis.delete(object);
        }

        new Thread(() -> Firestorm.runBatch(new FirestormBatch() {
            @Override
            public void execute() {
                for (MPWorld g : objects) {
                    delete(g);
                }
            }

            @Override
            public void onFailure(Exception e) {

            }

            @Override
            public void onSuccess() {

            }
        })).start();

        return true;
    }

    /**
     * Retrieve a world by name.
     * @param name The name of the world.
     * @return Returns a world object.
     */
    public MPWorld getByName(String name) {
        final List<MPWorld> items = Objectis.filter(MPWorld.class)
                .whereEqualTo("name", name)
                .limit(1)
                .fetch().getItems();

        if (items.size() == 0) {
            return null;
        }
        return items.get(0);
    }

    /**
     * Lists a player's worlds.
     * @param playerID The player.
     * @return Returns a collection of worlds.
     */
    public Collection<MPWorld> listByPlayer(String playerID) {
        return Objectis.filter(MPWorld.class)
                .whereEqualTo("playerID", playerID)
                .fetch().getItems();
    }


}


