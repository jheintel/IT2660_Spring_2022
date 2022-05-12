import java.io.PrintStream;

/**
 * GraphGui keeps track of Strings used for terminal based user interface
 */
public class GraphyGui {
    static PrintStream o = System.out; //Set o = System.out so I don't have to type it a bunch
    
    /**
     * Prints the home menu
     * I considered having a splash screen on app startup but decided that would get annoying
     */
    public static void printMenu(){        
        clearScreen();
        o.println( 
        "What would you like to do? \n" +
        "Make a selection then hit enter\n\n" +
        "1 Use the standard graph :: 1000 vertices w/ random values between 1-100000 and 1-5 edges each\n" +
        "2 Create a graph with user defined fields\n" +
        "3 Use Depth-First Traversal on graph\n" +
        "4 Use Breadth-First Traversal on graph\n" +
        "\n" +
        "5 to exit the program");
    }   
    
    /**
     * Two methods to ask for a number
     * the first is generic while the second allows for adding a string in the middle to clarify numbers being asked for
     */
    public static void askForNumber(){
        o.print("Choose a value then press enter: ");
    }
    public static void askForNumber(String string){
        o.print("Choose a value for the " + string + " then press enter: ");
    }

    public static void clearScreen(){ //clears the terminal screen
        o.print("\033[H\033[2J");
    }
    public static void pressEnterToContinue(){ //prints out the press enter to continue message but has no functionality beyond the message
        o.print("Please press enter to continue...");
    }
    public static void printGoodbye(){ //Print exiting splash screen. I wish I has written these comments as I went. This is taking forever.
        clearScreen();
        o.println("Thanks for the opportunity to succeed this semester!\n" + 
                  "   - Jon Heintel\n\n");
    }
    public static void noGraphFound(){ //prints error message when no graph has been created
        clearScreen();
        o.println("No graph found. Create a graph before trying to search through it.");
    }
    public static void errorMessage(){ //general error message
        o.print("    -- Command error --\n");
    }
}
