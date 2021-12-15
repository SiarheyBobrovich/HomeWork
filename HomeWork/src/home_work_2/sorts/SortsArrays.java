package home_work_2.sorts;

/*
    4.* Выполнить сортировку массива с числами:
        4.1. После каждой сортировки в консоли у вас должно получиться
            "[Какой массив был до сортировки] -> [Каким стал массив после сортировки]".
            Для преобразования массива в текст можно использовать класс Arrays.
 */

import home_work_2.utils.ArraysUtils;
import home_work_2.utils.SortsUtils;

import java.util.Arrays;


public class SortsArrays {

    public static void main(String[] args) {
        int[][] test = {
                        {1,2,3,4,5,6},
                        {1,1,1,1},
                        {9,1,5,99,9,9},
                        {}
        };
        System.out.println("Тест заполнеными массивами: ");
        for (int[] ints : test) {
            sort(ints);
        }

        System.out.println("\nТест ArraysUtils.arrayRandom()!");
        int[] test2 = ArraysUtils.arrayRandom(9, 999);
        sort(test2);

        System.out.println("\nТест ArraysUtils.arrayFromConsole()!");
        int[] test3 = ArraysUtils.arrayFromConsole();
        sort(test3);

    }

    public static void sort(int[] ints) {
        //Проверяем bubbleSort
        int[] bubbleArray = Arrays.copyOf(ints, ints.length);
        System.out.print("Пузырьковая сортировка массива\n" + Arrays.toString(bubbleArray) + " -> ");
        SortsUtils.bubbleSort(bubbleArray);
        System.out.println(Arrays.toString(bubbleArray));

        //Проверяем шейкерную сортировку
        int[] shackerArray = Arrays.copyOf(ints, ints.length);
        System.out.print("Шейкерная сортировка массива\n" + Arrays.toString(shackerArray) + " -> ");
        SortsUtils.shakerSort(shackerArray);
        System.out.println(Arrays.toString(shackerArray));

        //Проверяем mySort
        int[] myArray = Arrays.copyOf(ints, ints.length);
        System.out.print("Моя сортировка\n" + Arrays.toString(myArray) + " -> ");
        SortsUtils.mySort(myArray);
        System.out.println(Arrays.toString(myArray));
    }
}
