package ru.asgubin.diploma.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity                     //Указывает, что данный бин (класс) является сущностью
@Table(name = "fsscm")      //Имя сущности
public class FSSCm implements Serializable {

    @Id
    @Column(name = "id", length = 50)    //Имя атрибута
    private String id;

    @Column(name = "name", length = 500) //Имя атрибута
    private String name;

    @Column(name = "coast")              //Имя атрибута
    private Double coast;

    protected FSSCm() {}

    public FSSCm(String id, String name, Double coast) {
        this.id = id;
        this.name = name;
        this.coast = coast;
    }

    @Override
    public String toString() {
        return "FSSCm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", coast=" + coast +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getCoast() {
        return coast;
    }
}
