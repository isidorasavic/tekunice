package sbnz.integracija.example.model.enums;

public enum MJT {
    ExtraCold(5), VeryCold(11), Cold(17), Medium(21), Hot(26), VeryHot(31);

    private int numVal;

    MJT(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }
}
