package com.sbnz.tekunicebackend.model;

import com.sbnz.tekunicebackend.model.enums.Type;

import javax.persistence.*;

@Entity
@Table(name="natural_factor_options")
public class NaturalFactorOptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @Column(name="type", nullable=false)
    private Type type;

    @Column(name="exposition_options", nullable=false)
    private String expositionOptions;

    @Column(name="mjt_options", nullable=false)
    private String mjtOptions;

    @Column(name="elevation_options", nullable=false)
    private String elevationOptions;

    @Column(name="slope_options", nullable=false)
    private String slopeOptions;


    public void addExpositionOptions(String option){
        this.expositionOptions = this.expositionOptions+","+option;
    }

    public void addMjtOptions(String option){
        this.mjtOptions = this.mjtOptions+","+option;
    }

    public void addElevationOptions(String option){
        this.elevationOptions = this.elevationOptions+","+option;
    }

    public void addSlopeOptions(String option){
        this.slopeOptions = this.slopeOptions+","+option;
    }

    public boolean containsElevationOption(String option) {
        if(this.elevationOptions.contains(option)) return true;
        return false;
    }

    public NaturalFactorOptions(long id, Type typeOptions, String expositionOptions, String mjtOptions, String elevationOptions, String slopeOptions) {
        this.id = id;
        this.type = typeOptions;
        this.expositionOptions = expositionOptions;
        this.mjtOptions = mjtOptions;
        this.elevationOptions = elevationOptions;
        this.slopeOptions = slopeOptions;
    }

    public NaturalFactorOptions() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Type getTypeOptions() {
        return type;
    }

    public void setTypeOptions(Type typeOptions) {
        this.type = typeOptions;
    }

    public String getExpositionOptions() {
        return expositionOptions;
    }

    public void setExpositionOptions(String expositionOptions) {
        this.expositionOptions = expositionOptions;
    }

    public String getMjtOptions() {
        return mjtOptions;
    }

    public void setMjtOptions(String mjtOptions) {
        this.mjtOptions = mjtOptions;
    }

    public String getElevationOptions() {
        return elevationOptions;
    }

    public void setElevationOptions(String elevationOptions) {
        this.elevationOptions = elevationOptions;
    }

    public String getSlopeOptions() {
        return slopeOptions;
    }

    public void setSlopeOptions(String slopeOptions) {
        this.slopeOptions = slopeOptions;
    }
}
