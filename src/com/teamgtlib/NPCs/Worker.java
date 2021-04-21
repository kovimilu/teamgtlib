package com.teamgtlib.NPCs;

public abstract class Worker extends NPC {
    int wage = 450;

    public Worker(int x, int y) {
        super(x, y);
    }

    public void pay(int wage) {
        super.changeParkBudgetBy(-wage);
    }
}
