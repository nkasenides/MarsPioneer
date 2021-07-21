package com.example.marspioneer.persistence;

import com.example.marspioneer.model.MPTerrainIdentifier;
import com.nkasenides.athlos.persistence.WorldBasedDAO;
import com.raylabz.firestorm.Firestorm;
import com.raylabz.objectis.Objectis;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class MPTerrainIdentifierDAO implements WorldBasedDAO<MPTerrainIdentifier> {

    @Override
    public MPTerrainIdentifier get(String itemID) {
        return Objectis.get(MPTerrainIdentifier.class, itemID);
    }

    @Override
    public MPTerrainIdentifier getForWorld(String worldID, String itemID) {
        final List<MPTerrainIdentifier> identifiers = Objectis.collection(MPTerrainIdentifier.class, "terrain_" + worldID).list();
        for (MPTerrainIdentifier identifier : identifiers) {
            if (identifier.getWorldID().equals(worldID)) {
                return identifier;
            }
        }
        return null;
    }

    @Override
    public Collection<MPTerrainIdentifier> listForWorld(String worldID) {
        return Objectis.collection(MPTerrainIdentifier.class, "terrainIdentifier_" + worldID).list();
    }

    @Override
    public boolean create(MPTerrainIdentifier object) {
        String uuid = UUID.randomUUID().toString();
        object.setId(uuid);
        Objectis.create(object, uuid);
        Objectis.collection(MPTerrainIdentifier.class, "terrainIdentifier_" + object.getWorldID()).add(object);
        new Thread(() -> Firestorm.create(object, uuid)).start();
        return true;
    }

    @Override
    public boolean update(MPTerrainIdentifier object) {
        Objectis.update(object);
        new Thread(() -> Firestorm.update(object)).start();
        return true;
    }

    @Override
    public boolean delete(MPTerrainIdentifier object) {
        Objectis.delete(object);
        new Thread(() -> Firestorm.delete(object)).start();
        return true;
    }

}
