package com.project.starterio_version_1.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Department {

    @Id
    @GeneratedValue
    private int departmentId;
    private String name;
    private String description;
    private String departmentThumbnail;
    private String departmentCover;

    /*@OneToMany(fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Notice> noticeSet=new HashSet<Notice>(0);

    public Set<Notice> getNoticeSet() {
        return noticeSet;
    }

    public void setNoticeSet(Set<Notice> noticeSet) {
        this.noticeSet = noticeSet;
    }*/

    public Department() {
    }

    public Department(int departmentId, String name, String description, String departmentThumbnail, String departmentCover) {
        this.departmentId = departmentId;
        this.name = name;
        this.description = description;
        this.departmentThumbnail = departmentThumbnail;
        this.departmentCover = departmentCover;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentCover() {
        return departmentCover;
    }

    public String getDepartmentThumbnail() {
        return departmentThumbnail;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartmentCover(String departmentCover) {
        this.departmentCover = departmentCover;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public void setDepartmentThumbnail(String departmentThumbnail) {
        this.departmentThumbnail = departmentThumbnail;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", departmentThumbnail='" + departmentThumbnail + '\'' +
                ", departmentCover='" + departmentCover + '\'' +
                '}';
    }
}
