package com.codecool.hogwartshouses.controller;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.model.types.PetType;
import com.codecool.hogwartshouses.service.RoomService;
import com.codecool.hogwartshouses.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class GreetingController {

    @Autowired
    RoomService roomService;

    @Autowired
    StudentService studentService;

    boolean firstVisit = true;

    @GetMapping("/")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="Witches and Wizards") String name, Model model) {
        model.addAttribute("name", name);

        if (firstVisit == true) {
            initializeData();
        }

        return "greeting.html";
    }

    private void initializeData() {
        Room room1 = roomService.addRoom("Dormitory 1", HouseType.GRYFFINDOR);
        Room room2 = roomService.addRoom("Dormitory 2", HouseType.GRYFFINDOR);
        roomService.addRoom("Dormitory 3", HouseType.GRYFFINDOR);
        roomService.addRoom("Dormitory 4", HouseType.GRYFFINDOR);

        Student studentHarry = studentService.addStudent("Harry Potter", HouseType.GRYFFINDOR, PetType.OWL);
        Student studentRon = studentService.addStudent("Ron Weasley", HouseType.GRYFFINDOR, PetType.RAT);
        Student studentHermione = studentService.addStudent("Hermione Granger", HouseType.GRYFFINDOR, PetType.CAT);

        room1.addStudent(studentHarry);
        room1.addStudent(studentRon);
        room2.addStudent(studentHermione);

        firstVisit = false;
    }

}
