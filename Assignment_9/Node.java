/**
 * Recycled Node class from linked list assignment
 * Should rename to Vertex if motivation strikes
 * 
 * Stores values of the vertices
 * tracks the number of edges each vertex has to check if at max capacity
 * tracks if they have been pushed onto the stack so that the Depth-First traversal method doesn't pass over them twice
 */
public class Node {
    private int value;
    private int numberOfEdges;
    private int maxNumOfEdges;
    private boolean pushed;

    /**
     * Initialize a vertex with a value
     * @param nodeValue Value stored within this vertex
     */
    public Node(int nodeValue){
        value = nodeValue;
        numberOfEdges = 0; //a new vertex has no edges
    }
    public Node deepCopy(){Node clone = new Node(value); return clone;} //return the value without passing the object
    
    public int getValue(){return value;}                       //Get and set for the vertex value
    public void setValue(int v){value = v;}

    public boolean getPushed(){return pushed;}                 //get and set for boolean tracking pushed or popped
    public void setPushed(boolean b){pushed = b;}

    public int getNumOfEdges(){return numberOfEdges;}          //get and set for number of edges
    public void setNumOfEdges(int e){numberOfEdges = e;}
    public int getMaxNumOfEdges(){return maxNumOfEdges;}
    public void setMaxNumOfEdges(int m){maxNumOfEdges = m;}
    public void incrementNumberOfEdges(){numberOfEdges++;}     //more useful increment number of edges
    

    //Print methods are used for various tests
    public void println(Node n){                               //prints value stored by vertex with some formatting
        System.out.println("Node value is: " + value);
    }
    public void print(Node n){                                 //prints value with no formatting 
        System.out.print(value);
    }
    public void visit(){                                       //prints the address of the object
        print(this);
        System.out.print(", ");
    }
}
