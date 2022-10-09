package com.upc.uroomsapi.model.entity;

import com.upc.uroomsapi.model.enums.TransactionStatus;

import java.util.Date;

public class Transactions {
    private String name;
    private Date date;
    private User user;
    private TransactionStatus status;

    public Transactions() {}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public TransactionStatus getStatus() {
        return status;
    }
    public void setStatus(TransactionStatus status) {
        this.status = status;
    }
}
