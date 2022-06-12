package drools.spring.example.model.enums;

public enum Slope {
    NoSlope(0), Small(10), Medium(20), Great(40);

    private int numVal;

    Slope(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }
}
