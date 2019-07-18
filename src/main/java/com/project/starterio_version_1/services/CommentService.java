package com.project.starterio_version_1.services;

import com.project.starterio_version_1.model.Comment;
import com.project.starterio_version_1.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public ResponseEntity<String> addComment(Comment comment){
        try {
            if(!commentRepository.existsById(comment.getCommentId())){
                commentRepository.save(comment);
                return new ResponseEntity<String>("OK", HttpStatus.OK);
            }else {
                return new ResponseEntity<String>("Already exists",HttpStatus.ALREADY_REPORTED);
            }
        }catch (Exception e){
            return new ResponseEntity<String>("Server error",HttpStatus.FORBIDDEN);
        }
    }

    public ResponseEntity<List<Comment>> getComment(int userId){
        try {
            return new ResponseEntity<List<Comment>>(commentRepository.findByUserId(userId),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<List<Comment>>(HttpStatus.FORBIDDEN);
        }
    }
}
