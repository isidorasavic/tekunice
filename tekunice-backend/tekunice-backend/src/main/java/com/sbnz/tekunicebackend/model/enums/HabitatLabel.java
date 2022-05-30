package com.sbnz.tekunicebackend.model.enums;

public enum HabitatLabel {
    NoLabel(-1), Optimal(5), Suboptimal(4), Moderate(3), Inadequate(2), Inappropriate(1);

    
    private int numVal;

    HabitatLabel(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }
}
