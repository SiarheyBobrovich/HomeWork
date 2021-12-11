package home_work_2.arrays;
/*
    2.4 Задачи взяты с сайта https://taskcode.ru/array.
        На сайте есть пояснения по каждой из этих задач. Все задачи в одном классе, в отдельных методах.
        Для создания массивов использовать ранее созданный arrayRandom.
            2.4.1. Сумма четных положительных элементов массива
            2.4.2. Максимальный из элементов массива с четными индексами
            2.4.3. Элементы массива, которые меньше среднего арифметического
            2.4.4. Найти два наименьших (минимальных) элемента массива
            2.4.5. Сжать массив, удалив элементы, принадлежащие интервалу
            2.4.6. Сумма цифр массива
 */

import home_work_2.utils.ArraysUtils;

import java.util.Arrays;
import java.util.Scanner;


public class ArrayOperations {
    public static void main(String[] args) {
        int[] array = ArraysUtils.arrayRandom(10, 100);
        ArrayIterator.print(array);

        System.out.print("Сумма четных положительных элементов массива: ");
        System.out.println(evenSum(array));



        System.out.print("Максимальный из элементов массива с четными индексами равен: ");
        System.out.println(maxEvenIndex(array));

        System.out.print("Сумма всех цифр массива: ");
        System.out.println(sum(array));

        System.out.print("Элементы массива, которые меньше среднего арифметического: ");
        System.out.println(Arrays.toString(elementsLessArithmeticMean(array)));

        System.out.print("Два наименьших (минимальных) элемента массива: ");
        try {
            System.out.println(Arrays.toString(twoMinElements(array)));
        }catch (IllegalArgumentException e) {
            e.getMessage();
        }

        System.out.println("Сжатие массива!");
        System.out.print("Введите от какого включительно числа начинать удаление: ");
        int from = new Scanner(System.in).nextInt();
        System.out.print("Введите до какого включительно числа завершить удаление: ");
        int till = new Scanner(System.in).nextInt();


        System.out.print("Сжатый массив: ");
        delInterval(array, from, till);
        System.out.println(Arrays.toString(array));
    }

    // 2.4.1. Сумма четных положительных элементов массива
    public static long evenSum(int[] array) {
        long result = 0;

        for (int i : array) {
            if (i % 2 == 0 && i > 0) {
                result += i;
            }
        }

        return result;
    }

    //2.4.2. Максимальный из элементов массива с четными индексами
    public static long maxEvenIndex(int[] array) {
        long max = Long.MIN_VALUE;

        for (int i = 0; i < array.length; i += 2) {
            if (max < array[i]) {
                max = array[i];
            }
        }

        return max;
    }

    //2.4.3. Элементы массива, которые меньше среднего арифметического
    public static int[] elementsLessArithmeticMean(int[] array) {
        double sum = 0;
        //считаем среднее арифметическое
        for (int i : array) {
            sum += i;
        }
        //Вычисляем среднее арифметическое
        sum /= array.length;
        int index = 0;
        //считаем элементы меньше среднего арифметического
        for (int i : array) {
            if (i < sum) {
                index++;
            }
        }

        int[] elements = new int[index];
        //Заполняем массив
        for (int i : array) {
            if (i < sum) {
                elements[elements.length - index] = i;
                index--;
            }
        }

        return elements;
    }

    // 2.4.4. Найти два наименьших (минимальных) элемента массива
    public static int[] twoMinElements(int[] array) throws IllegalArgumentException {
        if (array.length < 2) {
            throw new IllegalArgumentException("Неверный размер массива");
        }else if (array.length == 2) {
            return array;
        }

        int[] minElements = new int[2];
        boolean isMin = array[0] < array[1];

        minElements[0] = isMin ? array[0] : array[1];
        minElements[1] = isMin ? array[1] : array[0];

        for (int i = 2; i < array.length; i++) {
            if (array[i] < minElements[0]) {
                minElements[1] = minElements[0];
                minElements[0] = array[i];
            }else if (array[i] < minElements[1]) {
                minElements[1] = array[i];
            }
        }

        return minElements;
    }

    //2.4.5. Сжать массив, удалив элементы, принадлежащие интервалу
    public static void delInterval(int[] array, int from, int till) {
        int count = 0;

        for (int i = 0; i < array.length - count; i++) {
            boolean interval = array[i] >= from && array[i] <= till;

            if (interval) {
                count++;

                for (int j = i; j < array.length - count; j++) {
                    array[j] = array[j + 1];
                }

                array[array.length - count] = 0;
                i--;
            }
        }
    }

    // 2.4.6. Сумма цифр массива
    public static long sum(int[] array) {
        long result = 0;

        for (int i : array) {

            while (i != 0) {
                result += i % 10;
                i /= 10;
            }
        }

        return result;
    }
}
