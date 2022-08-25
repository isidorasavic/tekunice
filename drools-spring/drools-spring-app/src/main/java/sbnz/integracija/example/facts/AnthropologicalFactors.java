package sbnz.integracija.example.facts;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name="anthropological_factors")
public class AnthropologicalFactors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shrubbery_id")
    private AnthropologicalFactorLevelAndDescription shrubbery;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "distance_id")
    private AnthropologicalFactorLevelAndDescription distanceToNeighbourhoodPopulation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "disturbance_id")
    private AnthropologicalFactorLevelAndDescription disturbance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roads_id")
    private AnthropologicalFactorLevelAndDescription roads;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agriculture_id")
    private AnthropologicalFactorLevelAndDescription agriculture;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grazing_id")
    private AnthropologicalFactorLevelAndDescription grazing;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grass_removing_id")
    private AnthropologicalFactorLevelAndDescription grassRemoving;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "predators_id")
    private AnthropologicalFactorLevelAndDescription predators;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "protection_id")
    private AnthropologicalFactorLevelAndDescription protection;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purpose_id")
    private AnthropologicalFactorLevelAndDescription purpose;

    @ManyToOne()
    @JoinColumn(name="habitat_id")
    private Habitat habitat;

    @Column(name="date_created")
    private LocalDate dateCreated;

    public AnthropologicalFactors() {
    }

    public AnthropologicalFactors(AnthropologicalFactorLevelAndDescription shrubbery, AnthropologicalFactorLevelAndDescription distanceToNeighbourhoodPopulation, AnthropologicalFactorLevelAndDescription disturbance, AnthropologicalFactorLevelAndDescription roads, AnthropologicalFactorLevelAndDescription agriculture, AnthropologicalFactorLevelAndDescription grazing, AnthropologicalFactorLevelAndDescription grassRemoving, AnthropologicalFactorLevelAndDescription predators, AnthropologicalFactorLevelAndDescription protection, AnthropologicalFactorLevelAndDescription purpose, Habitat habitat, LocalDate dateCreated) {
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
        this.habitat = habitat;
        this. dateCreated = dateCreated;
    }
}
