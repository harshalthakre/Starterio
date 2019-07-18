package com.project.starterio_version_1.controllers;

import com.project.starterio_version_1.model.Event;
import com.project.starterio_version_1.model.User;
import com.project.starterio_version_1.services.EventServices;
import com.project.starterio_version_1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EventController {

    @Autowired
    private EventServices eventServices;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST,value = "/user/{userId}/event")
    public ResponseEntity<String> addEvent(@RequestBody Event event, @PathVariable int userId){
        User user=userService.getUser(userId);
        if(user!=null){
            event.setUser(user);
            return eventServices.addEvent(event);
        }else {return new ResponseEntity<String>("User not found",HttpStatus.NOT_FOUND);}
    }

    @RequestMapping(method = RequestMethod.GET,value = "/event")
    public ResponseEntity<List<Event>> getAllEvent(){
        return eventServices.getEvent();
    }
}
