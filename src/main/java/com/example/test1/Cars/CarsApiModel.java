package com.example.test1.Cars;

import com.example.test1.Locations.Location;
import com.example.test1.Locations.LocationRepository;
import com.example.test1.Users.User;
import com.example.test1.Users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CarsApiModel {

    private Long id;
    private String manifatuer;
    private String model;
    private float fuelConsumption;
    private int numberOfDoors;
    private int power;
    private long user_id;
    private long location_id;
    private String[] images;

    CarsApiModel() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManifatuer() {
        return manifatuer;
    }

    public void setManifatuer(String manifatuer) {
        this.manifatuer = manifatuer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(float fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getLocation_id() {
        return location_id;
    }

    public void setLocation_id(long location_id) {
        this.location_id = location_id;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }
}
