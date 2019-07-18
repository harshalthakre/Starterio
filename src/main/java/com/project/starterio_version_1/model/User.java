package com.project.starterio_version_1.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance
public class User {

    @Id
    @GeneratedValue
    private int id;

    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String dob;
    private String fName;
    private String lName;

    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Role> roles=new HashSet<Role>(0);

    public Set<Role> getRoles() {
        return roles;
    }

    public int getId() {
        return id;
    }

    public String getDob() {
        return dob;
    }


    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }



    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public User() {
    }

    public User(int id, String username, String password, String dob, String fName, String lName, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.dob = dob;
        this.fName = fName;
        this.lName = lName;
        this.roles = roles;
    }
}
