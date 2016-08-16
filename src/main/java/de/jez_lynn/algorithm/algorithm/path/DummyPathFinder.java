package de.jez_lynn.algorithm.algorithm.path;

import de.jez_lynn.algorithm.util.graph.Graph;
import de.jez_lynn.algorithm.util.graph.edge.DirectedEdge;
import de.jez_lynn.algorithm.util.IPathFindingAlgo;
import de.jez_lynn.algorithm.util.graph.vertex.Vertex;

import java.util.LinkedList;

/**
 * Created by mail on 18.07.2016.
 */
public class DummyPathFinder implements IPathFindingAlgo {

    @Override
    public long[] findPath(Graph graph, Vertex start) throws Exception {
        return new long[0];
    }
}
