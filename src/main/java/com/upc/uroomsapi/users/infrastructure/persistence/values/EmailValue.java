package com.upc.uroomsapi.users.infrastructure.persistence.values;

import javax.persistence.Embeddable;

@Embeddable
public class EmailValue {
    private String email;

    public EmailValue() {}

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
