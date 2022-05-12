import java.io.PrintStream;

public class GraphyGui {
    static PrintStream o = System.out;
    
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
    
    public static void askForNumber(){
        o.print("Choose a value then press enter: ");
    }
    public static void askForNumber(String string){
        o.print("Choose a value for the " + string + " then press enter: ");
    }
    public static void clearScreen(){
        o.print("\033[H\033[2J");
    }

    public static void pressEnterToContinue(){
        o.print("Please press enter to continue...");
    }

    public static void printGoodbye(){
        clearScreen();
        o.println("Thanks for the opportunity to succeed this semester!\n" + 
                  "   - Jon Heintel\n\n");
    }

    public static void noGraphFound(){
        clearScreen();
        o.println("No graph found. Create a graph before trying to search through it.");
    }

    public static void errorMessage(){
        o.print("    -- Command error --\n");
    }
}
