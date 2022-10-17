package com.upc.uroomsapi.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student extends User {
    private String universityName;

    //UN "estudiante" puede tener MUCHOS "reviews"
    @JsonBackReference
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Review> reviews = new HashSet<>();

    public Student() {}

    public String getUniversityName() {
        return universityName;
    }
    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public Set<Review> getReviews() {
        return reviews;
    }
    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }
}
