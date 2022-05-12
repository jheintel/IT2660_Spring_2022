import java.util.Stack;
import java.util.LinkedList;

/**
 * I named this class Graphy so that I would get to write Graphy graph a bunch of times
 * GraphyGui was just a fortuitous afterthought
 * 
 * Creates data structures called graphs
 * has methods to search through them using both Breadth-First Traversal and Depth-First Traversal
 */
public class Graphy {
    Node vertex[];
    int edge[][];
    int max;
    int numberOfVerticies;

    /**
     * Constructor for a graph only needs how many vertices it will contain
     * 
     * @param n number of vertices graph will include
     */
    public Graphy(int n){
        vertex = new Node[n];
        edge = new int[n][n];
        max = n;
        numberOfVerticies = 0;
    }
    
    /**
     * Generates a graph with random values set between parameter definitions
     * 
     * @param gSize number of vertices graph will include
     * @param minNodeVal minimum value stored within the verticies
     * @param maxNodeVal maximum value stored within the verticies
     * @param minEdgesPerNode minimum edges each vertex can support
     * @param maxEdgesPerNode maximum edges each vertex can support
     * 
     * @return a randomly generated graph with parameter defined ranges
     */
    public static Graphy generateRandomGraph(int gSize, int minNodeVal, int maxNodeVal, int minEdgesPerNode, int maxEdgesPerNode){
        final int GRAPH_SIZE = gSize;
        final int MIN_NODE_VALUE = minNodeVal;
        final int MAX_NODE_VALUE = maxNodeVal;
        final int MIN_EDGES = minEdgesPerNode;
        final int MAX_EDGES = maxEdgesPerNode;
        Graphy genGraph = new Graphy(GRAPH_SIZE);

        //Generate an array of vertices with random values between MIN_NODE_VALUE && MAX_NODE_VALUE
        for(int i = 0; i<GRAPH_SIZE; i++){
            int nodeValue =  (int)Math.floor(Math.random()*(MAX_NODE_VALUE - MIN_NODE_VALUE +1) +MIN_NODE_VALUE);
            genGraph.insertVertex(i, new Node(nodeValue)); 
        }

        //Generate the edges between the vertices
        for(int i = 0; i<GRAPH_SIZE; i++){                                                              //scroll through every vertex
            int maxEdgeAdj = MAX_EDGES - genGraph.numberOfEdges(i);                                     //adjust max edges if pointed at a vertex that already has edges
            int addNumberOfEdges = (int)Math.floor(Math.random()*(maxEdgeAdj - MIN_EDGES+1) +MIN_EDGES);//find the random number of edges to add within a range
            int edgeCheckFirstVert = genGraph.numberOfEdges(i);                                         //set a check of how many edges current vertex has
            while(addNumberOfEdges>0 && edgeCheckFirstVert<MAX_EDGES){                                  //While we have edges to add and the edge check is under maximum edges allowed
                int randomNode = (int)Math.floor(Math.random()*(GRAPH_SIZE-1 - 0 + 1) +0);              //find a random vertex to make an edge to *math could be simplified but I fear bugs now
                int edgeCheckSecondVert = genGraph.numberOfEdges(randomNode);                           //second edge check to make sure random edge were pointed at has edges left
                if(edgeCheckSecondVert<MAX_EDGES && randomNode != i){                                   //If second edge check passes && the random vertex isn't this vertex
                    genGraph.insertEdge(i, randomNode);                                                 //NOW you can add the edge between this vertex and the random vertex
                    addNumberOfEdges--;                                                                 //lower the number of edges to be added
                }
            }
        }
        return genGraph;
    }//end of random graph generator

