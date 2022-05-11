public class Test {
    public static void main(String args[]){
        Listing a = new Listing("Jon", "Time Nexus", "1-111-1111", "4.00");
        Listing b = a.deepCopy();
        

        Roster bigWoobly = new Roster();
        bigWoobly.addStudent(new Listing("Henry"));
        bigWoobly.addStudent(new Listing("Sarah"));
        bigWoobly.addStudent(new Listing("Jon"));
        bigWoobly.addStudent(new Listing("Bill"));
        bigWoobly.addStudent(new Listing("Saxophone"));
        bigWoobly.addStudent(new Listing("Lucifer"));
        bigWoobly.addStudent(a);
        bigWoobly.addStudent(b);
        bigWoobly.addStudent(new Listing("Jane"));
        bigWoobly.addStudent(new Listing("Jxl"));
        
        bigWoobly.deleteStudent("Bill", "7 TEST");
        //bigWoobly.deleteStudent("Lucifer", "TEST");

        b.setAddress("yesteryear");

        System.out.print(a.toString());
        System.out.print(b.toString());
        System.out.println("a's hashcode is: " + a.getKey());

        System.out.println("The Roster bigWoobly:");
        bigWoobly.print();
    }
}
