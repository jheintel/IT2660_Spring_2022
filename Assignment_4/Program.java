public class Program {
    public static void main (String args[]){
        LinkedList listy = new LinkedList(new Node<String>("D"));

        listy.appendNode(new Node<String>("E"));
        listy.appendNode(new Node<String>("F"));

        listy.insertNodeAtPosition(new Node<String>("A"), 0);
        listy.insertNodeAtPosition(new Node<String>("B"), 1);
        listy.insertNodeAtPosition(new Node<String>("C"), 2);
        listy.insertNodeAtPosition(new Node<String>("G"), 6);

        listy.print();
        System.out.println();
        listy.print(3);
    }
}
