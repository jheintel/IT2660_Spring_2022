public class Node {
    private int value;
    private int numberOfEdges;

    public Node(int nodeValue){
        value = nodeValue;
        numberOfEdges = 0;
    }

    public int getValue(){
        return value;
    }
    public void setValue(int v){
        value = v;
    }

    public int getNumOfEdges(){
        return numberOfEdges;
    }
    public void incrementNumberOfEdges(){
        numberOfEdges++;
    }

    //This code returns if I need to make the nodes linked lists
    /*public Node getNext(){
        return next;
    }

    public void setNext(Node nextNode){
        next = nextNode;
    }*/

    public Node deepCopy(){
        Node clone = new Node(value);
        return clone;
    }
}
