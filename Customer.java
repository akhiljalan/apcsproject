import java.util.*;
/*
 * Creates a customer object
 * 3 child classes
 * Methods to change and modify info
 */
abstract public class Customer
{
    //instance variables
    public String filler = "-------------------------------------------------------\n"; 
    public int TRIES = 5; //number of tries customer has to get their username and password right
    public String ename;
    public String epassword;
    public boolean eisMale; 
    public Date eDOB;
    public ArrayList <Seat> ebookedSeats; 
    
    public Customer(String name, String password, boolean isMale, Date DOB,
    ArrayList<Seat> bookedSeats)
    {
        ename = name; 
        epassword = password;
        eisMale = isMale; 
        eDOB = DOB; 
        ebookedSeats = bookedSeats; //seats objects to represent which seats customer has already booked
    }

    //method overloading in case of errors in cList
    public Customer()
    {
    }
    //following methods to get info
    public abstract String toString();
    public abstract String getName(); 
    public abstract String getPassword(); 
    public abstract double getPrice(double price); 
    //following methods to modify info
    public abstract void addSeat(Seat toAdd); //add a seat object to represent flights the customer will take
    public abstract void changePassword(String toChange); 
    public abstract void changeName(String toChange); 
    public abstract void changeGender(boolean toChange);
    public abstract void changeDOB(Date toChange);}
