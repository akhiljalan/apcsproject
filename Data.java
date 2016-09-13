//Fulfills wrapper class requirement
/*
 * Data of all customers and planes
 * Used as examples in the program
 */
import java.util.*;
public class Data
{
    private Random r = new Random(); 
    public Data()
    {

    }

    public pList planesOfficial()
    {
        pList toReturn = new pList(generatePlanes());        
        return toReturn; 
    }

    public cList customersOfficial()
    {
        cList toReturn = new cList(generateCustomers());
        return toReturn; 
    }

    public ArrayList<Plane> generatePlanes()
    {
        Date firstDeparture = new Date (6, 20, 2013);
        Date secondDeparture = new Date (12, 20, 2013); 
        Plane firstPlane = new Plane (generateSeats(), firstDeparture, "LAX", "CANCUN"); 
        Plane secondPlane = new Plane (generateSeats(), firstDeparture, "LAX", "MAUI");
        Plane thirdPlane = new Plane (generateSeats(), secondDeparture, "LAX", "NYC");
        Plane fourthPlane = new Plane (generateSeats(), secondDeparture, "LAX", "CHICAGO");
        ArrayList <Plane> toReturn = new ArrayList <Plane> (); 
        toReturn.add(firstPlane);
        toReturn.add(secondPlane);
        toReturn.add(thirdPlane);
        toReturn.add(fourthPlane); 
        return toReturn;

    }
    public Seat[][] generateSeats()
    {
        Seat[][] seats = new Seat[6][23]; 
        for (int col = 0; col < 6; col++)
        {
            for (int row = 0; row < 23; row++)
            {
                int x = r.nextInt(3); 
                if(x == 1)
                {
                    Seat temp = new Seat(true, col, row); //approximately 1/3rd of seats are automatically taken
                    
                    seats[col][row] = temp; 
                }
                else
                {
                    Seat temp = new Seat(false, col, row); //rest are free
                    seats[col][row] = temp; 

                }
            }
        }
        return seats; 
    }

    public ArrayList<Customer> generateCustomers()
    {
        ArrayList<Customer> toReturn = new ArrayList<Customer>(); 

        ArrayList <Seat> seatsForYash = new ArrayList<Seat>(); 
        ArrayList <Seat> seatsForLee = new ArrayList<Seat>(); 

        Date yashDOB = new Date(9, 9, 1995);
        Date leeDOB = new Date(8, 4, 1995); 

        Standard Yash = new Standard ("Yash", "yash", true, yashDOB, true, seatsForYash);
        Minor Lee = new Minor ("Lee", "lee", true, leeDOB, true, seatsForLee);

        toReturn.add(Yash); 
        toReturn.add(Lee); 

        return toReturn; 
    }

}
