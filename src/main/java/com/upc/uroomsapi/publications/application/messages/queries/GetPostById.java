package com.upc.uroomsapi.publications.application.messages.queries;

public class GetPostById {
    private long postId;

    public GetPostById(long postId) {
        this.postId = postId;
    }

    public long getPostId() {
        return postId;
    }
    public void setPostId(long postId) {
        this.postId = postId;
    }
}
