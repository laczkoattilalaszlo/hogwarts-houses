package com.codecool.hogwartshouses.service.DAO;

import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.model.types.PetType;

import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class StudentMemory implements StudentDAO {

    private Set<Student> students;

    public StudentMemory() {
        students = new HashSet<>();
    }

    @Override
    public Set<Student> getStudents() {
        return students;
    }

    @Override
    public void addStudent(String name, HouseType houseType, PetType petType) {
        students.add(new Student(name, houseType, petType));
    }

}
