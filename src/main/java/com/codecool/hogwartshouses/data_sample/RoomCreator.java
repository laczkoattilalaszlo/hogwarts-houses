package com.codecool.hogwartshouses.data_sample;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.service.DAO.RoomMemory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomCreator {

    @Autowired
    RoomMemory roomMemory;

    public RoomCreator() {
//        initialize();
    }

//    public void initialize() {
//        roomMemory.addRoom(new Room("Room 1", HouseType.GRYFFINDOR));
//        roomMemory.addRoom(new Room("Room 2", HouseType.GRYFFINDOR));
//        roomMemory.addRoom(new Room("Room 3", HouseType.GRYFFINDOR));
//
//        roomMemory.addRoom(new Room("Room 1", HouseType.HUFFLEPUFF));
//        roomMemory.addRoom(new Room("Room 2", HouseType.HUFFLEPUFF));
//        roomMemory.addRoom(new Room("Room 3", HouseType.HUFFLEPUFF));
//    }

}

// Consultation:
// - Sehogy sem sikerult osszehozni rendesen az initialize() fuggvenyt a constructorban.
// - Consider what Java data structure is best suited to represent these values (definitely not List or Map).
