package sbnz.integracija.example.facts;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import sbnz.integracija.example.dto.HabitatDTO;
import sbnz.integracija.example.facts.enums.Label;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name="habitats")
public class Habitat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="label", unique=true, nullable = false)
    private Label label;

    @JoinColumn(name = "antropological_factors_id", referencedColumnName = "id")
    @OneToOne
    private AntropologicalFactors antropologicalFactors;

    @JoinColumn(name = "natural_factors_id", referencedColumnName = "id")
    @OneToOne
    private NaturalFactors naturalFactors;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Habitat() {
    }

    public Habitat(String name, Label label, AntropologicalFactors antropologicalFactors, NaturalFactors naturalFactors) {
        this.name = name;
        this.label = label;
        this.antropologicalFactors = antropologicalFactors;
        this.naturalFactors = naturalFactors;
    }

    public Habitat(HabitatDTO habitatDTO){
        this.name = habitatDTO.getName();
        this.label = Label.valueOf(habitatDTO.getLabel());
        this.naturalFactors = new NaturalFactors(habitatDTO.getNaturalFactorsDTO());
        //TODO: antropological factors
    }

}
