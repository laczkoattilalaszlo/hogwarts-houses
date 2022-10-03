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
    public String greeting(Model model) {
        if (firstVisit == true) {
            initializeData();
        }
        return "greeting.html";
    }

    private void initializeData() {
        Room room1 = roomService.addRoom("Dormitory 1", HouseType.GRYFFINDOR);
        Room room2 = roomService.addRoom("Dormitory 2", HouseType.GRYFFINDOR);
        roomService.addRoom("Dormitory 3", HouseType.HUFFLEPUFF);
        roomService.addRoom("Dormitory 4", HouseType.RAVENCLAW);

        Student studentHarry = studentService.addStudent("Harry Potter", HouseType.GRYFFINDOR, PetType.OWL);
        Student studentRon = studentService.addStudent("Ron Weasley", HouseType.GRYFFINDOR, PetType.RAT);
        Student studentHermione = studentService.addStudent("Hermione Granger", HouseType.GRYFFINDOR, PetType.CAT);

        room1.addStudent(studentHarry);
        room1.addStudent(studentRon);
        room2.addStudent(studentHermione);

        studentService.addStudent("Draco Malfoy", HouseType.SLYTHERIN, PetType.FERRET);
        studentService.addStudent("Neville Longbottom", HouseType.GRYFFINDOR, PetType.FROG);
        studentService.addStudent("Su Li", HouseType.RAVENCLAW, PetType.RAT);
        studentService.addStudent("Susan Bones", HouseType.HUFFLEPUFF, PetType.FROG);
        studentService.addStudent("Blaise Zabin", HouseType.SLYTHERIN, PetType.RAT);
        studentService.addStudent("Theodore Nott", HouseType.SLYTHERIN, PetType.OWL);
        studentService.addStudent("Padama Patil", HouseType.RAVENCLAW, PetType.RAT);
        studentService.addStudent("Terry Boot", HouseType.RAVENCLAW, PetType.CAT);
        studentService.addStudent("Hanah Abbot", HouseType.HUFFLEPUFF, PetType.FROG);

        firstVisit = false;
    }

}
