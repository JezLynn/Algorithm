package de.jez_lynn.algorithm.algorithm.search.graph;

import de.jez_lynn.algorithm.util.IGraphSearchingAlgo;
import de.jez_lynn.algorithm.util.graph.vertex.Vertex;

import java.util.LinkedList;

/**
 * Created by mail on 18.07.2016.
 */
public class DepthFirstSearch implements IGraphSearchingAlgo{
    private boolean result = false;
    @Override
    public boolean search(Vertex start, Vertex end) {
        if(start.equals(end)){
            result = true;
            return result;
        }else{
            LinkedList<Vertex> childs = start.childs();
            while(!childs.isEmpty()){
                search(childs.pop(), end);
            }
            return result;
        }
    }
}
