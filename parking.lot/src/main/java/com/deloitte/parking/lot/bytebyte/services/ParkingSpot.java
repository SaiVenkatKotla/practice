package com.deloitte.parking.lot.bytebyte.services;

import com.deloitte.parking.lot.bytebyte.Enum.VehicleSize;

public interface ParkingSpot {
    public boolean isAvailable();

    public void occupy(Vehicle vehicle);

    public void vacate();

    public int getSpotNumber();

    public VehicleSize getSize();
}
