package de.jez_lynn.algorithm.algorithm.sort;

import de.jez_lynn.algorithm.util.BinaryTree;
import de.jez_lynn.algorithm.util.ISortingAlgo;
public class BinaryTreeSort implements ISortingAlgo {

    private int steps = 0;

    @Override
    public Comparable[] sort(Comparable[] data) {
        BinaryTree tree = new BinaryTree(data);
        Comparable[] r = tree.toArray();
        steps = r.length;
        return r;
    }

    @Override
    public int getSteps() {
        return steps;
    }
}
