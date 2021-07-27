package com.example.marspioneer.client.simulation;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class SimulationConfig {

    private ArrayList<SimulationEvent> events = new ArrayList<>();
    private long timeLimit = -1;
    private long delay;

    public SimulationConfig(long timeLimitSeconds, int delay) {
        this.timeLimit = timeLimitSeconds * 1000;
        this.delay = delay;
    }

    public long getTimeLimit() {
        return timeLimit;
    }

    public long getDelay() {
        return delay;
    }

    public void setTimeLimit(long timeLimit) {
        this.timeLimit = timeLimit;
    }

    public void addEvent(SimulationEvent event) {
        this.events.add(event);
    }

    public ArrayList<SimulationEvent> getEvents() {
        return events;
    }

    public static void main(String[] args) {
        final SimulationConfig simulationConfig = new SimulationConfig(60, 3000);
        for (int i = 1000; i <= 1000; i+= 1000) {
            simulationConfig.addEvent(new SimulationEvent(i, SimulationEventType.PLAYER_JOIN, Bot.getRandomNumber(10000, 60000)));
        }

        final String jsonString = new Gson().toJson(simulationConfig);
        try {
            FileWriter fileWriter = new FileWriter("simConfig.cfg");
            fileWriter.write(jsonString);
            fileWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "SimulationConfig{" +
                "events=" + events +
                ", timeLimit=" + timeLimit +
                '}';
    }

}
