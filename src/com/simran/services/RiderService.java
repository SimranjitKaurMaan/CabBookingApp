package com.simran.services;

import com.simran.exceptions.RiderAlreadyExistsException;
import com.simran.exceptions.RiderNotFoundException;
import com.simran.models.Rider;

import java.util.Map;

public class RiderService
{
    Map<String, Rider> RiderMap;

    public RiderService(Map<String, Rider> riderMap) {
        RiderMap = riderMap;
    }

    public void createRider(Rider rider)
    {
      if(this.RiderMap.containsKey(rider.getId()))
      {
          throw new RiderAlreadyExistsException();
      }

      RiderMap.put(rider.getId(),rider);
    }

     public Rider getRider(String riderId)
     {
       if(!RiderMap.containsKey(riderId))
       {
           throw new RiderNotFoundException();
       }

       Rider rider = RiderMap.get(riderId);
       return rider;
     }

}
