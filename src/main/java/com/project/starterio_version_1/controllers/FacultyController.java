package com.project.starterio_version_1.controllers;

import com.project.starterio_version_1.model.Department;
import com.project.starterio_version_1.model.Faculty;
import com.project.starterio_version_1.services.FacultyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FacultyController {

    @Autowired
    private FacultyServices facultyServices;

    @RequestMapping(method = RequestMethod.GET,value = "/faculty")
    public ResponseEntity<List<Faculty>> getFaculty(){
        return facultyServices.getFaculty();
    }

    @RequestMapping(method = RequestMethod.GET,value = "/faculty/{facultyId}")
    public ResponseEntity<Faculty> getFaculty(@PathVariable int facultyId){
        return facultyServices.getFaculty(facultyId);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/faculty/{facultyId}/department")
    public ResponseEntity<Department> getDepartment(@PathVariable int facultyId){
        return facultyServices.getDepartment(facultyId);
    }
}
