/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Project Editor, v1.0 BETA
-------------------------------------------------------------------------------- */

package com.example.marspioneer.state;


import com.example.marspioneer.model.*;
import com.example.marspioneer.proto.*;
import com.example.marspioneer.persistence.DBManager;
import com.example.marspioneer.generation.MPTerrainGenerator;
import com.raylabz.jsec.HashType;
import com.raylabz.jsec.Hashing;
import redis.clients.jedis.Jedis;

import java.util.*;

public class WorldContext {

    private final String worldID;
    private final MPWorld world;
    private final MPTerrainGenerator terrainGenerator;

    public WorldContext(String worldID) {
        this.worldID = worldID;
        this.world = DBManager.world.get(worldID);
        this.terrainGenerator = new MPTerrainGenerator(world);
    }

    public String getWorldID() {
        return worldID;
    }

    public MPTerrainGenerator getTerrainGenerator() {
        return terrainGenerator;
    }

    public MPWorld getWorld() {
        return world;
    }

    /**
     * Requests terrain data for a specific chunk.
     * @param chunkRow The row of the chunk to load.
     * @param chunkCol The column of the chunk to load.
     * @return Returns a TerrainChunk.
     */
    private MPTerrainChunk requestChunk(int chunkRow, int chunkCol) {
        final String chunkHash = Hashing.hash(HashType.MD5, chunkRow + "," + chunkCol);

        //Find the chunk using the identifier:
        MPTerrainIdentifier chunkIdentifier = null;
        final Collection<MPTerrainIdentifier> terrainIdentifiers = DBManager.terrainIdentifier.listForWorld(worldID);
        for (MPTerrainIdentifier terrainIdentifier : terrainIdentifiers) {
            if (terrainIdentifier.getChunkPosition().toHash().equals(chunkHash)) {
                chunkIdentifier = terrainIdentifier;
            }
        }

        //Retrieve the chunk by ID, if it exists:
        if (chunkIdentifier != null) {
            return DBManager.terrainChunk.get(chunkIdentifier.getChunkID());
        }
        //If cache and/or database don't have the chunk, generate it and store it:
        else {
            final MPTerrainChunk generatedChunk = terrainGenerator.generateChunk(chunkRow, chunkCol);
            DBManager.terrainChunk.create(generatedChunk);
            MPWorld updatedWorld = DBManager.world.get(worldID);
            updatedWorld.addChunk(generatedChunk.getId());
            DBManager.world.update(updatedWorld);
            return generatedChunk;
        }
    }

    /**
     * Retrieves the terrain cells that are within the area of interest of a list of entities.
     * @param playerEntities The list of entities.
     * @return Returns a Map containing the terrain cells.
     */
    public Map<String, MPTerrainCellProto> getTerrain(Collection<MPEntity> playerEntities) {

        HashMap<String, MPTerrainCellProto> cells = new HashMap<>();

        HashSet<MatrixPosition> chunksNeeded = new HashSet<>();
        for (MPEntity entity : playerEntities) {
            int minRow, maxRow, minCol, maxCol;
            minRow = (int) (entity.getPosition().getRow() - entity.getAreaOfInterest());
            maxRow = (int) (entity.getPosition().getRow() + entity.getAreaOfInterest());
            minCol = (int) (entity.getPosition().getCol() - entity.getAreaOfInterest());
            maxCol = (int) (entity.getPosition().getCol() + entity.getAreaOfInterest());

            final int INCREMENTATION_STEP = (int) Math.min(entity.getAreaOfInterest(), MPTerrainChunk.SIZE);

            for (int cellRow = minRow; cellRow <= maxRow; cellRow += INCREMENTATION_STEP) {
                for (int cellCol = minCol; cellCol <= maxCol; cellCol += INCREMENTATION_STEP) {
                    chunksNeeded.add(MPTerrainChunk.getChunkPosition(cellRow, cellCol));
                }
            }
        }

        ArrayList<MPTerrainChunk> chunks = new ArrayList<>();
        for (MatrixPosition chunkPos : chunksNeeded) {
            if (world.chunkIsInBounds(chunkPos.getRow(), chunkPos.getCol())) {
                //Request the entire chunk:
                MPTerrainChunk chunk = requestChunk(chunkPos.getRow(), chunkPos.getCol());
                chunks.add(chunk);
            }
        }

        for (MPEntity entity : playerEntities) {
            for (MPTerrainChunk chunk : chunks) {
                //Only include cells from this chunk that are within the AoI:
                for (Map.Entry<String, MPTerrainCell> entry : chunk.getCells().entrySet()) {
                    final MatrixPosition position = entry.getValue().getPosition();
                    final double distance = position.distanceTo(entity.getPosition());
                    if (distance <= entity.getAreaOfInterest()) {
                        cells.put(position.toHash(), entry.getValue().toProto().build());
                    }
                }
            }
        }
        return cells;
    }

