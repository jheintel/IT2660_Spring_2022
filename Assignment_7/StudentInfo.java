import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * DONT BOTHER READING THROUGH THIS FILE UNLESS YOU'RE BORED
 * 
 * This interface is not finished but I am moving on to the final
 * The code within Test.java shows functionality of the binary search tree
 * What needs to be done here is to link the functions to the interface
 * and store the binary tree into a written txt file
 */

/**
 * A lite gui for manipulating a saved binary search tree holding student listings
 */
public class StudentInfo {
    public static void main(String args[])
        throws IOException
    {
        Roster test = new Roster();
        menu(test);
        test.print();
    }

    /**
     * Takes a roster and displays an options menu of functions that
     * manipulate the roster
     * @param roster Roster to be manipulated
     */
    public static void menu(Roster roster){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int choice;
        
        System.out.println("\033[H\033[2J"+ //clears the terminal
                           "Enter: 1 to insert a new student's information\n" +
                           "       2 to fetch and output a student's information\n" +
                           "       3 to delete a student's information\n" +
                           "       4 to update a student's information\n" +
                           "       5 to output all the student information in descending order\n"+
                           "       6 to exit the program");
        
        try { //Try to read a string and throw an exception if that fails
            choice = Integer.parseInt(reader.readLine()); //parse correctly entered values into integer values
        } catch (IOException e) {
            choice = 0;
            e.printStackTrace();
        }
        
        //match the choice from the terminal input to a function
        switch(choice){
            case 1: System.out.print("Enter Students name: "); //inserts a new student by name
                try {
                    String name = reader.readLine();
                    roster.addStudent(name);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                break;

            // Other cases would be put here!
            
            
            case 6: break;                                          //exits the program
            default:                                                //yells at you AND exits the program
                System.out.print("Command error exiting program\n" +
                                 "Press enter to continue...");
                try{System.in.read();}
                catch(Exception e){}
                break;
        }
    }
}