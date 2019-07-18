package com.project.starterio_version_1.controllers;

import com.project.starterio_version_1.model.Department;
import com.project.starterio_version_1.model.Student;
import com.project.starterio_version_1.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentServices studentServices;

    @RequestMapping(method = RequestMethod.GET,value = "/student")
    public ResponseEntity<List<Student>> getStudent(){
        return studentServices.getAllStudent();
    }

    @RequestMapping(method = RequestMethod.GET,value = "/student/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable int studentId){
        return studentServices.getStudent(studentId);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/student/{studentId}/department")
    public ResponseEntity<Department> getDepartmentOfStudent(@PathVariable int studentId){
        return studentServices.getDepartment(studentId);
    }
}
