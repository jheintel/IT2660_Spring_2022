import Plants.*;

//This class should be treated as a dynamic Array of Moss objects
//the theme of this stupid class was fun at first but now I'm cold on the inside
public class RollingStone {
    private int next;
    private int size;
    private Moss[] stoneFace;

    //basic constructor with no input
    public RollingStone(){
        this.next = 0;
        this.size = 5;
        this.stoneFace = new Moss[this.size];
    }
    //constructor with an input Moss
    public RollingStone(Moss growth){
        this.next = 1;
        this.size = 5;
        this.stoneFace = new Moss[this.size];
        this.stoneFace[0] = growth;
    }

    //return the Dynamic size of this array
    public int getSize(){
        return this.next;
    }

    //test function to return the actual size of the array object
    public int getTestIndex(){
        return stoneFace.length;
    }

    //print everything stored in the rollingStone
    public void print(){
        for(int i=0; i<this.next; i++){
            System.out.println(stoneFace[i].getName());
        }
    }

    //method to add a new growth to the end of the rollingStone
    public void addGrowth(Moss newGrowth){
        //if the length of the base array is reached make a larger one and store the old within the new
        if(this.next == this.size){
            int i =0;
            this.size+=5;
            Moss[] biggerStone= new Moss[this.size];
            while(i<this.next){
                biggerStone[i] = this.stoneFace[i];
                i++;
            }
            this.stoneFace = biggerStone;
        }
        this.stoneFace[this.next] = newGrowth;
        this.next++;
    }

    //return the Moss at a certain index
    public Moss fetchGrowth(int target){
        return stoneFace[target];
    }

    // return the index of a requested Moss
    public int findIndex(String target){
        for(int i=0; i<this.next; i++){
            if(this.stoneFace[i].getName().compareTo(target) == 0)
                return i;
        }
        //throw out a -1 of the Moss isn't found. Be a lot better to put an error handler for this
        return -1;
    }

    //delete a growth by name
    public void deleteGrowth(String toDelete){
        int i = 0;
        i=findIndex(toDelete);

        //cycle through replacing lower indexes with what was above them after the delete point
        while(i<this.next && i<this.size-1){
            stoneFace[i] = stoneFace[i+1];
            i++;
        }
        this.next--;

        //if our dynamic array becomes 5 smaller than our base array reduce the size of the base array
        if(this.next <= this.size-5){
            int j =0;
            this.size-=5;
            Moss[] smallerStone= new Moss[this.size];
            while(j<this.next){
                smallerStone[j] = this.stoneFace[j];
                j++;
            }
            this.stoneFace = smallerStone;
        }
    }

    //delete a growth by its index within the array
    public void deleteGrowth(int toDelete){
        int i = 0;
        i=toDelete;

        //cycle through replacing lower indexes with what was above them after the delete point
        while(i<this.next && i<this.size-1){
            stoneFace[i] = stoneFace[i+1];
            i++;
        }
        this.next--;

        //if our dynamic array becomes 5 smaller than our base array reduce the size of the base array
        if(this.next <= this.size-5){
            int j =0;
            this.size-=5;
            Moss[] smallerStone= new Moss[this.size];
            while(j<this.next){
                smallerStone[j] = this.stoneFace[j];
                j++;
            }
            this.stoneFace = smallerStone;
        }
    }

    //add a new moss in at a target index
    //might also be a fun idea to create a method to add a Moss after another specified Moss
    public void update(Moss newMoss, int targetIndex){
        int i = 0;
        Moss temp;
        while(i<=this.next){
            if(i>=targetIndex && i!=this.size){
                temp = this.stoneFace[i];
                stoneFace[i] = newMoss;
                newMoss = temp;
            } else if (i==this.size){
                this.addGrowth(newMoss);
                //if I don't reduce the next count here the previous IF statement runs again
                this.next--;
            }
            i++;
        }
        this.next++;
    }
}