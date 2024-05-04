package com.example.examences3.dao;

import java.util.Date;

public class Course {
    private int id;
    private String courseName;
    private String teacher;
    private String description;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;

    // Constructor
    public Course(int id, String courseName, String teacher, String description,
                   Date createdAt, Date updatedAt, Date deletedAt) {
        this.id = id;
        this.courseName = courseName;
        this.teacher = teacher;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
}
