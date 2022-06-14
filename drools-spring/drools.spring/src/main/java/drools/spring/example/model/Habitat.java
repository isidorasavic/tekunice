package drools.spring.example.model;

import drools.spring.example.model.enums.Label;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
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


}
