package my_utils;


import java.util.Arrays;
import java.util.Date;
import home_work_2.utils.ArraysUtils;

public class TestSort {

    public static void main(String[] args) {

        int[] array = ArraysUtils.arrayRandom(100_000_001, 1000);
        int length = array.length;

        //Sort классом
        Date date = new Date();
        array = Sort.sort(array);
        Date date1 = new Date();
        System.out.println(date1.getTime() - date.getTime() + "ms - для Sort.sort()");

        System.out.printf("Начальная длина: %d. Конечная длина: %d Отсортирован? - %s", length, array.length, isSorted(array));
    }

    static String isSorted(int[] a) {

        for (int i = 0; i < a.length - 1; i++) {

            if (a[i] > a[i + 1]) {
                return "НЕТ";
            }

        }

        return "ДА!";
    }
}
