package com.upc.uroomsapi.users.application.messages.commands;

import com.upc.uroomsapi.users.domain.aggregates.Gender;
import com.upc.uroomsapi.users.infrastructure.persistence.values.DniValue;
import com.upc.uroomsapi.users.infrastructure.persistence.values.EmailValue;
import com.upc.uroomsapi.users.infrastructure.persistence.values.PersonalInfoValue;

public class RegisterOwnerCommand {
    private PersonalInfoValue personalInfo;
    private String username;
    private EmailValue email;
    private DniValue dni;
    private String password;
    private long phoneNumber;
    private Gender gender;

    public RegisterOwnerCommand() {}

    public PersonalInfoValue getPersonalInfo() {
        return personalInfo;
    }
    public void setPersonalInfo(PersonalInfoValue personalInfo) {
        this.personalInfo = personalInfo;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public EmailValue getEmail() {
        return email;
    }
    public void setEmail(EmailValue email) {
        this.email = email;
    }

    public DniValue getDni() {
        return dni;
    }
    public void setDni(DniValue dni) {
        this.dni = dni;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
