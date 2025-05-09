import java.time.LocalDate; 

public class Employee extends User {
    private String employeeID;
    private String designation;
    private int salary;
    private boolean isManager;
    public int leavesTotal ; 
    public int leavesAvailable ; 

    

    public Employee(String fName, String mName, String lName, String email, String mobile, String birthdate, Address permanentAddress, 
                    String employeeID, int salary, String designation, boolean isManager , int leavesTotal , int leavesAvailable) {
       
        super( fName , mName , lName , email , mobile , birthdate , permanentAddress );        
        this.employeeID = employeeID;
        this.salary = salary;
        this.designation = designation;
        this.isManager = isManager;
        this.leavesTotal = leavesTotal ; 
        this.leavesAvailable = leavesAvailable ; 

    }
    
    public Employee(){
        super() ;
    }
    public String toCSV() {
        return fName + "," + mName+ "," + lName + "," + email + "," + mobile 
         + "," + birthdate  + "," + permanentAddress.getStreet() + "," + permanentAddress.getCity() + "," + permanentAddress.getState() + "," + permanentAddress.getZipCode() + "," + employeeID + "," + salary + "," + designation + "," +isManager 
         + "," + leavesTotal+ "," + leavesAvailable ;  // Example: Alice,25
    }
    
    public void fromCSV(String csv) {
        
        String[] parts = csv.split(",");
        Address address = new Address( parts[6],parts[7] ,parts[8] ,parts[9] ) ; 
        
        this.fName= parts[0].trim() ; this.mName = parts[1] ; this.lName = parts[2] ; this.email = parts[3] ; this.mobile = parts[4] ;
        this.birthdate = LocalDate.parse(parts[5]) ; this.permanentAddress = address ; this.employeeID = parts[10];
        this.salary = Integer.parseInt(parts[11]) ; this.designation = parts[12] ; this.isManager = Boolean.parseBoolean(parts[13] );
        this.leavesTotal = Integer.parseInt(parts[14]) ; this.leavesAvailable = Integer.parseInt(parts[15]) ; 
        
    }

    public String getEmployeeID() {
        return employeeID ;
    }

    public int getSalary() {
        return salary;
    }

    public String getDesignation() {
        return designation;
    }

    public boolean isManager() {
        return isManager;
    }

    
    

    public void displayEmployeeInfo() {
        super.displayUserInfo();
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Salary: " + salary);
        System.out.println("Designation: " + designation);
        System.out.println("Manager: " + isManager);
    }

}

// Employee(parts[0] , parts[1] , parts[2]  ,parts[3] ,parts[4]  , parts[5], permanentAddress , Integer.parseInt(parts[10]) , Integer.parseInt(parts[11]) , parts[12] , Boolean.parseBoolean(parts[13]) , Integer.parseInt(parts[14]),Integer.parseInt(parts[15]));
