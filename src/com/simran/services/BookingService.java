package com.simran.services;

import com.simran.exceptions.NoCabAvailableException;
import com.simran.models.Booking;
import com.simran.models.Cab;
import com.simran.models.Location;
import com.simran.models.Rider;
import com.simran.strategies.ICabMatchingStrategy;
import com.simran.strategies.IPricingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingService
{
    private Map<String, List<Booking>> bookingsByRiderIdMap;
    private RiderService riderService;
    private CabService cabService;
    private ICabMatchingStrategy cabMatchingStrategy;
    private IPricingStrategy pricingStrategy;
    public final static double MAX_ALLOWED_BOOKING_DISTANCE = 10.0;

    public BookingService(RiderService riderService,CabService cabService, ICabMatchingStrategy cabMatchingStrategy, IPricingStrategy pricingStrategy)
    {
        this.bookingsByRiderIdMap = new HashMap<>();
        this.cabService = cabService;
        this.riderService = riderService;
        this.cabMatchingStrategy = cabMatchingStrategy;
        this.pricingStrategy = pricingStrategy;
    }
    
    public String bookCab(String riderId, Location pickupLocation, Location dropLocation)
    {
        Rider rider = this.riderService.getRider(riderId);
        List<Cab> cabs = this.cabService.getCabs(pickupLocation, MAX_ALLOWED_BOOKING_DISTANCE);
        Cab selectedCab = this.cabMatchingStrategy.matchingCab(cabs,rider,pickupLocation,dropLocation);
        if(selectedCab==null)
        {
            throw new NoCabAvailableException();
        }

        double fare = this.pricingStrategy.calculateFare(pickupLocation,dropLocation);
        Booking booking = new Booking(rider,selectedCab,pickupLocation,dropLocation,fare);
        if(!bookingsByRiderIdMap.containsKey(riderId))
        {
            bookingsByRiderIdMap.put(riderId,new ArrayList<>());
        }

        bookingsByRiderIdMap.get(riderId).add(booking);
        this.cabService.updateCabBooking(booking,selectedCab.getId());
        return booking.getId();
    }

    public List<Booking> getBookings(String riderId)
    {
        List<Booking> bookings = bookingsByRiderIdMap.get(riderId);
        return bookings;
    }

}
