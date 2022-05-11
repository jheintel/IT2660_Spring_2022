public class Listing{
    private String name;
    private String address;
    private String number;
    private String idNumber;
    private String gpa;
    private Listing leftListing;
    private Listing rightListing;

    public Listing(String n, String a, String num, String id, String g){
        name = n;
        address = a;
        number = num;
        idNumber = id;
        gpa = g;
    }
    public String toString(){
        return ("Name is  " + name +
               "\nAddress is " + address +
               "\nNumber is " + number + "\n\n");
    }
    public Listing deepCopy(){
        Listing clone = new Listing(name, address, number, idNumber, gpa);
        return clone;
    }
    public int compareTo(String targetKey){
        return(name.compareTo(targetKey));
    }

    public String getName(){return name;}
    //public void setName(String newName){name = newName;}
    public void setAddress(String newAddress){address = newAddress;}
    
    public void setLeft(Listing l){leftListing = l;}
    public void setRight(Listing r){rightListing = r;}

    public int getKey(){
        return name.hashCode()%100;
    }
}