package home_work_2.loops;

/*
        1.4.* Умножать число long a = 1; пока не произойдёт переполнение.
            В конце в консоль вывести сообщение со значением до переполнения и после переполнения.
            Умножать на:
              1.4.1. 3
              1.4.2. 188
              1.4.3. -19
             1.4.4. Да и вообще на любое целочисленное
 */

public class OverFlow {
    public static void main(String[] args) {
        //,
        long[] numbers = {3, 188, -19, 2, -2, Long.MIN_VALUE, Long.MAX_VALUE, 1, -1, 0};

        for (long number : numbers) {
            overFlow(number);
        }
    }

    public static void overFlow(long number) {
        long result = 1;
        long overFlow = 1;
        boolean start = number > 1 || number < -1;

        while (start) {
            result *= number;
            boolean forMinus = overFlow <= 0 && result <= 0 || overFlow >= 0 && result >= 0;
            boolean forPlus = result <= 1;

            if (number > 0 ? forPlus : forMinus) {
                System.out.printf("До переполнения : %d. После переполнения %d%n", overFlow, result);
                return;
            }

            overFlow = result;
        }
        System.out.println("С таким числом ваш компьютер сгорит!");
    }
}
