package de.jez_lynn.algorithm.util.graph;

import de.jez_lynn.algorithm.util.graph.vertex.Vertex;

/**
 * Created by mail on 18.07.2016.
 */
public class TestGraph {

    public WeightedDirectedGraph directedGraph = new WeightedDirectedGraph(10);
    public WeightedUndirectedGraph undirectedGraph = new WeightedUndirectedGraph(10);

    public final Vertex ONE = new Vertex(0, "one");
    public final Vertex TWO = new Vertex(1, "two");
    public final Vertex THREE = new Vertex(2, "three");
    public final Vertex FOUR = new Vertex(3, "four");
    public final Vertex FIVE = new Vertex(4, "five");
    public final Vertex SIX = new Vertex(5, "six");
    public final Vertex SEVEN = new Vertex(6, "seven");
    public final Vertex EIGHT = new Vertex(7, "eight");
    public final Vertex NINE = new Vertex(8, "nine");
    public final Vertex TEN = new Vertex(9, "ten");

    public TestGraph() {
        connectGraph();
    }

    private void connectGraph() {
        ONE.addChild(TWO, THREE, FOUR);
        TWO.addChild(FOUR, SIX);

        directedGraph.addEdge(ONE, TWO, 3);
        directedGraph.addEdge(ONE, THREE, 4);
        directedGraph.addEdge(ONE, FOUR, 10);
        directedGraph.addEdge(FOUR, TWO, 2);
        directedGraph.addEdge(TWO, SIX, 3);
        directedGraph.addEdge(FOUR, THREE, 2);
        directedGraph.addEdge(THREE, FIVE, 5);
        directedGraph.addEdge(FIVE, ONE, 7);

        undirectedGraph.addEdge(ONE, TWO, 3);
        undirectedGraph.addEdge(ONE, THREE, 4);
        undirectedGraph.addEdge(ONE, FOUR, 10);
        undirectedGraph.addEdge(FOUR, TWO, 2);
        undirectedGraph.addEdge(TWO, SIX, 3);
        undirectedGraph.addEdge(FOUR, THREE, 2);
        undirectedGraph.addEdge(THREE, FIVE, 5);
        undirectedGraph.addEdge(FIVE, ONE, 7);
    }
}
