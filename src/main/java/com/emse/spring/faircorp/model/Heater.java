package com.emse.spring.faircorp.model;

import javax.persistence.*;

public class Heater {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)// (4)
    private String name;

    @Column
    private long power;

    @Column(nullable = false)
    @ManyToOne
    private Room room;

    public Heater() {
    }

    public Heater(String name, Room room, long power) {
        this.room = room;
        this.name = name;
        this.power = power;
    }
}
