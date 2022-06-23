package sbnz.integracija.example.facts.enums;

public enum Elevation {
    NoElevation(0), ExtraSmall(200), Small(600), Medium(800), Large(1200), ExtraLarge(2000);

    private int numVal;

    Elevation(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }
}
