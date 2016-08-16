package de.jez_lynn.algorithm.util.graph;

import de.jez_lynn.algorithm.util.graph.edge.Edge;
import de.jez_lynn.algorithm.util.graph.vertex.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Copyright 2016
 * Created on   : 03.08.2016
 * Author       : Michael Schlittenbauer
 */
public abstract class Graph<E extends Edge> {

    protected int vertexCount;
    protected int edgeCount;
    protected ArrayList<E>[] adj;
    protected HashMap<Integer, Vertex> vertices;
    protected LinkedList<E> edges;

    public abstract void addEdge(Vertex from, Vertex to, int weight);

    public ArrayList<E> adj(Vertex v) {
        if (v.id() < 0 || v.id() >= vertexCount) throw new IndexOutOfBoundsException();
        return this.adj[v.id()];
    }

    public int V() {
        return this.vertexCount;
    }

    public int E() {
        return this.edgeCount;
    }

    public LinkedList<Vertex> vertices() {
        return new LinkedList<Vertex>(vertices.values());
    }

    public LinkedList<E> edges() {
        return edges;
    }
}
