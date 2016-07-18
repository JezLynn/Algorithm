package de.jez_lynn.algorithm.algorithm.search.graph;

import de.jez_lynn.algorithm.util.IGraphSearchingAlgo;
import de.jez_lynn.algorithm.util.Node;

import java.util.LinkedList;

public class BreathFirstSearch implements IGraphSearchingAlgo {
    @Override
    public boolean search(Node start, Node end) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.push(start);
        start.visited = true;
        while (!queue.isEmpty()) {
            Node current = queue.pop();
            if (current.equals(end)) {
                return true;
            }
            current.childs.stream().filter(child -> !child.visited).forEach(child -> {
                queue.push(child);
                child.visited = true;
            });
        }
        return false;
    }
}
