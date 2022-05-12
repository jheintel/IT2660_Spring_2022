import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws IOException {
        Graphy graph = null;
        menu(graph);
    }

    public static void menu(Graphy graph) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int choice;
        
        GraphyGui.printMenu();
        choice = Integer.parseInt(reader.readLine()); //parse entered values into integer values

        
        //match the choice from the terminal input to a function
        switch(choice){
            case 1:
                graph = Graphy.generateRandomGraph(1000, 1, 100000, 1, 5);
                menu(graph);
                break;
            case 2:
                int gSize;
                int minNodeVal;
                int maxNodeVal;
                int minEdgesPerNode;
                int maxEdgesPerNode;
                
                GraphyGui.clearScreen();
                GraphyGui.askForNumber("number of vertices in the graph");
                gSize = Integer.parseInt(reader.readLine());
                GraphyGui.askForNumber("minimum vertex value");
                minNodeVal = Integer.parseInt(reader.readLine());
                GraphyGui.askForNumber("maximum vertex value");
                maxNodeVal = Integer.parseInt(reader.readLine());
                GraphyGui.askForNumber("minimum edges per vertex");
                minEdgesPerNode = Integer.parseInt(reader.readLine());
                GraphyGui.askForNumber("maximum adges per vertex");
                maxEdgesPerNode = Integer.parseInt(reader.readLine());

                graph = Graphy.generateRandomGraph(gSize, minNodeVal, maxNodeVal, minEdgesPerNode, maxEdgesPerNode);
                menu(graph);
                break;
            case 3:
                if(graph != null){
                    GraphyGui.clearScreen();
                    GraphyGui.askForNumber("for the Depth-First algorithm to search for");
                    choice = Integer.parseInt(reader.readLine());
                    GraphyGui.clearScreen();
                    graph.dftPrintShortestDistance(0, choice);
                    GraphyGui.pressEnterToContinue();
                    menu(graph);
                } else {
                    GraphyGui.noGraphFound();
                    GraphyGui.pressEnterToContinue();
                    reader.read();
                    menu(graph);
                }
                break;
            case 4:
                if(graph != null){
                    GraphyGui.clearScreen();
                    GraphyGui.askForNumber("for the Breadth-First algorithm to search for");
                    choice = Integer.parseInt(reader.readLine());
                    GraphyGui.clearScreen();
                    graph.bftPrintShortestDistance(0, choice);
                    GraphyGui.pressEnterToContinue();
                    reader.read();
                    menu(graph);
                } else {
                    GraphyGui.noGraphFound();
                    GraphyGui.pressEnterToContinue();
                    reader.read();
                    menu(graph);
                }
                break;
            case 5: //exits the program
                GraphyGui.printGoodbye();
                break;
            default: //yells at you and resets the menu
                GraphyGui.errorMessage();
                GraphyGui.pressEnterToContinue();
                reader.read();
                menu(graph);
                break;
        }
        reader.close();
    }
}
