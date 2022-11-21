package com.upc.uroomsapi.publications.domain.events;

public class PostCreated {
    private String title;
    private long id;

    public PostCreated(String title, long id) {
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
}
