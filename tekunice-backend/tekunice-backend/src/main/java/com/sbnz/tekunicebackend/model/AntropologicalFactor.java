package com.sbnz.tekunicebackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="antropological_factor")
public class AntropologicalFactor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    //za sad sve intidzeri a boze pomozi za kasnije
    @Column(name="shrubbery", nullable=false)
    private int shrubbery;
    @Column(name="distance_to_next_population", nullable=false)
    private int distanceToNextPopulation;
    @Column(name="disturbance", nullable=false)
    private int disturbance;
    @Column(name="roads", nullable=false)
    private int roads;
    @Column(name="agriculture", nullable=false)
    private int agriculture;
    @Column(name="grazing", nullable=false)
    private int grazing;
    @Column(name="grass_removing", nullable=false)
    private int grassRemoving;
    @Column(name="predators", nullable=false)
    private int predators;
    @Column(name="protection", nullable=false)
    private int protection;
    @Column(name="purpouse", nullable=false)
    private int purpouse; // mozda obrisati
    
    @JoinColumn(name = "habitat_id")
    @ManyToOne
    private Habitat habitat;
    
    
    public AntropologicalFactor() {
    }

    public AntropologicalFactor(int shrubbery, int distanceToNextPopulation, int disturbance, int roads,
            int agriculture, int grazing, int grassRemoving, int predators, int protection, int purpouse) {
        this.shrubbery = shrubbery;
        this.distanceToNextPopulation = distanceToNextPopulation;
        this.disturbance = disturbance;
        this.roads = roads;
        this.agriculture = agriculture;
        this.grazing = grazing;
        this.grassRemoving = grassRemoving;
        this.predators = predators;
        this.protection = protection;
        this.purpouse = purpouse;
    }

    public long getId() {
        return id;
    }


    public int getShrubbery() {
        return shrubbery;
    }

    public void setShrubbery(int shrubbery) {
        this.shrubbery = shrubbery;
    }

    public int getDistanceToNextPopulation() {
        return distanceToNextPopulation;
    }

    public void setDistanceToNextPopulation(int distanceToNextPopulation) {
        this.distanceToNextPopulation = distanceToNextPopulation;
    }

    public int getDisturbance() {
        return disturbance;
    }

    public void setDisturbance(int disturbance) {
        this.disturbance = disturbance;
    }

    public int getRoads() {
        return roads;
    }

    public void setRoads(int roads) {
        this.roads = roads;
    }

    public int getAgriculture() {
        return agriculture;
    }

    public void setAgriculture(int agriculture) {
        this.agriculture = agriculture;
    }

    public int getGrazing() {
        return grazing;
    }

    public void setGrazing(int grazing) {
        this.grazing = grazing;
    }

    public int getGrassRemoving() {
        return grassRemoving;
    }

    public void setGrassRemoving(int grassRemoving) {
        this.grassRemoving = grassRemoving;
    }

    public int getPredators() {
        return predators;
    }

    public void setPredators(int predators) {
        this.predators = predators;
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    public int getPurpouse() {
        return purpouse;
    }

    public void setPurpouse(int purpouse) {
        this.purpouse = purpouse;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }

    
}
