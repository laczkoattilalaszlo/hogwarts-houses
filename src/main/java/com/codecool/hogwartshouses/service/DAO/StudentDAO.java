package com.codecool.hogwartshouses.service.DAO;

import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.model.types.PetType;

import java.util.Set;

public interface StudentDAO {

    Set<Student> getStudents();

    Student addStudent(String name, HouseType houseType, PetType petType);

}
