package de.jez_lynn.algorithm.algorithm.path;

import de.jez_lynn.algorithm.util.IPathFindingAlgo;
import de.jez_lynn.algorithm.util.graph.WeightedDirectedGraph;
import de.jez_lynn.algorithm.util.graph.edge.DirectedEdge;
import de.jez_lynn.algorithm.util.graph.edge.Edge;
import de.jez_lynn.algorithm.util.graph.vertex.Vertex;
import javafx.util.Pair;

import java.util.List;


public class BellmanFord implements IPathFindingAlgo<WeightedDirectedGraph> {

    private long[] dist;
    private Vertex[] prev;


    @Override
    public Pair<long[], Vertex[]> findPath(WeightedDirectedGraph graph, Vertex source) throws Exception {
        List<Vertex> vertices = graph.vertices();
        List<DirectedEdge> edges = graph.edges();

        dist = new long[vertices.size()];
        prev = new Vertex[vertices.size()];

        for (int v = 0; v < vertices.size(); v++) {
            dist[v] = Long.MAX_VALUE;
            prev[v] = null;
        }

        dist[source.id()] = 0;

        for (int i = 0; i < vertices.size() - 1; i++) {
            for (Edge e : edges) {
                if (!willAdditionOverflow(dist[e.from().id()], e.weight()))
                    if (dist[e.from().id()] + e.weight() < dist[e.to().id()]) {
                        dist[e.to().id()] = dist[e.from().id()] + e.weight();
                        prev[e.to().id()] = e.from();
                    }
            }
        }

        for (Edge e : edges) {
            if (!willAdditionOverflow(dist[e.from().id()], e.weight()))
                if (dist[e.from().id()] + e.weight() < dist[e.to().id()])
                    throw new Exception("GraphDisplay contains a negativ-weight cycle");
        }

        return new Pair<>(dist, prev);
    }

    private boolean willAdditionOverflow(long left, long right) {
        try {
            Math.addExact(left, right);
            return false;
        } catch (ArithmeticException e) {
            return true;
        }
    }

    private boolean willSubtractionOverflow(long left, long right) {
        try {
            Math.subtractExact(left, right);
            return false;
        } catch (ArithmeticException e) {
            return true;
        }
    }
}
