package com.emse.spring.faircorp.api;


import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.model.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController // (1)
@RequestMapping("/api/rooms") // (2)
@Transactional // (3)
public class RoomController {

    private final RoomDao roomDao;
    private final HeaterDao heaterDao;
    private final WindowDao windowDao;

    public RoomController(RoomDao roomDao, HeaterDao heaterDao, WindowDao windowDao) {
        this.roomDao = roomDao;
        this.heaterDao = heaterDao;
        this.windowDao = windowDao;
    }

    @GetMapping
    public List<RoomDto> findAll() {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());
    }

    @PostMapping
    public RoomDto create(@RequestBody RoomDto dto) {
        Room room = null;
        if (dto.getId()==null) {
            room = new Room(dto.getFloor(),dto.getName(),dto.getCurrent_temperature(),dto.getTarget_temperature());
            roomDao.save(room);
        }
        else {
            room = roomDao.getOne(dto.getId());
        }
        return new RoomDto(room);
    }

    @GetMapping(path = "/{id}")
    public RoomDto findById(@PathVariable Long id) {
        return roomDao.findById(id).map(RoomDto::new).orElse(null);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        heaterDao.deleteHeaterInARoom(id);
        windowDao.deleteWindowInARoom(id);
        roomDao.deleteById(id);
    }

    @GetMapping(path="/{id}/switchWindows")
    public void switchWindowsStatus(@PathVariable Long id) {
        List<Window> windows = windowDao.findWindowsInARoom(id);
        windows.stream().forEach(window -> window.setWindowStatus(window.getWindowStatus() == WindowStatus.OPEN ? WindowStatus.CLOSED: WindowStatus.OPEN));
    }

    @GetMapping(path="/{id}/switchHeaters")
    public void switchHeatersStatus(@PathVariable Long id) {
        List<Heater> heaters = heaterDao.findHeatersInARoom(id);
        heaters.stream().forEach(heater -> heater.setHeaterStatus(heater.getHeaterStatus() == HeaterStatus.ON ? HeaterStatus.OFF: HeaterStatus.ON));
    }

}
