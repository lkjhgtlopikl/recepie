package com.example.recepie.model;

public enum Difficulty {
    Легко("Легко"),
    Средне("Средне"),
    Сложно("Сложно");

    private final String displayName;

    Difficulty(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
