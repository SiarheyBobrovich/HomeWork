package home_work_2.arrays;
/*
    2.2 Перебор массива при помощи do....while, while, for, foreach.
    Элементы массива вводить используя ранее созданный arrayFromConsole.
    Все задачи в одном классе, в отдельных методах.
    Должно получиться 3 метода (что такое метод https://metanit.com/java/tutorial/2.7.php(sad)
        2.2.1. Вывести все элементы в консоль.
        2.2.2. Вывести каждый второй элемент массива в консоль.
        2.2.3. Вывести все элементы массива в консоль в обратном порядке.

 */

import home_work_2.utils.ArraysUtils;

public class ArrayIterator {
    public static void main(String[] args) {
        int[] array = ArraysUtils.arrayFromConsole();
        print(array);
        printSecondElement(array);
        printReverse(array);
    }

    public static void print(int[] array) {
        System.out.println("Вывод массива:");

        for (int i = 0; i < array.length; i++) {
            if (i != array.length - 1) {
                System.out.print(array[i] + " ");
            }else {
                System.out.print(array[i]);
            }
        }

        System.out.println();
    }

    public static void printSecondElement(int[] array) {
        System.out.println("Вывод каждого второго элемента:");

        for (int i = 0; i < array.length; i += 2) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
    }

    public static void printReverse(int[] array) {
        System.out.println("Вывод массива в обратном порядке:");

        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
    }
}
