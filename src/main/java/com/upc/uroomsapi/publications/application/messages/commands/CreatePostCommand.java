package com.upc.uroomsapi.publications.application.messages.commands;

import com.upc.uroomsapi.publications.domain.aggregates.PropertyType;

public class CreatePostCommand {
    private String title;
    private String description;
    private double pricePerMonth;
    private String propertyAddress;
    private String propertyDimensions;
    private PropertyType propertyType;
    private long ownerId;

    public CreatePostCommand() {}

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

    public double getPricePerMonth() {
        return pricePerMonth;
    }
    public void setPricePerMonth(double pricePerMonth) {
        this.pricePerMonth = pricePerMonth;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }
    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public String getPropertyDimensions() {
        return propertyDimensions;
    }
    public void setPropertyDimensions(String propertyDimensions) {
        this.propertyDimensions = propertyDimensions;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }
    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public long getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }
}
