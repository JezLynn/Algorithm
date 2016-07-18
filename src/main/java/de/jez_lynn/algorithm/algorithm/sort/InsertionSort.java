package de.jez_lynn.algorithm.algorithm.sort;

import de.jez_lynn.algorithm.util.ISortingAlgo;

public class InsertionSort implements ISortingAlgo {

    private int steps;

    @Override
    public Comparable<?>[] sort(Comparable[] data) {
        steps = 0;
        for (int i = 1; i < data.length; i++) {
            steps++;
            Comparable sortingValue = data[i];
            int j = i;
            while (j > 0 && data[j - 1].compareTo(sortingValue) > 0) {
                steps++;
                data[j] = data[j - 1];
                j--;
            }
            data[j] = sortingValue;
        }
        return data;
    }

    @Override
    public int getSteps() {
        return steps;
    }
}
