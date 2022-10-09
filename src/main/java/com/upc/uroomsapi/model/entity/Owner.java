package com.upc.uroomsapi.model.entity;

public class Owner extends User {
    private long dni;
    private long ruc;

    public Owner() {}

    public long getDni() {
        return dni;
    }
    public void setDni(long dni) {
        this.dni = dni;
    }

    public long getRuc() {
        return ruc;
    }
    public void setRuc(long ruc) {
        this.ruc = ruc;
    }
}
