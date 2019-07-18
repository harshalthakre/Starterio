package com.project.starterio_version_1.controllers;

import com.project.starterio_version_1.model.User;
import com.project.starterio_version_1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/secure")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET,value = "/users")
    public List<User> getAllUser(){
        return userService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET,value = "/secure/{studentId}")
    @PreAuthorize("hasAuthority('user'+#studentId)")
    public User getUser(@PathVariable @Param("studentId") int studentId){
        return userService.getUser(studentId);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/secure/user/{userId}")
    @PreAuthorize("hasAuthority('user'+#userId)")
    public boolean updateUser(@PathVariable @Param("userId") int userId, @RequestBody User user){
        return userService.updateUser(userId,user);
    }
}
