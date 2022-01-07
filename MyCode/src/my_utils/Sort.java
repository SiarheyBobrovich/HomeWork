package my_utils;

import java.util.Arrays;

public class Sort {

    private static int[] sortTwoNumber(int first, int second) {

        if (first >= second) {
            return new int[]{second, first};
        }else {
            return new int[]{first, second};
        }
    }

    private static int[] sortTreeNumber(int first, int second, int third) {
        return sort(sortTwoNumber(first, second), new int[]{third});
    }

    private static int[] sortTreeArray(int[] first, int[] second, int[] third) {
        return sort(sort(first, second), third);
    }

    public static int[] sort(int[] array) {

        if (array.length < 2) {
            return array;
        }

        int[][] sorts = firstSort(array);

        return sorts[0];
    }

    private static int[][] firstSort(int[] array) {

        int[][] sorts = new int[array.length / 2][];

        for (int i = 1, sortsIndex = 0; i < array.length; i += 2, sortsIndex++) {

            if (i != array.length - 2) {
                sorts[sortsIndex] = sortTwoNumber(array[i - 1], array[i]);
            } else {
                sorts[sortsIndex] = sortTreeNumber(array[i - 1], array[i], array[i + 1]);
            }

        }

        while (sorts.length != 1) {
            sorts = secondSort(sorts);
        }

        return sorts;
    }

    private static int[][] secondSort(int[][] arraySorts) {

        int[][] sorts = new int[arraySorts.length / 2][];

        for (int i = 1, sortedIndex = 0; i < arraySorts.length; i += 2, sortedIndex++) {

            if (i != arraySorts.length - 2) {
                sorts[sortedIndex] = sort(arraySorts[i - 1], arraySorts[i]);
            }else {
                sorts[sortedIndex] = sortTreeArray(arraySorts[i - 1], arraySorts[i], arraySorts[i + 1]);
            }

        }

        return sorts;
    }

    private static int[] sort(int[] a, int[] b) {

        int[] result = new int[a.length + b.length];
        int index = 0;
        int indexA = 0;
        int indexB = 0;

        while (indexA < a.length || indexB < b.length) {

            if(indexB >= b.length) {
                result[index++] = a[indexA++];
            }

            while (indexB < b.length) {

                if(indexA >= a.length) {
                    result[index++] = b[indexB++];
                    continue;
                }else if (a[indexA] == b[indexB]) {
                    result[index++] = a[indexA++];
                    result[index++] = b[indexB++];
                }else if (a[indexA] < b[indexB]) {
                    result[index++] = a[indexA++];
                }else {
                    result[index++] = b[indexB++];
                }
                break;
            }
        }

        return result;
    }

}
