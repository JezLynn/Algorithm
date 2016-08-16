package de.jez_lynn.algorithm.util;

import de.jez_lynn.algorithm.util.graph.Graph;
import de.jez_lynn.algorithm.util.graph.vertex.Vertex;

/**
 * Created by mail on 18.07.2016.
 */
public interface IPathFindingAlgo<E extends Graph> {
    long[] findPath(E graph, Vertex start) throws Exception;
}
