package DJS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ryan on 5/5/18.
 */
public class TestDijkstraAlgorithm {
    List<Vertex> nodes;
    List<Edge> edges;

    public void addLane(String laneId, int sourceLocNo, int destLocNo,
                         int duration) {
        Edge lane = new Edge(laneId,nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
        edges.add(lane);
    }

    public static void main(String[] args) {
        TestDijkstraAlgorithm djs = new TestDijkstraAlgorithm();
        djs.nodes = new ArrayList<>();
        djs.edges = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            Vertex location = new Vertex("Node_" + i, "Node_" + i);
            djs.nodes.add(location);
        }

        djs.addLane("Edge_0", 0, 1, 85);
        djs.addLane("Edge_1", 0, 2, 217);
        djs.addLane("Edge_2", 0, 4, 173);
        djs.addLane("Edge_3", 2, 6, 186);
        djs.addLane("Edge_4", 2, 7, 103);
        djs.addLane("Edge_5", 3, 7, 183);
        djs.addLane("Edge_6", 5, 8, 250);
        djs.addLane("Edge_7", 8, 9, 84);
        djs.addLane("Edge_8", 7, 9, 167);
        djs.addLane("Edge_9", 4, 9, 502);
        djs.addLane("Edge_10", 9, 10, 40);
        djs.addLane("Edge_11", 1, 10, 600);

        // Lets check from location Loc_1 to Loc_10
        Graph graph = new Graph(djs.nodes, djs.edges);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(djs.nodes.get(0));
        LinkedList<Vertex> path = dijkstra.getPath(djs.nodes.get(10));

        System.out.println("path size: " + path.size());

        for (Vertex vertex : path) {
            System.out.println(vertex);
        }
    }
}
