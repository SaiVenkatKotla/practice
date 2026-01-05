package com.deloitte.parking.lot.bytebyte.serviceImpl;

import com.deloitte.parking.lot.bytebyte.services.ParkingSpot;
import com.deloitte.parking.lot.bytebyte.services.Vehicle;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
public class Ticket {
    private final String ticketId;
    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;
    private final LocalDateTime entryTime;
    private LocalDateTime exitTime;


    public Ticket(String ticketId, Vehicle vehicle, ParkingSpot parkingSpot, LocalDateTime entryTime) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTime = entryTime;
    }

    public BigDecimal calculateParkingDuration() {
        return new BigDecimal(Duration.between(
                        this.entryTime,
                        Objects.requireNonNullElseGet(this.exitTime, LocalDateTime::now))
                .toMinutes()
        );
    }
}
