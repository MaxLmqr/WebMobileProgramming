package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;

import java.util.List;

public interface BuildingDaoCustom {
    List<Window> findAllBuildingWindows(Long id);
    List<Room> findAllBuildingRooms(Long id);
}
