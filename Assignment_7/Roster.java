/**
 * Roster creates a binary search tree out of Listing.java nodes
 */
public class Roster {
    private Listing root;
    private int idTracker; //will allow me to create sequential IDs for tree sorted students NOT used for lookup only reference

    public Roster(){
        root = null;
        idTracker = 0;
    }
    public Roster(Listing newRoot){
        root = newRoot.deepCopy();
        idTracker++; //every time a new student is created they get ID assigned from this tracker
    }

    /**
     * The public version of findStudent calls the private one. adds more detail to the call and allows the private function to recurse
     * @param student Name of the student being looked for as a string
     * @return the listing with that students "Key" in this case it's their name
     */
    public Listing findStudent(String student){return search(root, root, new Listing(student));}
    /**
     * this is called by the public find student to do the behind the scenes work
     * @param localRoot starts at root and iterates down the tree
     * @param parentListing keeps track of our current parent
     * @param student the listing we are searching for
     * @return
     */
    private Listing search(Listing localRoot, Listing parentListing, Listing student){
        if(localRoot == null || localRoot.getKey() == student.getKey())
            return localRoot;
        if(localRoot.getKey().compareTo(student.getKey())<0){
            parentListing = localRoot;
            localRoot = localRoot.getRight();
            return search(localRoot, parentListing, student);
        }
        else{
            parentListing = localRoot;
            localRoot = localRoot.getLeft();
            return search(localRoot, parentListing, student);
        } //I don't actually believe I use or test this. I know it works because I reuse the code in the delete method
          //I couldn't get delete to work otherwise because I needed delete to access both the parent and the child Listing
          //I took a shower and thought screw it I'll do what works for now and hope to learn my logic error when I'm older
    }

    /**
     * Overloaded method to create a student Listing
     * @param name takes a string and makes it into a listing within the Roster
     */
    public void addStudent(String name){
        addStudent(new Listing(name));
    }
    /**
     * Takes a listing and calls insert while incrementing the ID tracker
     * @param student adds this student to the Roster
     */
    public void addStudent(Listing student){
        idTracker++;
        root = insert(root, student);       
    }
    /**
     * Inserts the Student at its proper place within an unbalanced binary search tree
     * @param localRoot initially set at the root then interates through the tree
     * @param student the student to be added
     * @return returns the root of the Roster
     */
    private Listing insert(Listing localRoot, Listing student){
        if(localRoot == null){ //If root is null just drop the listing here and go home 
            student.setIdNumber(idTracker);
            localRoot = student;
            return localRoot;
        }
        if(localRoot.getKey().compareTo(student.getKey())>0){ //If our key smaller iterate down the left of the tree
            localRoot.setLeft(insert(localRoot.getLeft(), student));
        }
        else{                                                 //If key is larger iterate down right side of tree
            localRoot.setRight(insert(localRoot.getRight(), student));
        }
        return localRoot; //this return allows program to iterate down into itself while returning the roots to be used for the next pass
    }

    /**
     * This method hurt my feelings
     * It deletes Listings with the key given to it in this case the key is the name of the student
     * @param toDelete the name of the student we wish to execute
     * @param id not functioning at this time
     */
    public void deleteStudent(String toDelete, String id){
        Listing dummy = new Listing(toDelete); //create a dummy listing with the same key as the one we want to delete.
        delete(root, null, dummy, id);
    }
    /**
     * private function to ease the users heart adds more fields we need to find our Listing to delete
     * @param localRoot initially the Roster root, iterates with the method
     * @param parentListing keeps track of who out parent was so we can point or children to them
     * @param toDelete tracks the key we want gone
     * @param id I said this doesn't work and that I was sorry
     * @return needed for iterating otherwise returns null when a deletion occurs
     */
    private Listing delete(Listing localRoot, Listing parentListing, Listing toDelete, String id){
        if(localRoot.getKey().compareTo(toDelete.getKey())==0){
            Listing leftCheck = localRoot.getLeft();        //keeps track of our current Listings left and right children
            Listing rightCheck = localRoot.getRight();
            
            //delete if both child nodes are null and my favorite
            if(leftCheck == null && rightCheck == null){
                if(parentListing.getLeft() == localRoot){
                    parentListing.setLeft(null); //if the current Listing is on the left set parents left child to null
                }else{
                    parentListing.setRight(null);//if current listing is on right set parents right child to null
                }
                return null; //return null if deletion occurs
            }
    
            //Delete if one of the child nodes has value
            if(leftCheck != null && rightCheck == null || leftCheck == null && rightCheck != null){ //if either node has only one child
                if(parentListing.getLeft() == localRoot){             //If current node is on the left
                    if(localRoot.getLeft() != null){                  //If current nodes left child exists
                        parentListing.setLeft(localRoot.getLeft());   //point the parents left pointer at its left left grandchild
                    }
                    else{                                             //If current nodes right child exists
                        parentListing.setLeft(localRoot.getRight());  //point the parents left pointer at its left right grandchild
                    }
                    return null; //return null if deletion occurs
                }
                else{                                                 //If current node is on the right
                    if(localRoot.getLeft() != null){                  //If current nodes left child exists  
                        parentListing.setRight(localRoot.getLeft());  //Set the parents right pointer at its right left grandchild
                    }
                    else{                                             //If current nodes right child exits
                        parentListing.setRight(localRoot.getRight());  //Set the parents right pointer at its right right grandchild
                    }
                    return null; //return null if deletion occurs
                }
            }

            //Delete if both child nodes have values
            if(leftCheck != null && rightCheck != null){
                Listing nextLargest = localRoot.getLeft(); //create listings to track down the trees branches
                Listing largest = nextLargest.getRight();  //these will allow delete to find and point higher nodes to leaf nodes and vice versa
                if(largest != null){
                    while(largest.getRight()!=null){
                        nextLargest = largest;
                        largest = largest.getRight();
                    }
                    nextLargest.setLeft(largest.getLeft());
                    largest.setLeft(localRoot.getLeft());
                    largest.setRight(localRoot.getRight());
                }
                else{
                    nextLargest.setRight(localRoot.getRight());
                    if(parentListing.getLeft() == localRoot){
                        parentListing.setLeft(nextLargest);
                    }
                    else{
                        parentListing.setRight(nextLargest);
                    }
                }
                return null; //return null if deletion occurs
            }
        }
        
        //search through the tree if nothing was deleted sane code as search method but I needed to track multiple values
        if(localRoot.getKey().compareTo(toDelete.getKey())<0){
            parentListing = localRoot;
            localRoot = localRoot.getRight();
            localRoot = delete(localRoot, parentListing, toDelete, id);
        }
        else{
            parentListing = localRoot;
            localRoot = localRoot.getLeft();
            localRoot = delete(localRoot, parentListing, toDelete, id);
        } 
        return null;
    }

    /**
     * calls the printInOrder method
     */
    public void print(){
        printInOrder(root);
    }
    /**
     * Finds the next node to print in order and then prints it.
     * @param localRoot initially set to the Roster root then changes as method iterates
     */
    private void printInOrder(Listing localRoot){
        if (localRoot != null) {
            printInOrder(localRoot.getLeft());
            System.out.println(localRoot.getName());
            printInOrder(localRoot.getRight());
        }
    }
}
