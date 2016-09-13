/*
 * Customers can modify their information
 * Similar to NewAccountGUI class
 * Enter all info
 */
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*; 
import java.util.*;
public class ModifyInfoGUI extends JFrame implements ActionListener, Airlines
{
    Scanner z = new Scanner (System.in); 
    private static JFrame frameModifyInfo = new JFrame(); 
    public static Date currentDate; 
    private JTextField ename, emonth, eday, eyear;
    private JPasswordField epassword, econfirmPassword; 
    private JTextField egender; 
    private Customer eLoggedIn;  

    private JButton enterAll = new JButton ("Enter information"); 

    public ModifyInfoGUI(Date today, Customer loggedIn)
    {
        JOptionPane.showMessageDialog(frameModifyInfo, "Enter all information, even if you don't want to change it"); 
        eLoggedIn = loggedIn; 
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

        //         constructorFrame.getContentPane().add(constructorFrame, BorderLayout.WEST);
        //         constructorFrame.getContentPane().add(constructorFrame, BorderLayout.EAST);
        //constructorFrame.setSize(400, 400);
        constructorFrame.pack();
        GUI NewAccountGUI = new GUI();
        frameModifyInfo = constructorFrame;
    }

    public JFrame getFrame()
    {
        return frameModifyInfo;
    }

    public void launchFrame(JFrame importedFrame)
    {
        importedFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //importedFrame.pack(); 
        importedFrame.setSize(400, 400); 
        importedFrame.setVisible(true);
    }

    public void actionPerformed (ActionEvent ev)
    {
        Object source = ev.getSource(); 
        if(source == enterAll) //gets all info from the different objects
        {
            //declare new variables here
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
            else
            {
                for (int i = 0; i < passwordEntered.length; i++)
                    passwordOfUser += passwordcheckEntered[i];                    
                passwordOfUser.toLowerCase(); //used so that passwords are all lowercase
            }
            
            //get date by parseInt method
            int monthOfUser = Integer.parseInt(emonth.getText()); 
            int dayOfUser = Integer.parseInt(eday.getText()); 
            int yearOfUser = Integer.parseInt(eyear.getText()); 
            Date userDOB = new Date(monthOfUser, dayOfUser, yearOfUser);
            ArrayList<Seat> seatsOfUser = new ArrayList<Seat>();
            
            
            //methods to change info 
            if(eLoggedIn instanceof Standard || eLoggedIn instanceof Minor || eLoggedIn instanceof Platinum)
            {
                eLoggedIn.changePassword(passwordOfUser);//FLAG
                eLoggedIn.changeName(nameOfUser); //FLAG
                eLoggedIn.changeGender(isMale);
                eLoggedIn.changeDOB(userDOB);
            }

            
            //launch the frame to go back to LoginGUI
            LoginGUI loggedInGUI = new LoginGUI(currentDate, eLoggedIn); 
            loggedInGUI.launchFrame(loggedInGUI.getFrame());
        }

    }

}
