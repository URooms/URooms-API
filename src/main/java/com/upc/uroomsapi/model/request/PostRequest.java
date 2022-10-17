package com.upc.uroomsapi.model.request;

import javax.validation.constraints.NotEmpty;

public class PostRequest {
    @NotEmpty(message = "El título es requerido")
    private String title;
    @NotEmpty(message = "La descripción es requerida")
    private String description;
    //private Property property;
    private long ownerId;

    public PostRequest() {}

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

//    public Property getProperty() {
//        return property;
//    }
//    public void setProperty(Property property) {
//        this.property = property;
//    }

    public long getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }
}
