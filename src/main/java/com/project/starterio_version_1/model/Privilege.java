package com.project.starterio_version_1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Privilege {

    @Id
    @GeneratedValue
    private int privilegeId;
    private String name;
    private String description;

    public Privilege() {
    }

    public Privilege(int privilegeId, String name, String description) {
        this.privilegeId = privilegeId;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrivilegeId() {
        return privilegeId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrivilegeId(int privilegeId) {
        this.privilegeId = privilegeId;
    }

    @Override
    public String toString() {
        return "Privilege{" +
                "privilegeId=" + privilegeId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
