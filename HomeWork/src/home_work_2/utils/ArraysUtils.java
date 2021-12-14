package home_work_2.utils;

/*
    2.1. Создать класс ArraysUtils:
		2.1.1. Написать метод public static int[] arrayFromConsole() рядом с main.
		       Данный метод размер массива и каждый его элемент запрашивает у пользователя через консоль.
			2.1.1.1. Пример int[] container = arrayFromConsole().
			         Результат: В методе arrayFromConsole будет запрошена информация у пользователя,
			         пользователь вводит размер (3) и его элементы по порядку {4, 17, 32}.
			         Соответсвенно будет создан массив размером 3 с элементами {4, 17, 32} и сохранён в переменную container.
		2.1.2. Написать метод public static int[] arrayRandom(int size, int maxValueExclusion) рядом с main.
		       Данный метод принимает два аргумента. Первый (size) указывает размер массива который мы хотим получить.
		       Второй (maxValueExclusion) указывает до какого числа генерировать рандомные числа.
			2.1.2.1. Пример: int[] container = arrayRandom(5, 100).
			         Результат: В методе arrayRandom будет создан массив размером 5 с числами от 0 до 99 (использовать класс Random) и сохранён в переменную container.
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArraysUtils {
    public static void main(String[] args) {
        int[] container = null;

        while (container == null) {

            try {
                container = arrayFromConsole();
            }catch (NegativeArraySizeException e) {
                System.out.println("Try again!");
            }
        }

        System.out.println(Arrays.toString(container));

        container = arrayRandom(5, 100);
        System.out.println(Arrays.toString(container));

    }
    public static int[] arrayFromConsole() throws NegativeArraySizeException {
        Scanner console = new Scanner(System.in);
        System.out.print("Введите размер массива(число >= 0): ");
        int length = console.nextInt();
        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            System.out.print("Введите число для сохранения [" + i + "]: ");
            array[i] = console.nextInt();
        }

        return array;
    }

    public static int[] arrayRandom(int size, int maxValueExclusion) {
        if (size <= 0) {
            return new int[0];
        }

        int[] result = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            result[i] = random.nextInt(maxValueExclusion);
        }

        return result;
    }
}
