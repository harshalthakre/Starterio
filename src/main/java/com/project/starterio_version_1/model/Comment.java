package com.project.starterio_version_1.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue
    private int commentId;
    private String description;

    @ManyToOne
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Event event;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public User getUser() {
        return user;
    }

    public String getDescription() {
        return description;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }
}
