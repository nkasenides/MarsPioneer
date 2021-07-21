package com.example.marspioneer.model;

import com.raylabz.firestorm.annotation.FirestormObject;
import com.raylabz.objectis.annotation.ObjectisObject;

import java.io.Serializable;

@FirestormObject
@ObjectisObject
public class MPTerrainIdentifier implements Serializable {

    private String id;
    private String chunkID;
    private String worldID;
    private MatrixPosition chunkPosition;

    public MPTerrainIdentifier(String id, String chunkID, String worldID, MatrixPosition chunkPosition) {
        this.id = id;
        this.chunkID = chunkID;
        this.worldID = worldID;
        this.chunkPosition = chunkPosition;
    }

    public MPTerrainIdentifier() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChunkID() {
        return chunkID;
    }

    public void setChunkID(String chunkID) {
        this.chunkID = chunkID;
    }

    public String getWorldID() {
        return worldID;
    }

    public void setWorldID(String worldID) {
        this.worldID = worldID;
    }

    public MatrixPosition getChunkPosition() {
        return chunkPosition;
    }

    public void setChunkPosition(MatrixPosition chunkPosition) {
        this.chunkPosition = chunkPosition;
    }

}
