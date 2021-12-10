package home_work_2.Loops;

//      1.1. Перемножить числа от 1 до числа (включительно) введенного через аргумент к исполняемой программе.
//          Есть нюанс с переполнением, можно добавить проверки и сообщения пользователю.
//          Пример: Ввели 5, должно получиться в консоли: 1 * 2 * 3 * 4 * 5 = ответ
//    	1.1.1. Используя только цикл
//    	1.1.2.* Используя рекурсию

import home_work_2.Loops.Checker;


public class Multiplier {

    public static void main(String[] args) {
        long number = 0;
        for (String arg : args) {
            try {
                Checker.check(arg, false, false, true);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            number = Long.parseLong(arg);
            System.out.println("Цикл:");
            count(number);

            System.out.println("Рекурсия:");
            try {
                System.out.println(recursive(number, true));
            } catch (IllegalArgumentException ignore) {
            }
        }
    }

    public static void count(long num){
        num = Checker.isMinus(num);
        long result = 1;

        for(int i = 1; i <= num; i++) {
            result *= i;

            if (result < 0) {
                System.out.println(i + " = Переполнение!");
                return;
            }else if (i < num) {
                System.out.print(i + " * ");
            }else {
                System.out.print(i);
            }
        }

        System.out.println(" = " + result);
    }

    public static long recursive(long num, boolean isFirst) throws IllegalArgumentException {
        if (num == 0) {
            return 1;
        }else if (isFirst) {
            num = Checker.isMinus(num);
        }
        long result = num * recursive(num - 1, false);

        if (result < 0) {
            System.out.println(num + " = Переполнение!");
            throw new IllegalArgumentException("Переполнение");
        }else if (isFirst) {
            System.out.print(num + " = ");
        }else {
            System.out.print(num + " * ");
        }

        return result;
    }
}
