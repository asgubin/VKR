package ru.asgubin.diploma.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity                     //Указывает, что данный бин (класс) является сущностью
@Table(name = "category")   //Имя сущности
public class Category implements Serializable {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")    //Имя атрибута
    private Long id;

    @Column(name = "name", length = 50)  //Имя атрибута
    private String name;

    protected  Category() {}

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}