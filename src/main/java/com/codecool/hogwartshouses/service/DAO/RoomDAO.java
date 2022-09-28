package com.codecool.hogwartshouses.service.DAO;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.Student;

import java.util.Set;
import java.util.UUID;

public interface RoomDAO {

    Set<Room> getRooms();

    Room getRoomById(UUID id);

    Set<Room> getAvailableRooms();

    Set<Room> getCatAndOwlFreeRooms();

    Room addRoom(Room room);

    void addStudentToRoom(Room room, Student student);

    void deleteRoomById(UUID id);

    void updateRoomById(UUID id, Room room);

}