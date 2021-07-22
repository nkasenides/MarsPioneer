package com.example.marspioneer.state;

import com.example.marspioneer.model.*;
import com.example.marspioneer.proto.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * Sets the created entities attribute of the state update.
     * @param createdEntities A map of created entities.
     */
    public StateUpdateBuilder setCreatedEntitiesProto(Map<String, ? extends MPEntityProto> createdEntities) {
        stateUpdateProtoBuilder.getNewEntitiesMap().clear();
        stateUpdateProtoBuilder.getNewEntitiesMap().putAll(createdEntities);
        return this;
    }

    /**
     * Sets the created entities attribute of the state update.
     * @param createdEntities A map of created entities.
     */
    public StateUpdateBuilder setCreatedEntities(Map<String, ? extends MPEntity> createdEntities) {
        stateUpdateProtoBuilder.getNewEntitiesMap().clear();
        for (Map.Entry<String, ? extends MPEntity> entry : createdEntities.entrySet()) {
            final MPEntityProto entityProto = entry.getValue().toProto().build();
            stateUpdateProtoBuilder.getNewEntitiesMap().put(entry.getKey(), entityProto);
        }
        return this;
    }

    /**
     * Sets the updated entities attribute of the state update.
     * @param updatedEntities A map of updated entities.
     */
    public StateUpdateBuilder setUpdatedEntitiesProto(Map<String, ? extends MPEntityProto> updatedEntities) {
        stateUpdateProtoBuilder.getUpdatedEntitiesMap().clear();
        stateUpdateProtoBuilder.getUpdatedEntitiesMap().putAll(updatedEntities);
        return this;
    }

    /**
     * Sets the updated entities attribute of the state update.
     * @param updatedEntities A map of updated entities.
     */
    public StateUpdateBuilder setUpdatedEntities(Map<String, ? extends MPEntity> updatedEntities) {
        stateUpdateProtoBuilder.getUpdatedEntitiesMap().clear();
        for (Map.Entry<String, ? extends MPEntity> entry : updatedEntities.entrySet()) {
            final MPEntityProto entityProto = entry.getValue().toProto().build();
            stateUpdateProtoBuilder.getUpdatedEntitiesMap().put(entry.getKey(), entityProto);
        }
        return this;
    }

    /**
     * Sets the removed entities attribute of the state update.
     * @param removedEntities A list of IDs of removed entities.
     */
    public StateUpdateBuilder setRemovedEntities(List<String> removedEntities) {
        stateUpdateProtoBuilder.getRemovedEntitiesList().clear();
        stateUpdateProtoBuilder.getRemovedEntitiesList().addAll(removedEntities);
        return this;
    }

    /**
     * Sets the created terrain attribute of the state update.
     * @param createdTerrain A map of created terrain.
     */
    public StateUpdateBuilder setCreatedTerrainProto(Map<String, ? extends MPTerrainCellProto> createdTerrain) {
        stateUpdateProtoBuilder.getNewTerrainCellsMap().clear();
        stateUpdateProtoBuilder.getNewTerrainCellsMap().putAll(createdTerrain);
        return this;
    }

    /**
     * Sets the created terrain attribute of the state update.
     * @param createdTerrain A map of created terrain.
     */
    public StateUpdateBuilder setCreatedTerrain(Map<String, ? extends MPTerrainCell> createdTerrain) {
        stateUpdateProtoBuilder.getNewTerrainCellsMap().clear();
        for (Map.Entry<String, ? extends MPTerrainCell> entry : createdTerrain.entrySet()) {
            final MPTerrainCellProto terrainProto = entry.getValue().toProto().build();
            stateUpdateProtoBuilder.getNewTerrainCellsMap().put(entry.getKey(), terrainProto);
        }
        return this;
    }

    /**
     * Sets the updated terrain attribute of the state update.
     * @param updatedTerrain A map of updated terrain.
     */
    public StateUpdateBuilder setUpdatedTerrainProto(Map<String, ? extends MPTerrainCellProto> updatedTerrain) {
        stateUpdateProtoBuilder.getUpdatedTerrainCellsMap().clear();
        stateUpdateProtoBuilder.getUpdatedTerrainCellsMap().putAll(updatedTerrain);
        return this;
    }

    /**
     * Sets the updated terrain attribute of the state update.
     * @param updatedTerrain A map of updated terrain.
     */
    public StateUpdateBuilder setUpdatedTerrain(Map<String, ? extends MPTerrainCell> updatedTerrain) {
        stateUpdateProtoBuilder.getUpdatedTerrainCellsMap().clear();
        for (Map.Entry<String, ? extends MPTerrainCell> entry : updatedTerrain.entrySet()) {
            final MPTerrainCellProto terrainProto = entry.getValue().toProto().build();
            stateUpdateProtoBuilder.getUpdatedTerrainCellsMap().put(entry.getKey(), terrainProto);
        }
        return this;
    }

    /**
     * Sets the removed terrain attribute of the state update.
     * @param removedTerrain A list of IDs of removed terrain cells.
     */
    public StateUpdateBuilder setRemovedTerrain(List<String> removedTerrain) {
        stateUpdateProtoBuilder.getRemovedTerrainCellsList().clear();
        stateUpdateProtoBuilder.getRemovedTerrainCellsList().addAll(removedTerrain);
        return this;
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
