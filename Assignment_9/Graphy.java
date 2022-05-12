//import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;

public class Graphy {
    Node vertex[];
    int edge[][];
    int max;
    int numberOfVerticies;
    int destination = 0;

    public Graphy(int n){
        vertex = new Node[n];
        edge = new int[n][n];
        max = n;
        numberOfVerticies = 0;
    }
    public static Graphy generateRandomGraph(int gSize, int minNodeVal, int maxNodeVal, int minEdgesPerNode, int maxEdgesPerNode){
        final int GRAPH_SIZE = gSize;
        final int MIN_NODE_VALUE = minNodeVal;
        final int MAX_NODE_VALUE = maxNodeVal;
        final int MIN_EDGES = minEdgesPerNode;
        final int MAX_EDGES = maxEdgesPerNode;
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
        
        return genGraph;
    }

    public boolean insertVertex(int vertexNumber, Node newNode){
        if(vertexNumber>= max)
            return false;
        vertex[vertexNumber] = newNode.deepCopy();
        numberOfVerticies++;
        return true;
    }
    public boolean insertEdge(int fromVertex, int toVertex){
        if(vertex[fromVertex] == null || vertex[toVertex] == null)
            return false;
        edge[fromVertex][toVertex] = 1;
        edge[toVertex][fromVertex] = 1;
        vertex[fromVertex].incrementNumberOfEdges();
        vertex[toVertex].incrementNumberOfEdges();
        return true;
    }
    public int numberOfEdges(int v){
        return vertex[v].getNumOfEdges();
    }

    public void showVertex(int vertexNumber){
        System.out.println(vertex[vertexNumber].getValue());
    }
    public void showEdges(int vertexNumber){
        for(int column = 0; column < numberOfVerticies; column++){
            if(edge[vertexNumber][column] == 1)
                System.out.println(vertexNumber + "," + column);
        }
    }

    public void DFT_scanAndPrint(int firstVertex){
        int v;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i<numberOfVerticies; i++){
            if(vertex[i]!=null)
                vertex[i].setPushed(false);
        }
        stack.push(firstVertex);
        vertex[firstVertex].setPushed(true);

        while(!stack.empty()){
            v = stack.pop();
            System.out.print("Vertex " + v + "\'s stored value is ");
            vertex[v].visit();
            for (int column = 0; column < numberOfVerticies; column++){
                if(edge[v][column] == 1 && !vertex[column].getPushed()){
                    stack.push(column);
                    vertex[column].setPushed(true);
                }
            }
        }
    }
    private boolean DFT(int src, int dest, int pred[], int dist[]){
        int v = numberOfVerticies;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i<v; i++){
            if(vertex[i]!=null)
                vertex[i].setPushed(false);
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;    
        }
                
        dist[src] = 0;
        stack.push(src);
        vertex[src].setPushed(true);

        while(!stack.empty()){
            v = stack.pop();
            for (int column = 0; column < numberOfVerticies; column++){ 
                if(edge[v][column] == 1 && !vertex[column].getPushed()){
                    stack.push(column);
                    vertex[column].setPushed(true);
                    dist[column] = dist[v] + 1;
                    pred[column] = v;

                    if(vertex[column].getValue() == dest){
                        destination = column;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void printShortestDistance(int s, int dest)
	{
		// predecessor[i] array stores predecessor of
		// i and distance array stores distance of i
		// from s
		int pred[] = new int[numberOfVerticies];
		int dist[] = new int[numberOfVerticies];

		if (DFT(s, (Integer)dest, pred, dist) == false) {
			System.out.println("Given source and destination are not connected");
			return;
		}


		// LinkedList to store path
		LinkedList<Integer> path = new LinkedList<Integer>();
		int crawl = destination;
		path.add(crawl);
		while (pred[crawl] != -1) {
			path.add(pred[crawl]);
			crawl = pred[crawl];
		}

		// Print distance
		System.out.println("Shortest path length is: " + dist[destination]);

		// Print path
		System.out.println("Path is ::");
		for (int i = path.size() - 1; i >= 0; i--) {
			System.out.print(path.get(i) + " ");
		}
	}

    public void printGraph(){
        for(int i = 0; i < numberOfVerticies; i++){
            System.out.print("Node " + i + "\'s ");
            showVertex(i);
            System.out.println("its connections are: ");
            showEdges(i);
        }
    }
    /*private void pause(){
        System.out.print("Press enter to continue...");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        scan.close();
    }*/
}
