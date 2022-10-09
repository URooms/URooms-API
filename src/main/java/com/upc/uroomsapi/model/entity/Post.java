package com.upc.uroomsapi.model.entity;

public class Post {
    private String title;
    private String description;
    private int photos;
    private int videos;
    private float averageRating;
    private Property propertyDetails;
    private Comment comments;

    public Post() {}

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

    public Property getPropertyDetails() {
        return propertyDetails;
    }
    public void setPropertyDetails(Property propertyDetails) {
        this.propertyDetails = propertyDetails;
    }

    public Comment getComments() {
        return comments;
    }
    public void setComments(Comment comments) {
        this.comments = comments;
    }
}
