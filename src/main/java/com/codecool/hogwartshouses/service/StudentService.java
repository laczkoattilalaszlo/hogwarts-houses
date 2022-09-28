package com.codecool.hogwartshouses.service;

import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.model.types.PetType;
import com.codecool.hogwartshouses.service.DAO.StudentDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class StudentService {

    @Autowired
    private StudentDAO studentDAO;

    public Set<Student> getStudents() {
        return studentDAO.getStudents();
    }

    public Student addStudent(String name, HouseType houseType, PetType petType) {
        return studentDAO.addStudent(name, houseType, petType);
    }

}
