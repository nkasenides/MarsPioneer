package com.example.marspioneer.benchmarking;

import com.raylabz.objectis.annotation.ObjectisObject;

import java.io.Serializable;
import java.util.UUID;

@ObjectisObject
public class StateModificationResult implements Serializable {

    long value;
    String id;

    public StateModificationResult() {
        id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public StateModificationResult(long value) {
        this.value = value;
        id = UUID.randomUUID().toString();
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

}
