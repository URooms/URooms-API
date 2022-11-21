package com.upc.uroomsapi.publications.application.messages.queries;

public class GetPostsByOwnerId {
    private long ownerId;

    public GetPostsByOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public long getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }
}
