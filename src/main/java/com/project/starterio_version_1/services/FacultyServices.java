package com.project.starterio_version_1.services;

import com.project.starterio_version_1.model.Department;
import com.project.starterio_version_1.model.Faculty;
import com.project.starterio_version_1.model.Notice;
import com.project.starterio_version_1.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServices {

    @Autowired
    private FacultyRepository facultyRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();

    public ResponseEntity<Void> addFaculty(Faculty faculty){
        try {
            if(!facultyRepository.existsById(faculty.getId())){
                faculty.setPassword(bCryptPasswordEncoder.encode(faculty.getPassword()));
                facultyRepository.save(faculty);
                return new ResponseEntity<Void>(HttpStatus.OK);
            }
            else {return new ResponseEntity<Void>(HttpStatus.ALREADY_REPORTED);}
        }catch (Exception e){
            return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);
        }
    }

    public ResponseEntity<Faculty> getFaculty(int facultyId){
        try {
            Faculty faculty=facultyRepository.findById(facultyId);
            if (faculty==null){return new ResponseEntity<Faculty>(HttpStatus.NOT_FOUND);}
            else {return new ResponseEntity<Faculty>(faculty,HttpStatus.OK);}
        }catch (Exception e){
            return new ResponseEntity<Faculty>(HttpStatus.FORBIDDEN);
        }
    }

    public ResponseEntity<List<Faculty>> getFaculty(){
        try {
            return new ResponseEntity<List<Faculty>>(facultyRepository.findAll(),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<List<Faculty>>(HttpStatus.FORBIDDEN);
        }
    }

    public ResponseEntity<Department> getDepartment(int facultyId){
        try {
            Faculty faculty=facultyRepository.findById(facultyId);
            if(faculty==null){return new ResponseEntity<Department>(HttpStatus.NOT_FOUND);}
            else {return new ResponseEntity<Department>(faculty.getDepartment(),HttpStatus.OK);}
        }catch (Exception e){
            return new ResponseEntity<Department>(HttpStatus.FORBIDDEN);
        }
    }

    public ResponseEntity<Void> addNotice(Notice notice,int facultyId){
        try{
            Faculty faculty=facultyRepository.findById(facultyId);
            if(faculty==null){
                System.out.println("in not found fac");
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);}
            else {

                //faculty.getNoticeSet().add(notice);
                System.out.println("in ok fac");
                return new ResponseEntity<Void>(HttpStatus.OK);}
        }catch (Exception e){
            System.out.println("in excep fac");
            return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);
        }
    }
}
