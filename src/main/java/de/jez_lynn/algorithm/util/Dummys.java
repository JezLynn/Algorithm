package de.jez_lynn.algorithm.util;

import de.jez_lynn.algorithm.algorithm.path.DummyPathFinder;
import de.jez_lynn.algorithm.algorithm.search.graph.DummyGraphSorter;
import de.jez_lynn.algorithm.algorithm.sort.DummySorter;

public class Dummys {
    public static final DummySorter SORTER = new DummySorter();
    public static final DummyGraphSorter GRAPH_SEARCHER = new DummyGraphSorter();
    public static final DummyPathFinder PATH_FINDER = new DummyPathFinder();
}
