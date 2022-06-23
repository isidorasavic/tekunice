package drools.spring.example.model.enums;

public enum Exposition {
    No_Exposition(0), North(1), NorthWest(2), NorthEast(3), East(4), West(5), South(6), SouthEast(7), SouthWest(8);

    private int numVal;

    Exposition(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }
}
