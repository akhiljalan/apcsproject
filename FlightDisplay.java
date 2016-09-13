import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*; 
import java.util.*;

/*
 * Displays seats as buttons
 * Click on a free seat to book it
 * Shows price via jOptionPane
 */
//uses arraylist class
//uses iterator to traverse the arraylist in actionperformed
//JOptionPane

public class FlightDisplay extends JFrame implements ActionListener, Airlines
{
    private static JFrame flightFrame = new JFrame("Select seats"); 
    private JPanel mainPanel = new JPanel(); 

    private Plane ePlane;
    private ArrayList<JButton> buttonsForSeats = new ArrayList<JButton>();
    private Iterator <JButton> buttonsIterator = buttonsForSeats.iterator(); 
    private static Date currentDate = new Date (4, 12, 2013); 
    private static Data data = new Data(); 
    private static Customer eLoggedIn; 

    public FlightDisplay(Plane accessedPlane, Date today, Customer loggedIn)
    {
        //plane is an additional parameter so that program can get info of plane
        eLoggedIn = loggedIn; 
        currentDate = today; 
        ePlane = accessedPlane; 
        setLayout(new FlowLayout (FlowLayout.CENTER));
        Seat[][] seats = accessedPlane.getSeating(); //FLAG
        
        //shows the user which planes are empty
        String flightInfo = ("\nSeats marked 'XXX' are taken - click on the free ones to select"); 
        JOptionPane.showMessageDialog(flightFrame, flightInfo); 
        for (int x = 0; x < accessedPlane.getSeating().length; x++) //for each seat object, new button
        {
            for (int y = 0; y < accessedPlane.getSeating()[x].length; y++)
            {
                String labelForSeat = seats[x][y].generateLabel(); //label maker from seat class
                JButton currentSeat = new JButton(labelForSeat);
                currentSeat.addActionListener(this); 
                buttonsForSeats.add(currentSeat); 
                flightFrame.add(currentSeat); //adds to the panel 
                
                //sets location manually
                if (x < seats.length/2)
                    currentSeat.setBounds((50 * x+1) + 50, (20 * y+1) + 150, 50, 20);
                else
                    currentSeat.setBounds((50 * x+1) + 175, (20 * y+1) + 150, 50, 20);

            }
        }
        flightFrame.add(mainPanel); //panel added to the frame
    }

    public void actionPerformed (ActionEvent ev)
    {        
        Seat[][] seats = ePlane.getSeating(); 
        Object source = ev.getSource(); 
        int x = 0; 
        while (buttonsIterator.hasNext()) //list iterator 
        {
            if (source == buttonsForSeats.get(x)) //FLAG
            {
                //figures out which seat is selected
                int row = 0; 
                int col = 0;
                if (x < 6)  
                    col = x; 
                else
                    col = x%6; 
                if(x%6 == 0 && x!= 0)
                    row++;
                //seatSelectedSequence(row, col); //FLAG
                seatSelectedSequence(); 
            }
            if(x == buttonsForSeats.size()-1)
                x = x;
            else
                x++; 

        }
    }

    public void seatSelectedSequence(int row, int col)
    {
        JOptionPane confirmTicket = new JOptionPane(); 
        double priceOfTicket = ePlane.getPriceofTicket(eLoggedIn, currentDate); //flag
        System.out.println(priceOfTicket);
        
        int reply = confirmTicket.showConfirmDialog(null, "The seat you have selected is $" + 300 +
                ". Would you like to buy it?", " confirm", JOptionPane.YES_NO_OPTION); //does the user want to buy it? 
        if(reply == JOptionPane.YES_OPTION)
        {
            Seat[][] seatsOfPlane = ePlane.getSeating(); //gets the seating of the plane
            seatsOfPlane[row][col].changeBoolean(true); //seat is flagged as bought
            JOptionPane.showMessageDialog(flightFrame, "Confirmed!");
            flightFrame.setVisible(false); 
        }
        else
        {
            FlightDisplay flightDisplayGUI = new FlightDisplay(ePlane, currentDate, eLoggedIn); //FLAG
            flightDisplayGUI.launchFrame(flightDisplayGUI.getFrame()); 
        }

    }

    public void seatSelectedSequence() //method overloading in case the program can't find the row and col
    {
        JOptionPane confirmTicket = new JOptionPane(); 
        eLoggedIn = data.customersOfficial().getCustomer(0); 
        double priceOfTicket = ePlane.getPriceofTicket(eLoggedIn, currentDate); //flag
        int reply = confirmTicket.showConfirmDialog(null, "The seat you have selected is $" + priceOfTicket +
                ". Would you like to buy it?", " confirm", JOptionPane.YES_NO_OPTION); 
        if(reply == JOptionPane.YES_OPTION)
        {
            //Seat[][] seatsOfPlane = ePlane.getSeating(); //gets the seating of the plane
            //seatsOfPlane[row][col].changeBoolean(true); //seat is flagged as bought
            JOptionPane.showMessageDialog(flightFrame, "Confirmed!");
            flightFrame.setVisible(false); 
        }
        else
        {
            FlightDisplay flightDisplayGUI = new FlightDisplay(ePlane, currentDate, eLoggedIn); //FLAG
            flightDisplayGUI.launchFrame(flightDisplayGUI.getFrame()); 
        }
    }

    public JFrame getFrame()
    {
        return flightFrame;
    }

    public void launchFrame(JFrame importedFrame)
    {
        importedFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        importedFrame.setSize(600, 1200); 
        importedFrame.setVisible(true);
    }

    public static void main (String[]args)
    {
        Data data = new Data(); 
        FlightDisplay toLaunch = new FlightDisplay(data.planesOfficial().getPlane(0), currentDate, eLoggedIn); 
        toLaunch.launchFrame(flightFrame); 
    }

}
