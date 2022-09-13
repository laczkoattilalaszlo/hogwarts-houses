package com.codecool.hogwartshouses.controller;

import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.model.types.PetType;
import com.codecool.hogwartshouses.service.StudentService;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Set;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping()
    public String getStudents(Model model) {
        model.addAttribute("students", studentService.getStudents());
        return "students";
    }

    @GetMapping("/get-all-students")
    public @ResponseBody Set<Student> getStudentsAPI() {
        return studentService.getStudents();
    }

    @PostMapping()
    public String addStudent(@RequestParam String name, @RequestParam String house, @RequestParam String pet, Model model) {
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

        PetType petType = null;
        switch (pet) {
            case "CAT":
                petType = PetType.CAT;
                break;
            case "RAT":
                petType = PetType.RAT;
                break;
            case "OWL":
                petType = PetType.OWL;
                break;
            case "NONE":
                petType = PetType.NONE;
                break;
        }

        studentService.addStudent(name, houseType, petType);

        model.addAttribute("students", studentService.getStudents());
        return "students";
    }

}

// Consultation:
// - getStudents() es getStudentsAPI kozott csak az akulonbseg, hogy az egyik renderel a masikmeg objektumot tovabbit. Ha ilyenre van szukseg ez mindig kulon van?
