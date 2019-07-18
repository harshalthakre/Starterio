package com.project.starterio_version_1.controllers;

import com.project.starterio_version_1.model.Comment;
import com.project.starterio_version_1.model.Event;
import com.project.starterio_version_1.model.User;
import com.project.starterio_version_1.services.CommentService;
import com.project.starterio_version_1.services.EventServices;
import com.project.starterio_version_1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @Autowired
    private EventServices eventServices;

    @RequestMapping(method = RequestMethod.POST,value = "/user/{userId}/event/{eventId}")
    public ResponseEntity<String> addComment(@RequestBody Comment comment,
                                             @PathVariable int userId,
                                             @PathVariable int eventId){
        User user=userService.getUser(userId);

        if(user!=null){
            ResponseEntity<Event> eventStatus=eventServices.getEvent(eventId);
            if(eventStatus.getStatusCode()==HttpStatus.OK){
                comment.setUser(user);
                comment.setEvent(eventStatus.getBody());
                return commentService.addComment(comment);
            }
            else {
                return new ResponseEntity<String>("Event not found",HttpStatus.NOT_FOUND);
            }
        }else {
            return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
        }
    }
}
