package de.jez_lynn.algorithm.util;

import java.util.LinkedList;

/**
 * Created by mail on 18.07.2016.
 */
public class Node {
    public LinkedList<Node> childs;
    public String key;
    public boolean visited;

    public Node(String key){
        this(key, new LinkedList<>());
    }

    public Node(String key, LinkedList<Node> childs){
        this.key = key;
        this.childs = childs;
        this.visited = false;
    }

    public Node addChild(Node... node){
        for (Node n: node) {
            childs.push(n);
        }
        return this;
    }

    public boolean equals(Node node){
        return this.key.equals(node.key);
    }
}
