package com.upc.uroomsapi.users.infrastructure.persistence.values;

import javax.persistence.Embeddable;

@Embeddable
public class DniValue {
    private long dniNumber;

    public DniValue() {}

    public long getDni() {
        return dniNumber;
    }

    public void setDni(long dni) {
        this.dniNumber = dni;
    }
}
