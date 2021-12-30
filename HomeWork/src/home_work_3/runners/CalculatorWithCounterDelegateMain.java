package home_work_3.runners;

/*
    7.7 Создать класс CalculatorWithCounterDelegateMain в котором будет точка входа (main метод).
            В main методе требуется создать экземпляры калькуляторов созданных из классов из этого задания
            и используя методы из экземпляра посчитать выражения из задания 1.
            Вывести в консоль результаты посчитанных выражений и результат метода getCountOperation().

 */

import home_work_3.calcs.additional.CalculatorWithCounterAutoAgregation;
import home_work_3.calcs.additional.CalculatorWithCounterAutoComposite;
import home_work_3.calcs.simple.CalculatorWithOperator;

public class CalculatorWithCounterDelegateMain {
    public static void main(String[] args) {

        //Для CalculatorWithCounterAutoAgregation
        CalculatorWithCounterAutoAgregation calculator = new CalculatorWithCounterAutoAgregation(new CalculatorWithOperator());

        double first = calculator.divide(28, 5);
        double second = calculator.pow(first, 2);
        double third = calculator.multiply(15, 7);
        double fourth = calculator.add(4.1, third);
        double result = calculator.add(fourth, second);

        System.out.println("4.1 + 15 * 7 + (28 / 5) ^ 2 = " + result);
        System.out.println("Колличество использований калькулятора = " + calculator.getCountOperation());

        //Для CalculatorWithCounterAutoComposite
        CalculatorWithCounterAutoComposite calculator2 = new CalculatorWithCounterAutoComposite(new CalculatorWithOperator());

        double one = calculator2.divide(28, 5);
        double two = calculator2.pow(one, 2);
        double three = calculator2.multiply(15, 7);
        double four = calculator2.add(4.1, three);
        double five = calculator2.add(four, two);

        System.out.println("4.1 + 15 * 7 + (28 / 5) ^ 2 = " + five);
        System.out.println("Колличество использований калькулятора = " + calculator.getCountOperation());
    }
}
