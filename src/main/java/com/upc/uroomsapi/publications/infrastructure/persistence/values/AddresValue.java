package com.upc.uroomsapi.publications.infrastructure.persistence.values;

import javax.persistence.Embeddable;

@Embeddable //to work with value objects
public class AddresValue {
    private String district;
    private String street;
    private String department;
    private String zipCode;

    public AddresValue() {}

    public String getDistrict() {
        return district;
    }
    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "AddresValue{" +
                "district='" + district + '\'' +
                ", street='" + street + '\'' +
                ", department='" + department + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
