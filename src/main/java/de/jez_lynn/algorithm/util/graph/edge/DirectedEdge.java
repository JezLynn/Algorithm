package de.jez_lynn.algorithm.util.graph.edge;

import de.jez_lynn.algorithm.util.graph.vertex.Vertex;
import javafx.util.Pair;

/**
 * Copyright 2016
 * Created on   : 01.08.2016
 * Author       : Michael Schlittenbauer
 */
public class DirectedEdge extends Edge{

    public DirectedEdge(int key, int weight, Vertex from, Vertex to) {
        super(key, weight, new Pair<>(from, to));
    }

    public Vertex from(){
        return vertices.getKey();
    }

    public Vertex to(){
        return vertices.getValue();
    }
}
