package com.upc.uroomsapi.users.domain.events;

public class OwnerRegistered {
    private String fullname;
    private long id;

    public OwnerRegistered(String fullname, long id) {
        this.fullname = fullname;
        this.id = id;
    }
}
