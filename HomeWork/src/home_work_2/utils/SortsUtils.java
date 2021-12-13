package home_work_2.utils;

/*
    4.2. Создать класс SortsUtils. Пишем в нём следующие алгоритмы:
		4.2.1. Пузырьковая сортировка
		4.2.2. Шейкерная сортировка
 */

import java.util.Arrays;

public class SortsUtils {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            int[] ints = ArraysUtils.arrayRandom(100, 1000);

            //Проверяем bubbleSort
            System.out.println("Пузырьковая сортировка: ");
            int[] bubbleArray = Arrays.copyOf(ints, ints.length);
            bubbleSort(bubbleArray);
            isSorted(bubbleArray);

            //Проверяем шейкерную сортировку
            System.out.print("Шейкерная сортировка: ");
            int[] shackerArray = Arrays.copyOf(ints, ints.length);
            //shackerArray = new int[]{346, 500, 861, 899, 482, 810, 119, 443, 324, 431};
            //System.out.printf(Arrays.toString(shackerArray));
            shakerSort(shackerArray);

            isSorted(shackerArray);

            //Проверяем mySort
            System.out.println("Моя сортировка: ");
            int[] myArray = Arrays.copyOf(ints, ints.length);
            mySort(myArray);
            isSorted(myArray);
        }
    }


    public static void bubbleSort(int[] array) {
        for (int i = 0, maxIndex = array.length - 1; i < maxIndex; maxIndex--) {
            changeLeft(array, i, maxIndex);
        }
    }





    //    Shaker sorting
    public static void shakerSort(int[] array) {
        int minIndex = 0;
        int maxIndex = array.length - 1;
        do {

            changeLeft(array, minIndex, maxIndex);
            maxIndex--;
            changeRight(array, minIndex, maxIndex);
            minIndex++;
        }while (minIndex <= maxIndex);
    }



    private static void changeLeft(int[] array, int minIndex, int maxIndex) {
        for (int i = minIndex; i < maxIndex; i++) {
            change(array, i + 1, i );
        }
    }

    private static void changeRight(int[] array, int minIndex, int maxIndex) {
        for (int i = maxIndex - 1; i >= minIndex; i--) {
            change(array, i + 1 , i);
        }
    }

    private static void change(int[] array, int next, int last) {
        if (array[last] > array[next]) {
           int buffer = array[last];
           array[last] = array[next];
           array[next] = buffer;
        }
    }

    //    mySort
    public static void mySort(int[] array) {

        for (int i = 1; i < array.length; i++) {

            if (array[i] < array[i - 1]) {
                changePlaces(array, i);
            }
        }
    }

    private static void changePlaces(int[] array, int index) {

        int buffer = array[index];

        for (int i = index - 1; i >= 0; i--) {

            if (buffer < array[i]) {
                array[i + 1] = array[i];
                array[i] = buffer;
            }else {
                break;
            }
        }
    }

    private static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                System.out.println("-----------------------------------------------" + false);
                return false;

            }
        }
        System.out.println(true);
        return true;
    }
}




