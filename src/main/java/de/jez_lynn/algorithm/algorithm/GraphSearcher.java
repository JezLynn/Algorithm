package de.jez_lynn.algorithm.algorithm;

import com.google.common.base.Stopwatch;
import de.jez_lynn.algorithm.util.Dummys;
import de.jez_lynn.algorithm.util.IGraphSearchingAlgo;
import de.jez_lynn.algorithm.util.Node;

import java.util.concurrent.TimeUnit;

/**
 * Created by mail on 18.07.2016.
 */
public class GraphSearcher {
    private IGraphSearchingAlgo searchingAlgo;
    private Stopwatch watch;

    public GraphSearcher() {
        this(Dummys.GRAPH_SEARCHER);
    }

    public GraphSearcher(IGraphSearchingAlgo searchingAlgo) {
        this.searchingAlgo = searchingAlgo;
    }

    public void setSearchingAlgo(IGraphSearchingAlgo searchingAlgo) {
        this.searchingAlgo = searchingAlgo;
    }

    public boolean search(Node start, Node end) {
        watch = Stopwatch.createStarted();
        boolean r = searchingAlgo.search(start, end);
        watch.stop();
        return r;
    }

    public long getTime() {
        return watch.elapsed(TimeUnit.MICROSECONDS);
    }
}
