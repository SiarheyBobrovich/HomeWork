package my_utils;


import java.util.Arrays;
import java.util.Date;
import home_work_2.utils.ArraysUtils;

public class TestSort {

    public static void main(String[] args) {

        int[] array = ArraysUtils.arrayRandom(70_000_000, 1000);
        int[] array2 = Arrays.copyOf(array, array.length);

        Date date = new Date();
        array = Sort.sort(array);
        Date date1 = new Date();
        System.out.println(date1.getTime() - date.getTime() + "ms");
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));

        Date date2 = new Date();
        array2 = Sort.sort(array2);
        Date date3 = new Date();
        System.out.println(date3.getTime() - date2.getTime() + "ms - Arrays.sort()");
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));

        isSorted(array, array2);
    }

    static void isSorted(int[] a, int[] b) {

        for (int i = 0; i < a.length; i++) {

            if (a[i] != b[i]) {
                System.out.println("Не верное решение!");
            }

        }

    }
}
