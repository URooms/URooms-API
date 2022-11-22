package com.upc.uroomsapi.users.application.messages.queries;

public class GetOwnerById {
    private long userId;

    public GetOwnerById(long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
}
