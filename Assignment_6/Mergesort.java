/**I'm using lists for this!
 * which was probably a mistake as I have never used them before
 * but they seemed like the datatype for the job
 */
import java.util.ArrayList;
import java.util.List;

/**
 * I am really only using this many comments because this is a class
 * I would generally be more reserved
 * 
 * This is a class that creates a list of numbers and then mergesorts that very list
 */
public class Mergesort {
    public static void main(String args[]){
        final int LIST_SIZE = 100;
        final int MIN = 1;                      // Floor of the random numbers
        final int MAX = 1001;                   // Ceiling of Random numbers
        List<Integer> list = new ArrayList<>(); // list will store a bunch of random numbers


        // Create the random number list by looping LIST_SIZE nuber of times and generating a number to add to the list
        // I might have encased this into a method but I only needed it once
        for(int i=0 ; i<LIST_SIZE; i++){
            list.add(i, (int)Math.floor(Math.random()*(MAX-MIN+1)+MIN));
        }
        
        print(list);
        list = sort(list);
        print(list);
    }


    /**Takes a list of unsorted numbers and mergesorts them through recursion
     * 
     * @param m A list of random numbers
     * @return A list of merge sorted numbers
     */
    public static List<Integer> sort(List<Integer> m) {
        if(m.size() <= 1){                              //Send the list back if it can't be split further
            return m;
        }

        List<Integer> left = new ArrayList<>();        //list to hold the first half of the imported list
        List<Integer> right = new ArrayList<>();       //list to hold second half of imported list
        int i = 0;

        while(i<m.size()){                             //Scroll through the list splitting it in half
            if(i<m.size()/2){                          //adding values to previously created lists
                left.add(m.get(i));
                i++;
            }
            else{
                right.add(m.get(i));
                i++;
            }
        }
        
        left = sort(left);                              //have the method call itself to further split the list into individual cells
        right = sort(right);
        return merge(left, right);                      //merge reunites the cells in numerical order
    }

    /**Takes two Integer lists and combines them in numerical order 
     * *for use within sort method
     * It kills me how long it took me to write this.
     * I got stuck with a bug that ordered the first digit properly no matter the list size then
     * ordered the rest of the list in arcane ways that defied reason
     * 
     * @param left list of Integers
     * @param right list of Integers
     * @return combined list in numerical order
     */
    private static List<Integer> merge(List<Integer> left, List<Integer> right){
        List<Integer> list = new ArrayList<>();          //make a list we can combine lef and right into

        while(!left.isEmpty() && !right.isEmpty()){      //while both lists have an item at the 0 index
            if(left.get(0)<right.get(0)){   //if the left item is smaller add it to list
                list.add(left.get(0));            
                left.remove(0);                   //remove the added value from left
            }
            else{                                       
                list.add(right.get(0));           //if the right item is smaller add it to the list
                right.remove(0);                  //remove the added value from right
            }
        }

        if(!left.isEmpty())                             //Whatever values reamain after the above logic slap em on the end of the list
            list.addAll(left);
        if(!right.isEmpty())
            list.addAll(right);

        return list;
    }

    public static void print(List<Integer> list){
        list.forEach((Integer)-> System.out.print(Integer + ", ")); //for ever item in the list print
        System.out.println("\b" + "\b" + " ");                      //Backspace and cover the final apostrophe with a space
        //                                                          //Print a line for clairity
        System.out.println("-----------------------------------------------------------------------------------------");
    }
}
