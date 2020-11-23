package com.emse.spring.faircorp.model;

import javax.persistence.*;
import java.util.List;

public class Room {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)// (4)
    private int floor;

    @Column(nullable = false)
    private String name;

    @Column
    private double current_temperature;

    @Column
    private double target_temperature;

    @OneToMany(mappedBy = "room")
    private List<Heater> heaters;

    @OneToMany(mappedBy = "room")
    private List<Window> windows;

    public Room() {
    }

    public Room(int floor, String name, double current_temperature, double target_temperature, List<Heater> heaters, List<Window> windows) {
        this.floor = floor;
        this.name = name;
        this.current_temperature = current_temperature;
        this.target_temperature = target_temperature;
        this.heaters = heaters;
        this.windows = windows;
    }
}
