import java.util.ArrayList ;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Period; 

public class Manager extends Employee{
    private static final String FILE_NAME = "EmpRecord.txt";
    private static final String variables = "variables.txt";
    public int empID ; 

    public ArrayList<Employee> empRecord ;
    private ArrayList<EmpLeaveRecord> empLRecord ;  // ArrayList to store employee records
    private int empCount ; // to keep track of the number of employees
// to generate unique employee ID
    
    public Manager(){

        empRecord = new ArrayList<>();
        empLRecord = new ArrayList<>() ;
        empCount = 0 ; 
        empID = 1 ; 

    }


    public Manager( String fName, String mName, String lName, String email, String mobile, String birthdate, Address permanentAddress, 
    String employeeID, int salary, String designation, boolean isManager , int leavesTotal , int leavesAvailable ) {
        super(  fName,  mName,  lName,  email,  mobile,  birthdate,  permanentAddress,  employeeID,  salary,  designation,  isManager ,  leavesTotal ,  leavesAvailable) ; 
        empRecord = new ArrayList<>();
        empLRecord = new ArrayList<>() ;
        empCount = 0 ; 
        empID = 1 ; 

        }
    
    
    public void addEmployee(Employee emp) {
        empRecord.add(emp);
        empCount++;
        empID++;
    
    }

    public void addLeaveRecord(EmpLeaveRecord employeeLeaveRecord ) {
        empLRecord.add(employeeLeaveRecord);
    }

    public void approveLeave( String id ){
        int days ;
        int indexInEmpRecord = 0 ;
          
        while ( empRecord.get(indexInEmpRecord).getEmployeeID() != id ){
            indexInEmpRecord++; 
        }
        for ( int i = 0 ; i < empLRecord.size() ; i ++ ) {
             if ( empLRecord.get(i).empID == id ){
                days = Period.between(empLRecord.get(i).startDate , empLRecord.get(i).endDate ).getDays() ;
                if ( days <= empRecord.get(indexInEmpRecord).leavesAvailable ){
                    empRecord.get(indexInEmpRecord).leavesAvailable -= days ;
                    empLRecord.get(i).status = "approved" ; 
                } 
                else{
                    System.out.println("Not enough leaves available");
                }
             }
        }
    }


    public  void saveEmployee() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Employee e : empRecord) {
                writer.write(e.toCSV()); // Convert object to CSV and write
                writer.newLine(); // New line for each entry
            }
            System.out.println("ArrayList saved to text file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadEmployee() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                Employee emp = new Employee(); // Create a new Employee instance
                emp.fromCSV(line); // Convert CSV string to Employee object
                this.empRecord.add(emp); // Add it to the list
            }
            System.out.println("Employees loaded successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void saveVariables(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(variables))) {
            writer.write( empCount +","+ empID);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void loadVariables(){
        try (BufferedReader reader = new BufferedReader(new FileReader(variables))) {
            String line;
            line = reader.readLine() ; 
                String[] parts = line.split(",");
                this.empCount = Integer.parseInt(parts[0]);
                this.empID = Integer.parseInt(parts[1]) ;  
        }  
        catch (IOException e) {
            e.printStackTrace();
        }   


    }

    public  String checkLeaveStatus ( String id ){
        int i = 0 , flag = 0 ;
        for ( ; i < empLRecord.size() ; i ++ ) {
            if ( empLRecord.get(i).empID == id ){
                flag = 1 ; 
                return (empLRecord.get(i).status) ; 
                }
        }
        if ( flag == 0 ){
            return "No leave record found" ;
        }
        return "na" ; 
    }
        

    public void display(){
        for(Employee e : empRecord ){

            System.out.println("Name : " + e.getFirstName() + " " + e.getLastName());
            System.out.println("Emp ID :  " + e.getEmployeeID());
            System.out.println("Designation : " + e.getDesignation());
            System.out.println("----------------------------");

        }

    }

}
