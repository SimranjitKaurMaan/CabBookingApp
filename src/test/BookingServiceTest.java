package test;

import com.simran.models.Booking;
import com.simran.models.Cab;
import com.simran.models.Location;
import com.simran.models.Rider;
import com.simran.services.BookingService;
import com.simran.services.CabService;
import com.simran.services.RiderService;
import com.simran.strategies.DefaultCabMatchingStrategy;
import com.simran.strategies.DefaultPricingStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingServiceTest
{
    @Test
    public void defaultTest()
    {
        Map<String, Cab> cabMap = new HashMap<>();
        cabMap.put("C1",new Cab("C1","C11",new Location(5,5)));
        cabMap.put("C2",new Cab("C2","C12",new Location(20,20)));
        cabMap.put("C3",new Cab("C3","C13",new Location(30,30)));
        CabService cabService = new CabService(cabMap);
        Map<String, Rider> riderMap = new HashMap<>();
        riderMap.put("R1",new Rider("R1","R11"));
        riderMap.put("R2",new Rider("R2","R12"));
        riderMap.put("R3",new Rider("R3","R13"));
        riderMap.put("R4",new Rider("R4","R14"));
        RiderService riderService = new RiderService(riderMap);
        cabService.updateCabAvailability(false,"C1");
        BookingService bookingService = new BookingService(riderService,cabService,new DefaultCabMatchingStrategy(),new DefaultPricingStrategy());
        String bookingId1 = bookingService.bookCab("R1", new Location(30,30),new Location(50,50));
        List<Booking> bookingsForR1 = bookingService.getBookings("R1");
        for(Booking booking : bookingsForR1)
        {
            System.out.println(booking);
        }
        String bookingId2 = bookingService.bookCab("R2", new Location(20,20),new Location(50,50));
        List<Booking> bookingsForR2 = bookingService.getBookings("R2");
        for(Booking booking : bookingsForR2)
        {
            System.out.println(booking);
        }
        cabService.updateCabLocation(new Location(10,10),"C2");
        String bookingId3 = bookingService.bookCab("R3", new Location(10,10),new Location(50,50));
        List<Booking> bookingsForR3 = bookingService.getBookings("R3");
        for(Booking booking : bookingsForR3)
        {
            System.out.println(booking);
        }
        cabService.updateCabAvailability(true,"C1");
        String bookingId4 = bookingService.bookCab("R4", new Location(10,10),new Location(50,50));
        List<Booking> bookingsForR4 = bookingService.getBookings("R4");
        for(Booking booking : bookingsForR4)
        {
            System.out.println(booking);
        }

    }
}
