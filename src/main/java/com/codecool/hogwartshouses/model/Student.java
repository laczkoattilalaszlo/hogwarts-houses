package com.codecool.hogwartshouses.model;

import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.model.types.PetType;

import java.util.UUID;

public class Student {

    private final UUID uuid;
    private String name;
    private HouseType houseType;
    private PetType petType;

    public Student(String name, HouseType houseType, PetType petType) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.houseType = houseType;
        this.petType = petType;
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

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    @Override
    public String toString() {
        return name;
    }

}
