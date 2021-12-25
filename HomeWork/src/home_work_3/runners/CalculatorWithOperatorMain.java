package home_work_3.runners;

/*
    2.5 Создать класс CalculatorWithOperatorMain в котором будет точка входа (main метод).
        В main методе требуется создать экземпляр калькулятора и используя методы из данного экземпляра
        посчитать выражения из задания 1.1  4.1 + 15 * 7 + (28 / 5) ^ 2.
        Вывести в консоль результат.
 */

import home_work_3.calcs.simple.CalculatorWithOperator;

public class CalculatorWithOperatorMain {
    public static void main(String[] args) {
        CalculatorWithOperator calculator = new CalculatorWithOperator();
        double result = calculator.pow(calculator.divide(28, 5.0), 2);
        result = calculator.add(calculator.multiply(15, 7), result);
        result = calculator.add(4.1, result);

        System.out.println(result);

    }
}
