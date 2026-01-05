package com.deloitte.parking.lot.bytebyte.serviceImpl.vehicle;

import com.deloitte.parking.lot.bytebyte.Enum.VehicleSize;
import com.deloitte.parking.lot.bytebyte.services.Vehicle;

public class Bike implements Vehicle {

    private final String licensePlate;

    public Bike(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String getLicensePlate() {
        return licensePlate;
    }

    @Override
    public VehicleSize getSize() {
        return VehicleSize.SMALL;
    }
}
