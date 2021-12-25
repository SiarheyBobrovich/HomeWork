package home_work_3.runners;
/*
        3.3 Создать класс CalculatorWithMathCopyMain в котором будет точка входа (main метод).
                В main методе требуется создать экземпляр калькулятора и
                используя методы из данного экземпляра посчитать выражения из задания 1.1 4.1 + 15 * 7 + (28 / 5) ^ 2
                Вывести в консоль результат.
 */

import home_work_3.calcs.simple.CalculatorWithMathCopy;

public class CalculatorWithMathCopyMain {
    public static void main(String[] args) {
        CalculatorWithMathCopy calc = new CalculatorWithMathCopy();
        double result = calc.divide(28, 5);
        result = calc.pow(result, 2);
        result = calc.add(calc.multiply(15, 7),result);
        result = calc.add(4.1, result);

        System.out.println(result);
    }
}
