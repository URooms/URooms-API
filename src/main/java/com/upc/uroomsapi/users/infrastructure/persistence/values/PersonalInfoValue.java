package com.upc.uroomsapi.users.infrastructure.persistence.values;

import javax.persistence.Embeddable;
import java.util.Date;

@Embeddable
public class PersonalInfoValue {
    private String firstname;
    private String surname;
    private Date birthDate;

    public PersonalInfoValue() {}

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "PersonalInfoValue{" +
                "firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
