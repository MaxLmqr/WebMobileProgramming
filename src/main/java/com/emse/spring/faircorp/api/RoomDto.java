package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.model.Room;

public class RoomDto {
    private Long id;
    private Integer floor;
    private String name;
    private Double current_temperature;
    private Double target_temperature;


    public RoomDto() {

    }

    public RoomDto(Room room) {
        this.id = room.getId();
        this.floor = room.getFloor();
        this.name = room.getName();
        this.current_temperature = room.getCurrent_temperature();
        this.target_temperature = room.getTarget_temperature();
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
