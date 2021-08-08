package com.example.marspioneer.benchmarking;

import com.raylabz.objectis.annotation.ObjectisObject;

import java.io.Serializable;
import java.util.UUID;

@ObjectisObject
public class TotalResult implements Serializable {

    long value;
    String id;

    public TotalResult() {
        id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TotalResult(long value) {
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
