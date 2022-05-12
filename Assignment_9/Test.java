/**
 * This class contains a small seiries of tests to assure Graphy was working while I developed it
 * Tests can be uncommented to have them run. A few produce large lists in the Terminal
 */
public class Test {
    public static void main(String[] args) {
        //testGraph();                                        //uses local method to hardcode a graph
        
        //This graph needs to be created to perform lower tests
        Graphy graph = Graphy.generateRandomGraph(1000, 1, 100000, 1, 3);
        {
            
            graph.printGraph();                                   //Print out every vertex and its value and edges
            //graph.depthFirstTraversalScanAndPrint(0);           //Print vertices as they are passed over by DFT method
            //graph.dftPrintShortestDistance(0, 8);               //tests final DFT method searching for vertex with the stored value of 8
            //graph.bftPrintShortestDistance(0, 8);               //tests final BFT method searching for vertex with the stored value of 8
        }
    }

    public static Graphy testGraph(){
        Graphy testGraph = new Graphy(5);
        Node v0 = new Node(0);
        Node v1 = new Node(1);
        Node v2 = new Node(2);
        Node v3 = new Node(3);
        Node v4 = new Node(4);

        testGraph.insertVertex(0, v0);
        testGraph.insertVertex(1, v1);
        testGraph.insertVertex(2, v2);
        testGraph.insertVertex(3, v3);
        testGraph.insertVertex(4, v4);

        testGraph.insertEdge(0, 1);
        testGraph.insertEdge(0, 3);
        testGraph.insertEdge(1, 2);
        testGraph.insertEdge(1, 3);
        testGraph.insertEdge(2, 1);
        testGraph.insertEdge(3, 4);
        testGraph.insertEdge(4, 0);
        testGraph.insertEdge(4, 3);

        return testGraph;
    }
}
