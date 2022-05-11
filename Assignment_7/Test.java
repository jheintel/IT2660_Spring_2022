public class Test {
    public static void main(String args[]){
        Listing a = new Listing("Jon", "Time Nexus", "1-111-1111", "83764","4.00");
        Listing b = a.deepCopy();

        b.setAddress("yesteryear");

        System.out.print(a.toString());
        System.out.print(b.toString());
        System.out.println("a's hashcode is: " + a.getKey());
    }
}
