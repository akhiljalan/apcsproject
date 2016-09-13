//String manipulation - tolowercase()
/*
 * Users create a new account
 * Automatically becomes a standard user
 * 
 */
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*; 
import java.util.*;
public class NewAccountGUI extends JFrame implements ActionListener, Airlines
{
    Scanner z = new Scanner (System.in); 
    private static JFrame frameAccountNew = new JFrame(); 
    public static Date currentDate; 
    private JTextField ename, emonth, eday, eyear;
    private JPasswordField epassword, econfirmPassword; 
    private JTextField egender; 

    private JButton enterAll = new JButton ("Enter information"); 

    public NewAccountGUI(Date today)
    {
        //Text Fields to enter all info
        //Button to signify that user is done
        enterAll.addActionListener(this);
        currentDate = today; 
        //GridLayout layout = new GridLayout(8, 0, 30, 30); 

        JFrame constructorFrame = new JFrame("Create new account");
        constructorFrame.setLayout(new GridLayout(8, 2)); 

        JLabel nameLabel = new JLabel("Enter your name");
        JTextField newName = new JTextField("", 30); 
        ename = newName; 

        constructorFrame.add(nameLabel); 
        constructorFrame.add(newName);

        JLabel passwordLabel = new JLabel("Enter a password");
        JPasswordField newPassword = new JPasswordField("", 30); 
        epassword = newPassword; 
        JLabel confirmPasswordLabel = new JLabel("Confirm your password"); 
        JPasswordField confirmPassword = new JPasswordField("", 30); 
        econfirmPassword = confirmPassword; 

        JLabel genderLabel = new JLabel("Enter your gender (M/F)"); 
        JTextField gender = new JTextField("", 30); 
        egender = gender; 

        JLabel monthLabel = new JLabel("Month of Birth"); 
        JTextField newDOBMonth = new JTextField("", 2); 
        emonth = newDOBMonth; 
        JLabel dayLabel = new JLabel("Day of Birth"); 
        JTextField newDOBDay = new JTextField("", 2); 
        eday = newDOBDay; 
        JLabel yearLabel = new JLabel("Year of Birth"); 
        JTextField newDOBYear = new JTextField("", 2); 
        eyear = newDOBYear; 
        constructorFrame.add(newPassword);
        constructorFrame.add(passwordLabel); 
        constructorFrame.add(confirmPassword);
        constructorFrame.add(confirmPasswordLabel); 
        constructorFrame.add(genderLabel);
        constructorFrame.add(gender);
        constructorFrame.add(newDOBMonth);
        constructorFrame.add(monthLabel);
        constructorFrame.add(newDOBDay); 
        constructorFrame.add(dayLabel);
        constructorFrame.add(newDOBYear);
        constructorFrame.add(yearLabel);
        constructorFrame.add(enterAll); 

        constructorFrame.pack();
        GUI NewAccountGUI = new GUI();
        frameAccountNew = constructorFrame;
    }

    public void launchFrame(JFrame importedFrame)
    {
        importedFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        importedFrame.setSize(400, 400); 
        importedFrame.setVisible(true);
    }

    public static void main (String[]args)
    {
        NewAccountGUI toLaunch = new NewAccountGUI(currentDate); 
        toLaunch.launchFrame(frameAccountNew); 
    }

    public JFrame getFrame()
    {
        return frameAccountNew;
    }

    
    public void actionPerformed (ActionEvent ev)
    {
        Object source = ev.getSource(); 
        if(source == enterAll) //enterAll is the button the user clicks when they're done
        {
            //declare new variables
            String nameOfUser = ename.getText(); 
            char[] passwordcheckEntered = econfirmPassword.getPassword(); 
            char[] passwordEntered = epassword.getPassword();
            String passwordOfUser = ""; 
            String MaleFemale = egender.getText();
            boolean isMale = false; 

            if(MaleFemale.equalsIgnoreCase("M"))
                isMale = true; 
            if(passwordEntered.equals(passwordcheckEntered))
            {
                for (int i = 0; i < passwordEntered.length; i++)
                    passwordOfUser += passwordEntered[i];
                passwordOfUser.toLowerCase(); //used so that passwords are all lowercase
            }
            //parseInt gets creates a data object based on strings
            int monthOfUser = Integer.parseInt(emonth.getText()); 
            int dayOfUser = Integer.parseInt(eday.getText()); 
            int yearOfUser = Integer.parseInt(eyear.getText()); 
            Date userDOB = new Date(monthOfUser, dayOfUser, yearOfUser);
            
            //seats is empty
            ArrayList<Seat> seatsOfUser = new ArrayList<Seat>();

            Standard customerCreated = new Standard (nameOfUser, passwordOfUser, isMale, userDOB, false, seatsOfUser); 
            
            
            //launch the loginGUI with the new customer
            LoginGUI loggedInGUI = new LoginGUI(currentDate, customerCreated); 
            loggedInGUI.launchFrame(loggedInGUI.getFrame());
        }

    }
}