    /**
     * Insert a vertex into a graph
     * 
     * @param vertexNumber the index of the vertex
     * @param newNode data stored within the vertex
     * @return true if insert completes false if the graph is full
     */
    public boolean insertVertex(int vertexNumber, Node newNode){
        if(vertexNumber>= max)
            return false;
        vertex[vertexNumber] = newNode.deepCopy();
        numberOfVerticies++;
        return true;
    }
    /**
     * Insert an edge between two verteces
     * 
     * @param fromVertex 
     * @param toVertex
     * @return true if insert completes false if either vertex is null
     */
    public boolean insertEdge(int fromVertex, int toVertex){
        if(vertex[fromVertex] == null || vertex[toVertex] == null)
            return false;
        edge[fromVertex][toVertex] = 1; //edges are stored in a nested array where 1 represents a connection between the verteces represented by the indexes
        edge[toVertex][fromVertex] = 1; //this graph is not a digraph so edges go both ways
        vertex[fromVertex].incrementNumberOfEdges(); //increment edgecount for bothe verteces
        vertex[toVertex].incrementNumberOfEdges();
        return true;
    }
    /**
     * Finds how many edges a given vertex has
     * 
     * @param v the index of a vertex
     * @return number of edges the vertex has
     */
    public int numberOfEdges(int v){
        return vertex[v].getNumOfEdges();
    }
    public void setVertEdgeMax(int v, int m){
        /**
         * CODE TO FIX HIGH EDGE COUNTS
         * 
         * While technically generateRandomGraph currently does produce a random number of edges
         * it doesn't store or check the number of edges chosen for each vertex
         * at the time it passes over a vertex which allows all edges to keep pointing at eachother up to max
         * this causes the code to favor high edge counts THAT ARE STILL UNPREDUCTABLE but higher than intended
        */
    }
    /**
     * Prints stored value within vertex to the terminal
     * 
     * @param v index of a certex
     */
    public void showVertex(int v){
        System.out.println(vertex[v].getValue());
    }
    /**
     * Prints a vertex's edges to the terminal
     * 
     * @param v index of a vertex
     */
    public void showEdges(int v){
        for(int column = 0; column < numberOfVerticies; column++){
            if(edge[v][column] == 1)
                System.out.println(v + "," + column);
        }
    }
    
