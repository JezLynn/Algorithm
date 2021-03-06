package de.jez_lynn.algorithm;

import de.jez_lynn.algorithm.algorithm.GraphSearcher;
import de.jez_lynn.algorithm.algorithm.PathFinder;
import de.jez_lynn.algorithm.algorithm.Sorter;
import de.jez_lynn.algorithm.algorithm.path.BellmanFord;
import de.jez_lynn.algorithm.algorithm.search.graph.BreathFirstSearch;
import de.jez_lynn.algorithm.algorithm.search.graph.DepthFirstSearch;
import de.jez_lynn.algorithm.algorithm.sort.*;
import de.jez_lynn.algorithm.util.*;
import de.jez_lynn.algorithm.util.graph.TestGraph;
import javafx.util.Pair;

import java.util.*;

import static de.jez_lynn.algorithm.util.Utils.compareArrays;

public class Algorithm {

    private void sort() {
        Integer[] sortable = new Integer[4096];
        Random r = new Random();
        for (int i = 0; i < sortable.length; i++) {
            sortable[i] = r.nextInt();
        }

        Integer[] sorted = Arrays.copyOf(sortable, sortable.length);
        Arrays.sort(sorted);

        ISortingAlgo[] algos = new ISortingAlgo[]{new MergeSort(), new SelectionSort(), new InsertionSort(),
                new BubbleSort(), new BinaryTreeSort(), new QuikSort()};
        Sorter sorter = new Sorter(Arrays.copyOf(sortable, sortable.length));
        HashMap<ISortingAlgo, List<Pair<Integer, Long>>> results = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            for (ISortingAlgo a : algos) {
                if (!results.containsKey(a)) {
                    results.put(a, new LinkedList<>());
                }
                sorter.setSortingAlgo(a);
                sorter.setData(Arrays.copyOf(sortable, sortable.length));

                Comparable[] result = sorter.sort();

                System.out.println(String.format("\n-----------%s--------------", a.getClass().getSimpleName()));
                System.out.println(Arrays.toString(result));
                System.out.println(sorter.getSteps());
                System.out.println(sorter.getTime());
                System.out.println("Correct: " + compareArrays(sorted, result));
                results.get(a).add(new Pair<>(sorter.getSteps(), sorter.getTime()));
            }
        }
        DataExport.export(results);
    }

    public void findPath(){
        PathFinder searcher = new PathFinder();
        IPathFindingAlgo[] algos = new IPathFindingAlgo[]{new BellmanFord()};
        TestGraph g = new TestGraph();

        for (IPathFindingAlgo a : algos){
            searcher.setFindingAlgo(a);
            long[] distance = new long[0];
            try {
                distance = searcher.search(g.directedGraph);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(String.format("\n-----------%s--------------", a.getClass().getSimpleName()));
            System.out.println(Arrays.toString(distance));
            System.out.println(searcher.getTime());
        }
    }

    private void search() {
        GraphSearcher searcher = new GraphSearcher();
        IGraphSearchingAlgo[] algos = new IGraphSearchingAlgo[]{new BreathFirstSearch(), new DepthFirstSearch()};
        TestGraph g = new TestGraph();

        for (int i = 0; i < 10; i++) {
            for (IGraphSearchingAlgo a : algos) {

                searcher.setSearchingAlgo(a);
                boolean result = searcher.search(g.ONE, g.NINE);

                System.out.println(String.format("\n-----------%s--------------", a.getClass().getSimpleName()));
                System.out.println(result);
                System.out.println(searcher.getTime());
            }
        }
    }


    public static void main(String[] args) {
        Algorithm a = new Algorithm();
        a.findPath();
        //a.search();
        //a.sort();
    }
}