    /**
     * Retrieves the terrain cells that are within the area of interest of a list of entities.
     * @param playerEntities The list of entities.
     * @return Returns a Map containing the terrain cells.
     */
    public Map<String, MPTerrainCellProto> getTerrain(List<MPEntityProto> playerEntities) {

        HashMap<String, MPTerrainCellProto> cells = new HashMap<>();

        HashSet<MatrixPosition> chunksNeeded = new HashSet<>();
        for (MPEntityProto entity : playerEntities) {
            int minRow, maxRow, minCol, maxCol;
            minRow = (int) (entity.getPosition().getRow() - entity.getAreaOfInterest());
            maxRow = (int) (entity.getPosition().getRow() + entity.getAreaOfInterest());
            minCol = (int) (entity.getPosition().getCol() - entity.getAreaOfInterest());
            maxCol = (int) (entity.getPosition().getCol() + entity.getAreaOfInterest());

            final int INCREMENTATION_STEP = (int) Math.min(entity.getAreaOfInterest(), MPTerrainChunk.SIZE);

            for (int cellRow = minRow; cellRow <= maxRow; cellRow += INCREMENTATION_STEP) {
                for (int cellCol = minCol; cellCol <= maxCol; cellCol += INCREMENTATION_STEP) {
                    chunksNeeded.add(MPTerrainChunk.getChunkPosition(cellRow, cellCol));
                }
            }
        }

        ArrayList<MPTerrainChunk> chunks = new ArrayList<>();
        for (MatrixPosition chunkPos : chunksNeeded) {
            if (world.chunkIsInBounds(chunkPos.getRow(), chunkPos.getCol())) {
                //Request the entire chunk:
                MPTerrainChunk chunk = requestChunk(chunkPos.getRow(), chunkPos.getCol());
                chunks.add(chunk);
            }
        }

        for (MPEntityProto entity : playerEntities) {
            for (MPTerrainChunk chunk : chunks) {
                //Only include cells from this chunk that are within the AoI:
                for (Map.Entry<String, MPTerrainCell> entry : chunk.getCells().entrySet()) {
                    final MatrixPosition position = entry.getValue().getPosition();
                    final double distance = position.distanceTo(entity.getPosition().toObject());
                    if (distance <= entity.getAreaOfInterest()) {
                        cells.put(position.toHash(), entry.getValue().toProto().build());
                    }
                }
            }
        }
        return cells;
    }

    /**
     * Retrieves the terrain cells that are within the area of interest of a specific position.
     * @param position The position.
     * @param radius The radius of the area of interest.
     * @return Returns a map of terrain cells.
     */
    public Map<String, MPTerrainCellProto> getTerrain(MatrixPosition position, float radius) {
        HashMap<String, MPTerrainCellProto> cells = new HashMap<>();

        HashSet<MatrixPosition> chunksNeeded = new HashSet<>();
        int minRow, maxRow, minCol, maxCol;
        minRow = (int) (position.getRow() - radius);
        maxRow = (int) (position.getRow() + radius);
        minCol = (int) (position.getCol() - radius);
        maxCol = (int) (position.getCol() + radius);

        final int INCREMENTATION_STEP = (int) Math.min(radius, MPTerrainChunk.SIZE);

        for (int cellRow = minRow; cellRow <= maxRow; cellRow += INCREMENTATION_STEP) {
            for (int cellCol = minCol; cellCol <= maxCol; cellCol += INCREMENTATION_STEP) {
                chunksNeeded.add(MPTerrainChunk.getChunkPosition(cellRow, cellCol));
            }
        }

        ArrayList<MPTerrainChunk> chunks = new ArrayList<>();
        for (MatrixPosition chunkPos : chunksNeeded) {
            if (world.chunkIsInBounds(chunkPos.getRow(), chunkPos.getCol())) {
                //Request the entire chunk:
                MPTerrainChunk chunk = requestChunk(chunkPos.getRow(), chunkPos.getCol());
                chunks.add(chunk);
            }
        }

        for (MPTerrainChunk chunk : chunks) {
            //Only include cells from this chunk that are within the AoI:
            for (Map.Entry<String, MPTerrainCell> entry : chunk.getCells().entrySet()) {
                final MatrixPosition cellPosition = entry.getValue().getPosition();
                final double distance = cellPosition.distanceTo(position);
                if (distance <= radius) {
                    cells.put(cellPosition.toHash(), entry.getValue().toProto().build());
                }
            }
        }
        return cells;
    }

