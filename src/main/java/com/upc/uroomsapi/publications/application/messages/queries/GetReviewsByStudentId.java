package com.upc.uroomsapi.publications.application.messages.queries;

public class GetReviewsByStudentId {
    private long studentId;

    public GetReviewsByStudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getStudentId() {
        return studentId;
    }
    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }
}
