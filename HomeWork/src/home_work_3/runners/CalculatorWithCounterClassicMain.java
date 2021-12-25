package home_work_3.runners;
/*
        5.5 Создать класс CalculatorWithCounterClassicMain в котором будет точка входа (main метод).
                В main методе требуется создать экземпляр калькулятора и используя методы из данного экземпляра посчитать выражения из задания 1,
                при каждой математической операции самостоятельно вызывать метод incrementCountOperation() для увеличения счётчика. Вывести в консоль результат.
                                          4.1 + 15 * 7 + (28 / 5) ^ 2


        Какая проблема данного класса? Вроде всё красиво, всё ещё есть наследование, всё удобно разложено по отдельным методам.
        Но как всегда есть две беды... Дураки (программисты) и дороги (наш класс CalculatorWithCounterClassic).
        Дураки не умеют пользоваться дорогами, программисты не умеют пользоваться нашим классом CalculatorWithCounterClassic.
        Что обычно делают на дорогах чтобы дураки на них не убивались?
        -Правильно, делают дороги интуитивно понятными, безопасными, уменьшают количество мусорных знаков
        и делают так чтобы при их использовании дураку нельзя было бы ошибиться.

        Так вот проблема нашего CalculatorWithCounterClassic в том, что для увеличения счётчика программиста нужно заставить
        воспользоваться методом incrementCountOperation() чтобы в итоге наш счётчик операций был увеличен на 1.
        Можно сколько угодно настаивать на том, чтобы коллеги читали документацию к вашим классам,
        сколько угодно можно рассказывать, что там есть много важного... Они всё равно не будут её читать...
        Пока в продакшене проблем не возникнет, - документацию они не отроют в 90% случаев.

        Поэтому давайте немного воспользуемся прелестями наследования и большей степенью инкапсуляции.
        Просто сами, внутри нашего нового калькулятора, будем вызывать этот метод incrementCountOperation
        и снимем эту обязанность с программиста.
 */

import home_work_3.calcs.additional.CalculatorWithCounterClassic;

public class CalculatorWithCounterClassicMain {
    public static void main(String[] args) {
        CalculatorWithCounterClassic calculator = new CalculatorWithCounterClassic();
        double first = calculator.divide(28, 5);
        calculator.incrementCountOperation();
        double second = calculator.pow(first, 2);
        calculator.incrementCountOperation();
        double third = calculator.multiply(15, 7);
        calculator.incrementCountOperation();
        double fourth = calculator.add(4.1, third);
        calculator.incrementCountOperation();
        double result = calculator.add(fourth, second);
        calculator.incrementCountOperation();

        System.out.println("4.1 + 15 * 7 + (28 / 5) ^ 2 = " + result);
        System.out.println("Колличество использований калькулятора = " + calculator.getCountOperation());
    }
}
