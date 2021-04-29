package com.simran.strategies;

import com.simran.models.Location;

public class DefaultPricingStrategy implements IPricingStrategy
{
    @Override
    public double calculateFare(Location fromLocation, Location toLocation) {
        double distance = fromLocation.getDistance(toLocation);
        double fare = distance * 10;
        return fare;
    }
}
