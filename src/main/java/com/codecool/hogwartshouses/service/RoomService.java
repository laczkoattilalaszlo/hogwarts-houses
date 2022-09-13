package com.codecool.hogwartshouses.service;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.service.DAO.RoomDAO;
import com.codecool.hogwartshouses.service.DAO.StudentDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class RoomService {

    @Autowired
    private RoomDAO roomDAO;

    @Autowired
    private StudentDAO studentDAO;

    public Set<Room> getRooms() {
        return roomDAO.getRooms();
    }

    public Room getRoomById(UUID id) {
        return roomDAO.getRoomById(id);
    }

    public Set<Room> getAvailableRooms() {
        return roomDAO.getAvailableRooms();
    }

    public Set<Room> getCatAndOwlFreeRooms() {
        return roomDAO.getCatAndOwlFreeRooms();
    }

    public void addRoom(String name, HouseType houseType) {
        roomDAO.addRoom(new Room(name, houseType));
    }

    public void addStudentToRoom(UUID roomId, UUID studentId) {
        Set<Student> students = studentDAO.getStudents();
        Student searchedStudent = null;
        for (Student student : students) {
            if (student.getUuid().equals(studentId)) {
                searchedStudent = student;
                break;
            }
            continue;
        }

        Set<Room> rooms = roomDAO.getRooms();
        Room searchedRoom = null;
        for (Room room : rooms) {
            if (room.getUuid().equals(roomId)) {
                searchedRoom = room;
                break;
            }
            continue;
        }

        roomDAO.addStudentToRoom(searchedRoom, searchedStudent);
    }

    public void deleteRoomById(UUID id) {
        roomDAO.deleteRoomById(id);
    }

    public void updateRoomById(UUID id, Room room) {
        roomDAO.updateRoomById(id, room);
    }

}
