import java.util.*;
/*
 * Standard customer
 * Only one additional parameter
 * Represents a customer with no benefits
 */
public class Standard extends Customer
{
    boolean ehasCoupon;
    Scanner z = new Scanner (System.in); 

    public Standard (String name, String password, 
    boolean isMale, Date DOB, boolean hasCoupon, ArrayList <Seat> bookedSeats)
    {
        super(name, password, isMale, DOB, bookedSeats);
        ehasCoupon = hasCoupon; //instance variable to represent whether the customer has a coupon
    }

    public Standard() //method overloading to avoid any compiler errors
    {
    }

    public double getPrice(double price)
    {
        if (ehasCoupon) return (price * 0.95); //coupon boolean determines whether there is a discount
        else return price;
    }

    public String getName()
    {
        return ename;
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
        s = (filler + "NAME: " + ename);
        if (eisMale) s+= "\nGENDER: MALE";
        else s+= "\nGENDER: FEMALE";
        s+= "\nDATE OF BIRTH: " + eDOB.toString();
        s += ("\n" + filler);
        return s; 
    }

    public void addSeat(Seat toAdd)
    {
        ebookedSeats.add(toAdd);
    }

    

}
