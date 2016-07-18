package de.jez_lynn.algorithm.util;

import de.jez_lynn.algorithm.util.Node;
import javafx.util.Pair;

import java.util.LinkedList;

/**
 * Created by mail on 18.07.2016.
 */
public class TestGraph {
    public final Node ONE = new Node("one");
    public final Node TWO = new Node("two");
    public final Node THREE = new Node("three");
    public final Node FOUR = new Node("four");
    public final Node FIVE = new Node("five");
    public final Node SIX = new Node("six");
    public final Node SEVEN = new Node("seven");
    public final Node EIGHT = new Node("eight");
    public final Node NINE = new Node("nine");
    public final Node TEN = new Node("ten");

    public final Edge FIRST = new Edge(3,new Pair<>(ONE, THREE));
    public final Edge SECOND = new Edge(4, new Pair<>(ONE, FOUR));
    public final Edge THRID = new Edge(10, new Pair<>(ONE, TWO));
    public final Edge FOURTH = new Edge(2, new Pair<>(FOUR, TWO));
    public final Edge FIFTH = new Edge(3, new Pair<>(TWO, SIX));

    public TestGraph(){
        connectGraph();
    }

    private void connectGraph(){
        ONE.addChild(TWO, THREE, FOUR);
        TWO.addChild(FOUR, SIX);
    }

    public LinkedList<Node> getNodes(){
        LinkedList<Node> nodes = new LinkedList<>();
        nodes.push(ONE);
        nodes.push(TWO);
        nodes.push(THREE);
        nodes.push(FOUR);
        nodes.push(FIVE);
        nodes.push(SIX);
        nodes.push(SEVEN);
        nodes.push(EIGHT);
        nodes.push(NINE);
        nodes.push(TEN);
        return nodes;
    }

    public LinkedList<Edge> getEdges(){
        LinkedList<Edge> edges = new LinkedList<>();

        edges.push(FIRST);
        edges.push(SECOND);
        edges.push(THRID);
        edges.push(FOURTH);
        edges.push(FIFTH);

        return edges;
    }
}
