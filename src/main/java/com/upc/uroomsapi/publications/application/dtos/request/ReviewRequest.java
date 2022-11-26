package com.upc.uroomsapi.publications.application.dtos.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class ReviewRequest {
    private String comment;
    @Min(value = 1, message = "La calificación mínima es de 1 estrella")
    @Max(value = 5, message = "La calificación máxima es de 5 estrellas")
    private int score;

    public ReviewRequest() {}

    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
}
