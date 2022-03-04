package ru.asgubin.diploma.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity                     //Указывает, что данный бин (класс) является сущностью
@Table(name = "elements")   //Имя сущности
public class Elements implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")    //Имя атрибута
    private Long id;

    @Column(name = "mark", length = 50)  //Имя атрибута
    private String mark;

    @Column(name = "length")
    private Long length;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)   //указывает на связь между таблицами «один к одному»
    @JoinColumn(name = "family_id")   //применяется когда внешний ключ находится в одной из сущностей
    private Families family_id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)   //указывает на связь между таблицами «один к одному»
    @JoinColumn(name = "material_id")   //применяется когда внешний ключ находится в одной из сущностей
    private Materials material_id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)   //указывает на связь между таблицами «один к одному»
    @JoinColumn(name = "level_id")   //применяется когда внешний ключ находится в одной из сущностей
    private Levels level_id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)   //указывает на связь между таблицами «один к одному»
    @JoinColumn(name = "category_id")   //применяется когда внешний ключ находится в одной из сущностей
    private Category category_id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)   //указывает на связь между таблицами «один к одному»
    @JoinColumn(name = "fer_id", nullable = true)   //применяется когда внешний ключ находится в одной из сущностей
    private FER ferId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)   //указывает на связь между таблицами «один к одному»
    @JoinColumn(name = "fsscm_id", nullable = true)   //применяется когда внешний ключ находится в одной из сущностей
    private FSSCm fsscmId;

    @Column(name = "coast", nullable = true)  //Имя атрибута
    private Double coast;

    protected Elements() {}

    @Override
    public String toString() {
        return "Elements{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", length=" + length +
                ", family_id=" + family_id.getId() +
                ", material_id=" + material_id.getId() +
                ", level_id=" + level_id.getId() +
                ", category_id=" + category_id.getId() +
                ", fer_id=" + ferId.getId() +
                ", fsscm_id=" + fsscmId.getId() +
                ", coast=" + coast +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getMark() {
        return mark;
    }

    public Long getLength() {
        return length;
    }

    public Families getFamily_id() {
        return family_id;
    }

    public Materials getMaterial_id() {
        return material_id;
    }

    public Levels getLevel_id() {
        return level_id;
    }

    public Category getCategory_id() {
        return category_id;
    }

    public FER getFerId() {
        return ferId;
    }

    public FSSCm getFsscmId() {
        return fsscmId;
    }

    public Double getCoast() {
        return coast;
    }

    public void setFamily_id(Families family_id) {
        this.family_id = family_id;
    }

    public void setFerId(FER ferId) {
        this.ferId = ferId;
    }

    public void setFsscmId(FSSCm fsscmId) {
        this.fsscmId = fsscmId;
    }

    public void setCoast(Double coast) {
        this.coast = coast;
    }
}