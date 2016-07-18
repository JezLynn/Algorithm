package de.jez_lynn.algorithm.algorithm.sort;

import de.jez_lynn.algorithm.util.ISortingAlgo;

import java.util.Arrays;

public class MergeSort implements ISortingAlgo {
    private int steps = 0;

    public Comparable<?>[] sort(Comparable[] data) {
        steps = 0;
        Comparable[] r = mergeSort(data);
        return r;
    }

    private Comparable[] mergeSort(Comparable[] data) {
        steps++;
        if (data.length <= 1) return data;

        Comparable[] left = mergeSort(Arrays.copyOfRange(data, 0, data.length / 2));
        Comparable[] right = mergeSort(Arrays.copyOfRange(data, data.length / 2, data.length));
        return merge(left, right);
    }

    private Comparable[] merge(Comparable[] left, Comparable[] right) {
        Comparable[] merged = new Comparable[left.length + right.length];
        int i = 0, j = 0, insert = 0;
        while (i < left.length & j < right.length) {
            if (left[i].compareTo(right[j]) < 1) {
                merged[insert] = left[i];
                insert++;
                i++;
            } else {
                merged[insert] = right[j];
                insert++;
                j++;
            }
        }
        while (i < left.length) {
            merged[insert] = left[i];
            insert++;
            i++;
        }

        while (j < right.length) {
            merged[insert] = right[j];
            insert++;
            j++;
        }

        return merged;
    }

    public int getSteps() {
        return steps;
    }
}
