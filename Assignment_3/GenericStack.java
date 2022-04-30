//Make a generic stack that will accept any data type (simple data types will be wrapped into an object)
public class GenericStack<T> {
    private T[] data; //the T takes the place of the object that this class is working on
    private int top;
    private int size;
    
    public GenericStack(){ //ini for a Generic stack with no set size
        top = -1;
        size = 100;
        // this wont stop warning me "Type safety: Unchecked cast from Object[] to T[]Java(16777761)" and I dont really know how to stop it.
        // program runs so I'm sure it's nothing to worry about. This ship runs on glue and spit.
        data = (T[]) new Object[100];
    }  
    public GenericStack(int n){ //ini for stack with size n
        top = -1;
        size = n;
        data = (T[]) new Object[n];
    }

    public void push(T newNode){ //method to put something on top of the stack
        /* if the size limit is reached make a bigger array *pew pew finger guns*
           index through the old array assigning the values to the larger array 
           replace the old array with the new one then increment the top pointer and add the new node
        */
        if (top == size -1){ 
            int newSize = size+100;
            T[] biggerData = (T[]) new Object[newSize];

            for(int i = 0; i<size; i++)
                biggerData[i] = data[i];
            size = newSize;
            data = biggerData;
            top = top+1;
            data[top] = newNode;
        }
        else{  // else put the newNode onto the stack and increment the stack top pointer
            top = top+1;
            data[top] = newNode;
        }
    }
    public T pop(){ // method removes node form the stack
        int topLocation;
        if(top == -1) // if the stack is empty return null
            return null;
        else if(top < size-100) {
            /* If the top pointer is 101 lower than the array size
            make a smaller array and set the values of the old array 
            into the new smaller one and assign all the new smaller 
            variables into this */
            int newSize = size-100;
            T[] smallerData = (T[]) new Object[newSize];

            for(int i = 0; i<newSize; i++)
                smallerData[i] = data[i];
            size = newSize;
            data = smallerData;

            topLocation = top; // lower top pointer and return data that was at top spot
            top = top-1;
            return data[topLocation];
        } else { // otherwise lower the top pointer and return the data that was at the top spot
            topLocation = top;
            top = top-1;
            return data[topLocation];
        }
    }
    public void showAll(){ //cycle through the stack and print out everything up to the top pointer
        for(int i = top; i>= 0; i--)
            System.out.println(data[i].toString());
    }
}
