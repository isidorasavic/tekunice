package sbnz.integracija.example.facts.enums;

public enum Label {
    //TODO: RECENICE!!
    NO_LABEL("Nema labele"),
    OPTIMAL (" Optimalno stanište - Karakteristike navedenog  staništa su izuzetno povoljne za optimalan razvoj i opstanak populacije tekunica. Za uspeh naseljavanja nisu potrebne dodatne aktivnosti na održavanju terena."),
    SUBOPTIMAL("Suboptimalno stanište - Karakteristike predloženog staništa su sasvim dobre za opstanak tekunica. Uspeh naseljavanja trebalo bi da bude na zadovoljavajućem nivou ali će verovatno biti neophodno preduzeti određene aktivnosti manjeg obima na održavanju staništa."),
    MODERATE("Srednje dobro stanište - Karakteristike predloženog staništa nalaze se u granicama mogućeg opstanka tekunica. Iako uslovi nisu idealni na ovom staništu moguće je naseljavanje tekunica ali uz određene redovne aktivnosti na njegovom održavanju."),
    INADEQUATE("Neadekvatno stanište -  Karakteristike predloženog staništa su na samim granicama  mogućnosti opstanka tekunica, zbog čega se ne može preporučiti za pokušaj naseljavanja jer su veoma male šanse za uspeh čak i uz visok nivo dodatnih aktivnosti na pripremi i održavanju terena."),
    INAPPROPRIATE ("Nepovoljno stanište -  Jedna ili  više karakteristika predloženog staništa isključuje bilo kakvu mogućnost opstanka tekunica zbog čega se pokušaj njihovog naseljavanja na ovom staništu ne preporučuje.");

    private String name;

    Label(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
