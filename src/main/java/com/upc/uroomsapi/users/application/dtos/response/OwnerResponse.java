package com.upc.uroomsapi.users.application.dtos.response;

public class OwnerResponse extends UserResponse {
    private long dni;

    public OwnerResponse() {}

    public long getDni() {
        return dni;
    }
    public void setDni(long dni) {
        this.dni = dni;
    }
}
