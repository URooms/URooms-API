package com.upc.uroomsapi.model.request;

public class OwnerRequest extends UserRequest {
    private long dni;

    public OwnerRequest() {}

    public long getDni() {
        return dni;
    }
    public void setDni(long dni) {
        this.dni = dni;
    }
}
