package com.upc.uroomsapi.users.domain.events;

public class StudentRegistered {
    private String fullname;
    private long id;

    public StudentRegistered(String fullname, long id) {
        this.fullname = fullname;
        this.id = id;
    }
}
