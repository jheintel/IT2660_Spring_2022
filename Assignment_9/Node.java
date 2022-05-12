public class Node {
    private int value;
    private int numberOfEdges;
    private boolean pushed;

    public Node(int nodeValue){
        value = nodeValue;
        numberOfEdges = 0;
    }

    public Node deepCopy(){Node clone = new Node(value); return clone;}

    public int getValue(){return value;}
    public void setValue(int v){value = v;}

    public boolean getPushed(){return pushed;}
    public void setPushed(boolean b){pushed = b;}

    public int getNumOfEdges(){return numberOfEdges;}
    public void incrementNumberOfEdges(){numberOfEdges++;}

    public void println(Node n){
        System.out.println("Node " + value);
    }
    public void print(Node n){
        System.out.print(value);
    }
    public void visit(){
        print(this);
        System.out.print(", ");
    }
}
