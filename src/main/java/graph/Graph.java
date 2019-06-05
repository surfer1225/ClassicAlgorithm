package main.java.graph;

import java.util.LinkedList;
import java.util.Queue;

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
        // add the other direction if it is an undirected graph
        // this.adjListArr[dest].add(src);
    }

    public void BFS(int s) {
        boolean[] visited = new boolean[this.v];

        Queue<Integer> q = new LinkedList<>();
        q.offer(s);

        while (!q.isEmpty()) {
            int node = q.poll();
            processNode(node);
            for (int i:this.adjListArr[node]) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }

    public void DFS(int s) {
        DFSHelper(s,new boolean[this.v]);
    }

    private void DFSHelper(int s, boolean[] visited) {
        visited[s] = true;
        processNode(s);

        for (int i:this.adjListArr[s]) {
            if (!visited[i]) DFSHelper(i,visited);
        }
    }

    private void processNode(Integer i) {
        System.out.println(i + " ");
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
        //graph.printGraph();

        //graph.BFS(0);
        graph.DFS(0);
    }
}
