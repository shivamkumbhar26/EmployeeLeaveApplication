import javax.swing.*;
import java.awt.GridLayout; 
import java.awt.event.*;
import java.time.LocalDate;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.time.format.DateTimeParseException;

public class Application {

   
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);




        JFrame f = new JFrame("User Form");
        f.setSize(1200, 600) ; 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        JLabel l1 = new JLabel("Username : ");
        JTextField t1 = new JTextField(20);
        JLabel l2 = new JLabel("Password : "); 
        JPasswordField t2 = new JPasswordField(20);
        JLabel errorLabel = new JLabel(" "); 
        
        JButton b = new JButton("Log in"); 
        
        f.setLocationRelativeTo(null);  

        f.setLayout(new GridLayout(3, 2)); 
        f.add(l1); 
        f.add(t1); 
        f.add(l2); 
        f.add(t2); 
        f.add(errorLabel);  // empty label to create space before button 
        f.add(b); 
        f.setVisible(true);

        b.addActionListener(new ActionListener() {        
        Employee employee;
        EmpLeaveRecord empLRecord;
        String reason;
        String id;
        EmployeeLogin eLogin = new EmployeeLogin() ; 
        boolean exit = false;
        String st, end;
        LocalDate stDate = null, endDate = null;
            @Override 
            public void actionPerformed(ActionEvent e) { // e is ActionEvent here
                String user = t1.getText(); 
                String password = new String(t2.getPassword()); 
        
                eLogin.setEmpId(user); 
                eLogin.setPass(password); 
        
                try { 
                    if (eLogin.authentication()) {
                        Employee emp = eLogin.getWho();  
                        if (emp instanceof Manager) {
                            Manager m = (Manager) emp;
        
                            do {
                                System.out.println("Choose which task you want to perform: ");
                                System.out.println("1) Add Employee\n2) Manage Leaves\n3) Load All Employees Data\n4) Display Employees\n5) Exit From Manager");
                                int choice = sc.nextInt();
                                sc.nextLine();
        
                                if (choice == 1) {
                                    while (true) {
                                        System.out.println("IF YOU WANT TO ADD MORE EMPLOYEE PRESS 'y' ELSE PRESS 'n': ");
                                        char c = sc.next().charAt(0);
                                        sc.nextLine();
        
                                        if (c == 'n' || c == 'N') {
                                            break;
                                        }
        
                                        Address address = new Address("sarnobatwadi", "kolhapur", "Maharashtra", "416004");
                                        employee = new Employee("Shivam", "Suresh", "Kumbhar", "shivamk@example.com", "1234567890", "2005-12-26", address, String.format("emp%03d", m.empID), 50000, "Developer", false, 30, 30);
        
                                        m.addEmployee(employee);
                                        m.saveVariables(); 
                                        m.saveEmployee();
                                    }
                                } else if (choice == 2) {
                                    System.out.println("Enter employee id: ");
                                    id = sc.nextLine();
        
                                    m.approveLeave(id);
                                } else if (choice == 3) {
                                    m.loadEmployee();
                                    m.loadVariables(); 
                                } else if (choice == 4) {
                                    m.display();
                                } else if (choice == 5) {
                                    break;
                                }
                            } while (true);
                        } else {
                            do {
                                System.out.println("1) Apply for Leave\n2) Check Leave Status\n3) Exit From Employee");
                                int choice = sc.nextInt();
                                sc.nextLine();
        
                                if (choice == 1) {
                                    System.out.println("Enter start date from which you want to take a leave (yyyy-MM-dd): ");
                                    st = sc.nextLine().trim();
                                    System.out.println("Enter end date up to which you want leave (yyyy-MM-dd): ");
                                    end = sc.nextLine().trim();
        
                                    try {
                                        stDate = LocalDate.parse(st);
                                        endDate = LocalDate.parse(end);
        
                                        if (endDate.isBefore(stDate)) {
                                            System.out.println("Error: End date cannot be before start date.");
                                        } else {
                                            System.out.println("Leave applied from " + stDate + " to " + endDate);
                                        }
                                    } catch (DateTimeParseException ex) {
                                        System.out.println("Invalid date format. Please use yyyy-MM-dd.");
                                    }
        
                                    System.out.println("Enter reason why you are taking leave");
                                    reason = sc.nextLine();
        
                                    empLRecord = new EmpLeaveRecord(emp.getEmployeeID(), stDate, endDate, reason);
                                    EmpLeaveRecord.addLeaveRecord(empLRecord);
        
                                } else if (choice == 2) {
                                    System.out.println("Enter employee id to check leave status");
                                    id = sc.nextLine();
                                    System.out.println("Status : " + EmpLeaveRecord.checkLeaveStatus(id));
        
                                } else if (choice == 3) {
                                    break;
                                }
                            } while (true);
                        }
                    } 
                } catch (Exception ex) { // changed 'ne' to 'ex' for clarity
                    System.out.println("Wrong id or password");
                }
            }
        });
        



        

  

