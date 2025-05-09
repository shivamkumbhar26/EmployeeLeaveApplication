import javax.swing.*;
import java.awt.event.ActionListener ; 
import java.awt.event.ActionEvent;
import java.awt.GridLayout; 
import java.awt.event.*;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.awt.*;

public class LoginScreen extends JFrame {

    public Employee emp ; 

    CountDownLatch cdlock; 
    LoginScreen(CountDownLatch cd){ 
    cdlock = cd;  
        setTitle("Login Screen");  // title of the window 
        setSize(300, 150);              
        // size of the window 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        // operation for close button. 
        setLocationRelativeTo(null);   
        EmployeeLogin elog = new EmployeeLogin(); 
        // display window at the centre of the screen 
        // Create components 
        JLabel userLabel = new JLabel("Username:"); 
        JTextField userTextField = new JTextField(15); 
        JLabel passwordLabel = new JLabel("Password:"); 
        JPasswordField  passwordField = new JPasswordField(15); 
        JButton loginButton = new JButton("Login"); 
        JLabel errorLabel = new JLabel(" "); 
        
        setLayout(new GridLayout(3, 2)); 
        add(userLabel); 
        add(userTextField); 
        add(passwordLabel); 
        add(passwordField); 
        add(errorLabel);  // label to show error message 
        add(loginButton); 

        
        loginButton.addActionListener(new ActionListener() { 
        @Override 
        public void actionPerformed(ActionEvent e) { 
        String user = userTextField.getText(); 
        String password = new 
        String(passwordField.getPassword()); 
        //developed in exp 7 
        elog.setEmpId(user); 
        elog.setEmpPassword(password); 
        try{ 
        emp = elog.login();
        if ( emp instanceof Manager){      
            Manager manager = (Manager)emp ;
            setVisible(false);
            ManagerDashboard md = new ManagerDashboard(manager);
            md.setVisible(true) ;
        }   
        else{
            EmployeePane ep = new EmployeePane(emp);
            ep.setVisible(true);
        }
        
        cdlock.countDown();
        // close window without dispose 
        } 
        catch(Exception ne){ 
        errorLabel.setText("Wrong Employee ID"); 
        } 
  
        } 
        }); 
    
}
}
