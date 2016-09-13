import java.util.*;
/**
 * Manage and manipulate multiple plane/customer objects
 * Should be the parameter to all the classes
 * Accessible multiple times? 
 * Has a login sequence that is a work in progress
 */
public class cList 
{

    private ArrayList <Customer> c = new ArrayList<Customer>(); 

    public cList (ArrayList <Customer> customers)
    {
        c = customers;
    }

    public String toString()
    {
        String ret = "";
        for (int i = 0; i < c.size(); i++)
            ret += c.get(i).toString();
        return ret; 
    }

    public Customer getCustomer(int arrayIndex) //searches based on index in the arraylist
    {
        return c.get(arrayIndex);
    }
    
    public Customer getCustomer(String name) //searches based on the name
    {
        Customer toReturn = null; 
        for (int i = 0; i < c.size(); i++)
        {
            if(c.get(i).getName().equalsIgnoreCase(name))
                toReturn = c.get(i);
            else
                toReturn = null; 
        }
        return toReturn; 
    }
  
    public boolean loginCheck (String username, String password) //returns true if the parameters
    //match an object in the arraylist
    
    {

        boolean success = false; 

        for (int i5 = 0; i5 < c.size(); i5++) //searches through every object in the cList
        {
            if (username.equalsIgnoreCase(c.get(i5).getName())) //if name matches
            {
                if (password.equalsIgnoreCase(c.get(i5).getPassword())) //if password matches
                {
                    success = true; 
                }
                else //only occurs within searching each customer
                {
                    success = false; 
                }
            }
        }
        return success; 
    }

}
