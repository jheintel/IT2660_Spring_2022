import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentInfo {
    public static void main(String args[])
        throws IOException
    {
        Roster test = new Roster();
        menu(test);
        test.print();
    }

    public static void menu(Roster roster){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int choice;
        
        System.out.println("\033[H\033[2J"+
                           "Enter: 1 to insert a new student's information\n" +
                           "       2 to fetch and output a student's information\n" +
                           "       3 to delete a student's information\n" +
                           "       4 to update a student's information\n" +
                           "       5 to output all the student information in descending order\n"+
                           "       6 to exit the program");
        
        try {
            choice = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            choice = 0;
            e.printStackTrace();
        }
                   
        switch(choice){
            case 1: System.out.print("Enter Students name: ");
                try {
                    String name = reader.readLine();
                    roster.addStudent(name);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                break;
            
            
            case 6: break;
            default: 
                System.out.print("Command error exiting program\n" +
                                 "Press enter to continue...");
                try{System.in.read();}
                catch(Exception e){}
                break;
        }
    }
}