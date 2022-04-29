
import Plants.*;
public class RollingStone {
    private int next;
    private int size;
    private Moss[] stoneFace;

    public RollingStone(){
        this.next = 0;
        this.size = 5;
        this.stoneFace = new Moss[this.size];
    }
    public RollingStone(Moss growth){
        this.next = 1;
        this.size = 5;
        this.stoneFace = new Moss[this.size];
        this.stoneFace[0] = growth;
    }

    public void print(){
        for(int i=0; i+2<this.next; i++){
            System.out.println(stoneFace[i].getName());
        }
    }

    public void addGrowth(Moss newGrowth){
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
        this.stoneFace[next] = newGrowth;
        this.next++;
    }

    public Moss fetchGrowth(String target){
        return stoneFace[this.findIndex(target)];
    }

    public int findIndex(String target){
        for(int i=0; i<this.size; i++){
            if(this.stoneFace[i].getName().compareTo(target) == 0)
                return i;
        }
        return -1;
    }

    public void deleteGrowth(String toDelete){
        int i = 0;
        i=findIndex(toDelete);

        while(i<(next)){
            stoneFace[i] = stoneFace[i+1];
            i++;
        }
        this.next--;
    }

    public void update(Moss newMoss, int targetIndex){
        int i = 0;
        Moss temp;
        while(i<this.next){
            if(i>=targetIndex && this.next<=this.size){
                temp = this.stoneFace[i];
                stoneFace[i] = newMoss;
                newMoss = temp;
            }
            
            i++;
        }
        this.next++;
    }
}