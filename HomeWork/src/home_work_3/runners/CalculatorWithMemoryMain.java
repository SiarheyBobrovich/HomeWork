package home_work_3.runners;

/*
        10.6 Создать класс CalculatorWithMemoryMain в котором будет точка входа (main метод).

             В main методе требуется создать экземпляр калькулятора и используя
             методы из данного экземпляра посчитать выражения из задания 1. Вывести в консоль результат.
             В мэйне запрещается использование переменных для хранения значений участвующих в просчёте,
             а также результатов работы методов калькулятора,
             можно использовать только литералы и метод получения из памяти записанного значения.
 */

import home_work_3.calcs.additional.CalculatorWithMemory;

public class CalculatorWithMemoryMain {

    public static void main(String[] args) {

        CalculatorWithMemory calc = new CalculatorWithMemory();

        double first = calc.divide(28, 5); //5.6
        double second = calc.pow(first, 2);   //31.36

        calc.memory();                           // сохраняем 31.36

        double third = calc.multiply(15, 7);//105

        System.out.println("Возвращаем сохранённый результат: " + calc.getMemory());
        System.out.println("Проверяем обнуление памяти : " + calc.getMemory());

        double fourth = calc.add(4.1, third);//109.1

        calc.memory();                          //memory = 109.1

        double result = calc.add(fourth, second);

        System.out.println("4.1 + 15 * 7 + (28 / 5) ^ 2 = " + result);
        System.out.println("Было сохранено: " + calc.getMemory());
    }
}
