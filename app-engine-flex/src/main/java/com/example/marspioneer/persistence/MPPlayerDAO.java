/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Project Editor, v1.0 BETA
-------------------------------------------------------------------------------- */

package com.example.marspioneer.persistence;


import com.example.marspioneer.model.BuildingEntity;
import com.example.marspioneer.model.MPGameSession;
import com.example.marspioneer.model.MPPlayer;
import com.nkasenides.athlos.persistence.MultiDAO;
import com.raylabz.firestorm.Firestorm;
import com.raylabz.firestorm.FirestormBatch;
import com.raylabz.objectis.Objectis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;


public class MPPlayerDAO implements MultiDAO<MPPlayer> {


    @Override
    public boolean create(MPPlayer object) {
        Firestorm.create(object);
        Objectis.create(object);
        return true;
    }

    @Override
    public boolean update(MPPlayer object) {
        Objectis.update(object);
        new Thread(() -> Firestorm.update(object)).start();
        return true;
    }

    @Override
    public boolean delete(MPPlayer object) {
        Firestorm.delete(object);
        return true;
    }

    @Override
    public MPPlayer get(String id) {
        return Objectis.get(MPPlayer.class, id);
    }

    @Override
    public Collection<MPPlayer> getMany(String... ids) {
        return Objectis.filter(MPPlayer.class)
                .whereArrayContainsAny("id", Arrays.asList(ids))
                .fetch();
    }

    @Override
    public Collection<MPPlayer> list() {
        return Objectis.list(MPPlayer.class);
    }

    @Override
    public boolean create(Collection<MPPlayer> objects) {
        Firestorm.runBatch(new FirestormBatch() {
            @Override
            public void execute() {
                for (MPPlayer g : objects) {
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
    public boolean update(Collection<MPPlayer> objects) {
        for (MPPlayer object : objects) {
            Objectis.update(object);
        }

        new Thread(() -> Firestorm.runBatch(new FirestormBatch() {
            @Override
            public void execute() {
                for (MPPlayer g : objects) {
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
    public boolean delete(Collection<MPPlayer> objects) {
        for (MPPlayer object : objects) {
            Objectis.delete(object);
        }

        new Thread(() -> Firestorm.runBatch(new FirestormBatch() {
            @Override
            public void execute() {
                for (MPPlayer g : objects) {
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
     * Retrieve a player by name.
     * @param name The name of the player.
     * @return Returns a Player object.
     */
    public MPPlayer getByName(String name) {
        final ArrayList<MPPlayer> items = Objectis.filter(MPPlayer.class)
                .whereEqualTo("name", name)
                .limit(1)
                .fetch();

        if (items.size() == 0) {
            return null;
        }
        return items.get(0);
    }


}