//  EMPLOYEE         MANAGER          EXIT 
//                 System.out.println("Enter the empID  : ");
//                 String yourID = sc.nextLine() ; 
//                 System.out.println("Enter password : ");
//                 String myPass = sc.nextLine() ; 
//                 eLogin = new EmployeeLogin(yourID, myPass) ; 
// if( eLogin.authentication() ) {
//     System.out.println("login successful ! ");

//     Employee emp = eLogin.getWho() ; 
//     if ( emp instanceof Manager ){
//                 Manager m = (Manager)emp ; 
                
//                 do{
//                 System.out.println("Choose which task you want to perform : ");
//                 System.out.println("\n1) Add Employee\n2) Manage Leaves \n3) Load All Employees Data \n4) Display Employees \n5) Exit From Manager");
//                 int choice = sc.nextInt();
//                 sc.nextLine();

//                     if (choice == 1) {
//                         while (true) {
//                             System.out.println("IF YOU WANT TO ADD MORE EMPLOYEE PRESS 'y' ELSE PRESS 'n' : ");
//                             char c = sc.next().charAt(0);
//                            sc.nextLine();

//                             if (c == 'n' || c == 'N') {
//                                break;
//                            }

//                             Address address = new Address("sarnobatwadi", "kolhapur", "Maharashtra", "416004");
//                             employee = new Employee("Shivam", "Suresh", "Kumbhar", "shivamk@example.com", "1234567890", "2005-12-26", address, String.format("emp%03d", m.empID ), 50000, "Developer", false, 30, 30);

//                             m.addEmployee(employee);
//                             m.saveVariables(); 
//                             m.saveEmployee();
//                         }
//                     } 
//                     else if (choice == 2) {
//                         System.out.println("Enter employee id: ");
//                         id = sc.nextLine();
//                         sc.nextLine();

//                         m.approveLeave(id);

                    
//                     } else if ( choice == 3 ){
//                         m.loadEmployee();
//                         m.loadVariables(); 
//                     } else if ( choice == 4 ){
//                         m.display();
//                     } else if ( choice == 5 ){
//                         break ; 
//                     }
//                 }while ( true ) ;

//     } 
//     else{
//                 do{
//                     System.out.println("\n 1) Apply for Leave \n2) Check Leave Status \n3) Exit From Employee ");
//                     int choice = sc.nextInt();
//                     sc.nextLine();

//                     if (choice == 1) {


//                         System.out.println("Enter start date from which you want to take a leave (yyyy-MM-dd): ");
//                         st = sc.nextLine().trim();
//                         System.out.println("Enter end date up to which you want leave (yyyy-MM-dd): ");
//                         end = sc.nextLine().trim();

                   

//                         try {
//                             stDate = LocalDate.parse(st);
//                             endDate = LocalDate.parse(end);

//                             if (endDate.isBefore(stDate)) {
//                             System.out.println("Error: End date cannot be before start date.");
//                             } else {
//                                 System.out.println("Leave applied from " + stDate + " to " + endDate);
//                             }
//                         } catch (DateTimeParseException e) {
//                             System.out.println("Invalid date format. Please use yyyy-MM-dd.");
//                         }

//                         System.out.println("Enter reason why you are taking leave");
//                         reason = sc.nextLine();

