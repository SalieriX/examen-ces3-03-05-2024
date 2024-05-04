package com.example.examences3.dao;

import java.util.Date;

public class Student {
    private int id;
    private String name;
    private String lastname;
    private int age;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;
    private int id_course;


    // Constructor
    public Student(int id, String name, String lastname, int age,
                   Date createdAt, Date updatedAt, Date deletedAt) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.id_course = id_course;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
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

    public int getId_course() {
        return id_course;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAge(int age) {
        this.age = age;
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

    public void setId_course(int id_course) {
        this.id_course = id_course;
    }
}
