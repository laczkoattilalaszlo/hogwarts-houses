package com.codecool.hogwartshouses.service.DAO;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.model.types.PetType;

import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Repository
public class RoomMemory implements RoomDAO {

    private Set<Room> rooms;

    public RoomMemory() {
        rooms = new HashSet<>();
    }

    @Override
    public Set<Room> getRooms() {
        return rooms;
    }

    @Override
    public Room getRoomById(UUID id) {
        for(Room room : rooms){
            if (room.getUuid().equals(id)) {
                return room;
            }
        }
        return null;
    }

    @Override
    public Set<Room> getAvailableRooms() {
        Set<Room> availableRooms = new HashSet<>();
        for (Room room : rooms) {
            if (room.getStudents().size() < room.getCapacity()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    @Override
    public Set<Room> getCatAndOwlFreeRooms() {
        Set<Room> catAndOwlFreeRooms = new HashSet<>();
        for (Room room : rooms) {
            Set<Student> students = room.getStudents();
            if (students.size() == 0) {
                catAndOwlFreeRooms.add(room);
            } else {
                int checkedStudentQuantity = 0;
                for (Student student : students) {
                    checkedStudentQuantity++;
                    if (student.getPetType().equals(PetType.CAT) || student.getPetType().equals(PetType.OWL)) {
                        break;
                    }
                    if (checkedStudentQuantity == students.size()) {
                        catAndOwlFreeRooms.add(room);
                    }
                }
            }
        }
        return catAndOwlFreeRooms;
    }

    @Override
    public Room addRoom(Room room) {
        rooms.add(room);
        return room;
    }

    @Override
    public void addStudentToRoom(Room room, Student student) {
        room.addStudent(student);
    }

    @Override
    public void deleteRoomById(UUID id) {
        Room roomToDelete = null;
        for(Room room : rooms) {
            if (room.getUuid().equals(id)) {
                roomToDelete = room;
            }
        }
        rooms.remove(roomToDelete);
    }

    @Override
    public void updateRoomById(UUID id, Room room) {
        for(Room roomInRooms : rooms) {
            if (roomInRooms.getUuid().equals(id)) {
                roomInRooms.setName(room.getName());
                roomInRooms.setHouseType(room.getHouseType());
            }
        }
    }

}
