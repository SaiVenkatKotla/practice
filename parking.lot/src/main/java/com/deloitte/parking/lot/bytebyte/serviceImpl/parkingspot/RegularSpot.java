package com.deloitte.parking.lot.bytebyte.serviceImpl.parkingspot;

import com.deloitte.parking.lot.bytebyte.Enum.VehicleSize;
import com.deloitte.parking.lot.bytebyte.services.ParkingSpot;
import com.deloitte.parking.lot.bytebyte.services.Vehicle;

public class RegularSpot implements ParkingSpot {

    private final int spotNumber;
    private Vehicle vehicle;

    public RegularSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        this.vehicle = null;
    }

    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public void occupy(Vehicle vehicle) {
        if (this.isAvailable()) {
            this.vehicle = vehicle;
        }
    }

    @Override
    public void vacate() {
        this.vehicle = null;
    }

    @Override
    public int getSpotNumber() {
        return this.spotNumber;
    }

    @Override
    public VehicleSize getSize() {
        return VehicleSize.MEDIUM;
    }
}
