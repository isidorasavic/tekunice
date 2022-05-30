package com.sbnz.tekunicebackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sbnz.tekunicebackend.model.enums.Elevation;
import com.sbnz.tekunicebackend.model.enums.Exposition;
import com.sbnz.tekunicebackend.model.enums.Flooding;
import com.sbnz.tekunicebackend.model.enums.MJT;
import com.sbnz.tekunicebackend.model.enums.Slope;
import com.sbnz.tekunicebackend.model.enums.Type;

@Entity
@Table(name="natural_factor")
public class NaturalFactor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    
    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "elevation", nullable = false)
    @Enumerated(EnumType.STRING)
    private Elevation elevation;

    @Column(name = "mjt", nullable = false)
    @Enumerated(EnumType.STRING)
    private MJT mjt;

    @Column(name = "exposition", nullable = false)
    @Enumerated(EnumType.STRING)
    private Exposition exposition;

    @Column(name = "slope", nullable = false)
    @Enumerated(EnumType.STRING)
    private Slope slope;

    @Column(name = "flooding", nullable = false)
    @Enumerated(EnumType.STRING)
    private Flooding flooding;

    @JoinColumn(name = "habitat_id")
    @ManyToOne
    private Habitat habitat;


    public NaturalFactor() {
    }


    public NaturalFactor(Type type, Elevation elevation, MJT mjt, Exposition exposition, Slope slope, Flooding flooding) {
        this.type = type;
        this.elevation = elevation;
        this.mjt = mjt;
        this.exposition = exposition;
        this.slope = slope;
        this.flooding = flooding;
    }
    

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Elevation getElevation() {
        return elevation;
    }

    public void setElevation(Elevation elevation) {
        this.elevation = elevation;
    }

    public MJT getMjt() {
        return mjt;
    }

    public void setMjt(MJT mjt) {
        this.mjt = mjt;
    }

    public Exposition getExposition() {
        return exposition;
    }

    public void setExposition(Exposition exposition) {
        this.exposition = exposition;
    }

    public Slope getSlope() {
        return slope;
    }

    public void setSlope(Slope slope) {
        this.slope = slope;
    }

    public long getId() {
        return id;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }

    public Flooding getFlooding() {
        return this.flooding;
    }

    public void setFlooding(Flooding flooding) {
        this.flooding = flooding;
    }

    

    
}
