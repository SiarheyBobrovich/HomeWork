package home_work_2.Loops;

/*
1.2. Все цифры из числа введенного через аргумент к исполняемой программе перемножить между собой и вывести ход вычислений в консоль. Пользователь обязан ввести целое число. Если ввели не целое то выдать сообщение о том что пользователь ввёл некорректные данные.
    1.2.1 Пример: Ввели 181232375, должно получиться в консоли: 1 * 8 * 1 * 2 * 3 * 2 * 3 * 7 * 5 = 10 080
    1.2.2 Пример: Ввели 99.2, должно получиться в консоли: Введено не целое число
    1.2.3 Пример: Ввели Привет, должно получиться в консоли: Введено не число
*/


public class NumMultiplier {

public static void main(String[] args) {
    double check = 0;
    for (String arg : args) {
        try {
            Checker.check(arg, true, false, true);
            printer(arg);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}

    public static void printer(String number) {
        boolean isMinus = false;
        long result = 1;

        if (number.charAt(0) == '-') {
            isMinus  = true;
        }


        for(int i = isMinus ? 1 : 0; i < number.length(); i++) {
            int value = (number.charAt(i) - 48);
            result *= value;
            if(i < number.length() - 1) {
                System.out.print(value + " * ");
            }else{
                System.out.print(value + " = ");
            }
        }

        StringBuilder builder = new StringBuilder("" + result);

        for (int i = builder.length() - 3; i > 0; i -= 3) {
            builder.insert(i, " ");
        }

        System.out.println(builder);
    }
}

