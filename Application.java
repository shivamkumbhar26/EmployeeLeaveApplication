import java.util.concurrent.CountDownLatch;

public class Application {

    public static void main(String[] args) {
        
        CountDownLatch cdl = new CountDownLatch(1); 
        Employee emp; 
        LoginScreen log = new LoginScreen(cdl); 
        log.setVisible(true); 
        try { 
        cdl.await(); 
        } catch (InterruptedException ex) {} // return; 
        System.out.println("After Login Thread Returns"); 
        

    }

}


