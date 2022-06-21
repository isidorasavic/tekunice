package sbnz.integracija.example.model.enums;

public enum Type {
    NO_TYPE(0), PZS(1), SPKP(2), PSPNL(3), SLVTKSK(4), LS(5), CS(6), SLZ(7), PZ(8), PP(9), BMS(10);

    private int numVal;

    Type(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }
}
