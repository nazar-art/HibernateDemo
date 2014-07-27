package com.demo.dto;

import javax.persistence.*;

@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "VEHICLE_TYPE", discriminatorType = DiscriminatorType.STRING)
public class Vehicle {

    @Id @GeneratedValue(strategy = GenerationType.TABLE)
    private int vehicleId;

    @Column(name = "name", length = 35)
    private String vehicleName;

    /*@ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    private UserDetails user;
    @ManyToOne
    private Collection<UserDetails> userDetailses = new ArrayList<UserDetails>();*/

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

}
