package com.deloitte.parking.lot.bytebyte.services;

import com.deloitte.parking.lot.bytebyte.Enum.VehicleSize;

public interface Vehicle {
    String getLicensePlate();

    VehicleSize getSize();
}
