//uses string manipulation
/*
 * Represents one flight
 * parameters include when it will go (date)
 * where it will go (destination) from departure
 * Seat[][] to represent the seat objects in the flight
 */
import java.util.*;
public class Plane
{
    
    Scanner z = new Scanner(System.in);
    private Seat[][] eseating;

    public Date edepartureDate;
    public String edestination, edeparting; 

    public Plane(Seat[][] seating, Date departureDate,  String departing, String destination
    ) //month & day the plane leaves = departureDate
    {
        destination.toUpperCase(); 
        departing.toUpperCase(); 
        eseating = seating; 
        edestination = destination;
        edepartureDate = departureDate; 
        edeparting = departing; 
    }
    public Seat[][] getSeating()
    {
        return eseating;
    }
    public String getDestination()
    {
        return edestination;
    }
    public String getDeparture()
    {
        return edeparting;
    }
    public Plane()
    {}
  
    public String printOut() //functions as toString method
    {
        String ff = "";
        ff += ("Leaving from: " + edeparting);
        ff += " on " + edepartureDate + "\n" + "And arriving at: " + edestination;
        return ff; 
    }

    public String toString()
    {
        String ret = ""; 
        ret += edeparting + " to "  + edestination + "\nLeaving on: " + edepartureDate.toString();
        return ret; 
    }

    public double getPriceofTicket(Customer customer, Date now)
    {
        double price = 300; 
        price *= now.dateForPriceDifference(edepartureDate, now); //FLAG
        double toReturn = customer.getPrice(price);
            
        return toReturn; 
    }
    //method overloading to find the default price of a ticket
    public double getPriceofTicket()
    {
        double price = 350;
        return price;
    }    
}
