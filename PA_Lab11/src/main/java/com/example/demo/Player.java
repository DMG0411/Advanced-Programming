package com.example.demo;

public class Player {
    private final int id;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setPiece(char piece) {
        this.piece = piece;
    }
}
