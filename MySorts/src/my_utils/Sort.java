package my_utils;

import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        int[] i = {1, 22, 13, 2};
        sort(i);
    }

    private int[] sortedArray;


    private Sort(int a, int b) {
        sortedArray = sortInts(a, b);
    }
    private Sort(int a, int b, int c) {
        sortedArray = sort(sortInts(a, b), new int[]{c});
    }

    private Sort(int[] a, int[] b) {
        sortedArray = sort(a, b);
    }
    private Sort(int[] a, int[] b, int[] c) {
        sortedArray = sort(sort(a, b), c);
    }


    public static int[] sort(int[] array) {

        if (array.length < 2) {
            return array;
        }

        Sort[] sorts = firstSort(array);

        return sorts[0].getSortedArray();
    }

    //метод возвращает массив(Sort[]) сортированных массивов(Sort) из одного массива(int[])
    private static Sort[] firstSort(int[] array) {

        Sort[] sorts = new Sort[array.length / 2];

        for (int i = 1, sortsIndex = 0; i < array.length; i += 2, sortsIndex++) {

            if (array.length - i != 2) {
                sorts[sortsIndex] = new Sort(array[i - 1], array[i]);
            } else {
                sorts[sortsIndex] = new Sort(array[i - 1], array[i], array[i + 1]);
            }

        }

        while (sorts.length != 1) {
            sorts = secondSort(sorts);
        }

        return sorts;
    }

    //метод возвращает массив(Sort[]) объединённых массивов(Sort)
    private static Sort[] secondSort(Sort[] arraySorts) {

        Sort[] sorts = new Sort[arraySorts.length / 2];

        for (int i = 1, sortedIndex = 0; i < arraySorts.length; i += 2, sortedIndex++) {

            if (i - arraySorts.length != 2) {
                sorts[sortedIndex] = new Sort(arraySorts[i - 1].getSortedArray(), arraySorts[i].getSortedArray());
            }
            else {
                sorts[sortedIndex] = new Sort(arraySorts[i - 1].getSortedArray(),
                        arraySorts[i].getSortedArray(),
                        arraySorts[i+1].getSortedArray());
            }

        }

        return sorts;
    }

    //getter
    private int[] getSortedArray() {
        return sortedArray;
    }

    private int[] sortInts(int a, int b) {
        return new int[]{Math.min(a, b), Math.max(b, a)};
    }

    @Override
    public String toString() {
        return Arrays.toString(sortedArray);
    }

    private int[] sort(int[] a, int[] b) {
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
                }else if (a[indexA] == b[indexB]) {
                    result[index++] = a[indexA++];
                    result[index++] = b[indexB++];
                    break;
                }else if (a[indexA] < b[indexB]) {
                    result[index++] = a[indexA++];
                    break;
                }else {
                    result[index++] = b[indexB++];
                    break;
                }
            }
        }
        return result;
    }

}
