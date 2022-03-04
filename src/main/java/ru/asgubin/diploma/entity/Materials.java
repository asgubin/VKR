package ru.asgubin.diploma.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity                      //Указывает, что данный бин (класс) является сущностью
@Table(name = "materials")   //Имя сущности
public class Materials implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")    //Имя атрибута
    private Long id;

    @Column(name = "designation", length = 50)  //Имя атрибута
    private String designation;

    @Column(name = "name", length = 50)  //Имя атрибута
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)   //указывает на связь между таблицами «один к одному»
    @JoinColumn(name = "category_id")   //применяется когда внешний ключ находится в одной из сущностей
    private Category category_id;

    protected Materials() {}

    @Override
    public String toString() {
        return "Materials{" +
                "id=" + id +
                ", designation='" + designation + '\'' +
                ", name='" + name + '\'' +
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

    public Category getCategory_id() {
        return category_id;
    }
}