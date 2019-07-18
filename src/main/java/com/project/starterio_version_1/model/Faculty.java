package com.project.starterio_version_1.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Faculty extends User{

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Department  department;

    /*@OneToMany(fetch = FetchType.LAZY)
    *//**@OneToMany(mappedBy = "question",fetch=FetchType.LAZY,cascade= CascadeType.ALL, targetEntity = Notice.class)*//*
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Notice> noticeSet=new HashSet<Notice>(0);

    public Set<Notice> getNoticeSet() {
        return noticeSet;
    }

    public void setNoticeSet(Set<Notice> noticeSet) {
        this.noticeSet = noticeSet;
    }*/

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
