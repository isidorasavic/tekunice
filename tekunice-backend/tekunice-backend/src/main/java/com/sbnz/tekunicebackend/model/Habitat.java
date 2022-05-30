package com.sbnz.tekunicebackend.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sbnz.tekunicebackend.model.enums.Label;

@Entity
@Table(name="habitat")
public class Habitat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name="label", nullable=false)
    private Label label;

    @JoinColumn(name = "natural_factor_id", referencedColumnName = "id")
    @OneToOne
    private NaturalFactor naturalFactors;

    @OneToMany(mappedBy = "habitat", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<AntropologicalFactor> antropologicalFactors;


    public Habitat() {
    }


    public Habitat(Label label, NaturalFactor naturalFactors, List<AntropologicalFactor> antropologicalFactors) {
        this.label = label;
        this.naturalFactors = naturalFactors;
        this.antropologicalFactors = antropologicalFactors;
    }


    public long getId() {
        return id;
    }


    public Label getLabel() {
        return label;
    }


    public void setLabel(Label label) {
        this.label = label;
    }


    public NaturalFactor getNaturalFactors() {
        return naturalFactors;
    }


    public void setNaturalFactors(NaturalFactor naturalFactors) {
        this.naturalFactors = naturalFactors;
    }


    public List<AntropologicalFactor> getAntropologicalFactors() {
        return antropologicalFactors;
    }


    public void setAntropologicalFactors(List<AntropologicalFactor> antropologicalFactors) {
        this.antropologicalFactors = antropologicalFactors;
    }

    public void addAntropologicalFactor(AntropologicalFactor factor) {
        this.antropologicalFactors.add(factor);
    }


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }
    
}
