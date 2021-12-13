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

        for (int i = 0; i < 4; i++) {

            int[] ints = ArraysUtils.arrayRandom(20, 1000);

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
            System.out.print("Моя сортировка\n" + Arrays.toString(shackerArray) + " -> ");
            SortsUtils.mySort(myArray);
            System.out.println(Arrays.toString(myArray));

        }
    }

}
