public class Test {
    public static void main(String[] args) {
        //testGraph();
        generateRandomGraph();
    }

    public static void generateRandomGraph(){
        final int GRAPH_SIZE = 1000;
        final int MIN_NODE_VALUE = 0;
        final int MAX_NODE_VALUE = 100000;
        final int MIN_EDGES = 1;
        final int MAX_EDGES = 5;
        Graphy genGraph = new Graphy(GRAPH_SIZE);

        //Generate an array of nodes with random values
        for(int i = 0; i<GRAPH_SIZE; i++){
            int nodeValue =  (int)Math.floor(Math.random()*(MAX_NODE_VALUE - MIN_NODE_VALUE +1) +MIN_NODE_VALUE);
            
            genGraph.insertVertex(i, new Node(nodeValue));
        }

        //generate the edges between the nodes
        for(int i = 0; i<GRAPH_SIZE; i++){
            int maxEdgeAdj = MAX_EDGES - genGraph.numberOfEdges(i);
            int addNumberOfEdges = (int)Math.floor(Math.random()*(maxEdgeAdj - MIN_EDGES+1) +MIN_EDGES);
            int edgeCheckFirstVert = genGraph.numberOfEdges(i);
            while(addNumberOfEdges>0 && edgeCheckFirstVert<MAX_EDGES){
                int randomNode = (int)Math.floor(Math.random()*(GRAPH_SIZE-1 - 0 + 1) +0);
                int edgeCheckSecondVert = genGraph.numberOfEdges(randomNode);
                if(edgeCheckSecondVert<MAX_EDGES && randomNode != i){
                    genGraph.insertEdge(i, randomNode);
                    addNumberOfEdges--;
                }
                else{
                    addNumberOfEdges--;
                }
            }
        }

        for(int i = 0; i < GRAPH_SIZE; i++){
            System.out.print("Node " + i + "\'s Value is: ");
            genGraph.showVertex(i);
            System.out.println("its connections are: ");
            genGraph.showEdges(i);
        }
    }
    
    public static void testGraph(){
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

        for(int i = 0; i < 5; i++){
            System.out.print("Node " + i + "\'s ");
            testGraph.showVertex(i);
            System.out.println("its connections are: ");
            testGraph.showEdges(i);
        }
    }
}
