package com.project.starterio_version_1.services;

import com.project.starterio_version_1.model.CurricularDepartment;
import com.project.starterio_version_1.repository.CurricularDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurricularDepartmentServices {

    @Autowired
    private CurricularDepartmentRepository curricularDepartmentRepository;

    public ResponseEntity<Void> addCurricularDepartment(CurricularDepartment curricularDepartment){
        try {
            if(!curricularDepartmentRepository.existsById(curricularDepartment.getId())){
                curricularDepartmentRepository.save(curricularDepartment);
                return new ResponseEntity<Void>(HttpStatus.OK);
            }else {
                return  new ResponseEntity<Void>(HttpStatus.ALREADY_REPORTED);
            }
        }catch (Exception e){
            return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);
        }
    }

    public ResponseEntity<CurricularDepartment> getCurricularDepartment(int curricularDepartmentId){
        try {
            CurricularDepartment curricularDepartment=curricularDepartmentRepository.findById(curricularDepartmentId);
            if(curricularDepartment==null){return new ResponseEntity<CurricularDepartment>(HttpStatus.NOT_FOUND);}
            else {return new ResponseEntity<CurricularDepartment>(curricularDepartment,HttpStatus.OK);}
        }catch (Exception e){
          return new ResponseEntity<CurricularDepartment>(HttpStatus.FORBIDDEN);
        }
    }

    public ResponseEntity<List<CurricularDepartment>> getCurricularDepartment(){
        try {
            return new ResponseEntity<List<CurricularDepartment>>(curricularDepartmentRepository.findAll(),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<List<CurricularDepartment>>(HttpStatus.FORBIDDEN);
        }
    }
}
