package de.jez_lynn.algorithm.algorithm.sort;

import de.jez_lynn.algorithm.util.ISortingAlgo;

public class DummySorter implements ISortingAlgo {

    public Comparable<?>[] sort(Comparable[] data) {
        return data;
    }

    public int getSteps() {
        return 0;
    }
}
