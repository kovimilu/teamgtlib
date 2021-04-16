package com.teamgtlib.NPCs;

import com.teamgtlib.Park;

public abstract class Worker extends NPC {
    int wage = 450;

    public void payment(int wage) {
        Park.player.updateBudget(-wage);
    }
}
