package sbnz.integracija.example.facts.enums;

public enum Label {
    //TODO: RECENICE!!
    NO_LABEL("Nema labele"),
    OPTIMAL ("Optimalno stanište"),
    SUBOPTIMAL("Suboptimalno stanište"),
    MODERATE("Srednje optimalno stanište"),
    INADEQUATE("Neadekvatno stanište"),
    INAPPROPRIATE ("Loše stanište");

    private String name;

    Label(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
