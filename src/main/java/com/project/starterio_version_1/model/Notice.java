package com.project.starterio_version_1.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Notice {

    @Id
    @GeneratedValue
    private int noticeId;
    private String title;
    private String description;
    private String noticeImage;
    private String noticeFile;
    private String noticeAuthor;
    private int[] year=new int[4];

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Department department;

    @ManyToOne(cascade = CascadeType.ALL)//,fetch = FetchType.LAZY)
   // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int[] getYear() {
        return year;
    }

    public void setYear(int[] year) {
        this.year = year;
    }

    public String getNoticeAuthor() {
        return noticeAuthor;
    }

    public void setNoticeAuthor(String noticeAuthor) {
        this.noticeAuthor = noticeAuthor;
    }

    public Notice() {
    }

    public Notice(int noticeId, String title, String description, String noticeImage, String noticeFile) {
        this.noticeId = noticeId;
        this.title = title;
        this.description = description;
        this.noticeImage = noticeImage;
        this.noticeFile = noticeFile;
    }

    public String getDescription() {
        return description;
    }

    public int getNoticeId() {
        return noticeId;
    }

    public String getNoticeFile() {
        return noticeFile;
    }

    public String getNoticeImage() {
        return noticeImage;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNoticeFile(String noticeFile) {
        this.noticeFile = noticeFile;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    public void setNoticeImage(String noticeImage) {
        this.noticeImage = noticeImage;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
