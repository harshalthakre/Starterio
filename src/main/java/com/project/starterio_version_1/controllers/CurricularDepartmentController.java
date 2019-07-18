package com.project.starterio_version_1.controllers;

import com.project.starterio_version_1.model.CurricularDepartment;
import com.project.starterio_version_1.services.CurricularDepartmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CurricularDepartmentController {

    @Autowired
    private CurricularDepartmentServices curricualrDepartmentServices;

    @RequestMapping(method = RequestMethod.POST,value = "/curricular")
    public ResponseEntity<Void> addCurricularDepartment(@RequestBody CurricularDepartment curricularDepartment){
        return curricualrDepartmentServices.addCurricularDepartment(curricularDepartment);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/curricular")
    public ResponseEntity<List<CurricularDepartment>> getCurricularDepartment(){
        return curricualrDepartmentServices.getCurricularDepartment();
    }

    @RequestMapping(method = RequestMethod.GET,value = "/curricular/{curricularId}")
    public ResponseEntity<CurricularDepartment> getCurricularDepartment(@PathVariable int curricularId){
        return curricualrDepartmentServices.getCurricularDepartment(curricularId);
    }
}
