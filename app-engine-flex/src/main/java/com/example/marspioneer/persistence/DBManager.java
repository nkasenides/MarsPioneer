/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Project Editor, v1.0 BETA
-------------------------------------------------------------------------------- */

package com.example.marspioneer.persistence;


import com.example.marspioneer.model.MPTerrainIdentifier;
import redis.clients.jedis.Jedis;

public final class DBManager {

    public static final MPWorldSessionDAO worldSession  = new MPWorldSessionDAO();
    public static final MPTeamDAO team  = new MPTeamDAO();
    public static final BuildingEntityDAO buildingEntity  = new BuildingEntityDAO();
    public static final MPEntityDAO entity  = new MPEntityDAO();
    public static final MPGameSessionDAO gameSession  = new MPGameSessionDAO();
    public static final MPPlayerDAO player  = new MPPlayerDAO();
    public static final MPWorldDAO world  = new MPWorldDAO();
    public static MPTerrainChunkDAO terrainChunk = new MPTerrainChunkDAO();
    public static final MPTerrainIdentifierDAO terrainIdentifier = new MPTerrainIdentifierDAO(); //NEW

}
