package de.jez_lynn.algorithm.algorithm;

import com.google.common.base.Stopwatch;
import de.jez_lynn.algorithm.util.Dummys;
import de.jez_lynn.algorithm.util.ISortingAlgo;

import java.util.concurrent.TimeUnit;

public class Sorter {
    private ISortingAlgo sortingAlgo;
    private Comparable[] data;
    private Stopwatch watch;

    public Sorter(Comparable[] data) {
        this(data, Dummys.SORTER);
    }

    public Sorter(Comparable[] data, ISortingAlgo sortingAlgo) {
        this.data = data;
        this.sortingAlgo = sortingAlgo;
    }

    public void setSortingAlgo(ISortingAlgo sortingAlgo) {
        this.sortingAlgo = sortingAlgo;
    }

    public void setData(Comparable[] data) {
        this.data = data;
    }

    public Comparable[] sort() {
        if (sortingAlgo != null) {
            watch = Stopwatch.createStarted();
            Comparable[] result = sortingAlgo.sort(data);
            watch.stop();
            return result;
        }
        return null;
    }

    public int getSteps() {
        return sortingAlgo.getSteps();
    }

    public long getTime() {
        return watch.elapsed(TimeUnit.MICROSECONDS);
    }
}
