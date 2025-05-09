import java.io.BufferedReader ; 
import java.io.FileReader ;
import java.io.IOException; 

public class EmployeeLogin {
    String id  ; 
    String password ; 

    EmployeeLogin(){
        
    }

    EmployeeLogin( String id , String pass ){
        this.id = id ; 
        this.password = pass; 
    }

    public void setEmpId( String empid){
        this.id = empid ; 
    }
    
    public void setPass( String password){
        this.password = password ; 
    }

    public boolean authentication(){
        try (BufferedReader reader = new BufferedReader(new FileReader("empauth.txt"))) {
            String line;
            
            while ((line = reader.readLine()) != null) {

                String[] part = line.split(" ") ; 
                if ( part[0].equals(this.id) ){
                    if ( part[1].equals(this.password) ){
                        return true ; 
                    }
                    else{
                        return false ; 
                    }
                }
               
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false ; 
        
    }

    public Employee getWho(){

        try (BufferedReader reader = new BufferedReader(new FileReader("EmpRecord.txt"))) {
                            
                String line ;           
                while ((line = reader.readLine()) != null) {
                                
                    String[] parts = line.split(",") ;
                        if( parts[10].equals(this.id) ){
                
                                    boolean isManager = Boolean.parseBoolean(parts[13]) ; 
                                    System.out.println(isManager);
                                    // Employee emp = new Employee(); // Create a new Employee instance
                                    // emp.fromCSV(line);
                                    Address address = new Address(parts[6], parts[7], parts[8], parts[9]) ; 
                                    if( isManager ){
                                        return new Manager( parts[0], parts[1], parts[2], parts[3], parts[4] , parts[5] , address , parts[10], Integer.parseInt(parts[11]), parts[12], Boolean.parseBoolean(parts[13]) , Integer.parseInt(parts[14]) , Integer.parseInt(parts[15] )); 
                                    }        
                                    else{
                                        return new Employee( parts[0], parts[1], parts[2], parts[3], parts[4] , parts[5] , address , parts[10], Integer.parseInt(parts[11]), parts[12], Boolean.parseBoolean(parts[13]) , Integer.parseInt(parts[14]) , Integer.parseInt(parts[15] )) ; 
                                    }     
                        }
                                 
                }
                            
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null ; 
    }
    

}




                        