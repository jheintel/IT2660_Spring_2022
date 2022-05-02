/**
 * This class makes a generic node to be used within LinkedList.java
 */
public class Node<T> {
    private T value;
    private Node<T> next;

    /**
     * ini for Node takes requires a data type at time of calling
     * Visual studio put the next line here. Not sure what is does yet
     * 
     * I'm back. I think this code makes little windows within VS Code when
     * I mouse over the call
     * @param nodeValue requires data type at time of calling
     */
    public Node(T nodeValue){
        value = nodeValue;
    }

    /**
     * return the value stored within the node
     * @return
     */
    public T getValue(){
        return value;
    }

    /**
     * returns the next node within the linked list
     * @return
     */
    public Node<T> getNext(){
        return next;
    }

    /**
     * set the next node within the linked list
     * @param nextNode
     */
    public void setNext(Node<T> nextNode){
        next = nextNode;
    }
}
