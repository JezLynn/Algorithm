package de.jez_lynn.algorithm.algorithm.sort;

import de.jez_lynn.algorithm.util.ISortingAlgo;

public class QuikSort implements ISortingAlgo {
    private int steps;

    @Override
    public Comparable[] sort(Comparable[] data) {
        sort(0, data.length - 1, data);
        return data;
    }

    private void sort(int left, int right, Comparable[] data) {
        if (left < right) {
            int pivot = pivot(left, right, data);
            sort(left, pivot - 1, data);
            sort(pivot + 1, right, data);
        }
    }

    private int pivot(int left, int right, Comparable[] data) {
        int i = left;
        int j = right - 1;
        //TODO find better way to find pivot
        Comparable pivot = data[right];
        do {
            steps++;
            while (data[i].compareTo(pivot) <= 0 && i < right)
                i++;

            while (data[j].compareTo(pivot) >= 0 && j > left) {
                j--;
            }

            if (i < j) {
                swap(i, j, data);
            }
        } while (i < j);

        if (data[i].compareTo(pivot) > 0) {
            swap(i, right, data);
        }
        return i;
    }

    private void swap(int i, int j, Comparable[] data) {
        Comparable temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    @Override
    public int getSteps() {
        return steps;
    }
}
