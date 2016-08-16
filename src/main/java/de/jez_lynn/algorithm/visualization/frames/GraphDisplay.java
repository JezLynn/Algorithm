package de.jez_lynn.algorithm.visualization.frames;

import de.jez_lynn.algorithm.algorithm.path.BellmanFord;
import de.jez_lynn.algorithm.algorithm.path.Dijkstra;
import de.jez_lynn.algorithm.util.graph.*;
import de.jez_lynn.algorithm.util.graph.edge.DirectedEdge;
import de.jez_lynn.algorithm.util.graph.edge.Edge;
import de.jez_lynn.algorithm.util.graph.vertex.Vertex;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

import java.util.LinkedList;

/**
 * Copyright 2016
 * Created on   : 03.08.2016
 * Author       : Michael Schlittenbauer
 */
public class GraphDisplay {

    private Graph<? extends Edge> graph;
    private org.graphstream.graph.Graph displayGraph;

    public GraphDisplay() {
        this(new WeightedDirectedGraph(0));
    }

    public GraphDisplay(Graph g) {
        this.graph = g;
        this.displayGraph = new SingleGraph("Graph Visualization");
        this.displayGraph.setAutoCreate(true);
        this.displayGraph.setStrict(false);
    }

    public void update(long[] distance) {
        displayGraph.getEdgeSet().retainAll(graph.edges());
        for (Edge e : graph.edges()) {
            displayGraph.addEdge("" + e.id(), "" + e.from().id(), "" + e.to().id(), true).setAttribute("ui.label", e.weight());
        }

        for (Node v : displayGraph) {
            int id = Integer.valueOf(v.getId());
            System.out.print("Knoten: " + (id + 1));
            System.out.println(" hat eine Distanz von: " + distance[id]);
            v.addAttribute("ui.label", (id + 1) + "|" + distance[id]);
        }
    }

    public static void main(String[] args) throws Exception {
        GraphDisplay graphDisplay = new GraphDisplay(new TestGraph().undirectedGraph);
        Dijkstra path = new Dijkstra();
        Vertex source = graphDisplay.graph.vertices().get(0);
        Vertex target = graphDisplay.graph.vertices().get(5);
        System.out.println("Die Quelle ist: " + source.name());
        graphDisplay.update(path.findPath((WeightedUndirectedGraph) graphDisplay.graph, source));
        graphDisplay.displayGraph.display();
        System.out.print("Berechne Pfad von: " + source.name() + " nach " + target.name() + " : ");
        //System.out.println(path.getPath(source, target));
    }

}
