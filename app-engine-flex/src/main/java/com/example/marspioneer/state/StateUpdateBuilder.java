package com.example.marspioneer.state;

import com.example.marspioneer.model.*;
import com.example.marspioneer.proto.*;

import java.util.*;

public class StateUpdateBuilder {

    private final MPStateUpdateProto.Builder stateUpdateProtoBuilder = MPStateUpdateProto.newBuilder();

    /**
     * Creates a new StateUpdateBuilder.
     * @return Returns a StateUpdateBuilder.
     */
    public static StateUpdateBuilder create() {
        return new StateUpdateBuilder();
    }

    /**
     * Constructs a new StateUpdateBuilder.
     */
    public StateUpdateBuilder() {
    }

    /**
     * Retrieves the protocol buffer builder object.
     * @return Returns StateUpdateProto.Builder.
     */
    public MPStateUpdateProto.Builder getStateUpdateProtoBuilder() {
        return stateUpdateProtoBuilder;
    }

    /**
     * Adds a created entity to the builder.
     * @param entity The entity to add.
     * @return Returns a StateUpdateBuilder
     */
    public StateUpdateBuilder addCreatedEntity(MPEntity entity) {
        stateUpdateProtoBuilder.putNewEntities(entity.getId(), entity.toProto().build());
        return this;
    }

    /**
     * Adds a created entity to the builder.
     * @param entity The entity to add.
     * @return Returns a StateUpdateBuilder
     */
    public StateUpdateBuilder addCreatedEntity(MPEntityProto entity) {
        stateUpdateProtoBuilder.putNewEntities(entity.getId(), entity);
        return this;
    }

    /**
     * Adds an updated entity to the builder.
     * @param entity The entity to add.
     * @return Returns a StateUpdateBuilder
     */
    public StateUpdateBuilder addUpdatedEntity(MPEntity entity) {
        stateUpdateProtoBuilder.putUpdatedEntities(entity.getId(), entity.toProto().build());
        return this;
    }

    /**
     * Adds an updated entity to the builder.
     * @param entity The entity to add.
     * @return Returns a StateUpdateBuilder
     */
    public StateUpdateBuilder addUpdatedEntity(MPEntityProto entity) {
        stateUpdateProtoBuilder.putUpdatedEntities(entity.getId(), entity);
        return this;
    }

    /**
     * Adds a removed entity to the builder.
     * @param entityID The ID of the entity removed.
     * @return Returns a StateUpdateBuilder
     */
    public StateUpdateBuilder addRemovedEntity(String entityID) {
        stateUpdateProtoBuilder.addRemovedEntities(entityID);
        return this;
    }

    /**
     * Adds a created terrain cell to the builder.
     * @param terrainCell The terrain cell to add.
     * @return Returns a StateUpdateBuilder.
     */
    public StateUpdateBuilder addCreatedTerrain(MPTerrainCell terrainCell) {
        stateUpdateProtoBuilder.putNewTerrainCells(terrainCell.getPosition().toHash(), terrainCell.toProto().build());
        return this;
    }

    /**
     * Adds a created terrain cell to the builder.
     * @param terrainCell The terrain cell to add.
     * @return Returns a StateUpdateBuilder.
     */
    public StateUpdateBuilder addCreatedTerrain(MPTerrainCellProto terrainCell) {
        stateUpdateProtoBuilder.putNewTerrainCells(terrainCell.getPosition().toHash(), terrainCell);
        return this;
    }

    /**
     * Adds an updated terrain cell to the builder.
     * @param terrainCell The terrain cell to add.
     * @return Returns a StateUpdateBuilder.
     */
    public StateUpdateBuilder addUpdatedTerrain(MPTerrainCell terrainCell) {
        stateUpdateProtoBuilder.putUpdatedTerrainCells(terrainCell.getPosition().toHash(), terrainCell.toProto().build());
        return this;
    }

    /**
     * Adds an updated terrain cell to the builder.
     * @param terrainCell The terrain cell to add.
     * @return Returns a StateUpdateBuilder.
     */
    public StateUpdateBuilder addUpdatedTerrain(MPTerrainCellProto terrainCell) {
        stateUpdateProtoBuilder.putUpdatedTerrainCells(terrainCell.getPosition().toHash(), terrainCell);
        return this;
    }

    /**
     * Adds a removed terrain cell to the builder.
     * @param terrainCellHash The hash of the terrain cell removed.
     * @return Returns a StateUpdateBuilder.
     */
    public StateUpdateBuilder addRemovedTerrain(String terrainCellHash) {
        stateUpdateProtoBuilder.addRemovedTerrainCells(terrainCellHash);
        return this;
    }

    //TODO --- NOT ADDED TO GENERATOR!! (start from this point)

    /**
     * Retrieves the map of created entities.
     * @return Returns a map.
     */
    public Map<String, MPEntityProto> getCreatedEntities() {
        return stateUpdateProtoBuilder.getNewEntitiesMap();
    }

    /**
     * Retrieves the map of updated entities.
     * @return Returns a map.
     */
    public Map<String, MPEntityProto> getUpdatedEntities() {
        return stateUpdateProtoBuilder.getUpdatedEntitiesMap();
    }

    /**
     * Retrieves the list of removed entities.
     * @return Returns a map.
     */
    public List<String> getRemovedEntities() {
        return stateUpdateProtoBuilder.getRemovedEntitiesList();
    }

    /**
     * Retrieves the map of created terrain.
     * @return Returns a map.
     */
    public Map<String, MPTerrainCellProto> getCreatedTerrain() {
        return stateUpdateProtoBuilder.getNewTerrainCellsMap();
    }

    /**
     * Retrieves the map of updated terrain.
     * @return Returns a map.
     */
    public Map<String, MPTerrainCellProto> getUpdatedTerrain() {
        return stateUpdateProtoBuilder.getUpdatedTerrainCellsMap();
    }

    /**
     * Retrieves the list of removed terrain.
     * @return Returns a map.
     */
    public List<String> getRemovedTerrain() {
        return stateUpdateProtoBuilder.getRemovedTerrainCellsList();
    }

    //TODO --- UP TO THIS POINT.

    /**
     * Builds the state update.
     * @return Returns a state update.
     */
    public MPStateUpdateProto build() {
        return stateUpdateProtoBuilder.build();
    }

}
