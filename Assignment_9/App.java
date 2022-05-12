import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * App presents a terminal menu that gives the user basic Graphy operations to choose from
 */
public class App {
    public static void main(String[] args) throws IOException {
        Graphy graph = null; //Create an empty graph for the program to manipulate
        menu(graph);         //Send the graph to menu method within this class
    }

    /**
     * Takes a graph
     * Presents the user with choices in the terminal to manipulate the graph
     * manipulates the based off of user selections
     * 
     * @param graph 
     * @throws IOException
     */
    public static void menu(Graphy graph) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int choice;                                   //tracks user entered values
        
        GraphyGui.printMenu();                        //Print the menu designed in GraphyGui
        choice = Integer.parseInt(reader.readLine()); //parse user entered values into integer values

        
        /**
         * Match the choice from the terminal input to a function
         * pretty sure this switch statement recusively calls istelf every user choice. Please don't make millions of choices.
        */
        switch(choice){
            case 1: //generates standard random graph defined in assignment
                graph = Graphy.generateRandomGraph(1000, 1, 100000, 1, 5);
                menu(graph); //recall menu to allow for further choices
                break;
            case 2: //asks the user to define their own parameters for a random graph
                int gSize, minNodeVal, maxNodeVal, minEdgesPerNode, maxEdgesPerNode;//empty fields to be defined by user for graph creation
                
                GraphyGui.clearScreen();
                GraphyGui.askForNumber("number of vertices in the graph"); //Collect user field values for a new graph
                gSize = Integer.parseInt(reader.readLine());
                GraphyGui.askForNumber("minimum vertex value");
                minNodeVal = Integer.parseInt(reader.readLine());
                GraphyGui.askForNumber("maximum vertex value");
                maxNodeVal = Integer.parseInt(reader.readLine());
                GraphyGui.askForNumber("minimum edges per vertex");
                minEdgesPerNode = Integer.parseInt(reader.readLine());
                GraphyGui.askForNumber("maximum adges per vertex");
                maxEdgesPerNode = Integer.parseInt(reader.readLine());

                graph = Graphy.generateRandomGraph(gSize, minNodeVal, maxNodeVal, minEdgesPerNode, maxEdgesPerNode); //create user graph
                menu(graph);//recall menu to allow for further choices
                break;
            case 3: //use a previously generated graph and find a user defined value in the graph
                if(graph != null){
                    GraphyGui.clearScreen();
                    GraphyGui.askForNumber("for the Depth-First algorithm to search for"); //ask user for value to search for
                    choice = Integer.parseInt(reader.readLine());
                    GraphyGui.clearScreen();
                    graph.dftPrintShortestDistance(0, choice); //call the Depth-First Traversal method within Graphy.java
                    GraphyGui.pressEnterToContinue(); reader.read(); //these calls are paired throughout the file
                    menu(graph); //recall menu to allow for further choices
                } else {
                    GraphyGui.noGraphFound();
                    GraphyGui.pressEnterToContinue(); reader.read();
                    menu(graph);//recall menu to allow for further choices
                }
                break;
            case 4:
                if(graph != null){
                    GraphyGui.clearScreen();
                    GraphyGui.askForNumber("for the Breadth-First algorithm to search for");
                    choice = Integer.parseInt(reader.readLine());
                    GraphyGui.clearScreen();
                    graph.bftPrintShortestDistance(0, choice); //call the Breadth-First Traversal method within Graphy.java
                    GraphyGui.pressEnterToContinue(); reader.read();
                    menu(graph);//recall menu to allow for further choices
                } else {
                    GraphyGui.noGraphFound();
                    GraphyGui.pressEnterToContinue(); reader.read();
                    menu(graph);//recall menu to allow for further choices
                }
                break;
            case 5: //exits the program
                GraphyGui.printGoodbye();
                break;
            default: //yells at you and resets the menu
                GraphyGui.errorMessage();
                GraphyGui.pressEnterToContinue(); reader.read();
                menu(graph);//recall menu to allow for further choices
                break;
        }//end switch statement
        reader.close();
    }//end menu class
}//end program