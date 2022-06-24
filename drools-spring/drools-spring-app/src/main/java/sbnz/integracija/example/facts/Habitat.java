package sbnz.integracija.example.facts;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import sbnz.integracija.example.dto.HabitatDTO;
import sbnz.integracija.example.facts.enums.Label;

import javax.persistence.*;
import java.time.LocalDate;

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

    @Column(name="label", nullable = false)
    @Enumerated(EnumType.STRING)
    private Label label;

    @JoinColumn(name = "antropological_factors_id", referencedColumnName = "id")
    @OneToOne
    private AntropologicalFactors antropologicalFactors;

    @JoinColumn(name = "natural_factors_id", referencedColumnName = "id")
    @OneToOne
    private NaturalFactors naturalFactors;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User user;

    @Column(name="date_created")
    private LocalDate dateCreated;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Habitat() {
    }

    public Habitat(String name, Label label, AntropologicalFactors antropologicalFactors, NaturalFactors naturalFactors, User user, LocalDate dateCreated) {
        this.name = name;
        this.label = label;
        this.antropologicalFactors = antropologicalFactors;
        this.naturalFactors = naturalFactors;
        this.user = user;
        this.dateCreated = dateCreated;
    }

    public Habitat(HabitatDTO habitatDTO){
        this.name = habitatDTO.getName();
        this.label = Label.valueOf(habitatDTO.getLabel());
        this.naturalFactors = new NaturalFactors(habitatDTO.getNaturalFactorsDTO());
        //TODO: antropological factors
        //TODO: user
        this.dateCreated = LocalDate.parse(habitatDTO.getDateCreated());
    }

}
