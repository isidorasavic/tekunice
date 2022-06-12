package drools.spring.example.model;

import drools.spring.example.model.enums.*;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "natural_factors")
public class NaturalFactors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="type", nullable=false)
    private String type;

    @Column(name="elevation", nullable=false)
    @Enumerated(EnumType.STRING)
    private Elevation elevation;

    @Column(name="mjt", nullable=false)
    @Enumerated(EnumType.STRING)
    private MJT mjt;

    @Column(name="exposition", nullable=false)
    @Enumerated(EnumType.STRING)
    private Exposition exposition;

    @Column(name="slope", nullable=false)
    @Enumerated(EnumType.STRING)
    private Slope slope;

    @Column(name="flooding", nullable=false)
    @Enumerated(EnumType.STRING)
    private Flooding flooding;


}