//                         empLRecord = new EmpLeaveRecord( emp.getEmployeeID() , stDate, endDate, reason);
//                         EmpLeaveRecord.addLeaveRecord(empLRecord);

//                     } 

//                     else if (choice == 2) {

//                         System.out.println("Enter employee id to check leave status");
//                         id = sc.nextLine();
//                         sc.nextLine();
//                         System.out.println("Status : " + EmpLeaveRecord.checkLeaveStatus(id));

//                     } else if ( choice == 3 ){
//                         break ; 
//                     }
//                 }while ( true ) ;

//     }

// }
// else {
//     System.out.println(" login failed ! ");
// }





















                //     MANAGER      SECTION 
            //     do{
            //     System.out.println("Choose which task you want to perform : ");
            //     System.out.println("\n1) Add Employee\n2) Manage Leaves \n3) Load All Employees Data \n4) Display Employees \n5) Exit From Manager");
            //     int choice = sc.nextInt();
            //     sc.nextLine();

            //         if (choice == 1) {
            //             while (true) {
            //                 System.out.println("IF YOU WANT TO ADD MORE EMPLOYEE PRESS 'y' ELSE PRESS 'n' : ");
            //                 char c = sc.next().charAt(0);
            //                sc.nextLine();

            //                 if (c == 'n' || c == 'N') {
            //                    break;
            //                }

            //                 Address address = new Address("sarnobatwadi", "kolhapur", "Maharashtra", "416004");
            //                 employee = new Employee("Shivam", "Suresh", "Kumbhar", "shivamk@example.com", "1234567890", "2005-12-26", address, String.format("emp%03d", m.empID ), 50000, "Developer", false, 30, 30);

            //                 m.addEmployee(employee);
            //                 m.saveVariables(); 
            //                 m.saveEmployee();
            //             }
            //         } 
            //         else if (choice == 2) {
            //             System.out.println("Enter employee id: ");
            //             id = sc.nextLine();
            //             sc.nextLine();

            //             m.approveLeave(id);

                    
            //         } else if ( choice == 3 ){
            //             m.loadEmployee();
            //             m.loadVariables(); 
            //         } else if ( choice == 4 ){
            //             m.display();
            //         } else if ( choice == 5 ){
            //             break ; 
            //         }
            //     }while ( true ) ;
             

            //     //   EMPLOYEE     SECTION 
            

            //     do{
            //         System.out.println("\n 1) Apply for Leave \n2) Check Leave Status \n3) Exit From Employee ");
            //         int choice = sc.nextInt();
            //         sc.nextLine();

            //         if (choice == 1) {

            //             System.out.println("Enter your id ");
            //             id = sc.nextLine();
            //             sc.nextLine();

            //             System.out.println("Enter start date from which you want to take a leave (yyyy-MM-dd): ");
            //             st = sc.nextLine().trim();
            //             System.out.println("Enter end date up to which you want leave (yyyy-MM-dd): ");
            //             end = sc.nextLine().trim();

                   

            //             try {
            //                 stDate = LocalDate.parse(st);
            //                 endDate = LocalDate.parse(end);

            //                 if (endDate.isBefore(stDate)) {
            //                 System.out.println("Error: End date cannot be before start date.");
            //                 } else {
            //                     System.out.println("Leave applied from " + stDate + " to " + endDate);
            //                 }
            //             } catch (DateTimeParseException e) {
            //                 System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            //             }

            //             System.out.println("Enter reason why you are taking leave");
            //             reason = sc.nextLine();

            //             empLRecord = new EmpLeaveRecord(id, stDate, endDate, reason);
            //             m.addLeaveRecord(empLRecord);

            //         } 

            //         else if (choice == 2) {

            //             System.out.println("Enter employee id to check leave status");
            //             id = sc.nextLine();
            //             sc.nextLine();
            //             System.out.println("Status : " + m.checkLeaveStatus(id));

            //         } else if ( choice == 3 ){
            //             break ; 
            //         }
            //     }while ( true ) ;
            } 

                //  EXIT 


          
        

        
     
    
}


