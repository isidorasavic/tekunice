package sbnz.integracija.example.facts;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.minidev.json.annotate.JsonIgnore;
import sbnz.integracija.example.dto.HabitatDTO;
import sbnz.integracija.example.facts.enums.Label;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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

//    @JoinColumn(name = "antropological_factors_id", referencedColumnName = "id")
//    @OneToOne
//    private AntropologicalFactors antropologicalFactors;

/*
    @OneToMany(fetch =FetchType.LAZY)
    @JoinColumn(name="antropological_factors_id", referencedColumnName="id")
    @JsonIgnore
    private List<AntropologicalFactors> antropologicalFactors;
*/

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

    public Habitat(String name, Label label, NaturalFactors naturalFactors, User user, LocalDate dateCreated) {
        this.name = name;
        this.label = label;
        this.naturalFactors = naturalFactors;
        this.user = user;
        this.dateCreated = dateCreated;
    }


}
