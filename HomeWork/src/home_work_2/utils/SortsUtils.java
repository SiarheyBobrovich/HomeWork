package home_work_2.utils;

/*
    4.2. Создать класс SortsUtils. Пишем в нём следующие алгоритмы:
		4.2.1. Пузырьковая сортировка
		4.2.2. Шейкерная сортировка
 */

public class SortsUtils {

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

        }while (minIndex < maxIndex);
    }


    //Проход слева -> направа с заменой минимума -> налево
    private static void changeLeft(int[] array, int minIndex, int maxIndex) {

        for (int i = minIndex; i < maxIndex; i++) {

            change(array, i + 1, i );
        }
    }
    //Проход справа -> налево с заменой максимума -> направа
    private static void changeRight(int[] array, int minIndex, int maxIndex) {

        for (int i = maxIndex - 1; i >= minIndex; i--) {

            change(array, i + 1 , i);
        }
    }

    //метод смены позиций
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

    //Проход слева - > направа с заменой минимального влево до ещё меньшего
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

    public static void isSorted(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {

            if (array[i] > array[i + 1]) {
                System.out.println(false);
            }
        }

        System.out.println(true);
    }
}




