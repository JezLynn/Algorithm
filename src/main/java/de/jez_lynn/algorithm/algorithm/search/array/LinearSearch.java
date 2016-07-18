package de.jez_lynn.algorithm.algorithm.search.array;

import de.jez_lynn.algorithm.util.IArraySearchingAlgo;

public class LinearSearch implements IArraySearchingAlgo {
    @Override
    public int search(Comparable key, Comparable[] data) {
        for (int i = 0; i < data.length; i++) {
            if (key.compareTo(data[i]) == 0)
                return i;
        }
        return -1;
    }
}
