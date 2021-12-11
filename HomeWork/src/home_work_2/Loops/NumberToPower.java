package home_work_2.loops;

/*
       1.3. Возведение в степень. Через консоль пользователь вводит два числа.
            Первое число это число которое мы будем возводить, Второе число это степень в которую возводят первое число.
            Степень - только положительная и целая. Возводимое число - может быть отрицательным и оно будет дробным.
            Math использовать нельзя.
                1.3.1 Пример: Ввели 18 и 5, должно получиться в консоли: 18.0 ^ 5 = 1 889 568.0
                1.3.2 Пример: Ввели 7.5 и 2, должно получиться в консоли: 7.5 ^ 2 = 56.25

 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberToPower {
    public static void main(String[] args) {
        double number = 0;
        long power = 0;

        System.out.print("Введите возводимое число: ");
        while (true) {
            try {
                number = new Scanner(System.in).nextDouble();
                break;
            }catch (InputMismatchException e) {
                System.out.print("Целое число или дробное число разделённое запятой!\nВведите возводимое число: ");
            }
        }

        System.out.print("Введите степень: ");
        while (true) {
            try {
                power = new Scanner(System.in).nextLong();
                break;

            }catch (InputMismatchException e) {
                System.out.print("Целое число!\nВведите степень: ");
            }
        }

        System.out.println(pow(number, power));
    }

    //Степень возможна отрицательная(не правильно прочитал условие)
    public static double pow(double num, long pow) {
        if(pow == 0) {
            return 1;
        }

        boolean isMinus = pow < 0;
        double result = num;

        if (isMinus) {
            pow *= -1;
            result = 1 / result;
        }

        for (long i = 1; i < pow; i++) {
            result = !isMinus ? result * num : result / num;
        }

        return result;
    }
}