    /**
     * Retrieves the entities that are within the area of interest of a given set of entities.
     * @param playerEntities The entities given.
     * @return Returns a map of entities.
     */
    public Map<String, MPEntityProto> getEntities(Collection<MPEntity> playerEntities) {
        HashMap<String, MPEntityProto> entitiesInAOI = new HashMap<>();
        for (MPEntity e : playerEntities) {
            entitiesInAOI.put(e.getId(), e.toProto().build());
        }
        final Collection<MPEntity> allEntities = DBManager.entity.listForWorld(worldID);
        for (MPEntity providedEntity : playerEntities) {
            for (MPEntity entity : allEntities) {
                if (!providedEntity.getId().equals(entity.getId()) && !entitiesInAOI.containsKey(entity.getId())) {
                    if (providedEntity.getPosition().distanceTo(entity.getPosition()) <= providedEntity.getAreaOfInterest()) {
                        entitiesInAOI.put(entity.getId(), entity.toProto().build());
                    }
                }
            }
        }
        return entitiesInAOI;
    }

    /**
     * Retrieves the entities that are within a radius of a given position.
     * @param position The position given.
     * @param radius The radius.
     * @return Returns a map of entities.
     */
    public Map<String, MPEntityProto> getEntities(MatrixPosition position, float radius) {
        HashMap<String, MPEntityProto> entitiesInAOI = new HashMap<>();
        final Collection<MPEntity> allEntities = DBManager.entity.listForWorld(worldID);
        for (MPEntity entity : allEntities) {
            if (!entitiesInAOI.containsKey(entity.getId())) {
                if (position.distanceTo(entity.getPosition()) <= radius) {
                    entitiesInAOI.put(entity.getId(), entity.toProto().build());
                }
            }
        }
        return entitiesInAOI;
    }

    /**
     * Retrieves a snapshot of the current partial state using a player's entities and their AoI.
     * @param worldSession The world session retrieving the snapshot.
     * @return Returns a PartialStateProto.
     */
    public MPPartialStateProto getPartialStateSnapshot(MPWorldSession worldSession) {
        final Collection<MPEntity> playerEntities = DBManager.entity.listForPlayerAndWorld(worldSession.getPlayerID(), worldSession.getWorldID());
        final MPPlayer player = DBManager.player.get(worldSession.getPlayerID());
        return MPPartialStateProto.newBuilder()
                .putAllEntities(getEntities(playerEntities))
                .putAllTerrain(getTerrain(playerEntities))
                .setTimestamp(System.currentTimeMillis())
                .setWorldSession(worldSession.toProto())
                .setResourceSet(
                        ResourceSetProto.newBuilder()
                                .setFood(player.getFood())
                                .setMetal(player.getMetal())
                                .setSand(player.getSand())
                                .setWater(player.getWater())
                                .build()
                )
                .build();
    }

