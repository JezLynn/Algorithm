package de.jez_lynn.algorithm.algorithm;

import com.google.common.base.Stopwatch;
import de.jez_lynn.algorithm.util.Dummys;
import de.jez_lynn.algorithm.util.IGraphSearchingAlgo;
import de.jez_lynn.algorithm.util.IPathFindingAlgo;
import de.jez_lynn.algorithm.util.Node;

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

    public int search(Node start, Node end) {
        watch = Stopwatch.createStarted();
        int distance = findingAlgo.findPath(start, end);
        watch.stop();
        return distance;
    }

    public long getTime() {
        return watch.elapsed(TimeUnit.MICROSECONDS);
    }
}
