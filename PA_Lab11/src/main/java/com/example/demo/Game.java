package com.example.demo;

import java.util.Date;

public class Game {
    private final int id;
    private final String createdOn;
    private final int timePlayed;

    public Game(int id, String createdOn, int timePlayed) {
        this.id = id;
        this.createdOn = createdOn;
        this.timePlayed = timePlayed;
    }

    public int getId() {
        return id;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public int getTimePlayed() {
        return timePlayed;
    }
}
