package com.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("Car")
public class FourWheeler extends Vehicle {
    @Column(length = 35)
    private String steeringWheel;

    public String getSteeringWheel() {
        return steeringWheel;
    }

    public void setSteeringWheel(String steeringWheel) {
        this.steeringWheel = steeringWheel;
    }
}
