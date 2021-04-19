package com.teamgtlib.NPCs;

public abstract class Worker extends NPC {
    int wage = 450;

    public void pay(int wage) {
        super.changeParkBudgetBy(-wage);
    }
}
