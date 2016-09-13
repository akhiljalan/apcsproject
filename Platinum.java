import java.util.*;
/*
 * Represents a platinum customer
 * Benefits include discounts on plane tickets
 */
public class Platinum extends Customer
{
    //(String name, String address, String phoneNum, String password, boolean isMale, Date DOB)
    private double ediscount;
    private int eyears; 
    public Platinum(String name, String address, String phoneNum, 
    String password, boolean isMale, Date DOB, double discount, int years, ArrayList<Seat> bookedSeats)
    {
        super (name, password, isMale, DOB, bookedSeats);
        discount += (0.002) * years; //the discount gets a boost for every year of membership
        ediscount = discount;
        eyears = years; 
    }
    
    public void addYears(int toAdd)
    {
        eyears += toAdd;
    }
    
    public double getPrice(double price)
    {
        return (price *= (1 - (ediscount)));
    }
    
    public String getName()
    {
        return ename;
    }
    
    public void addSeat(Seat toAdd)
    {
        ebookedSeats.add(toAdd);
    }
    public void changePassword(String toChange)
    {
        epassword = toChange;
    }
    public  void changeName(String toChange)
    {
        ename = toChange;
    }
    public  void changeGender(boolean toChange)
    {
        eisMale = toChange; 
    }
    public  void changeDOB(Date toChange)
    {
        eDOB = toChange;
    }
    
    public String getPassword()
    {
        return epassword; 
    }
    public String toString()
    {
        String s;
        s = (filler + "NAME: " + ename + " IS A PLATINUM CUSTOMER");
        if (eisMale) 
        {
            s+= "\nGENDER: MALE";
        }
        else 
        {
            s+= "\nGENDER: FEMALE";
        }
        s+= "\nDATE OF BIRTH: " + eDOB.toString();
        s += ("\n" + filler);
        return s; 
    }
}
