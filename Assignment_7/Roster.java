public class Roster {
    private Listing root;
    private int idTracker;

    public Roster(){
        root = null;
        idTracker = 0;
    }
    public Roster(Listing newRoot){
        root = newRoot.deepCopy();
        idTracker++;
    }

    public boolean findStudent(Listing student){return search(root, root, student);}
    private boolean search(Listing localRoot, Listing parentListing, Listing student){
        if(localRoot == null || localRoot.getKey() == student.getKey())
            return true;
        if(localRoot.getKey().compareTo(student.getKey())<0){
            parentListing = localRoot;
            localRoot = localRoot.getRight();
            return search(localRoot, parentListing, student);
        }
        else{
            parentListing = localRoot;
            localRoot = localRoot.getLeft();
            return search(localRoot, parentListing, student);
        }
    }

    
    public void addStudent(String name){
        addStudent(new Listing(name));
    }
    public void addStudent(Listing student){
        idTracker++;
        root = insert(root, student);       
    }
    private Listing insert(Listing localRoot, Listing student){
        if(localRoot == null){
            student.setIdNumber(idTracker);
            localRoot = student;
            return localRoot;
        }
        if(localRoot.getKey().compareTo(student.getKey())>0){
            localRoot.setLeft(insert(localRoot.getLeft(), student));
        }
        else{
            localRoot.setRight(insert(localRoot.getRight(), student));
        }
        return localRoot;
    }

    public boolean deleteStudent(String toDelete, String id){
        Listing dummy = new Listing(toDelete);
        return delete(root, null, dummy, id);
    }
    private boolean delete(Listing localRoot, Listing parentListing, Listing toDelete, String id){
        search(localRoot, parentListing, toDelete);
        Listing leftCheck = localRoot.getLeft();
        Listing rightCheck = localRoot.getRight();
        
        if(localRoot == null){
            return false;
        }
        if(leftCheck == null && rightCheck == null){
            if(parentListing.getLeft() == localRoot){
                parentListing.setLeft(null);
            }else{
                parentListing.setRight(null);
            }
            return true;
        }

        if(leftCheck != null && rightCheck == null || leftCheck == null && rightCheck != null){
            if(parentListing.getLeft() == localRoot){
                if(localRoot.getLeft() != null){
                    parentListing.setLeft(localRoot.getLeft());
                }
                else{
                    parentListing.setLeft(localRoot.getRight());
                }
            }
            else{
                if(localRoot.getLeft() != null){
                    parentListing.setRight(localRoot.getLeft());
                }
                else{
                    parentListing.setLeft(localRoot.getRight());
                }
            }
            return true;
        }
        return false;
    }

    public void print(){
        printInOrder(root);
    }
    private void printInOrder(Listing localRoot){
        if (localRoot != null) {
            printInOrder(localRoot.getLeft());
            System.out.println(localRoot.getName());
            printInOrder(localRoot.getRight());
        }
    }
}
