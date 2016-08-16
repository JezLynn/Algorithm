package de.jez_lynn.algorithm.util.graph.edge;

import de.jez_lynn.algorithm.util.graph.vertex.Vertex;
import javafx.util.Pair;

/**
 * Copyright 2016
 * Created on   : 03.08.2016
 * Author       : Michael Schlittenbauer
 */
public class UndirectedEdge extends Edge {

    public UndirectedEdge(int id, int weight, Vertex v1, Vertex v2) {
        super(id, weight, new Pair<>(v1,v2));
    }

    @Override
    public Vertex from() {
        return vertices.getKey();
    }

    @Override
    public Vertex to() {
        return vertices.getValue();
    }
}
