package com.deloitte.parking.lot.bytebyte.serviceImpl;

import com.deloitte.parking.lot.bytebyte.Enum.VehicleSize;
import com.deloitte.parking.lot.bytebyte.services.FareStrategy;
import com.deloitte.parking.lot.bytebyte.services.ParkingSpot;
import com.deloitte.parking.lot.bytebyte.services.PaymentStrategy;
import com.deloitte.parking.lot.bytebyte.services.Vehicle;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingManager {

    private final Map<VehicleSize, List<ParkingSpot>> availableSpots;
    private final Map<Vehicle, ParkingSpot> vehicleToSpotMap;
    private final PaymentFactory paymentFactory;
    private final FareCalculator fareCalculator;

    public ParkingManager(Map<VehicleSize, List<ParkingSpot>> availableSpots, FareCalculator fareCalculator) {
        this.availableSpots = availableSpots;
        this.vehicleToSpotMap = new HashMap<>();
        this.paymentFactory = new PaymentFactory();
        this.fareCalculator = fareCalculator;
    }

    public ParkingSpot findParkingSpot(Vehicle vehicle) {
        VehicleSize vehicleSize = vehicle.getSize();

        for (VehicleSize size : VehicleSize.values()) {
            if (size.ordinal() >= vehicleSize.ordinal()) {
                List<ParkingSpot> spots = availableSpots.get(size);
                for (ParkingSpot spot : spots) {
                    if (spot.isAvailable()) {
                        return spot;
                    }
                }
            }
        }
        return null;
    }

    public ParkingSpot parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = findParkingSpot(vehicle);
        if (spot != null) {
            spot.occupy(vehicle);
            vehicleToSpotMap.put(vehicle, spot);
            availableSpots.get(spot.getSize()).remove(spot);
            return spot;
        }
        return null;
    }

    public ParkingSpot unparkVehicle(Vehicle vehicle) {
        ParkingSpot spot = vehicleToSpotMap.remove(vehicle);
        if (spot != null) {
            spot.vacate();
            availableSpots.get(spot.getSize()).add(spot);
            return spot;
        }
        return null;
    }

    public void processPayment(Ticket ticket, String paymentType) {
        PaymentStrategy strategy = paymentFactory.getPaymentStrategy(paymentType);
        BigDecimal fare = fareCalculator.calculateFare(ticket);
        strategy.processPayment(fare);
        unparkVehicle(ticket.getVehicle());
    }
}
