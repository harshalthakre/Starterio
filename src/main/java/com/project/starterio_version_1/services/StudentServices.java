package com.project.starterio_version_1.services;

import com.project.starterio_version_1.model.Department;
import com.project.starterio_version_1.model.Student;
import com.project.starterio_version_1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServices {

    @Autowired
    private StudentRepository studentRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();

    public ResponseEntity<Void> addStudent(Student student){
        try {
            if(!studentRepository.existsById(student.getId())){
                student.setPassword(bCryptPasswordEncoder.encode(student.getPassword()));
                studentRepository.save(student);
            return new ResponseEntity<Void>(HttpStatus.OK);}
            else {return new ResponseEntity<Void>(HttpStatus.ALREADY_REPORTED);}
        }catch (Exception e){
            return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);
        }
    }

    public ResponseEntity<List<Student>> getAllStudent(){
        try {
            return new ResponseEntity<List<Student>>(studentRepository.findAll(),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<List<Student>>(HttpStatus.FORBIDDEN);
        }
    }

    public ResponseEntity<Student> getStudent(int studentId){
        try {
            Student student=studentRepository.findById(studentId);
            if(student==null){return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);}
            else {return new ResponseEntity<Student>(student,HttpStatus.OK);}
        }catch (Exception e){
            return new ResponseEntity<Student>(HttpStatus.FORBIDDEN);
        }
    }


    public ResponseEntity<Department> getDepartment(int studentId){
        try {
            Student student=studentRepository.findById(studentId);
            if(student==null){return new ResponseEntity<Department>(HttpStatus.NOT_FOUND);}
            else {return new ResponseEntity<Department>(student.getDepartment(),HttpStatus.OK);}
        }catch (Exception e){
            return new ResponseEntity<Department>(HttpStatus.FORBIDDEN);
        }
    }
}
