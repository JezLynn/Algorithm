package de.jez_lynn.algorithm.util.graph;

import de.jez_lynn.algorithm.util.graph.edge.UndirectedEdge;
import de.jez_lynn.algorithm.util.graph.vertex.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Copyright 2016
 * Created on   : 03.08.2016
 * Author       : Michael Schlittenbauer
 */
public class WeightedUndirectedGraph extends Graph<UndirectedEdge> {

    public WeightedUndirectedGraph(int V) {
        this.vertexCount = V;
        this.edgeCount = 0;
        adj = (ArrayList<UndirectedEdge>[]) new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        vertices = new HashMap<>();
        edges = new LinkedList<>();
    }

    @Override
    public void addEdge(Vertex v1, Vertex v2, int weight) {
        UndirectedEdge edge = new UndirectedEdge(edgeCount, weight, v1, v2);
        adj[v1.id()].add(edge);
        adj[v2.id()].add(edge);
        if (!vertices.containsKey(v1.id()))
            vertices.put(v1.id(), v1);
        if (!vertices.containsKey(v2.id()))
            vertices.put(v2.id(), v2);
        edges.add(edge);
        this.edgeCount++;
    }
}
