package com.upc.uroomsapi.publications.application.dtos.response;

import com.upc.uroomsapi.users.infrastructure.persistence.entities.User;

public class ReviewResponse {
    private Long reviewId;
    private int score;
    private String comment;
    private User student;

    public ReviewResponse() {}

    public Long getReviewId() {
        return reviewId;
    }
    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getStudent() {
        return student;
    }
    public void setStudent(User student) {
        this.student = student;
    }
}
