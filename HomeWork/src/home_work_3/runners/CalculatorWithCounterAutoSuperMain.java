package home_work_3.runners;

/*
        6.5 Создать класс CalculatorWithCounterAutoSuperMain в котором будет точка входа (main метод).
            В main методе требуется создать экземпляр калькулятора и используя методы из данного экземпляра посчитать выражения из задания 1.
            Вывести в консоль результаты посчитанных выражений и результат метода getCountOperation().

        Отлично, мы воспользовались наследованием и вроде получился красивый код.
        А теперь давайте подумаем, а если нам скажут что нам нужно создать такого наследника не только для CalculatorWithMathExtends,
        но и для CalculatorWithOperator и CalculatorWithMathCopy..... и этот список нескончаем
        так как калькуляторы могут быть добавлены в проект в любом количестве и любым программистом.
        При добавлении нового калькулятора, который должен будет иметь функции по учёту количества использований,
        нам каждый раз нужно будет совершать подвиг (писать тот же код что и CalculatorWithCounterSuper) и это не то чтобы плохо,
        но отнимает большое количество времени, растёт количество классов которые нужно контролировать и тестировать.
        Это превращается в лавину!

        Давайте рассмотрим решение при помощи композиции. Композиция позволяет создать один класс.
        Но в нём нужно будет постоянно добавлять конструкторы для новых калькуляторов, менять код методов.
        Код станет сложнее (эту проблему мы решим дальше) но от лавины по количеству классов точно уйдём. Но это вы ощутите выполнив уже следующее задание.
        Больше о композиции можно почитать тут https://refactoring.guru/ru/design-patterns/composite
 */

import home_work_3.calcs.additional.CalculatorWithCounterAutoSuper;

public class CalculatorWithCounterAutoSuperMain {
    public static void main(String[] args) {

        CalculatorWithCounterAutoSuper calculator = new CalculatorWithCounterAutoSuper();

        double first = calculator.divide(28, 5);
        double second = calculator.pow(first, 2);
        double third = calculator.multiply(15, 7);
        double fourth = calculator.add(4.1, third);
        double result = calculator.add(fourth, second);

        System.out.println("4.1 + 15 * 7 + (28 / 5) ^ 2 = " + result);
        System.out.println("Колличество использований калькулятора = " + calculator.getCountOperation());

    }
}
