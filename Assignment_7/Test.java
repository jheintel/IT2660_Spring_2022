import java.util.List;

public class Test {
    public static void main(String args[]){
        Listing a = new Listing("Jon", "Time Nexus", "1-111-1111");
        Listing b = a.deepCopy();

        System.out.print(b.toString());
    }
}
