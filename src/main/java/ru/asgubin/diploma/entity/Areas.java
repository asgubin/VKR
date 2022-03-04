package ru.asgubin.diploma.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity                     //Указывает, что данный бин (класс) является сущностью
@Table(name = "areas")   //Имя сущности
public class Areas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")    //Имя атрибута
    private Long id;

    @Column(name = "name", length = 50)  //Имя атрибута
    private String name;

    @Column(name = "area")  //Имя атрибута
    private Double area;

    @Column(name = "perimeter")  //Имя атрибута
    private Double perimeter;

    @Column(name = "floor")  //Имя атрибута
    private Integer floor;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)   //указывает на связь между таблицами «один к одному»
    @JoinColumn(name = "level_id")   //применяется когда внешний ключ находится в одной из сущностей
    private Levels level_id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)   //указывает на связь между таблицами «один к одному»
    @JoinColumn(name = "category_id")   //применяется когда внешний ключ находится в одной из сущностей
    private Category category_id;

    protected Areas() {}

    @Override
    public String toString() {
        return "Areas{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", area=" + area +
                ", perimeter=" + perimeter +
                ", floor=" + floor +
                ", level_id=" + level_id.getId() +
                ", category_id=" + category_id.getId() +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getArea() {
        return area;
    }

    public Double getPerimeter() {
        return perimeter;
    }

    public Integer getFloor() {
        return floor;
    }

    public Levels getLevel_id() {
        return level_id;
    }

    public Category getCategory_id() {
        return category_id;
    }
}