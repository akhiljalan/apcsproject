import java.util.*;
/*
 * Child class of customer
 * Represetns a minor under 18
 */
public class Minor extends Customer
{
    private boolean eIsTroublesome; 
    public Minor (String name, 
    String password, boolean isMale, Date DOB, 
    boolean isTroublesome, ArrayList <Seat> bookedSeats)
    {
        super (name, password, isMale, DOB, bookedSeats); //inheritance
        eIsTroublesome = isTroublesome; //to get instance variables
    }
    
    //the following gets info
    public String getName(){return ename;}
    public String getPassword(){
        return epassword; }
    
    //the following methods change info
    
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
    
    
    //generic toString method which accesses info about customer
    public String toString()
    {
        String s;
        s = (filler + "NAME: " + ename + " IS A MINOR.");
        if (eisMale) s+= "\nGENDER: MALE";
        else s+= "\nGENDER: FEMALE";
        s+= "\nDATE OF BIRTH: " + eDOB.toString();
        s += ("\n" + filler);
        return s; 
    }
    //price method 
    //minor always gets markup
    public double getPrice(double price)
    {
        double toReturn = price; 
        if(eIsTroublesome)
            toReturn *= 1.2;//additional markup if child will give us trouble
        else
            toReturn += 1.1; 
        return toReturn; 
    }
    
    
    public void addSeat(Seat toAdd)
    {
        ebookedSeats.add(toAdd);
    }

}
