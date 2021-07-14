/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Project Editor, v1.0 BETA
-------------------------------------------------------------------------------- */


package com.example.marspioneer.model;

import com.example.marspioneer.proto.*;
import com.nkasenides.athlos.model.*;
import com.nkasenides.athlos.proto.*;
import com.raylabz.firestorm.annotation.FirestormObject;


public interface MPEntity extends IEntity, Transmittable<MPEntityProto.Builder> {

    String getWorldID();    
    float getAreaOfInterest();    
    String getId();    
    MatrixPosition getPosition();    
    String getPlayerID();    
    Direction4 getDirection();    
    void setWorldID(String worldID);    
    void setAreaOfInterest(float areaOfInterest);    
    void setId(String id);    
    void setPosition(MatrixPosition position);    
    void setPlayerID(String playerID);    
    void setDirection(Direction4 direction);    

}

