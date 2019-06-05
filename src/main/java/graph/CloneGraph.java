package main.java.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
Given a reference of a node in a connected undirected graph,
return a deep copy (clone) of the graph.

Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.

Input:
{"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}

Explanation:
Node 1's value is 1, and it has two neighbors: Node 2 and 4.
Node 2's value is 2, and it has two neighbors: Node 1 and 3.
Node 3's value is 3, and it has two neighbors: Node 2 and 4.
Node 4's value is 4, and it has two neighbors: Node 1 and 3.
 */
public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node==null) return null;
        Map<Node, Node> visited = new HashMap<>();
        Node start = new Node(node.val, new LinkedList<>());
        dfsHelper(node, visited, start);
        return start;
    }

    private void dfsHelper(Node start, Map<Node, Node> visited, Node clonedStart) {
        visited.put(start, clonedStart);
        for (Node n:start.neighbors) {
            if (visited.containsKey(n)) {
                clonedStart.neighbors.add(visited.get(n));
            }
            else {
                Node clonedNode = new Node(n.val, new LinkedList<>());
                clonedStart.neighbors.add(clonedNode);
                dfsHelper(n,visited,clonedNode);
            }
        }
    }
}
