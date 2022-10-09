package com.upc.uroomsapi.model.entity;

public class Student extends User {
    private String university;

    public Student() {}

    public String getUniversity() {
        return university;
    }
    public void setUniversity(String university) {
        this.university = university;
    }
}
