package de.jez_lynn.algorithm.util;

import javafx.util.Pair;

/**
 * Created by mail on 18.07.2016.
 */
public class Edge {
    public int weight;
    public Pair<Node, Node> nodes;

    public Edge(int weight, Pair<Node, Node> nodes) {
        this.weight = weight;
        this.nodes = nodes;
    }

    public boolean connected(Node u, Node v) {
        if (!u.equals(v)) {
            if (nodes.getKey().equals(u) && nodes.getValue().equals(v)) {
                return true;
            }
        }
        return false;
    }
}
