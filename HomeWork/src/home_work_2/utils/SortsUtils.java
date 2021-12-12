package home_work_2.utils;

/*
    4.2. Создать класс SortsUtils. Пишем в нём следующие алгоритмы:
		4.2.1. Пузырьковая сортировка
		4.2.2. Шейкерная сортировка
 */

import home_work_2.arrays.ArrayIterator;

import java.util.Arrays;

public class SortsUtils {

    public static void main(String[] args) {

        int[][] array = {
                {1, 2, 3, 4, 5, 6},
                {1, 1, 1, 1},
                {9, 1, 5, 99, 9, 9},
                {12, 645, 73, 123, 756, 645},
                {57, -7856, 45, -74, 3, 7}
        };

        for (int[] ints : array) {

            System.out.println("До пузырьковой сортировки : " + Arrays.toString(ints));

            bubbleSort(ints);

            System.out.println("После пузырьковой сортировки : " + Arrays.toString(ints));
        }
    }

//    Bubble sort
    public static void bubbleSort(int[] array) {

        for(int i = 1; i < array.length; i++) {

            if(array[i] < array[i - 1]) {
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
            }
        }
    }

//    Shaker sorting
    public static void shakerSort(int[] array) {

    }
}
