public class Listing{
    private String name;
    private String address;
    private String number;
    private String idNumber;
    private String gpa;
    private Listing leftListing;
    private Listing rightListing;

    public Listing(String n, String a, String num, String g){
        name = n;
        address = a;
        number = num;
        gpa = g;
        leftListing = rightListing = null;
    }
    public Listing(String n){name = n;}
    public String toString(){
        return ("Name:  " + name +
               "\nAddress: " + address +
               "\nNumber: " + number + 
               "\nID: " + idNumber +
               "\nGPA:" + gpa +
               "\n\n");
    }
    public Listing deepCopy(){
        Listing clone = new Listing(name, address, number, gpa);
        return clone;
    }
    public int compareTo(String targetKey){
        return(name.compareTo(targetKey));
    }

    public String getName(){return name;}
    //public void setName(String newName){name = newName;}
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