public class Test {
    public static void main(String[] args) {
        //testGraph();
        Graphy graph = Graphy.generateRandomGraph(100, 1, 10, 1, 5);
        //graph.printGraph();
        //graph.DFT_scanAndPrint(0);
        graph.printShortestDistance(0, 8);
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
