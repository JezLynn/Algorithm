package de.jez_lynn.algorithm.algorithm.sort;

import de.jez_lynn.algorithm.util.ISortingAlgo;

import java.util.ArrayList;
import java.util.List;

public class BucketSort implements ISortingAlgo {

    private static final int DEFAULT_BUCKET_SIZE = 5;

    private int steps;

    private final ISortingAlgo sortingAlgo;

    public BucketSort() {
        this(new InsertionSort());
    }

    public BucketSort(ISortingAlgo sortingAlgo) {
        this.sortingAlgo = sortingAlgo;
    }


    @Override
    public Comparable<?>[] sort(Comparable[] data) {
        return sort(data, DEFAULT_BUCKET_SIZE);
    }

    private Comparable<?>[] sort(Comparable[] data, int defaultBucketSize) {
        if (data.length == 0)
            return data;

        Comparable minValue = data[0];
        Comparable maxValue = data[0];

        for (int i = 1; i < data.length; i++) {
            if (data[i].compareTo(minValue) < 0) {
                minValue = data[i];
            } else if (data[i].compareTo(maxValue) > 0) {
                maxValue = data[i];
            }
        }

        int bucketCount = (maxValue.hashCode() - minValue.hashCode()) / defaultBucketSize + 1;
        List<List<Comparable>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        for (Comparable aData : data) {
            buckets.get((aData.hashCode() - minValue.hashCode()) / defaultBucketSize).add(aData);
        }

        int currentIndex = 0;
        for (List<Comparable> bucket : buckets) {
            Comparable[] bucketArray = new Comparable[bucket.size()];
            bucketArray = bucket.toArray(bucketArray);
            bucketArray = sortingAlgo.sort(bucketArray);
            steps = sortingAlgo.getSteps();
            for (Comparable aBucketArray : bucketArray) {
                data[currentIndex++] = aBucketArray;
            }
        }
        return data;
    }

    @Override
    public int getSteps() {
        return steps;
    }
}
