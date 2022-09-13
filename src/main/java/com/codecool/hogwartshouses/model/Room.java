package com.codecool.hogwartshouses.model;

import com.codecool.hogwartshouses.model.types.HouseType;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Room {

    private final UUID uuid = UUID.randomUUID();
    private String name;
    private HouseType houseType;
    private Set<Student> students;
    private final int capacity = 2;

    public Room(String name, HouseType houseType) {
        this.name = name;
        this.houseType = houseType;
        students = new HashSet<>();
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HouseType getHouseType() {
        return houseType;
    }

    public void setHouseType(HouseType houseType) {
        this.houseType = houseType;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return name;
    }

}
