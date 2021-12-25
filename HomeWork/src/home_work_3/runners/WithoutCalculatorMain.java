package home_work_3.runners;

/*  1. Создать класс WithoutCalculatorMain в котором необходимо посчитать следующие выражения:
	    1.1 4.1 + 15 * 7 + (28 / 5) ^ 2. Вывести сохранённый результат в консоль.
	        Внимание, знак "^" обозначает возведение в степень.

 */

public class WithoutCalculatorMain {
    public static void main(String[] args) {

        double result = 28 / 5.0;
        result *= result;
        result += 15 * 7;
        result += 4.1;

        System.out.println(result);
    }

}
