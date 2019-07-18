package com.project.starterio_version_1.services;

import com.project.starterio_version_1.model.Notice;
import com.project.starterio_version_1.repository.DepartmentRepository;
import com.project.starterio_version_1.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServices {

    @Autowired
    private NoticeRepository noticeRepository;

    @Autowired
    private DepartmentServices departmentServices;

    @Autowired
    private FacultyServices facultyServices;


    public ResponseEntity<String> addNotice(Notice notice,int facultyId,
                                          int departmentId)
    {
        try {
            if(!noticeRepository.existsById(notice.getNoticeId())){
                noticeRepository.save(notice);
                ResponseEntity<Void> departmentStatus=departmentServices.addNotice(notice,departmentId);
                ResponseEntity<Void> facultyStatus=facultyServices.addNotice(notice,facultyId);
                if(departmentStatus.getStatusCode()== HttpStatus.OK&&facultyStatus.getStatusCode()==HttpStatus.OK){
                    return new ResponseEntity<String>("OK",HttpStatus.OK);
                }else {
                    return new ResponseEntity<String>("Problem with Department OR Faculty",HttpStatus.OK);
                }
            }else {
                return new ResponseEntity<String>("Problem with Notice",HttpStatus.ALREADY_REPORTED);
            }
        }catch (Exception e){
            return new ResponseEntity<String>("Server Error",HttpStatus.FORBIDDEN);
        }

    }

    public ResponseEntity<String> addNotice(Notice notice){
        try {
            if(!noticeRepository.existsById(notice.getNoticeId())){
                noticeRepository.save(notice);
                return new ResponseEntity<String>("OK",HttpStatus.OK);
            }else {return new ResponseEntity<String>("Already Exists",HttpStatus.ALREADY_REPORTED);}
        }catch (Exception e){
            return new ResponseEntity<String>("Server Error",HttpStatus.FORBIDDEN);
        }
    }

    public ResponseEntity<List<Notice>> getNoticeByDepartment(int departmentId){
        try{
            return new ResponseEntity<List<Notice>>(noticeRepository.findByDepartmentDepartmentId(departmentId),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<List<Notice>>(HttpStatus.FORBIDDEN);
        }
    }
}
