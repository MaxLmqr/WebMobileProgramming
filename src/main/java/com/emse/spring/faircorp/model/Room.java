package com.emse.spring.faircorp.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ROOM")
public class Room {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)// (4)
    private Integer floor;

    @Column(nullable = false)
    private String name;

    @Column
    private Double current_temperature;

    @Column
    private Double target_temperature;

    @OneToMany(mappedBy = "room")
    private List<Heater> heaters;

    @OneToMany(mappedBy = "room")
    private List<Window> windows;

    public Room() {
    }

    public Room(int floor, String name, Double current_temperature, Double target_temperature, List<Heater> heaters, List<Window> windows) {
        this.floor = floor;
        this.name = name;
        this.current_temperature = current_temperature;
        this.target_temperature = target_temperature;
        this.heaters = heaters;
        this.windows = windows;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCurrent_temperature() {
        return current_temperature;
    }

    public void setCurrent_temperature(Double current_temperature) {
        this.current_temperature = current_temperature;
    }

    public Double getTarget_temperature() {
        return target_temperature;
    }

    public void setTarget_temperature(Double target_temperature) {
        this.target_temperature = target_temperature;
    }
}
