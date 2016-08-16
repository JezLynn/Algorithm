package de.jez_lynn.algorithm.algorithm.path;

import de.jez_lynn.algorithm.util.IPathFindingAlgo;
import de.jez_lynn.algorithm.util.graph.WeightedUndirectedGraph;
import de.jez_lynn.algorithm.util.graph.edge.Edge;
import de.jez_lynn.algorithm.util.graph.edge.UndirectedEdge;
import de.jez_lynn.algorithm.util.graph.vertex.Vertex;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * Copyright 2016
 * Created on   : 03.08.2016
 * Author       : Michael Schlittenbauer
 */
public class Dijkstra implements IPathFindingAlgo<WeightedUndirectedGraph> {

    private long[] distance;
    private Vertex[] prev;

    @Override
    public long[] findPath(WeightedUndirectedGraph graph, Vertex start) throws Exception {
        distance = new long[graph.vertices().size()];
        prev = new Vertex[graph.vertices().size()];

        Comparator<Pair<Long, ?>> c = ((o1, o2) -> o1.getKey().compareTo(o2.getKey()));
        PriorityQueue<Pair<Long, Vertex>> Q = new PriorityQueue<>(c);
        init(graph, start, distance, prev, Q);
        while (!Q.isEmpty()) {
            Vertex u = Q.poll().getValue();
            for (Vertex v : u.childs()) {
                if (Q.contains(new Pair<>(distance[v.id()], v))) {
                    update(graph.adj(v), u, v);
                }
            }
        }
        return distance;
    }

    private void update(ArrayList<UndirectedEdge> adj, Vertex u, Vertex v) {
        Edge e = adj.stream().filter((Edge edge) -> (edge.from().equals(u) && edge.to().equals(v)) || (edge.from().equals(v) && edge.to().equals(u))).findFirst().get();
        long alternative = distance[u.id()] + e.weight();
        if (alternative < distance[v.id()]) {
            distance[v.id()] = alternative;
            prev[v.id()] = u;
        }
    }

    private void init(WeightedUndirectedGraph g, Vertex start, long[] distance, Vertex[] prev, PriorityQueue<Pair<Long, Vertex>> Q) {
        for (Vertex v : g.vertices()) {
            prev[v.id()] = null;
            if (v.equals(start)) {
                distance[v.id()] = 0;
            } else {
                distance[v.id()] = Long.MAX_VALUE / 2;
            }
            Q.add(new Pair<>(distance[v.id()], v));
        }
    }
}
