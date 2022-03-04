package ru.asgubin.diploma.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity                     //Указывает, что данный бин (класс) является сущностью
@Table(name = "levels")   //Имя сущности
public class Levels implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")    //Имя атрибута
    private Long id;

    @Column(name = "name", length = 50)  //Имя атрибута
    private String name;

    @Column(name = "elevation")  //Имя атрибута
    private Double elevation;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)   //указывает на связь между таблицами «один к одному»
    @JoinColumn(name = "category_id")   //применяется когда внешний ключ находится в одной из сущностей
    private Category category_id;

    protected Levels() {}

    @Override
    public String toString() {
        return "Levels{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", elevation=" + elevation +
                ", category_id=" + category_id.getId() +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getElevation() {
        return elevation;
    }

    public Category getCategory_id() {
        return category_id;
    }
}