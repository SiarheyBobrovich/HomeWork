package home_work_2.utils;

/*
    4.2. Создать класс SortsUtils. Пишем в нём следующие алгоритмы:
		4.2.1. Пузырьковая сортировка
		4.2.2. Шейкерная сортировка
 */

import java.util.Arrays;
import java.util.Date;

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
            System.out.println("Шейкерная сортировка: ");
            int[] shackerArray = Arrays.copyOf(ints, ints.length);
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

    }





    //    Shaker sorting
    public static void shakerSort(int[] array) {

    }

    //    mySort
    public static void mySort(int[] array) {

        for (int i = 1; i < array.length; i++) {

            if (array[i] < array[i - 1]) {
                changePlacesLeft(array, i);
            }
        }
    }

    private static void changePlacesLeft(int[] array, int index) {

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
                System.out.println(false);
                return false;
            }
        }
        System.out.println(true);
        return true;
    }
}




