package com.demo.dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "USERS")
//@org.hibernate.annotations.Entity(selectBeforeUpdate = true)
@Cacheable
@NamedQuery(name = "UserDetails.byId", query = "from UserDetails where userId = ?")
@NamedNativeQuery(name = "UserDetails.byName", query = "select * from users where name = ?")
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

    @OneToMany(cascade = CascadeType.ALL)
    @Column(name = "VEHICLES")
    private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();

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

    public Collection<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Collection<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
