package de.jez_lynn.algorithm.algorithm.sort;

import de.jez_lynn.algorithm.util.ISortingAlgo;

public class BubbleSort implements ISortingAlgo {

    private int steps;

    @Override
    public Comparable<?>[] sort(Comparable[] data) {
        steps = 0;
        int unsortedBelow = data.length;

        while (unsortedBelow > 0) {
            int lastSwap = 0;
            for (int i = 1; i < unsortedBelow; i++) {
                steps++;
                if (data[i - 1].compareTo(data[i]) > 0) {
                    swap(data, i, i - 1);
                    lastSwap = i;
                }
            }
            unsortedBelow = lastSwap;
        }
        return data;
    }

    private void swap(Comparable[] data, int a, int b) {
        Comparable temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

    @Override
    public int getSteps() {
        return steps;
    }
}
