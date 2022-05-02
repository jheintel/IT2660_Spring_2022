/**
 * Creates a linked list that tracks the root node, the last node,
 * and the size of the list
 */
public class LinkedList {
    private Node root;
    private Node last;
    private int size;

    /**
     * initialize LinkedList with a root Node
     * @param freshRoots the first node in a new LinkedList
     */
    public LinkedList(Node freshRoots)  {
        root = freshRoots; //set this Node as the first and last Node
        last = freshRoots;
        size = 1;          //size set to 1
    }

    /**
     * Takes a Node and adds it at the end of this LinkedList
     * @param node Node to put at end of List
     */
    public void appendNode(Node node){
        last.setNext(node); // Make the previously last Node point to parameter Node
        last = node;        // Set parameter Node to the last Node
        size++;             // increase LinkedList size
    }

    /**
     * Takes a Node and a position and decides which method should be used to insert the Node
     * @param node Node to be inserted
     * @param position Position in the LinkedList to insert new Node
     */
    public void insertNodeAtPosition(Node node, int position){
        if(position == 0){            // if root position is requested call insertNewRoot
            insertNewRoot(node);
        } else if(position == size) { // if last position is requested just append the node
            appendNode(node);
        } else{
            insert(node, position);   // for all other cases call private insert method
        }
    }

    /**
     * Takes a Node and sets it as the new root of a LinkedList that already exists
     * @param node Node to be set as the root of this LinkedList
     */
    private void insertNewRoot(Node node){
        node.setNext(root); // Set the old root as the Node after parameter Node
        root = node;        // Set parameter Node as the root
        size++;
    }

    /**
     * Takes a Node and inserts it at a Position
     * @param node Node to be inserted into LinkedList
     * @param position Position to insert the new Node
     */
    private void insert(Node node, int position){
        Node targetNode = getNode(position-1); //set targetNode to the node before the requested position
        node.setNext(targetNode.getNext());    //set the new Node's nextNode to the node after the targetNode
        targetNode.setNext(node);              //set new Node as the node following targetNode
        size++;
    }

    /**
     * Takes an integer and returns the node at that position in the LinkedList
     * @param position The position of the node being looked for
     * @return Returns the node at the requested position
     */
    private Node getNode(int position){
        Node walker = root;                 //walker is set a the next node a number of times requested by position
        for(int i = 0; i < position; i++){
            walker = walker.getNext();
        }
        return walker;
    }

    /**
     * print() is a special case that prints from the root
     */
    public void print(){
        print(0);
    }
    /**
     * Takes an integer position and then prints form that Node to the end of the LinkedList
     * @param position Position in the List to start printing from
     */
    public void print(int position){
        Node walker = root;
        for(int i = 0; i < size; i++){
            if(i >= position)
                System.out.print(walker.getValue() + " ");
            walker = walker.getNext();
        }
    }
}
