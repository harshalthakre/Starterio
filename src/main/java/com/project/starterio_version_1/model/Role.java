package com.project.starterio_version_1.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Role {

    @Id
    @GeneratedValue
    private int roleId;
    private String name;
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Privilege> privileges=new HashSet<Privilege>(0);

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public Set<Privilege> getPrivileges() {
        return privileges;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public void setPrivileges(Set<Privilege> privileges) {
        this.privileges = privileges;
    }
}
