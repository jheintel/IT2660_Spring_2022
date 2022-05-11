public class Listing{
    private String name;
    private String address;
    private String number;

    public Listing(String n, String a, String num){
        name = n;
        address = a;
        number = num;
    }
    public String toString(){
        return ("Name is  " + name +
               "\nAddress is " + address +
               "\nNumber is " + number + "\n");
    }
    public Listing deepCopy(){
        Listing clone = new Listing(name, address, number);
        return clone;
    }
    public int compareTo(String targetKey){
        return(name.compareTo(targetKey));
    }

}