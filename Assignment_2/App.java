import Plants.*;
// import DynamicArray.*;

public class App {
    public static void main(String[] args) throws Exception {
        
        // I make a moss named Fred using an abstract class and an interface.
        Moss test = new Moss("Fred");

        System.out.println(test.getName());
        pressAnyKeyToContinue();
    }

    public static void pressAnyKeyToContinue()
    { 
           System.out.println("Press Enter key to continue...");
           try
           {
               System.in.read();
           }  
           catch(Exception e)
           {}  
    }
}
