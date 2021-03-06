import java.util.*;
/**
 * Manage and manipulate multiple plane/customer objects
 * Should be the parameter to all the classes
 * Accessible multiple times? 
 * FULFILLS FOR LOOP REQUIREMENT
 */
public class pList extends Plane
{
    private Random r = new Random(); 
    private ArrayList <Plane> planes = generatePlanes(); 
    Scanner z = new Scanner(System.in);
    private int whichPlane = 0; //for void findPlane
    private Data data = new Data(); 
    
    public pList (ArrayList <Plane> p) //no constraints because all objects declared here
    { 
    }
    public pList() //empty to avoid compiler errors
    {
    }
    public ArrayList<Plane> generatePlanes() //declare plane objects here
    {
        Date firstDeparture = new Date (4, 20, 2013);

        Plane firstPlane = new Plane (generateSeats(), firstDeparture, "LAX", "CANCUN"); 
        Plane secondPlane = new Plane (generateSeats(), firstDeparture, "LAX", "MAUI");
        Plane thirdPlane = new Plane (generateSeats(), firstDeparture, "LAX", "NYC");
        Plane fourthPlane = new Plane (generateSeats(), firstDeparture, "LAX", "CHICAGO");
        ArrayList <Plane> toReturn = new ArrayList <Plane> (); 
        toReturn.add(firstPlane);
        toReturn.add(secondPlane);
        toReturn.add(thirdPlane);
        toReturn.add(fourthPlane); 
        return toReturn;
    }
    public Seat[][] generateSeats() //generates a 6x23 array of seat objects
    {
        Seat[][] seats = new Seat[6][23]; 
        for (int col = 0; col < 6; col++)
        {
            for (int row = 0; row < 23; row++)
            {
                int x = r.nextInt(3); 
                if(x == 1)
                {
                    Seat temp = new Seat(true, col, row); 
                    seats[col][row] = temp; 
                }
                else
                {
                    Seat temp = new Seat(false, col, row);
                    seats[col][row] = temp; 

                }
            }
        }
        return seats; 
    }

    public Plane getPlane(int arrayIndex) //finds plane based on index in the arraylist
    {
        return planes.get(arrayIndex);
    }

    public String toString() //generates info for every plane 
    {
        String ret = "";
        for (int i = 0; i < planes.size(); i++)
            ret += "Plane number: " + (i+1) + "\n" + planes.get(i).toString() + "\n" + "Price: " + getPriceofTicket();
        return ret; 
    }

    public ArrayList <String> destinationList() //for the selectflightGUI - all desinations
    {
        ArrayList<String> toReturn = new ArrayList<String>(); 
        for (int i = 0; i < planes.size(); i++)
            toReturn.add(planes.get(i).getDestination());
        return toReturn;
    }

    public ArrayList <String> departureList() //for the selectFlightGUI - all departure locations
    {
        ArrayList<String> toReturn = new ArrayList<String>(); 
        for (int i = 0; i < planes.size(); i++)
            toReturn.add(planes.get(i).getDeparture());
        return toReturn;
    }

    public Plane findPlane(String destination, String departure) //returns a plane with the same
    //destination and departure and parameters
    {
        departure.toUpperCase(); 
        destination.toUpperCase();
        Date temp = new Date(9, 9, 2000);
        Seat[][] tempseats = new Seat[0][0]; 
        Plane toReturn = data.planesOfficial().getPlane(0); //if no match, returns the first plane
        //         Plane toReturn = null; 
        for (int x = 0; x < planes.size(); x++)
        {
            if(planes.get(x).getDestination().equalsIgnoreCase(destination))
            {
                if(planes.get(x).getDeparture().equalsIgnoreCase(departure))
                {
                    toReturn = planes.get(x); 
                }
            }
        }
        return toReturn;
    }
    public int getLength() //returns number of planes in the arraylist
    {
        return planes.size();
    }
    
    //additional ways of finding planes
    public String planeFoundDebug(String departure, String destination)
    {
        String toReturn = "hi\n" + planes.size() + "\n";
        toReturn += planes.get(0).getDestination(); 
        for (int x = 0; x < planes.size(); x++)
        {
            if(planes.get(x).getDestination().equalsIgnoreCase(destination))
            {
                if(planes.get(x).getDeparture().equalsIgnoreCase(departure))
                {
                    toReturn += ("LOOP ITERATION: " + x + "\n"); 
                    toReturn += ("works" + "\n" + planes.get(x).getDeparture() + "\n" + departure);

                }
            }
        }
        return toReturn;
    }
    
    public boolean planeFound(String destination, String departure)
    {
        boolean toReturn = false; 
        for (int x = 0; x < planes.size(); x++)
        {
            if(planes.get(x).getDestination().equalsIgnoreCase(destination))
            {
                if(planes.get(x).getDeparture().equalsIgnoreCase(departure))
                {
                    //toReturn += ("LOOP ITERATION: " + x + "\n"); 
                    //toReturn += ("works" + "\n" + planes.get(x).getDeparture() + "\n" + departure);
                    toReturn = true; 
                }
            }
        }
        return toReturn;
    }
}
