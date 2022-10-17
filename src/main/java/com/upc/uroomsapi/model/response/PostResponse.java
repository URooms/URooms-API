package com.upc.uroomsapi.model.response;

import com.upc.uroomsapi.model.entity.Owner;
import com.upc.uroomsapi.model.entity.Review;

import java.util.Set;

public class PostResponse {
    private Long postId;
    private String title;
    private String description;
    private int photos;
    private int videos;
    private float averageRating;
    //private Property property;
    private Set<Review> reviews;
    private Owner owner;

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

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public int getPhotos() {
        return photos;
    }
    public void setPhotos(int photos) {
        this.photos = photos;
    }

    public int getVideos() {
        return videos;
    }
    public void setVideos(int videos) {
        this.videos = videos;
    }

    public float getAverageRating() {
        return averageRating;
    }
    public void setAverageRating(float averageRating) {
        this.averageRating = averageRating;
    }

//    public Property getProperty() {
//        return property;
//    }
//    public void setProperty(Property property) {
//        this.property = property;
//    }

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
}
