import javax.swing.*;
import java.awt.event.ActionListener ; 
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.awt.*;

public class ManagerDashboard extends JFrame{

    
        public ManagerDashboard(Manager manager) {
            setTitle("Manager Dashboard");
            setSize(600, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setLayout(new FlowLayout());
            
            JLabel name = new JLabel("Employee Name : " + manager.getFirstName());
            add(name);
            add(new JLabel());
            JLabel designation = new JLabel("Designation : " + manager.getDesignation());
            add(designation); 
            JLabel isManager = new JLabel("Manager : " + manager.isManager()); 
            add(isManager);
            JLabel totalLeaves = new JLabel("Total Leaves : " + manager.leavesTotal );
            add(totalLeaves); 
            JLabel availableLeaves = new JLabel("Leaves Available : " + manager.leavesAvailable); 
            add(availableLeaves);

            

            JButton applyLeaveBtn = new JButton("Apply Leave"); 
            JButton viewLeaveStatusBtn = new JButton("View Leave Status"); 
            JButton viewLeavesBtn = new JButton("view Leaves"); 
            JLabel errorLabel = new JLabel(" "); 
            add(applyLeaveBtn); add(viewLeaveStatusBtn);add(viewLeavesBtn);add(errorLabel) ; 
            
            
           
          
          
    
            // Add your buttons and actions here (Add Employee, Approve Leave, etc.)
    
            setVisible(true);
        }
    
    
    
}