    /**
     * Retrieves a snapshot of the current partial state using a position and a radius as an AoI.
     * @param worldSession The world session retrieving the snapshot.
     * @param position The position to retrieve the partial state at.
     * @param radius The radius of the AoI in this partial state.
     * @return Returns a PartialStateProto.
     */
    public MPPartialStateProto getPartialStateSnapshot(MPWorldSession worldSession, MatrixPosition position, float radius) {
        final MPPlayer player = DBManager.player.get(worldSession.getPlayerID());
        return MPPartialStateProto.newBuilder()
                .putAllEntities(getEntities(position, radius))
                .putAllTerrain(getTerrain(position, radius))
                .setTimestamp(System.currentTimeMillis())
                .setWorldSession(worldSession.toProto())
                .setResourceSet(
                        ResourceSetProto.newBuilder()
                                .setFood(player.getFood())
                                .setMetal(player.getMetal())
                                .setSand(player.getSand())
                                .setWater(player.getWater())
                                .build()
                )
                .build();
    }

    /**
     * Saves the state of an <b>entire</b> partial state to the cache/DB.
     * @param partialStateProto The partial state.
     */
    public void saveState(MPPartialStateProto partialStateProto) {
        saveTerrain(partialStateProto);
        saveEntities(partialStateProto);
    }

    /**
     * Saves the state to the cache/DB based on a state update.
     * @param stateUpdateProto The state update.
     */
    public void saveState(MPStateUpdateProto stateUpdateProto) {
        saveTerrain(stateUpdateProto);
        saveEntities(stateUpdateProto);
    }

    /**
     * Saves the terrain of an <b>entire</b> partial state to the cache/DB.
     * @param partialStateProto The partial state.
     */
    public void saveTerrain(MPPartialStateProto partialStateProto) {
        //Get the referenced chunks using the partial state provided:
        final Map<String, MPTerrainCellProto> terrainMap = partialStateProto.getTerrainMap();
        HashSet<MatrixPosition> chunkPositions = new HashSet<>();
        for (MPTerrainCellProto cell : terrainMap.values()) {
            chunkPositions.add(MPTerrainChunk.getChunkPosition(cell.getPosition().toObject()));
        }

        HashMap<String, MPTerrainChunk> chunks = new HashMap<>();
        for (MatrixPosition chunkPosition : chunkPositions) {
            final MPTerrainChunk chunk = DBManager.terrainChunk.getForWorld(worldID, chunkPosition.toHash());
            chunks.put(chunkPosition.toHash(), chunk);
        }

        //For each cell, find its corresponding chunk and update it:
        for (MPTerrainCellProto cell : partialStateProto.getTerrainMap().values()) {
            final MPTerrainChunk referencedChunk = chunks.get(MPTerrainChunk.getChunkPosition(cell.getPosition().toObject()).toHash());
            referencedChunk.getCells().put(cell.getPosition().toHash(), cell.toObject());
        }

        //Save the chunks:
        for (MPTerrainChunk chunk : chunks.values()) {
            DBManager.terrainChunk.update(chunk);
        }
    }

    /**
     * Saves the terrain to the cache/DB based on a state update.
     * @param stateUpdateProto The state update.
     */
    public void saveTerrain(MPStateUpdateProto stateUpdateProto) {
        //Get the referenced chunks using the state update:
        final Map<String, MPTerrainCellProto> terrainMap = stateUpdateProto.getPartialState().getTerrainMap();
        HashSet<MatrixPosition> chunkPositions = new HashSet<>();
        for (MPTerrainCellProto cell : terrainMap.values()) {
            chunkPositions.add(MPTerrainChunk.getChunkPosition(cell.getPosition().toObject()));
        }

        HashMap<String, MPTerrainChunk> chunks = new HashMap<>();
        for (MatrixPosition chunkPosition : chunkPositions) {
            final MPTerrainChunk chunk = DBManager.terrainChunk.getForWorld(worldID, chunkPosition.toHash());
            chunks.put(chunkPosition.toHash(), chunk);
        }

        //For each cell, find its corresponding chunk and update it:
        for (MPTerrainCellProto cell : stateUpdateProto.getPartialState().getTerrainMap().values()) {
            final MPTerrainChunk referencedChunk = chunks.get(MPTerrainChunk.getChunkPosition(cell.getPosition().toObject()).toHash());
            referencedChunk.getCells().put(cell.getPosition().toHash(), cell.toObject());
        }

        //Save the chunks:
        for (MPTerrainChunk chunk : chunks.values()) {
            DBManager.terrainChunk.update(chunk);
        }
    }

