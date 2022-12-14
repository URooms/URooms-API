package com.upc.uroomsapi.publications.application.dtos.response;

import com.upc.uroomsapi.publications.infrastructure.persistence.values.AddressValue;

public class PostResponse {
    private Long postId;
    private String title;
    private float averageRating;
    private double pricePerMonth;
    private AddressValue propertyAddress;
    private boolean isAvailable;

    public PostResponse() {}

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

    public float getAverageRating() {
        return averageRating;
    }
    public void setAverageRating(float averageRating) {
        this.averageRating = averageRating;
    }

    public double getPricePerMonth() {
        return pricePerMonth;
    }
    public void setPricePerMonth(double pricePerMonth) {
        this.pricePerMonth = pricePerMonth;
    }

    public AddressValue getPropertyAddress() {
        return propertyAddress;
    }
    public void setPropertyAddress(AddressValue propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

//
//    public Owner getOwner() {
//        return owner;
//    }
//    public void setOwner(Owner owner) {
//        this.owner = owner;
//    }
}
