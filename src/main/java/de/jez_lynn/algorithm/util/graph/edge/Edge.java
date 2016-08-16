package de.jez_lynn.algorithm.util.graph.edge;

import de.jez_lynn.algorithm.util.graph.vertex.Vertex;
import javafx.util.Pair;

/**
 * Created by mail on 18.07.2016.
 */
public abstract class Edge {
    protected String name;
    protected int id;
    protected int weight;
    protected Pair<Vertex, Vertex> vertices;

    public Edge(int id, int weight, Pair<Vertex, Vertex> vertices) {
        this.weight = weight;
        this.vertices = vertices;
        this.id = id;
        this.name = ""+vertices.getKey().name()+vertices.getValue().name();
    }

    public boolean connected(Vertex u, Vertex v) {
        if (!u.equals(v)) {
            if (vertices.getKey().equals(u) && vertices.getValue().equals(v)) {
                return true;
            }
        }
        return false;
    }

    public abstract Vertex from();

    public abstract Vertex to();

    public String name() {
        return name;
    }

    public int id(){
        return id;
    }

    public int weight() {
        return weight;
    }
}
