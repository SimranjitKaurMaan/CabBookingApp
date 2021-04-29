package com.simran.strategies;

import com.simran.models.Location;

public interface IPricingStrategy
{
    double calculateFare(Location fromLocation, Location toLocation);
}
