package com.upc.uroomsapi.publications.application.messages.commands;

public class WriteReviewCommand {
    private int score;
    private String comment;
    private long postId;
    private long studentId;

    public WriteReviewCommand() {}

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

    public long getPostId() {
        return postId;
    }
    public void setPostId(long postId) {
        this.postId = postId;
    }

    public long getStudentId() {
        return studentId;
    }
    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }
}
