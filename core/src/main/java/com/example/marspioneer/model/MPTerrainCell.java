/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Project Editor, v1.0 BETA
-------------------------------------------------------------------------------- */

package com.example.marspioneer.model;

import com.nkasenides.athlos.proto.Transmittable;
import com.example.marspioneer.proto.*;
import com.nkasenides.athlos.model.*;
import com.raylabz.firestorm.annotation.FirestormObject;

import java.io.Serializable;

@FirestormObject
public class MPTerrainCell implements Transmittable<MPTerrainCellProto.Builder>, ITerrainCell, Serializable {
    private MatrixPosition position;    
    private CellType type;    
    private int height;    

    public MatrixPosition getPosition() {    
        return position;        
    }    
    
    public CellType getType() {    
        return type;        
    }    
    
    public int getHeight() {    
        return height;        
    }    
    

    public void setPosition(MatrixPosition position) {    
        this.position = position;        
    }    
    
    public void setType(CellType type) {    
        this.type = type;        
    }    
    
    public void setHeight(int height) {    
        this.height = height;        
    }    
    

    @Override    
    public com.example.marspioneer.proto.MPTerrainCellProto.Builder toProto() {    
        com.example.marspioneer.proto.MPTerrainCellProto.Builder protoBuilder = com.example.marspioneer.proto.MPTerrainCellProto.newBuilder();        
        protoBuilder.setPosition(position.toProto().build());        
        protoBuilder.setType(type);        
        protoBuilder.setHeight(height);        
        return protoBuilder;        
    }    
    

}
