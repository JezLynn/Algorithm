package de.jez_lynn.algorithm.util.graph;

import de.jez_lynn.algorithm.util.graph.edge.DirectedEdge;
import de.jez_lynn.algorithm.util.graph.vertex.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Copyright 2016
 * Created on   : 01.08.2016
 * Author       : Michael Schlittenbauer
 */
public class WeightedDirectedGraph extends Graph<DirectedEdge>{

    public WeightedDirectedGraph(int V){
        this.vertexCount = V;
        this.edgeCount = 0;
        adj = (ArrayList<DirectedEdge>[]) new ArrayList[V];
        for(int i = 0; i < V; i++){
            adj[i] = new ArrayList<>();
        }
        vertices = new HashMap<>();
        edges = new LinkedList<>();
    }

    @Override
    public void addEdge(Vertex from, Vertex to, int weight){
        DirectedEdge edge = new DirectedEdge(edgeCount, weight, from, to);
        adj[from.id()].add(edge);
        if(!vertices.containsKey(from.id()))
            vertices.put(from.id(), from);
        if(!vertices.containsKey(to.id()))
            vertices.put(to.id(), to);
        edges.add(edge);
        this.edgeCount++;
    }
}
