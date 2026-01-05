package com.deloitte.parking.lot.bytebyte.serviceImpl;

import com.deloitte.parking.lot.bytebyte.Enum.VehicleSize;
import com.deloitte.parking.lot.bytebyte.services.FareStrategy;
import com.deloitte.parking.lot.bytebyte.services.ParkingSpot;
import com.deloitte.parking.lot.bytebyte.services.PaymentStrategy;
import com.deloitte.parking.lot.bytebyte.services.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ParkingManager {

    private final Map<VehicleSize, List<ParkingSpot>> availableSpots;
    private final Map<Vehicle, ParkingSpot> vehicleToSpotMap;
    private final PaymentFactory paymentFactory;
    private final FareCalculator fareCalculator;

    @Autowired
    public ParkingManager(FareCalculator fareCalculator) {
        this.availableSpots = new HashMap<>();
        this.vehicleToSpotMap = new HashMap<>();
        this.paymentFactory = new PaymentFactory();
        this.fareCalculator = fareCalculator;
    }

    public ParkingSpot findParkingSpot(Vehicle vehicle) {
        try {
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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public ParkingSpot parkVehicle(Vehicle vehicle) {
        try {
            ParkingSpot spot = findParkingSpot(vehicle);
            if (spot != null) {
                spot.occupy(vehicle);
                vehicleToSpotMap.put(vehicle, spot);
                availableSpots.get(spot.getSize()).remove(spot);
                return spot;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public ParkingSpot unparkVehicle(Vehicle vehicle) {
        try {
            ParkingSpot spot = vehicleToSpotMap.remove(vehicle);
            if (spot != null) {
                spot.vacate();
                availableSpots.get(spot.getSize()).add(spot);
                return spot;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void processPayment(Ticket ticket, String paymentType) {
        try {
            PaymentStrategy strategy = paymentFactory.getPaymentStrategy(paymentType);
            BigDecimal fare = fareCalculator.calculateFare(ticket);
            strategy.processPayment(fare);
            unparkVehicle(ticket.getVehicle());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
