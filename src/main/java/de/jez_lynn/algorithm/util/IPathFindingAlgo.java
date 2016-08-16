package de.jez_lynn.algorithm.util;

import de.jez_lynn.algorithm.util.graph.Graph;
import de.jez_lynn.algorithm.util.graph.vertex.Vertex;
import javafx.util.Pair;

/**
 * Created by mail on 18.07.2016.
 */
public interface IPathFindingAlgo<E extends Graph> {

    Pair<long[], Vertex[]> findPath(E graph, Vertex start) throws Exception;

    default String getPath(Vertex start, Vertex end, Vertex[] prev) {
        if (prev != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(end.name()).reverse();
            Vertex temp = prev[end.id()];
            while (temp != null && !temp.equals(start)) {
                sb.append(String.format(">-%s", new StringBuilder().append(temp.name()).reverse()));
                temp = prev[temp.id()];
            }

            if (temp != null && temp.equals(start)) {
                sb.append(String.format(">-%s", new StringBuilder().append(temp.name()).reverse()));
            } else {
                sb = new StringBuilder("Kein Weg gefunden");
            }

            return sb.reverse().toString();
        } else {
            return "";
        }
    }
}
