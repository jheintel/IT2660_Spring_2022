public class Roster {
    private Listing root;
    private int size;

    public Roster(){
        root = null;
        size = 0;
    }
    public Roster(Listing newRoot){
        root = newRoot;
        size = 1;
    }

    
}
