package de.jez_lynn.algorithm.algorithm.search.graph;

import de.jez_lynn.algorithm.util.IGraphSearchingAlgo;
import de.jez_lynn.algorithm.util.graph.vertex.Vertex;

import java.util.LinkedList;

public class BreathFirstSearch implements IGraphSearchingAlgo {
    @Override
    public boolean search(Vertex start, Vertex end) {
        LinkedList<Vertex> queue = new LinkedList<>();
        queue.push(start);
        start.visited = true;
        while (!queue.isEmpty()) {
            Vertex current = queue.pop();
            if (current.equals(end)) {
                return true;
            }
            current.childs().stream().filter(child -> !child.visited).forEach(child -> {
                queue.push(child);
                child.visited = true;
            });
        }
        return false;
    }
}
