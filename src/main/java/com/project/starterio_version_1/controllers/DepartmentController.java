package com.project.starterio_version_1.controllers;

import com.project.starterio_version_1.model.Department;
import com.project.starterio_version_1.services.DepartmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    @Autowired
    private DepartmentServices departmentServices;

    @RequestMapping(method = RequestMethod.POST,value = "/department")
    public ResponseEntity<Void> addDepartment(@RequestBody Department department){
        return departmentServices.addDepartment(department);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/department/{departmentId}")
    public ResponseEntity<Department> getDepartment(@PathVariable int departmentId){
        return departmentServices.getDepartment(departmentId);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/department")
    public ResponseEntity<List<Department>> getDepartment(){
        return departmentServices.getAllDepartment();
    }
}
