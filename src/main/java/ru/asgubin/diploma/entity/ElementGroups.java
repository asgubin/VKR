package ru.asgubin.diploma.entity;

import javax.persistence.Entity;

public class ElementGroups {

    private String mark;
    private Families family_id;
    private Materials material_id;
    private FER ferId;
    private FSSCm fsscmId;
    private Double coast;

    public ElementGroups(String mark, Families family_id, Materials material_id, FER ferId, FSSCm fsscmId, Double coast) {
        this.mark = mark;
        this.family_id = family_id;
        this.material_id = material_id;
        this.ferId = ferId;
        this.fsscmId = fsscmId;
        this.coast = coast;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Families getFamily_id() {
        return family_id;
    }

    public void setFamily_id(Families family_id) {
        this.family_id = family_id;
    }

    public Materials getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(Materials material_id) {
        this.material_id = material_id;
    }

    public FER getFerId() {
        return ferId;
    }

    public void setFerId(FER ferId) {
        this.ferId = ferId;
    }

    public FSSCm getFsscmId() {
        return fsscmId;
    }

    public void setFsscmId(FSSCm fsscmId) {
        this.fsscmId = fsscmId;
    }

    public Double getCoast() {
        return coast;
    }

    public void setCoast(Double coast) {
        this.coast = coast;
    }
}