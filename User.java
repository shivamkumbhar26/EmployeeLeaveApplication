import java.time.LocalDate;

public class User {
   
    public String fName , lName, mName, email, mobile;
    public LocalDate birthdate;
    public Address permanentAddress;

    public User(String fName, String mName, String lName, String email, String mobile, String birthdate, Address permanentAddress) {
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;
        this.email = email;
        this.mobile = mobile;
        this.birthdate = LocalDate.parse(birthdate);
        this.permanentAddress = permanentAddress;
    }

    public User(){
        
    }

    public void displayUserInfo(){
        System.out.println("Name: " + fName + " " + mName + " " + lName);
        System.out.println("Email: " + email);
        System.out.println("Mobile: " + mobile);
        System.out.println("Birthdate: " + birthdate);
        System.out.println("Address: " + permanentAddress);
    }

    public String getFirstName() {
        return fName;
    }

    public String getMiddleName() {
        return mName;
    }

    public String getLastName() {
        return lName;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public Address getPermanentAddress() {
        return permanentAddress;
    }


}
