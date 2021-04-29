package com.simran.strategies;

import com.simran.models.Cab;
import com.simran.models.Location;
import com.simran.models.Rider;

import java.util.List;

public interface ICabMatchingStrategy
{
    Cab matchingCab(List<Cab> cabs, Rider rider, Location fromLocation, Location toLocation);
}
