package ru.asgubin.diploma.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity                     //Указывает, что данный бин (класс) является сущностью
@Table(name = "fer")        //Имя сущности
public class FER implements Serializable {

    @Id
    @Column(name = "id", length = 50)    //Имя атрибута
    private String id;

    @Column(name = "name", length = 500) //Имя атрибута
    private String name;

    @Column(name = "coast")              //Имя атрибута
    private Double coast;

    protected FER() {}

    public FER(String id, String name, Double coast) {
        this.id = id;
        this.name = name;
        this.coast = coast;
    }

    @Override
    public String toString() {
        return "fer{" +
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

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoast(Double coast) {
        this.coast = coast;
    }
}