package com.project.starterio_version_1.controllers;

import com.project.starterio_version_1.model.Department;
import com.project.starterio_version_1.model.Faculty;
import com.project.starterio_version_1.model.Notice;
import com.project.starterio_version_1.repository.DepartmentRepository;
import com.project.starterio_version_1.repository.FacultyRepository;
import com.project.starterio_version_1.services.DepartmentServices;
import com.project.starterio_version_1.services.FacultyServices;
import com.project.starterio_version_1.services.NoticeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NoticeController {

    @Autowired
    private NoticeServices  noticeServices;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentServices departmentServices;

    @Autowired
    private FacultyServices facultyServices;
    @Autowired
    private FacultyRepository facultyRepository;

    @RequestMapping(method = RequestMethod.POST,value = "/faculty/{facultyId}/department/{departmentId}/notice")
    public ResponseEntity<String> addNotice(@RequestBody Notice notice, @PathVariable int facultyId,@PathVariable int departmentId){

        ResponseEntity<Department> department=departmentServices.getDepartment(departmentId);
        ResponseEntity<Faculty> faculty=facultyServices.getFaculty(facultyId);

        if(department.getStatusCode()== HttpStatus.OK&&faculty.getStatusCode()==HttpStatus.OK){
            notice.setDepartment(department.getBody());
            notice.setUser(faculty.getBody());
            return noticeServices.addNotice(notice);
        }
        else {
            return new ResponseEntity<String>("Department or Faculty does'nt exists",HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(method = RequestMethod.GET,value = "/department/{departmentId}/notice")
    public ResponseEntity<List<Notice>> getNoticeByDepartment(@PathVariable int departmentId){
        return noticeServices.getNoticeByDepartment(departmentId);
    }
}
