package com.example.marspioneer.benchmarking;

import com.raylabz.objectis.annotation.ObjectisObject;

import java.io.Serializable;
import java.util.UUID;

@ObjectisObject
public class StateSendResult implements Serializable {

    long value;
    String id;

    public StateSendResult() {
        id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public StateSendResult(long value) {
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
