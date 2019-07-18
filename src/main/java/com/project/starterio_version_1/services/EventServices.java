package com.project.starterio_version_1.services;

import com.project.starterio_version_1.model.Event;
import com.project.starterio_version_1.model.User;
import com.project.starterio_version_1.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServices {

    @Autowired
    private EventRepository eventRepository;

    public ResponseEntity<String> addEvent(Event event){
        try {
            if(!eventRepository.existsById(event.getEventId())){
                eventRepository.save(event);
                return new ResponseEntity<String>("OK", HttpStatus.OK);
            }else {
                return new ResponseEntity<String>("Already exist",HttpStatus.ALREADY_REPORTED);
            }
        }catch (Exception e){
            return new ResponseEntity<String>("Server Error",HttpStatus.FORBIDDEN);
        }
    }

    public ResponseEntity<List<Event>> getEvent(){
        try {
            return new ResponseEntity<List<Event>>(eventRepository.findAll(),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<List<Event>>(HttpStatus.FORBIDDEN);
        }
    }

    public ResponseEntity<List<Event>> getEventByAuthor(int userId){
        try {
            return new ResponseEntity<List<Event>>(eventRepository.findByUserId(userId),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<List<Event>>(HttpStatus.FORBIDDEN);
        }
    }

    public ResponseEntity<Event> getEvent(int eventId){
        try {
            return new ResponseEntity<Event>(eventRepository.findByEventId(eventId),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Event>(HttpStatus.FORBIDDEN);
        }
    }
}
