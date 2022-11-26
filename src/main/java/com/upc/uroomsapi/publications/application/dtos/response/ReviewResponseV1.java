package com.upc.uroomsapi.publications.application.dtos.response;

import com.upc.uroomsapi.publications.infrastructure.persistence.entities.Post;

public class ReviewResponseV1 {
    private Long reviewId;
    private int score;
    private String comment;
    private Post post;

    public ReviewResponseV1() {}

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

    public Post getPost() {
        return post;
    }
    public void setPost(Post post) {
        this.post = post;
    }
}
