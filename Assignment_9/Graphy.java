public class Graphy {
    Node vertex[];
    int edge[][];
    int max;
    int numberOfVerticies;
    public Graphy(int n){
        vertex = new Node[n];
        edge = new int[n][n];
        max = n;
        numberOfVerticies = 0;
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
}
