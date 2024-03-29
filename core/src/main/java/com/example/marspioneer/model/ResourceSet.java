/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Project Editor, v1.0 BETA
-------------------------------------------------------------------------------- */

package com.example.marspioneer.model;

import com.nkasenides.athlos.proto.Transmittable;
import com.example.marspioneer.proto.*;
import com.nkasenides.athlos.model.*;
import com.raylabz.objectis.annotation.ObjectisObject;

import java.io.Serializable;

@ObjectisObject
public class ResourceSet implements Transmittable<ResourceSetProto.Builder>, Serializable {
    private int sand;    
    private int metal;    
    private int water;    
    private int food;    

    public int getSand() {    
        return sand;        
    }    
    
    public int getMetal() {    
        return metal;        
    }    
    
    public int getWater() {    
        return water;        
    }    
    
    public int getFood() {    
        return food;        
    }    
    

    public void setSand(int sand) {    
        this.sand = sand;        
    }    
    
    public void setMetal(int metal) {    
        this.metal = metal;        
    }    
    
    public void setWater(int water) {    
        this.water = water;        
    }    
    
    public void setFood(int food) {    
        this.food = food;        
    }    
    

    @Override    
    public ResourceSetProto.Builder toProto() {
        ResourceSetProto.Builder protoBuilder = ResourceSetProto.newBuilder();
        protoBuilder.setSand(sand);        
        protoBuilder.setMetal(metal);        
        protoBuilder.setWater(water);        
        protoBuilder.setFood(food);        
        return protoBuilder;        
    }    
    

}
