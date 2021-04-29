package com.simran.strategies;

import com.simran.models.Cab;
import com.simran.models.Location;
import com.simran.models.Rider;

import java.util.List;

public class DefaultCabMatchingStrategy implements ICabMatchingStrategy{
    @Override
    public Cab matchingCab(List<Cab> cabs, Rider rider, Location fromLocation, Location toLocation)
    {
        if(cabs.isEmpty())
        {
            return null;
        }
        return cabs.get(0);
    }
}
