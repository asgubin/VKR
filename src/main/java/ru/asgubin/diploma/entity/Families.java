package ru.asgubin.diploma.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity                     //Указывает, что данный бин (класс) является сущностью
@Table(name = "families")   //Имя сущности
public class Families implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")    //Имя атрибута
    private Long id;

    @Column(name = "designation", length = 50)  //Имя атрибута
    private String designation;

    @Column(name = "name", length = 50)  //Имя атрибута
    private String name;

    @Column(name = "weight")  //Имя атрибута
    private Double weight;

    @Column(name = "section_area")  //Имя атрибута
    private Double section_area;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)   //указывает на связь между таблицами «один к одному»
    @JoinColumn(name = "category_id")   //применяется когда внешний ключ находится в одной из сущностей
    private Category category_id;

    protected Families() {}

    @Override
    public String toString() {
        return "Families{" +
                "id=" + id +
                ", designation='" + designation + '\'' +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", section_area=" + section_area +
                ", category_id=" + category_id.getId() +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getDesignation() {
        return designation;
    }

    public String getName() {
        return name;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getSection_area() {
        return section_area;
    }

    public Category getCategory_id() {
        return category_id;
    }
}