    /**
     * Saves the entities of an <b>entire</b> partial state to the cache/DB.
     * @param partialStateProto The partial state.
     */
    public void saveEntities(MPPartialStateProto partialStateProto) {
        for (MPEntityProto entity : partialStateProto.getEntitiesMap().values()) {
            if (entity.hasBuildingEntity()) { //FIXME: Do this for every type of entity...
                DBManager.buildingEntity.update(entity.getBuildingEntity().toObject());
            }
        }
    }

    /**
     * Saves the entities to the cache/DB based on a state update.
     * @param stateUpdateProto The state update.
     */
    public void saveEntities(MPStateUpdateProto stateUpdateProto) {
        for (MPEntityProto entity : stateUpdateProto.getPartialState().getEntitiesMap().values()) {
            if (entity.hasBuildingEntity()) { //FIXME: Do this for every type of entity...
                DBManager.buildingEntity.update(entity.getBuildingEntity().toObject());
            }
        }
    }

    /**
     * Refreshes the terrain of a particular StateUpdateBuilder using the new entities' AoI.
     * @param entities The old (existing) entities.
     * @param stateUpdateBuilder The builder, which contains the new entities.
     * @return Returns a StateUpdateBuilder.
     */
    public StateUpdateBuilder refreshTerrain(List<MPEntity> entities, StateUpdateBuilder stateUpdateBuilder) {
        final Map<String, MPTerrainCellProto> terrain = getTerrain(entities);
        for (MPTerrainCellProto terrainCell : terrain.values()) {
            stateUpdateBuilder.addUpdatedTerrain(terrainCell);
        }
        return stateUpdateBuilder;
    }

    /**
     * Refreshes the entities of a particular StateUpdateBuilder.
     * @param stateUpdateBuilder The builder.
     * @return Returns a StateUpdateBuilder.
     */
    public StateUpdateBuilder refreshEntities(MPWorldSession worldSession, StateUpdateBuilder stateUpdateBuilder) {
        final Collection<MPEntity> playerEntities = DBManager.entity.listForPlayerAndWorld(worldSession.getWorldID(), worldSession.getPlayerID());
        final Map<String, MPEntityProto> aoiEntities = getEntities(playerEntities);
        for (MPEntityProto value : aoiEntities.values()) {
            stateUpdateBuilder.addUpdatedEntity(value);
        }
        return stateUpdateBuilder;
    }

    /**
     * Refreshes an existing state's terrain ONLY, using existing entities in the stateUpdateBuilder provided.
     * @param stateUpdateBuilder An existing state update builder, containing the entities created in the last action.
     * @return Returns a StateUpdateBuilder.
     */
    public StateUpdateBuilder checkAndRefreshTerrain(MPWorldSession worldSession, StateUpdateBuilder stateUpdateBuilder) {
        //For each entity, find if the a entity is contained inside it
        final List<MPEntity> entities = new ArrayList<>(DBManager.entity.listForPlayerAndWorld(worldSession.getWorldID(), worldSession.getPlayerID()));

        boolean contained = false;
        outterLoop:
        for (MPEntity existingEntity : entities) {
            for (MPEntityProto createdEntity : stateUpdateBuilder.getUpdatedEntities().values()) {
                if (worldSession.getPlayerID().equals(createdEntity.getPlayerID())) {
                    break outterLoop;
                }
                double distance = existingEntity.getPosition().distanceTo(createdEntity.getPosition().toObject());
                if (distance - createdEntity.getAreaOfInterest() < existingEntity.getAreaOfInterest()) {
                    contained = true;
                    break outterLoop;
                }
            }
        }

        //If not contained, fetch the terrain and any entities associated with it.
        if (!contained) {
            stateUpdateBuilder = refreshTerrain(entities, stateUpdateBuilder);
            stateUpdateBuilder = refreshEntities(worldSession, stateUpdateBuilder);
        }

        return stateUpdateBuilder;
    }

