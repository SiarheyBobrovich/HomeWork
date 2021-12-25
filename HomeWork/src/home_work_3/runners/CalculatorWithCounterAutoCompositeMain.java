package home_work_3.runners;

/*
    7.7 Создать класс CalculatorWithCounterAutoCompositeMain в котором будет точка входа (main метод).
            В main методе требуется создать экземпляр калькулятора и используя методы из данного экземпляра посчитать выражения из задания 1.
            Вывести в консоль результаты посчитанных выражений и результат метода getCountOperation().

            Пройдя всё вышеперечисленное мы должны понять, что идём к тупику. Данный пункт нарочно усложнён тремя конструкторами.
            Он нужен для того, чтобы показать, что писать наш класс именно так - безумная идея.
            Из-за возможного нарастания количества всевозможных калькуляторов, для которых мы должны
            в класс CalculatorWithCounterAutoComposite добавить конструкторы, поля и тучу кода...
            Вроде уходили от наследования и говорили о том, что оно не желательно...
            а это получается желательно??? -на самом деле нет, мы тут ещё не закончили.

            Для того чтобы перейти дальше, необходимо добавить один важный компонент
            и с ним всё заиграет новыми красками, и он позволит писать более удобный код.
 */

import home_work_3.calcs.additional.CalculatorWithCounterAutoComposite;
import home_work_3.calcs.simple.CalculatorWithMathCopy;
import home_work_3.calcs.simple.CalculatorWithOperator;

public class CalculatorWithCounterAutoCompositeMain {
    public static void main(String[] args) {

        CalculatorWithCounterAutoComposite calculator = new CalculatorWithCounterAutoComposite(new CalculatorWithOperator());

        double first = calculator.divide(28, 5);
        double second = calculator.pow(first, 2);
        double third = calculator.multiply(15, 7);
        double fourth = calculator.add(4.1, third);
        double result = calculator.add(fourth, second);

        System.out.println("4.1 + 15 * 7 + (28 / 5) ^ 2 = " + result);
        System.out.println("Колличество использований калькулятора = " + calculator.getCountOperation());
    }
}
