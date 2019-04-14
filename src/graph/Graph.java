package graph;

import java.util.LinkedList;

public class Graph {
    int v;// number of vertices
    LinkedList<Integer>[] adjListArr;

    public Graph(int v) {
        this.v = v;
        adjListArr = new LinkedList[v];

        for (int i=0;i<v;i++) adjListArr[i] = new LinkedList<>();
    }

    public void addEdge(int src, int dest) {
        this.adjListArr[src].add(dest);
        this.adjListArr[dest].add(src);
    }

    public void printGraph() {
        for(int i = 0; i < this.v; i++) {
            System.out.println("Adjacency list of vertex "+ i);
            System.out.print("head");
            for(Integer pCrawl: adjListArr[i]){
                System.out.print(" -> "+pCrawl);
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        // create the graph given in above figure
        int V = 5;
        Graph graph = new Graph(V);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        // print the adjacency list representation of
        // the above graph
        graph.printGraph();
    }
}
