package de.jez_lynn.algorithm.algorithm.path;

import de.jez_lynn.algorithm.util.Edge;
import de.jez_lynn.algorithm.util.IPathFindingAlgo;
import de.jez_lynn.algorithm.util.Node;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by mail on 18.07.2016.
 */
public class BellmanFord implements IPathFindingAlgo {
    @Override
    public int findPath(LinkedList<Node> nodes, LinkedList<Edge> edges, Node start) {
        HashMap<Node, Integer> distance = new HashMap<>();
        HashMap<Node, Node> predecessor = new HashMap<>();

        for (Node n : nodes) {
            distance.put(n, Integer.MAX_VALUE);
            predecessor.put(n, null);
        }

        distance.put(start, 0);
        for (int i = 1; i < nodes.size(); i++) {
            for (Edge e : edges) {
                if()
            }
        }
    }
}
