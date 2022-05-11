/**
 * Test.java is a driver file for Roster.java binary search tree
 */
public class Test {
    public static void main(String args[]){
        //Make some listings. Manipulate them. Print the results. 
        Listing a = new Listing("Jon", "Time Nexus", "1-111-1111", "4.00");
        Listing b = a.deepCopy();
        b.setAddress("yesteryear");
        
        System.out.print(a.toString());
        System.out.print(b.toString());
        System.out.println("a's hashcode is: " + a.getKey());

        System.out.println();

        //Make a Roster named bigWoobly and populate it with names that are converted into listings
        //Only the previously made listings have all data fields entered
        Roster bigWoobly = new Roster();
        bigWoobly.addStudent(new Listing("Henry"));
        bigWoobly.addStudent(new Listing("Sarah"));
        bigWoobly.addStudent("Woofy");
        bigWoobly.addStudent("Bill");
        bigWoobly.addStudent("Saxophone");
        bigWoobly.addStudent("Lucifer");
        bigWoobly.addStudent(a);
        bigWoobly.addStudent(b);            //This adds a second Jon which breaks delete unless I implement ID checking. Nice job me! NO TIME
        bigWoobly.addStudent("Jane"); //Throw in some more J names to make sure the program is sorting well
        bigWoobly.addStudent("Jxl");
        
        //This print would show the roster before the deletions
        //System.out.println("The Roster bigWoobly:");
        //bigWoobly.print();

        //Each of these deletes covers one of the three cases for a binary search tree
        //the TEST variable is not used but when properly coded would make sure we were deleting by name and student ID
        bigWoobly.deleteStudent("Bill", "7 TEST");
        bigWoobly.deleteStudent("Lucifer", "TEST");
        bigWoobly.deleteStudent("Jane", "TEST");

        System.out.println("The Roster bigWoobly:");
        bigWoobly.print();
    }
}