    /**
     * Searches through a graph using a depth-first traversal algorithm
     * 
     * @param src the vertex index to start searching from
     * @param destination value look for at dest[0] -- returned dest[0] == vertex where value was found && dest[1] == number of verteces checked
     * @param pred predecessor[i] array stores predecessor of i
     * @param dist distance array stores distance of i from src
     * @return true if value was found false if value couldn't be found
     */
    private boolean depthFirstTraversal(int src, int destination[], int pred[], int dist[]){
        int v = numberOfVerticies; //store a local vertices variable that will change with the stack

        Stack<Integer> stack = new Stack<>(); //Create a stack to track verteces to look at
        for (int i = 0; i<v; i++){            //Set every vertex within the graph to unpushed
            if(vertex[i]!=null)
                vertex[i].setPushed(false);
            dist[i] = Integer.MAX_VALUE;      //set all distance trackers to 2 BILLION. adjusted down when the corresponding node is tracked over
            pred[i] = -1;                     //set all predecessor vertex trackers to -1 to denote unchecked verteces
        }
                 
        dist[src] = 0;                        //the distance to src at src is zero
        stack.push(src);                      //push the src onto the stack
        vertex[src].setPushed(true);       //set src as having been pushed so we dont do it again later
        destination[1] = destination[1] + 1;  //increment the number of verteces checked before checking src
        if(vertex[src].getValue() == destination[0]){ //if the src contains the value being searched for return true
            destination[0] = 0; //distance to the src is 0 Neo
            return true;
        }

        while(!stack.empty()){                                          //While the stack isnt empty
            v = stack.pop();                                            //pop the top vertex index off
            for (int column = 0; column < numberOfVerticies; column++){ //scroll through the vertex at index v
                if(edge[v][column] == 1 && !vertex[column].getPushed()){//check its edges for unpushed vertices  (%*$&#& I spelled vertices wrong all over this code)
                    stack.push(column);                                 //push em and set them to pushed
                    vertex[column].setPushed(true);
                    dist[column] = dist[v] + 1;                         //record the distance to pushed vertex as current distance + 1
                    pred[column] = v;                                   //set pushed vertex's previous value to current vertex
                    destination[1] = destination[1] + 1;                //increment the number of vertices that have been checked

                    if(vertex[column].getValue() == destination[0]){    //if the value being searched for is found here
                        destination[0] = column;                        //set here as the vertex containing the value
                        return true;                                    //return true -- best comment
                    }
                }
            }
        }
        return false;//if we never find the value return flase and end the search
    }
    public void dftPrintShortestDistance(int s, int dest)
	{
		int pred[] = new int[numberOfVerticies]; // predecessor[i] array stores predecessor of i
		int dist[] = new int[numberOfVerticies]; // distance array stores distance of i from s
        int destination[] = new int[2];
        destination[0] = dest; //I had to store the destination in an array so that DFT could manipulate it. I'm positive I should't be doing this
        destination[1] = 0;    //This tracks how many searches are perfomred. Lord help me, now I pseudo overloaded a basic operator

		if (depthFirstTraversal(s, destination, pred, dist) == false) { //call the depth-first traversal method and if it fails print error
			System.out.println("Source and given destination are not connected\n");
            System.out.println("--- " + destination[1] + " verticies were examined in this search. ---\n"); //display how many nodes were searched
			return;
		}

		// LinkedList to store path
		LinkedList<Integer> path = new LinkedList<Integer>();
		int scroll = destination[0]; //scroll a number of times equal to the distance found by Depth-First method
		path.add(scroll);            
		while (pred[scroll] != -1) { //populate path with the values tracked by predecessor[] -1 represents a vertex where predecessors haven't been found
			path.add(pred[scroll]);
			scroll = pred[scroll];
		}
		
        // Print shortest path length
        System.out.println("Success!");
		System.out.println("Shortest path length is: " + dist[destination[0]]);
		// Print path
		System.out.println("Path is ::");
		for (int i = path.size() - 1; i >= 0; i--) { //sroll through linked list path printing each vertex stored
			System.out.print(path.get(i) + " ");
		}
        System.out.println("\n" + destination[1] + " verticies were examined in this search.");
	}
    /**
     * Logic is consistant with DFT but using a linked list as a queue isnted of a stack to track the next vertex to look at.
     * Uses Breadth-First Traversal to search through a graph
     * 
     * @param src Vertex to start search from
     * @param destination value being searched for within the vertices
     * @param pred predecessor[i] array stores predecessor of i
     * @param dist distance array stores distance of i from src
     * @return true is value is found false if not
     */
    private boolean bredthFirstTraversal(int src, int destination[], int pred[], int dist[]){
        int v = numberOfVerticies;

        LinkedList<Integer> queue = new LinkedList<>(); //replaces the stack used in DFT so this method searches using BFT
        for (int i = 0; i<v; i++){ //initialize values of various tracking structures
            if(vertex[i]!=null)
                vertex[i].setPushed(false);
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;    
        }
        
        dist[src] = 0;
        queue.add(src);                         //add the src to the queue
        vertex[src].setPushed(true);

        destination[1] = destination[1] + 1;    //if src contains value return
        if(vertex[src].getValue() == destination[0]){
            destination[0] = 0;
            return true;
        }
        while(!queue.isEmpty()){                                           //while the queue isn't empty
            v = queue.remove();                                            //scroll through the queue
            for (int column = 0; column < numberOfVerticies; column++){ 
                if(edge[v][column] == 1 && !vertex[column].getPushed()){
                    queue.add(column);                                     //add new vertices to queue
                    vertex[column].setPushed(true);
                    dist[column] = dist[v] + 1;                            //update trackers
                    pred[column] = v;
                    destination[1] = destination[1] + 1;

                    if(vertex[column].getValue() == destination[0]){ //if value is found set destination vertex and return true
                        destination[0] = column;
                        return true;
                    }
                }
            }
        }
        return false; //if search doesn't find value return false
    }
    public void bftPrintShortestDistance(int s, int dest)
	{
		int pred[] = new int[numberOfVerticies]; // predecessor[i] array stores predecessor of i
		int dist[] = new int[numberOfVerticies]; // distance array stores distance of i from s
        int destination[] = new int[2];
        destination[0] = dest; //I had to store the destination in an array so that BFT could manipulate it.
        destination[1] = 0;    //This tracks how many searches are perfomred.

		if (bredthFirstTraversal(s, destination, pred, dist) == false) {
			System.out.println("Given source and destination are not connected");
            System.out.println("\n" + destination[1] + " verticies were examined in this search.");
            return;
		}


		// LinkedList to store path
		LinkedList<Integer> path = new LinkedList<Integer>();
		int scroll = destination[0];
		path.add(scroll);
		while (pred[scroll] != -1) { //generate path from trackers. The comments really took lax turn down here.
			path.add(pred[scroll]);
			scroll = pred[scroll];
		}

		// Print distance
        System.out.println("Success!");
		System.out.println("Shortest path length is: " + dist[destination[0]]);

		// Print path
		System.out.println("Path is ::");
		for (int i = path.size() - 1; i >= 0; i--) {
			System.out.print(path.get(i) + " ");
		}
        System.out.println("\n" + destination[1] + " verticies were examined in this search.");
	}
    /**
     * Prints Vertex index followed by its stored value then what its connections are
     */
    public void printGraph(){
        for(int i = 0; i < numberOfVerticies; i++){
            System.out.print("Node " + i + "\'s value is ");
            showVertex(i);
            System.out.println("its connections are: ");
            showEdges(i);
        }
    }

    /**
     * TEST METHOD
     * 
     * prints out vertices as they are scanned through by my depth-first traversal logic
     * @param firstVertex
     */
    public void depthFirstTraversalScanAndPrint(int firstVertex){
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

}
