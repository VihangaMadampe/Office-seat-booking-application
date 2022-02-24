package com.alm.onlinereservation.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "floor")
public class Floor {

    @OneToMany( fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "floor_id")
    private List<Table> allTables;

    public Floor() {
        System.out.println("Creating a Floor");
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public List<Table> getTables() {
        return allTables;
    }

    public void setTables(List<Table> tables) {
        allTables = tables;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

