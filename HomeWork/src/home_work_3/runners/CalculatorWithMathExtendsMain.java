package home_work_3.runners;

/*
     4.4 Создать класс CalculatorWithMathExtendsMain в котором будет точка входа (main метод).
                В main методе требуется создать экземпляр калькулятора
                и используя методы из данного экземпляра посчитать выражения из задания 1.1     4.1 + 15 * 7 + (28 / 5) ^ 2.
                Вывести в консоль результат.
 */

import home_work_3.calcs.simple.CalculatorWithMathExtends;

public class CalculatorWithMathExtendsMain {
    public static void main(String[] args) {

        CalculatorWithMathExtends calculator = new CalculatorWithMathExtends();
        double first = calculator.divide(28, 5);
        double second = calculator.pow(first, 2);
        double third = calculator.multiply(15, 7);
        double fourth = calculator.add(4.1, third);
        double result = calculator.add(fourth, second);

        System.out.println(result);
    }
}
