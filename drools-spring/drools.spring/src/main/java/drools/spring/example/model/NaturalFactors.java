package drools.spring.example.model;

import drools.spring.example.dto.NaturalFactorsDTO;
import drools.spring.example.model.enums.*;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "natural_factors")
public class NaturalFactors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="type", nullable=false)
    @Enumerated(EnumType.STRING)
    private Type type;

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

    public NaturalFactors(NaturalFactorsDTO naturalFactorsDTO) {
        this.type = Type.valueOf(naturalFactorsDTO.getType());
        this.elevation = Elevation.valueOf(naturalFactorsDTO.getElevation());
        this.mjt = MJT.valueOf(naturalFactorsDTO.getMjt());
        this.exposition = Exposition.valueOf(naturalFactorsDTO.getExposition());
        this.slope = Slope.valueOf(naturalFactorsDTO.getSlope());
        this.flooding = Flooding.valueOf(naturalFactorsDTO.getFlooding());
    }

    public NaturalFactors() {
    }

    public NaturalFactors(long id, Type type, Elevation elevation, MJT mjt, Exposition exposition, Slope slope, Flooding flooding) {
        this.id = id;
        this.type = type;
        this.elevation = elevation;
        this.mjt = mjt;
        this.exposition = exposition;
        this.slope = slope;
        this.flooding = flooding;
    }
}
