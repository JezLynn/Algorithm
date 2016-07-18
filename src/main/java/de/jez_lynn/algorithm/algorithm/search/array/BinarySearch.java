package de.jez_lynn.algorithm.algorithm.search.array;

import de.jez_lynn.algorithm.util.IArraySearchingAlgo;

public class BinarySearch implements IArraySearchingAlgo {

    @Override
    public int search(Comparable key, Comparable[] data) {
        int left = 0, right = data.length - 1;
        while (left <= right) {
            int center = (left + right) / 2;
            if (data[center].compareTo(key) == 0) return center;
            if (data[center].compareTo(key) > 0) right = center - 1;
            if (data[center].compareTo(key) < 0) left = center + 1;
        }
        return -1;
    }
}
