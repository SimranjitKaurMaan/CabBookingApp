package com.simran.models;

public class Cab
{
   private String id;
   private String regNumber;
   private Location currentLocation;
   private boolean isAvailable;
   private Booking booking;

    public Cab(String id,String regNumber,Location currentLocation)
    {
        this.id = id;
        this.regNumber = regNumber;
        this.currentLocation = currentLocation;
        this.isAvailable= true;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public String getId() {
        return id;
    }

    public Booking getBooking() {
        return booking;
    }

    @Override
    public String toString() {
        return "Cab{" +
                "Id='" + id + '\'' +
                ", regNumber='" + regNumber + '\'' +
                ", currentLocation=" + currentLocation +
                ", isAvailable=" + isAvailable +
                '}';
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }



}
