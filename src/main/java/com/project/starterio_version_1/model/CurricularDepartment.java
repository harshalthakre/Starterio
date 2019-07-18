package com.project.starterio_version_1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CurricularDepartment {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    private String thumbnailImage;
    private String coverImage;

    public CurricularDepartment() {
    }

    public CurricularDepartment(int id, String name, String description, String thumbnailImage, String coverImage) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.thumbnailImage = thumbnailImage;
        this.coverImage = coverImage;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public String getThumbnailImage() {
        return thumbnailImage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public void setThumbnailImage(String thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }
}
