package com.teamgtlib.NPCs;

public class Visitor extends NPC {
    private int mood;

    public void updateMood(int changeBy) {
        mood += changeBy;
    }
}
