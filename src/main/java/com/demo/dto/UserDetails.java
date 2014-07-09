package com.demo.dto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USERS")
public class UserDetails {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int userId;

    @Column(name = "name", length = 35)
    private String userName;

    @Temporal(TemporalType.DATE)
    private Date joinedDate;

    @Column(length = 35)
    private String address;

    @Column(length = 35)
    private String description;

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
