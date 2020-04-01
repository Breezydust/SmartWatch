package com.example.balib.mybeat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


// Define a data class that would have the following items:


// This is a holder of the data that would be used for your app.
public class DataItem {
    private int itemId;
    private String Heartbeat;
    private String Temperature;
    private String StepsTaken;
    private String timestamp;

    public DataItem( int itemId, String Heartbeat, String Temperature, String StepsTaken, String timestamp) {
        this.itemId = itemId;
        this.Heartbeat = Heartbeat;
        this.Temperature = Temperature;
        this.StepsTaken = StepsTaken;
        this.timestamp = timestamp;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getHeartbeat() {
        return Heartbeat;
    }

    public void setHeartbeat(String Heartbeat) {
        this.Heartbeat = Heartbeat;
    }

    public String getTemperature() {
        return Temperature;
    }

    public void setTemperature(String Temperature) {
        this.Temperature = Temperature;
    }

    public String getStepsTaken() {
        return StepsTaken;
    }

    public void setStepsTaken(String StepsTaken) { this.StepsTaken = StepsTaken; }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "DataItem{" +
                "itemId='" + itemId + '\'' +
                "  Heartbeat='" + Heartbeat + '\'' +
                ", Temperature='" + Temperature + '\'' +
                ", StepsTaken='" + StepsTaken + '\'' +
                "  Timestamp='" + timestamp + '\'' +
                '}';
    }
}