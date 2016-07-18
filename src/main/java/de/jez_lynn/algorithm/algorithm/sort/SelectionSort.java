package de.jez_lynn.algorithm.algorithm.sort;

import de.jez_lynn.algorithm.util.ISortingAlgo;

public class SelectionSort implements ISortingAlgo {
    private int steps;

    public Comparable[] sort(Comparable[] data) {
        int length = data.length;
        int min, left = 0;
        steps = 0;
        do {
            min = left;
            for (int searchIndex = left + 1; searchIndex < length; searchIndex++) {
                steps++;
                if (data[searchIndex].compareTo(data[min]) < 0) {
                    min = searchIndex;
                }
            }
            swap(min, left, data);
            left++;
        } while (left < length);
        return data;
    }

    private void swap(int min, int left, Comparable[] data) {
        Comparable temp = data[left];
        data[left] = data[min];
        data[min] = temp;
    }

    public int getSteps() {
        return steps;
    }
}
