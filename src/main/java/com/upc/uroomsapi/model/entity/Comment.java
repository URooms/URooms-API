package com.upc.uroomsapi.model.entity;

public class Comment {
    private User user;
    private int rating;
    private String comment;

    public Comment() {}

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
}