    /**
     * Composes a custom state update, optionally refreshing the terrain and/or entities.
     * Important note: Refreshing terrain/entities may impact the performance of this method significantly. Opt to refresh
     * the terrain and entities only when necessary.
     * @param worldSessionsMap A map of world sessions for which the state must be updated.
     * @param globalStateUpdateBuilder The state update, as provided by the action made.
     * @param refreshEntities Refresh entities?
     * @param refreshTerrain Refresh terrain?
     * @return Returns a StateUpdateProto
     */
    public HashMap<MPWorldSession, UpdateStateResponse> composeStateUpdate(HashMap<MPWorldSession, ArrayList<MPEntity>> worldSessionsMap, StateUpdateBuilder globalStateUpdateBuilder,
                                                 boolean refreshTerrain, boolean refreshEntities) {
        final HashMap<MPWorldSession, UpdateStateResponse> stateUpdateMap = new HashMap<>();
        for (Map.Entry<MPWorldSession, ArrayList<MPEntity>> entry : worldSessionsMap.entrySet()) {
            if (refreshTerrain) {
                globalStateUpdateBuilder = checkAndRefreshTerrain(entry.getKey(), globalStateUpdateBuilder);
            }
            if (refreshEntities) {
                globalStateUpdateBuilder = refreshEntities(entry.getKey(), globalStateUpdateBuilder);
            }
            StateUpdateBuilder individualStateUpdateBuilder = globalStateUpdateBuilder.clone();
            final MPPlayer player = DBManager.player.get(entry.getKey().getPlayerID());
            individualStateUpdateBuilder.getStateUpdateProtoBuilder().getPartialStateBuilder().setResourceSet(
                    ResourceSetProto.newBuilder()
                            .setFood(player.getFood())
                            .setMetal(player.getMetal())
                            .setSand(player.getSand())
                            .setWater(player.getWater())
                            .build()
            );

            //If any of the new entities belonging to the player are not within the current AOI of the player's entities, get the terrain around their AOI:
            final Collection<MPEntity> currentPlayerEntities = DBManager.entity.listForPlayerAndWorld(player.getId(), entry.getKey().getWorldID());
            for (MPEntityProto updatedEntity : individualStateUpdateBuilder.getUpdatedEntities().values()) {
                if (updatedEntity.getPlayerID().equals(entry.getKey().getPlayerID())) {
                    for (MPEntity playerEntity : currentPlayerEntities) {
                        if (State.Entities.isOutOfAOI(updatedEntity, playerEntity.toProto().build())) {
                            final Map<String, MPTerrainCellProto> newTerrain = getTerrain(updatedEntity.getPosition().toObject(), updatedEntity.getAreaOfInterest());
                            for (Map.Entry<String, MPTerrainCellProto> tEntry : newTerrain.entrySet()) {
                                individualStateUpdateBuilder.addUpdatedTerrain(tEntry.getValue());
                            }
                        }
                    }
                }
            }

            final UpdateStateResponse response = UpdateStateResponse.newBuilder()
                    .setStatus(UpdateStateResponse.Status.OK)
                    .setMessage("OK")
                    .setStateUpdate(individualStateUpdateBuilder.build())
                    .build();
            stateUpdateMap.put(entry.getKey(), response);
        }
        return stateUpdateMap;
    }

    /**
     * Returns the active sessions for this world.
     * @return Returns a collection of WorldSessions.
     */
    public Collection<MPWorldSession> getAllSessions() {
        return DBManager.worldSession.listForWorld(worldID);
    }

    /**
     * Returns the subscribed sessions (those receiving state updates) for this world.
     * @return Returns the subscribed sessions of this world.
     */
    public Collection<MPWorldSession> getSubscribedSessions() {
        final List<String> subscribedSessionIDs = DBManager.world.get(worldID).getSubscribedSessionIDs();
        return DBManager.worldSession.getMany(subscribedSessionIDs);
    }

    /**
     * Subscribes a world session to a world.
     * @param worldSession The world session.
     */
    public void subscribe(MPWorldSession worldSession) {
        final MPWorld world = DBManager.world.get(worldID);
        if (!world.getSubscribedSessionIDs().contains(worldSession.getId())) {
            world.getSubscribedSessionIDs().add(worldSession.getId());
            DBManager.world.update(world);
        }
    }

    /**
     * Unsubscribes a world session.
     * @param worldSession The world session to unsubscribe.
     */
    public void unsubscribe(MPWorldSession worldSession) {
        final MPWorld world = DBManager.world.get(worldID);
        world.getSubscribedSessionIDs().remove(worldSession.getId());
        DBManager.world.update(world);
    }

}
