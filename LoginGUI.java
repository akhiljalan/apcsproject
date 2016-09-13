import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*; 
import java.util.*;
/*
 * If user is logged in, two options
 * 1. Browse flights takes it to select flight GUI
 * 2. Modify info takes it to modify info GUI 
 */
public class LoginGUI extends JFrame implements ActionListener, Airlines
{
    Scanner z = new Scanner (System.in); 
    private static  JFrame frameOfGUI; 
    private JButton eFlightSelect;


    private JButton modifyInfoButton = new JButton("Modify account information"); 
    public static  Date today; 
    private static Customer eLoggedIn;
    public LoginGUI(Date currentDate, Customer loggedIn)
    {
        eLoggedIn = loggedIn; //customer who is logged in 
        JFrame loginFrame = new JFrame("Intro to Jalan Airlines");
        JOptionPane greeting = new JOptionPane("Welcome Back!"); 
        greeting.showMessageDialog(frameOfGUI, "Welcome back to Jalan Airlines!"); 
        
        //two panels
        JPanel panel1 = new JPanel(); 
        JPanel panel2 = new JPanel();
        
        //button to go browse flights
        JButton flightSelect = new JButton("Click here to Browse flights");
            eFlightSelect = flightSelect; 
            panel1.add(flightSelect); 
            flightSelect.addActionListener(this); 
                eFlightSelect.addActionListener(this); 
        
        
        //button to modify info
        modifyInfoButton.addActionListener(this);
            panel2.add(modifyInfoButton);
            
        loginFrame.getContentPane().add(panel1, BorderLayout.NORTH);
        loginFrame.getContentPane().add(panel2, BorderLayout.SOUTH);
        loginFrame.setSize(200, 200);
        
        frameOfGUI = loginFrame; 
        today = currentDate; 
    }
    public void actionPerformed (ActionEvent ev)
    {
        Object source = ev.getSource(); 
        if (source.equals(eFlightSelect)){
            flightSelectSequence();
        }
        if (source.equals(modifyInfoButton))
        {
            modifyInfoSequence();  
        } 
        
    }
    
    public void flightSelectSequence()
    {
        SelectFlightGUI fligtSelectionGUI = new SelectFlightGUI(today, eLoggedIn); 
        fligtSelectionGUI.launchFrame(fligtSelectionGUI.getFrame()); 
    }
    public void modifyInfoSequence()
    {
        ModifyInfoGUI modifyInfo = new ModifyInfoGUI(today, eLoggedIn); 
        modifyInfo.launchFrame(modifyInfo.getFrame()); 
    }
    public JFrame getFrame()
    {
        return frameOfGUI;
    }
    public void launchFrame(JFrame importedFrame)
    {
        importedFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        importedFrame.setSize(400, 400); 
        importedFrame.setVisible(true);
    }
    public static void main (String[]args)
    {
        LoginGUI toLaunch = new LoginGUI(today, eLoggedIn); 
        toLaunch.launchFrame(frameOfGUI); 
    }
}
