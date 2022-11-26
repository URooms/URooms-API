package com.upc.uroomsapi.publications.domain.events;

import com.upc.uroomsapi.publications.infrastructure.persistence.entities.Post;
import com.upc.uroomsapi.users.infrastructure.persistence.entities.Student;

public class ReviewCreated {
    private Post post;
    private Student student;
    private String comment;
    private int score;

    public ReviewCreated(Post post, Student student, String comment, int score) {
        this.post = post;
        this.student = student;
        this.comment = comment;
        this.score = score;
    }

    public Post getPost() {
        return post;
    }
    public void setPost(Post post) {
        this.post = post;
    }

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

    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "ReviewCreated{" +
                "post=" + post +
                ", student=" + student +
                ", comment='" + comment + '\'' +
                ", score=" + score +
                '}';
    }
}
