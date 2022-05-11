import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentInfo {
    public static void main(String args[])
        throws IOException
    {
        menu();
    }

    public void menu(){
        System.out.println("Enter: 1 to insert a new student's information\n" +
                           "       2 to fetch and output a student's information\n" +
                           "       3 to delete a student's information\n" +
                           "       4 to update a student's information\n" +
                           "       5 to output all the student information in descending order\n"+
                           "       6 to exit the program");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
                   
        System.out.println(name);
    }
}