package home_work_3.runners;

/*
    9.7 Создать класс CalculatorWithCounterAutoCompositeInterfaceMain в котором будет точка входа (main метод).
                В main методе требуется создать экземпляр
                калькулятора и используя методы из данного экземпляра посчитать выражения из задания 1.
                Вывести в консоль результаты посчитанных выражений и результат метода getCountOperation().

            Вот мы пришли к тому что сочетание композиции и интерфейса нам позволило остановить ту лавину кода,
            конструкторов и классов... В общем все проблемы которые нас преследовали ранее в предыдущих пунктах нашего задания.
            Наш код стал простым и соответственно понятным, его легче поддерживать так как
            теперь наш вариант CalculatorWithCounterAutoCompositeInterface
            будет работать с любым калькулятором который реализует интерфейс ICalculator.
            Если вдруг вы захотите выпустить свой калькулятор в виде библиотеки - то в этой библиотеке
            будет всего лишь два файла CalculatorWithCounterAutoCompositeInterface и ICalculator.
            Все кто захочет воспользоваться вашими наработками, просто создадут свой калькулятор реализуя интерфейс ICalculator.
            А логику учёта будут использовать ту что вы написали в классе CalculatorWithCounterAutoCompositeInterface.
 */

import home_work_3.calcs.additional.CalculatorWithCounterAutoCompositeInterface;
import home_work_3.calcs.simple.CalculatorWithMathCopy;
import home_work_3.calcs.simple.CalculatorWithMathExtends;
import home_work_3.calcs.simple.CalculatorWithOperator;

public class CalculatorWithCounterAutoCompositeInterfaceMain {

    public static void main(String[] args) {


        CalculatorWithCounterAutoCompositeInterface[] calcs = {
                new CalculatorWithCounterAutoCompositeInterface(new CalculatorWithMathCopy()),
                new CalculatorWithCounterAutoCompositeInterface(new CalculatorWithMathExtends()),
                new CalculatorWithCounterAutoCompositeInterface(new CalculatorWithOperator())
        };

        for (CalculatorWithCounterAutoCompositeInterface calc : calcs) {

            double first = calc.divide(28, 5);
            double second = calc.pow(first, 2);
            double third = calc.multiply(15, 7);
            double fourth = calc.add(4.1, third);
            double result = calc.add(fourth, second);

            System.out.println("4.1 + 15 * 7 + (28 / 5) ^ 2 = " + result);
            System.out.println("Колличество использований калькулятора = " + calc.getCountOperation());
            System.out.println("*****************************************");
        }
    }
}
