package drools.spring.example.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name="antropological_factors")
public class AntropologicalFactors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shrubbery_id")
    private AntropologicalFactorLevelAndDescription shrubbery;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "distance_id")
    private AntropologicalFactorLevelAndDescription distanceToNeighbourhoodPopulation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "disturbance_id")
    private AntropologicalFactorLevelAndDescription disturbance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roads_id")
    private AntropologicalFactorLevelAndDescription roads;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agriculture_id")
    private AntropologicalFactorLevelAndDescription agriculture;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grazing_id")
    private AntropologicalFactorLevelAndDescription grazing;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grass_removing_id")
    private AntropologicalFactorLevelAndDescription grassRemoving;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "predators_id")
    private AntropologicalFactorLevelAndDescription predators;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "protection_id")
    private AntropologicalFactorLevelAndDescription protection;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purpose_id")
    private AntropologicalFactorLevelAndDescription purpose;


}
