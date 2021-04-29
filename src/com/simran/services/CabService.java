package com.simran.services;

import com.simran.exceptions.CabAlreadyExistsException;
import com.simran.exceptions.CabNotFoundException;
import com.simran.models.Booking;
import com.simran.models.Cab;
import com.simran.models.Location;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CabService
{
    Map<String, Cab> CabMap;

    public CabService(Map<String, Cab> cabMap) {
        this.CabMap = cabMap;
    }

    public void createCab(Cab cab)
    {
        if(this.CabMap.containsKey(cab.getId()))
        {
            throw new CabAlreadyExistsException();
        }

        this.CabMap.put(cab.getId(),cab);
    }

    public Cab getCab(String cabId)
    {
       if(!this.CabMap.containsKey(cabId))
       {
          throw new CabNotFoundException();
       }
       return this.CabMap.get(cabId);
    }

    public void updateCabAvailability(boolean availability,String cabId)
    {
        if(!this.CabMap.containsKey(cabId))
        {
            throw new CabNotFoundException();
        }

        this.CabMap.get(cabId).setAvailable(availability);
    }

    public List<Cab> getCabs(Location fromLocation, double maxDistance)
    {
        List<Cab> cabs = new ArrayList<>();
        for(Cab cab: CabMap.values())
        {
            Location cabLocation = cab.getCurrentLocation();
            double distance = fromLocation.getDistance(cabLocation);
            if(cab.getAvailable() && distance<=maxDistance && cab.getBooking()==null)
            {
                cabs.add(cab);
            }
        }

        return cabs;
    }

    public void updateCabLocation(Location newLocation, String cabId)
    {
        if(!this.CabMap.containsKey(cabId))
        {
            throw new CabNotFoundException();
        }
        CabMap.get(cabId).setCurrentLocation(newLocation);
    }

    public void updateCabBooking(Booking booking,String cabId)
    {
        this.CabMap.get(cabId).setBooking(booking);
    }

}
