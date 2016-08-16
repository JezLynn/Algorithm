package de.jez_lynn.algorithm.algorithm;

import com.google.common.base.Stopwatch;
import de.jez_lynn.algorithm.util.Dummys;
import de.jez_lynn.algorithm.util.IPathFindingAlgo;
import de.jez_lynn.algorithm.util.graph.Graph;
import de.jez_lynn.algorithm.util.graph.vertex.Vertex;
import javafx.util.Pair;

import java.util.concurrent.TimeUnit;


public class PathFinder {
    private IPathFindingAlgo findingAlgo;
    private Stopwatch watch;

    public PathFinder() {
        this(Dummys.PATH_FINDER);
    }

    public PathFinder(IPathFindingAlgo<? extends Graph> searchingAlgo) {
        this.findingAlgo = searchingAlgo;
    }

    public void setFindingAlgo(IPathFindingAlgo<? extends Graph> findingAlgo) {
        this.findingAlgo = findingAlgo;
    }

    public long[] search(Graph g) throws Exception {
        watch = Stopwatch.createStarted();
        Pair<long[], Vertex[]> r = findingAlgo.findPath(g, ((Vertex) g.vertices().getFirst()));
        long[] distance = r.getKey();
        watch.stop();
        return distance;
    }

    public long getTime() {
        return watch.elapsed(TimeUnit.MICROSECONDS);
    }
}
