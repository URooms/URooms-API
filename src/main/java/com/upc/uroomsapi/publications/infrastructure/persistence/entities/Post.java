package com.upc.uroomsapi.publications.infrastructure.persistence.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.upc.uroomsapi.users.infrastructure.persistence.entities.Owner;
import com.upc.uroomsapi.publications.domain.aggregates.PropertyType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto-increment
    private Long postId;
    private String title;
    private String description;
    private float averageRating;
    private double pricePerMonth;
    private String propertyAddress;
    private String propertyDimensions;
    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;
    private boolean isAvailable;

    //UN "post" puede tener MUCHOS "reviews"
    @JsonBackReference
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Review> reviews = new HashSet<>();

    //MUCHOS "posts" van a estar en UN "arrendador"
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ownerId", nullable = false)
    private Owner owner;

    public Post() {}

    public Long getPostId() {
        return postId;
    }
    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public float getAverageRating() {
        return averageRating;
    }
    public void setAverageRating(float averageRating) {
        this.averageRating = averageRating;
    }

    public Set<Review> getReviews() {
        return reviews;
    }
    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Owner getOwner() {
        return owner;
    }
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public double getPricePerMonth() {
        return pricePerMonth;
    }
    public void setPricePerMonth(double pricePerMonth) {
        this.pricePerMonth = pricePerMonth;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }
    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public String getPropertyDimensions() {
        return propertyDimensions;
    }
    public void setPropertyDimensions(String propertyDimensions) {
        this.propertyDimensions = propertyDimensions;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }
    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
