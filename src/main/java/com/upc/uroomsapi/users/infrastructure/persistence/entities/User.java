package com.upc.uroomsapi.users.infrastructure.persistence.entities;

import com.upc.uroomsapi.users.domain.aggregates.Gender;
import com.upc.uroomsapi.users.infrastructure.persistence.values.DniValue;
import com.upc.uroomsapi.users.infrastructure.persistence.values.EmailValue;
import com.upc.uroomsapi.users.infrastructure.persistence.values.PersonalInfoValue;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto-increment
    private Long userId;
    private String username;
    @Embedded
    private EmailValue email;
    private String password;
    @Embedded
    private PersonalInfoValue personalInfo;
    @Embedded
    private DniValue dni;
    private long phoneNumber;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public User() {}

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
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

    public PersonalInfoValue getPersonalInfo() {
        return personalInfo;
    }
    public void setPersonalInfo(PersonalInfoValue personalInfo) {
        this.personalInfo = personalInfo;
    }

    public DniValue getDni() {
        return dni;
    }
    public void setDni(DniValue dni) {
        this.dni = dni;
    }

    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
