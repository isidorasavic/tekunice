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
@Table(name="atropological_factor_level_and_description")  // TODO: ulepsati naziv mozda
public class AntropologicalFactorLevelAndDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="factor_name", nullable=false)
    private String factorName;
    @Column(name="level", nullable=false)
    private int level;
    @Column(name="recommendation", nullable=false)
    private String recommendation;
}
