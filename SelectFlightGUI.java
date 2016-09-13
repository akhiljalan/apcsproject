/* Uses a drop down menu
 * Customer selects a destination
 * Customer also selects a departure area
 * Uses pList methods
 */


//uses relational operator in searchFlightSequence
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*; 
import java.util.*;
public class SelectFlightGUI extends JFrame implements ActionListener, Airlines
{
    //declare values outside of the GUI
    private static JFrame frameForClass = new JFrame ("Flight search"); 

    private JButton OKButton = new JButton("Search flight index");
    private JLabel instructions = new JLabel("Select a departure point and destination, and then" +  
            " conduct a flight search"); //user clicks this button when they want to Search
    //drop down boxes with the options
    private JComboBox <String> departingPoints = new JComboBox<String>(); 
    private JComboBox <String> destinationPoints= new JComboBox<String>(); 
    public static Date currentDate; 
    //instance variables
    public Data data = new Data();
    private pList planesList = data.planesOfficial(); 
    private static Customer eLoggedIn;
    private Plane ePlane; 
    public SelectFlightGUI(Date today, Customer loggedIn)
    {
        //other things
        eLoggedIn = loggedIn; 
        currentDate = today; 
        JPanel leftSide = new JPanel(); 
        JPanel rightSide = new JPanel();

        //label for departing cities
        JLabel departuresLabel = new JLabel ("Cities of departure");
        leftSide.add(departuresLabel); 

        //adding items to first combo box & managing it
        for(int i = 0; i<  data.planesOfficial().departureList().size(); i++)
            departingPoints.addItem(data.planesOfficial().departureList().get(i));

        departingPoints.addActionListener(this); 
        leftSide.add(departingPoints);

        //label for destination cities
        JLabel destinationsLabel = new JLabel ("Cities of destination");
        rightSide.add(destinationsLabel); 

        //adding items to second combo box
        for(int i = 0; i<  data.planesOfficial().destinationList().size(); i++)
            destinationPoints.addItem(data.planesOfficial().destinationList().get(i));
        destinationPoints.addActionListener(this);
        rightSide.add(destinationPoints); 

        frameForClass.getContentPane().add(leftSide, BorderLayout.WEST);
        frameForClass.getContentPane().add(rightSide, BorderLayout.EAST); 

        OKButton.addActionListener(this); 
        JPanel bottomOfFrame = new JPanel(); 
        bottomOfFrame.add(instructions);
        bottomOfFrame.add(OKButton); 
        frameForClass.getContentPane().add(bottomOfFrame, BorderLayout.SOUTH); 
    }

    public JFrame getFrame()
    {
        return frameForClass;
    }

    public void launchFrame(JFrame importedFrame)
    {
        importedFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        importedFrame.pack(); 
        importedFrame.setVisible(true);
    }

    public void actionPerformed (ActionEvent ev)
    {        
        Object source = ev.getSource(); 
        if (source.equals(OKButton))
        {
            //get items from the combo boxes
            String desiredDeparture = (String)departingPoints.getSelectedItem(); 
            String desiredDestination = (String)destinationPoints.getSelectedItem();
            
            searchFlightSequence(desiredDeparture, desiredDestination); //sequence from pList
        }

    }

    public void searchFlightSequence(String departure, String destination) //searches 
    {
         //search the pList to find a plane with the same parameters 
        Plane foundPlane = planesList.findPlane(departure, destination); 
        if (foundPlane == null)
        {
            JOptionPane failedSearch = new JOptionPane();
            failedSearch.showMessageDialog(frameForClass, "Sorry, we failed to find any planes with your parameters. You can try again!");
        }
        else
        {
            JOptionPane successfulSearch = new JOptionPane(); 
            String toShowInBox = "It worked! Now we'll display the seats" + "\nThe plane you have selected is: "; 
            toShowInBox += "Leaving from: " + departure + "\nGoing to: " + destination;
            
            successfulSearch.showConfirmDialog(frameForClass, toShowInBox);

            displayFlightSequence(foundPlane); 
        }
    }

    public void displayFlightSequence(Plane foundPlane) //launches flight display
    {
        FlightDisplay flightDisplayGUI = new FlightDisplay(foundPlane, currentDate, eLoggedIn); //FLAG
        flightDisplayGUI.launchFrame(flightDisplayGUI.getFrame()); 
    }

    public ArrayList <Plane> databaseSearch(String departure, String destination)
    {
        ArrayList <Plane> toReturn = new ArrayList <Plane>(); 
        return toReturn; 
    }

    public static void main (String[]args)
    {
        SelectFlightGUI toLaunch = new SelectFlightGUI(currentDate, eLoggedIn); 
        toLaunch.launchFrame(frameForClass); 
    }
}
