package sbnz.integracija.example.dto;

import lombok.*;
import sbnz.integracija.example.facts.AnthropologicalFactors;
import sbnz.integracija.example.facts.Option;

import java.time.format.DateTimeFormatter;

@Getter
@Setter
@ToString
public class AntropologicalFactorDTO {

    private Option shrubbery;
    private Option distanceToNeighbourhoodPopulation;
    private Option disturbance;
    private Option roads;
    private Option agriculture;
    private Option grazing;
    private Option grassRemoving;
    private Option predators;
    private Option protection;
    private Option purpose;
    private String dateAdded;

    private long habitatId;

    public AntropologicalFactorDTO(AnthropologicalFactors antropologicalFactors) {
        this.shrubbery = new Option(antropologicalFactors.getShrubbery());
        this.distanceToNeighbourhoodPopulation = new Option(antropologicalFactors.getDistanceToNeighbourhoodPopulation());
        this.disturbance = new Option(antropologicalFactors.getDisturbance());
        this.roads = new Option(antropologicalFactors.getRoads());
        this.agriculture = new Option(antropologicalFactors.getAgriculture());
        this.grazing = new Option(antropologicalFactors.getGrazing());
        this.grassRemoving = new Option(antropologicalFactors.getGrassRemoving());
        this.predators = new Option(antropologicalFactors.getPredators());
        this.protection = new Option(antropologicalFactors.getProtection());
        this.purpose = new Option(antropologicalFactors.getPurpose());
        this.dateAdded = antropologicalFactors.getDateCreated().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        this.habitatId = antropologicalFactors.getHabitat().getId();
    }


    public AntropologicalFactorDTO(Option shrubbery, Option distanceToNeighbourhoodPopulation, Option disturbance, Option roads, Option agriculture, Option grazing, Option grassRemoving, Option predators, Option protection, Option purpose, String dateAdded, long habitatId) {
        this.shrubbery = shrubbery;
        this.distanceToNeighbourhoodPopulation = distanceToNeighbourhoodPopulation;
        this.disturbance = disturbance;
        this.roads = roads;
        this.agriculture = agriculture;
        this.grazing = grazing;
        this.grassRemoving = grassRemoving;
        this.predators = predators;
        this.protection = protection;
        this.purpose = purpose;
        this.dateAdded = dateAdded;
        this.habitatId = habitatId;
    }

    public AntropologicalFactorDTO() {
    }
}
