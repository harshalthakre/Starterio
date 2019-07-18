package com.project.starterio_version_1.controllers;

import com.project.starterio_version_1.model.Faculty;
import com.project.starterio_version_1.model.Student;
import com.project.starterio_version_1.model.User;
import com.project.starterio_version_1.services.FacultyServices;
import com.project.starterio_version_1.services.StudentServices;
import com.project.starterio_version_1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SignupController {

    @Autowired
    private UserService userService;

    @Autowired
    private StudentServices studentServices;

    @Autowired
    private FacultyServices facultyServices;

    @RequestMapping(method = RequestMethod.POST,value = "/signup")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/signup/student")
    public ResponseEntity<Void> addStudent(@RequestBody Student student){
        return studentServices.addStudent(student);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/signup/faculty")
    public ResponseEntity<Void> addFaculty(@RequestBody Faculty faculty){
        return facultyServices.addFaculty(faculty);
    }
}
