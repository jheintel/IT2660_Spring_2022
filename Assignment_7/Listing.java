/*My JDE keeps adding these imports in and then telling me i'm not using them
probably becuse of me wildly typing something that makes no sense but has a corresponding import
then deleting that code*/

//import java.lang.reflect.Constructor;

public class Listing{
    private String name;
    private String address;
    private String number;
    private String idNumber;
    private String gpa;
    private Listing leftListing;
    private Listing rightListing;

    //Constructor takes values to be set
    public Listing(String n, String a, String num, String g){
        name = n;
        address = a;
        number = num;
        gpa = g;
        leftListing = rightListing = null; //all new nodes have no children and therefore get left and right Listings set to null
    }
    //Constructor to create a listing with just the students name
    public Listing(String n){name = n;}
    
    //Tostring takes a listing and orders and prints its data
    public String toString(){
        return ("Name:  " + name +
               "\nAddress: " + address +
               "\nNumber: " + number + 
               "\nID: " + idNumber +
               "\nGPA:" + gpa +
               "\n\n");
    }
    //make a copy that doesn't pass the original reference
    public Listing deepCopy(){
        Listing clone = new Listing(name, address, number, gpa);
        return clone;
    }
    //method to work alongside Strings .compareTo allowing strings and listings to be compared
    public int compareTo(String targetKey){
        return(name.compareTo(targetKey));
    }

    //Bunch of gets and sets
    //list not full
    //set name would require movement within the roster
    public String getName(){return name;}
    public void setAddress(String newAddress){address = newAddress;}
    public void setIdNumber(int id){idNumber = String.valueOf(id);}
    public String getIdNumber(){return idNumber;}
    
    public void setLeft(Listing l){leftListing = l;}
    public void setRight(Listing r){rightListing = r;}
    public Listing getLeft(){return leftListing;}
    public Listing getRight(){return rightListing;}


    public String getKey(){
        return (name);
    }
}