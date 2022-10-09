package com.upc.uroomsapi.model.entity;

import com.upc.uroomsapi.model.enums.PropertyType;

import java.util.List;

public class Property {
    private double price;
    private String location;
    private String dimensions;
    private PropertyType type;
    private List<String> comforts;

    public Property() {}

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public String getDimensions() {
        return dimensions;
    }
    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public PropertyType getType() {
        return type;
    }
    public void setType(PropertyType type) {
        this.type = type;
    }

    public List<String> getComforts() {
        return comforts;
    }
    public void setComforts(List<String> comforts) {
        this.comforts = comforts;
    }
}
