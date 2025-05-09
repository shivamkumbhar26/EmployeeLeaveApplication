import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter; 


public class EmpLeaveRecord {

    public static ArrayList <EmpLeaveRecord> empLRecord = new ArrayList<>();

    public String empID ;
    public LocalDate startDate ; 
    public LocalDate endDate ; 
    public int leavesAvailable ; 
    public String reason ; 
    public String status ; 


    public EmpLeaveRecord( String id , LocalDate starDate , LocalDate endDate  , String reason  ){
        this.empID = id ; 
        this.startDate = starDate ; 
        this.endDate = endDate ; 
        this.reason = reason ; 
        this.status = "na" ;
    }

    public static void addLeaveRecord(EmpLeaveRecord e){
        empLRecord.add(e) ; 
        try{
            BufferedWriter br = new BufferedWriter( new FileWriter("empleaverecord.txt")) ; 
            br.write(e.empID+" "+e.leavesAvailable+" "+e.reason+" "+e.status);
            br.newLine();

        }catch(IOException ex){
            ex.printStackTrace(); 
        }
    }

    public static String checkLeaveStatus( String id ){
    
    

    
    return "not approved" ; 
    }


}
