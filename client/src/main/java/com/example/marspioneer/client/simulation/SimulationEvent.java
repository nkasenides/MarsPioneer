package com.example.marspioneer.client.simulation;

public class SimulationEvent {

    private final long time;
    private final SimulationEventType type;
    private final long duration;

    public SimulationEvent(long time, SimulationEventType type, long duration) {
        this.time = time;
        this.type = type;
        this.duration = duration;
    }

    public long getDuration() {
        return duration;
    }

    public long getTime() {
        return time;
    }

    public SimulationEventType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "SimulationEvent{" +
                "time=" + time +
                ", type=" + type +
                ", duration=" + duration +
                '}';
    }
}
