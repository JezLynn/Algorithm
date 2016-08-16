package de.jez_lynn.algorithm.algorithm.path;

import de.jez_lynn.algorithm.util.IPathFindingAlgo;
import de.jez_lynn.algorithm.util.graph.Graph;
import de.jez_lynn.algorithm.util.graph.vertex.Vertex;
import javafx.util.Pair;

public class DummyPathFinder implements IPathFindingAlgo<Graph> {

    @Override
    public Pair<long[], Vertex[]> findPath(Graph graph, Vertex start) throws Exception {
        return new Pair<>(new long[0], new Vertex[0]);
    }
}
