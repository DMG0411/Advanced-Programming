package com.example.demo;

public class Player {
    private int id;
    private String name;
    private char piece;

    public Player(int id, String name, char piece) {
        this.id = id;
        this.name = name;
        this.piece = piece;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public char getPiece() {
        return piece;
    }
}
