package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.BuildingDao;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController // (1)
@RequestMapping("/api/buildings") // (2)
@Transactional // (3)
public class BuildingController {
    private final BuildingDao buildingDao;

    public BuildingController(BuildingDao buildingDao) {
        this.buildingDao = buildingDao;
    }

    @GetMapping
    public List<BuildingDto> findAll() { return buildingDao.findAll().stream().map(BuildingDto::new).collect(Collectors.toList()); }

    @GetMapping(path = "/{id}/windows")
    public List<RoomDto> findAllRooms(@PathVariable Long id) { return buildingDao.findAllBuildingRooms(id).stream().map(RoomDto::new).collect(Collectors.toList()); }
}
