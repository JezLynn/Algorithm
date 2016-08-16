package de.jez_lynn.algorithm.util.graph.vertex;

import java.util.LinkedList;

/**
 * Created by mail on 18.07.2016.
 */
public class Vertex {
    private LinkedList<Vertex> childs;
    private String name;
    private int id;
    public boolean visited;

    public Vertex(int id) {
        this(id, String.valueOf(id));
    }

    public Vertex(int id, String name) {
        this(id, name, new LinkedList<>());
    }

    public Vertex(int id, String name, LinkedList<Vertex> childs) {
        this.name = name;
        this.id = id;
        this.childs = childs;
    }

    public Vertex addChild(Vertex... vertex) {
        for (Vertex n : vertex) {
            childs.push(n);
        }
        return this;
    }

    public boolean equals(Vertex vertex) {
        return this.id == vertex.id;
    }

    public LinkedList<Vertex> childs() {
        return childs;
    }

    public String name() {
        return name;
    }

    public int id() {
        return id;
    }
}
