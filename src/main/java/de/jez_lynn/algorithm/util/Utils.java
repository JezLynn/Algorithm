package de.jez_lynn.algorithm.util;

public class Utils {
    public static boolean compareArrays(Comparable[] array1, Comparable[] array2) {
        boolean b = true;
        if (array1 != null && array2 != null) {
            if (array1.length != array2.length)
                b = false;
            else
                for (int i = 0; i < array2.length; i++) {
                    if (!array2[i].equals(array1[i])) {
                        b = false;
                    }
                }
        } else {
            b = false;
        }
        return b;
    }
}
