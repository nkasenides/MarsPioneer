/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Project Editor, v1.0 BETA
-------------------------------------------------------------------------------- */

package com.example.marspioneer.model;

import com.nkasenides.athlos.proto.Transmittable;
import com.example.marspioneer.proto.*;
import com.nkasenides.athlos.model.*;
import com.raylabz.firestorm.annotation.FirestormObject;
import com.raylabz.objectis.annotation.ObjectisObject;

import java.io.Serializable;

@FirestormObject
@ObjectisObject
public class MPGameSession implements Transmittable<MPGameSessionProto.Builder>, IGameSession, Serializable {
    private String ipAddress;    
    private long expiresOn;    
    private String id;    
    private long createdOn;    
    private String playerID;    

    public String getIpAddress() {    
        return ipAddress;        
    }    
    
    public long getExpiresOn() {    
        return expiresOn;        
    }    
    
    public String getId() {    
        return id;        
    }    
    
    public long getCreatedOn() {    
        return createdOn;        
    }    
    
    public String getPlayerID() {    
        return playerID;        
    }    
    

    public void setIpAddress(String ipAddress) {    
        this.ipAddress = ipAddress;        
    }    
    
    public void setExpiresOn(long expiresOn) {    
        this.expiresOn = expiresOn;        
    }    
    
    public void setId(String id) {    
        this.id = id;        
    }    
    
    public void setCreatedOn(long createdOn) {    
        this.createdOn = createdOn;        
    }    
    
    public void setPlayerID(String playerID) {    
        this.playerID = playerID;        
    }    
    

    @Override    
    public MPGameSessionProto.Builder toProto() {
        MPGameSessionProto.Builder protoBuilder = MPGameSessionProto.newBuilder();
        protoBuilder.setIpAddress(ipAddress);        
        protoBuilder.setExpiresOn(expiresOn);        
        protoBuilder.setId(id);        
        protoBuilder.setCreatedOn(createdOn);        
        protoBuilder.setPlayerID(playerID);        
        return protoBuilder;        
    }    
    

}
