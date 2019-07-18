package com.project.starterio_version_1.services;

import com.project.starterio_version_1.model.Department;
import com.project.starterio_version_1.model.Notice;
import com.project.starterio_version_1.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServices {

    @Autowired
    private DepartmentRepository departmentRepository;

    public ResponseEntity<Void> addDepartment(Department department){
        try {
            if(!departmentRepository.existsById(department.getDepartmentId())){
                departmentRepository.save(department);
                return new ResponseEntity<Void>(HttpStatus.OK);
            }
            else { return new ResponseEntity<Void>(HttpStatus.ALREADY_REPORTED);}
        }catch (Exception e){
            return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);
        }
    }

    public ResponseEntity<List<Department>> getAllDepartment(){
        try{
            return new ResponseEntity<List<Department>>(departmentRepository.findAll(),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<List<Department>>(HttpStatus.FORBIDDEN);
        }
    }

    public ResponseEntity<Department> getDepartment(int departmentId){
        try{
            Department department=departmentRepository.findByDepartmentId(departmentId);
            if(department==null){ return new ResponseEntity<Department>(HttpStatus.NOT_FOUND);}
            else return new ResponseEntity<Department>(department,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Department>(HttpStatus.FORBIDDEN);
        }
    }

    public ResponseEntity<Department> getDepartment(String departmentName){
        try{
            Department department=departmentRepository.findByName(departmentName);
            if(department==null){return new ResponseEntity<Department>(HttpStatus.NOT_FOUND);}
            else return new ResponseEntity<Department>(department,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Department>(HttpStatus.FORBIDDEN);
        }
    }

    public ResponseEntity<Void> addNotice(Notice notice,int departmentId){
        try {
            Department department=departmentRepository.findByDepartmentId(departmentId);
            if(department==null){System.out.println("in dept not found");return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);}
            else {
               // department.getNoticeSet().add(notice);
                departmentRepository.save(department);
                System.out.println("in ok dep");
                return new ResponseEntity<Void>(HttpStatus.OK);}
        }catch (Exception e){
            System.out.println("in excep dep");
            return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);
        }
    }

}
