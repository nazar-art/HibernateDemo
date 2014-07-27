package com.demo.dto;

import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("Bike")
public class TwoWheeler extends Vehicle {
//    @Column(length = 35)
    private String steeringHandler;

    public String getSteeringHandler() {
        return steeringHandler;
    }

    public void setSteeringHandler(String steeringHandler) {
        this.steeringHandler = steeringHandler;
    }
}
