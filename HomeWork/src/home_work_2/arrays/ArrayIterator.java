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

    //Вывод массива
    public static void print(int[] array) {
        System.out.println("Вывод массива цикл for(;;):");

        for (int i = 0; i < array.length; i++) {

            if (i != array.length - 1) {
                System.out.print(array[i] + " ");
            }else {
                System.out.println(array[i]);
            }
        }

        System.out.println("Вывод массива (цикл do....while):");

        int index = 0;

        do {

            if (index != array.length - 1) {
                System.out.print(array[index] + " ");
            }else {
                System.out.println(array[index]);
            }

            index++;

        }while (index < array.length);

        System.out.println("Вывод массива (цикл while):");

        int indexForWhile = 0;

        while (indexForWhile < array.length) {
            System.out.print(array[indexForWhile]);

            if (indexForWhile != array.length - 1) {
                System.out.print(" ");
            }else {
                System.out.println();
            }

            indexForWhile++;
        }

        System.out.println("Вывод массива (цикл foreach):");

        int indexForeach = 0;

        for (int i : array) {
            System.out.print(i);

            if(indexForeach != array.length - 1) {
                System.out.print(" ");
            }else {
                System.out.println();
            }

            indexForeach++;
        }
    }

    //Вывод каждого второго элемента
    public static void printSecondElement(int[] array) {
        System.out.println("Вывод каждого второго элемента цикл for(;;):");

        for (int i = 0; i < array.length; i += 2) {
            System.out.print(array[i]);

            if (i < array.length - 2) {
                System.out.print(" ");
            }else {
                System.out.println();
            }
        }

        System.out.println("Вывод каждого второго элемента (цикл do....while):");

        int index = 0;

        do {
            System.out.print(array[index]);

            if (index < array.length - 2) {
                System.out.print(" ");
            }else {
                System.out.println();
            }

            index += 2;

        }while (index < array.length);

        System.out.println("nВывод каждого второго элемента (цикл while):");

        int indexForWhile = 0;

        while (indexForWhile < array.length) {
            System.out.print(array[indexForWhile]);

            if (indexForWhile < array.length - 2) {
                System.out.print(" ");
            }else {
                System.out.println();
            }

            indexForWhile += 2;
        }

        System.out.println("Вывод каждого второго элемента (цикл foreach):");

        int indexForeach = 0;

        for (int i : array) {

            if (indexForeach % 2 == 0) {
                System.out.print(i);

                if (indexForeach < array.length - 2) {
                    System.out.print(" ");
                } else {
                    System.out.println();
                }
            }

            indexForeach++;
        }

    }

    //Вывод массива в обратном порядке
    public static void printReverse(int[] array) {
        System.out.println("Вывод массива в обратном порядке цикл for(;;):");

        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i]);

            if (i != 0) {
                System.out.print(" ");
            }else {
                System.out.println();
            }
        }

        System.out.println("Вывод массива в обратном порядке (цикл do....while):");

        int indexForDoWhile = array.length - 1;

        do {
            System.out.print(array[indexForDoWhile]);

            if (indexForDoWhile == 0) {
                System.out.println();
            }else {
                System.out.print(" ");
            }

            indexForDoWhile--;

        }while (indexForDoWhile >= 0);

        System.out.println("Вывод массива в обратном порядке (цикл while):");

        int indexForWhile = array.length - 1;

        while (indexForWhile >= 0) {
            System.out.print(array[indexForWhile]);

            if (indexForWhile == 0) {
                System.out.println();
            }else {
                System.out.print(" ");
            }

            indexForWhile--;
        }

        System.out.println("Вывод массива в обратном порядке (цикл foreach):");

        int[] reverse = new int[array.length];
        int reverseIndex = reverse.length - 1;

        for (int i : array) {

            reverse[reverseIndex] = i;
            reverseIndex--;
        }

        reverseIndex = reverse.length - 1;

        for (int i : reverse) {
            System.out.print(i);

            if (reverseIndex == 0) {
                System.out.println();
            }else {
                System.out.print(" ");
            }
            reverseIndex--;
        }
    }
}
