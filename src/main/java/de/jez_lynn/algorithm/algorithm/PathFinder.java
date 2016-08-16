package de.jez_lynn.algorithm.algorithm;

import com.google.common.base.Stopwatch;
import de.jez_lynn.algorithm.util.*;
import de.jez_lynn.algorithm.util.graph.WeightedDirectedGraph;

import java.util.concurrent.TimeUnit;

/**
 * Created by mail on 18.07.2016.
 */
public class PathFinder {
    private IPathFindingAlgo findingAlgo;
    private Stopwatch watch;

    public PathFinder() {
        this(Dummys.PATH_FINDER);
    }

    public PathFinder(IPathFindingAlgo searchingAlgo) {
        this.findingAlgo = searchingAlgo;
    }

    public void setFindingAlgo(IPathFindingAlgo findingAlgo) {
        this.findingAlgo = findingAlgo;
    }

    public long[] search(WeightedDirectedGraph g) throws Exception {
        watch = Stopwatch.createStarted();
        long[] distance = findingAlgo.findPath(g, g.vertices().getFirst());
        watch.stop();
        return distance;
    }

    public long getTime() {
        return watch.elapsed(TimeUnit.MICROSECONDS);
    }
}
