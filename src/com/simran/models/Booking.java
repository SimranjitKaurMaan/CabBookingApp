package com.simran.models;


import com.simran.exceptions.InvalidStateException;

import java.time.LocalDateTime;
import java.util.UUID;

public class Booking
{
    private String id;
    private Rider rider;
    private Cab cab;
    private LocalDateTime timestamp;
    private Location fromLocation;
    private Location toLocation;
    private double fare;
    private BookingStatus bookingStatus;

    public Booking(Rider rider, Cab cab, Location fromLocation, Location toLocation, double fare) {
        this.id = UUID.randomUUID().toString();
        this.rider = rider;
        this.cab = cab;
        this.timestamp = LocalDateTime.now();
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.fare = fare;
        this.bookingStatus = BookingStatus.IN_PROGRESS;
    }


    public String getId() {
        return id;
    }

    public void endBooking()
    {
        if(this.bookingStatus!=BookingStatus.IN_PROGRESS)
        {
          throw new InvalidStateException();
        }

        this.bookingStatus = BookingStatus.FINISHED;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id='" + id + '\'' +
                ", rider=" + rider +
                ", cab=" + cab +
                ", timestamp=" + timestamp +
                ", fromLocation=" + fromLocation +
                ", toLocation=" + toLocation +
                ", fare=" + fare +
                ", bookingStatus=" + bookingStatus +
                '}';
    }
}
