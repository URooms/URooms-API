package com.upc.uroomsapi.model.entity;

import com.upc.uroomsapi.model.enums.PropertyType;

import javax.persistence.*;

@Entity
@Table(name = "Properties")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto-increment
    @Column(name = "property_id")
    private Long propertyId;
    private double pricePerMonth;
    private String address;
    private String dimensions;
    @Enumerated(EnumType.STRING)
    private PropertyType type;
    private boolean isAvailable;

    //UNA "post" tiene UN "propiedad"
    @OneToOne(mappedBy = "property")
    private Post post;

    public Property() {}

    public Long getPropertyId() {
        return propertyId;
    }
    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public double getPricePerMonth() {
        return pricePerMonth;
    }
    public void setPricePerMonth(double pricePerMonth) {
        this.pricePerMonth = pricePerMonth;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
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

    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Post getPost() {
        return post;
    }
    public void setPost(Post post) {
        this.post = post;
    }
}
