package com.codecool.hogwartshouses.controller;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.service.RoomService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.UUID;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    RoomService roomService;

    @GetMapping()
    public String getRooms(Model model) {
        model.addAttribute("rooms", roomService.getRooms());
        return "rooms";
    }

    @GetMapping("/{roomId}")
    public String getRoomById(@PathVariable String roomId, Model model) {
        UUID roomUuid = UUID.fromString(roomId);
        model.addAttribute("room", roomService.getRoomById(roomUuid));
        return "room";
    }

    @GetMapping("/available")
    public @ResponseBody Set<Room> getAvailableRoomsAPI(Model model) {
        Set<Room> availableRooms = roomService.getAvailableRooms();
        return availableRooms;
    }

    @GetMapping("/rat-owners")
    public @ResponseBody Set<Room> getCatAndOwlFreeRooms(Model model) {
        Set<Room> availableRooms = roomService.getCatAndOwlFreeRooms();
        return availableRooms;
    }

    @PostMapping()
    public String addRoom(@RequestParam String name, @RequestParam String house, Model model) {
        HouseType houseType = null;
        switch (house) {
            case "GRYFFINDOR":
                houseType = HouseType.GRYFFINDOR;
                break;
            case "HUFFLEPUFF":
                houseType = HouseType.HUFFLEPUFF;
                break;
            case "RAVENCLAW":
                houseType = HouseType.RAVENCLAW;
                break;
            case "SLYTHERIN":
                houseType = HouseType.SLYTHERIN;
                break;
        }

        roomService.addRoom(name, houseType);

        model.addAttribute("rooms", roomService.getRooms());
        return "rooms";
    }

    @PostMapping("/room/add-student")
    public String addStudentToRoom(@RequestParam String roomId, @RequestParam String studentId, Model model) {
        roomService.addStudentToRoom(UUID.fromString(roomId), UUID.fromString(studentId));
        model.addAttribute("room", roomService.getRoomById(UUID.fromString(roomId)));
        return "room";
    }

    @PutMapping("/{roomId}")
    public @ResponseBody Room updateRoomById(@PathVariable String roomId, @RequestBody Room room) {
        roomService.updateRoomById(UUID.fromString(roomId), room);
        return roomService.getRoomById(room.getUuid());
    }

    @DeleteMapping("/{roomId}")
    public @ResponseBody ResponseEntity<String> deleteRoomById(@PathVariable String roomId) {
        UUID roomUuid = UUID.fromString(roomId);
        roomService.deleteRoomById(roomUuid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
