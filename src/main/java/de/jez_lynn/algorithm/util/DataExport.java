package de.jez_lynn.algorithm.util;

import javafx.util.Pair;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class DataExport {
    public static void export(HashMap<ISortingAlgo, List<Pair<Integer, Long>>> data) {
        FileWriter writer = null;
        try {
            writer = new FileWriter("test.csv");
            writer.append("AlgoName,Schritte,Zeit\n");
            for (ISortingAlgo algo : data.keySet()) {
                boolean first = true;
                writer.append(algo.getClass().getSimpleName()).append(",");
                List<Pair<Integer, Long>> results = data.get(algo);
                for (Pair<Integer, Long> r : results) {
                    if (first) {
                        writer.append(r.getKey().toString()).append(",").append(r.getValue().toString()).append("\n");
                        first = false;
                    } else {
                        writer.append(",").append(r.getKey().toString()).append(",").append(r.getValue().toString()).append("\n");
                    }
                }
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null)
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
