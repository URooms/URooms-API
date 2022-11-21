package com.upc.uroomsapi.users.infrastructure.persistence.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.upc.uroomsapi.publications.infrastructure.persistence.entities.Review;
import com.upc.uroomsapi.users.infrastructure.persistence.values.InstitutionValue;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student extends User {
    @Embedded
    private InstitutionValue institution;

    //UN "estudiante" puede tener MUCHOS "reviews"
    @JsonBackReference
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Review> reviews = new HashSet<>();

    public Student() {}

    public InstitutionValue getInstitution() {
        return institution;
    }
    public void setInstitution(InstitutionValue institution) {
        this.institution = institution;
    }

    public Set<Review> getReviews() {
        return reviews;
    }
    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }
}
