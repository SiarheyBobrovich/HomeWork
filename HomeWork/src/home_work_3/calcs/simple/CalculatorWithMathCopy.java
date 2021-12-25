package home_work_3.calcs.simple;

/*
    3. Создать класс CalculatorWithMathCopy.
        3.1 Все методы объявленные в данном классе НЕ статические (не имеют модификатор static).
        3.2 В классе должны присутствовать математические методы:
            3.2.1 4 базовых математических метода (деление, умножение, вычитание, сложение).
                Скопировать базовые математические операции из CalculatorWithOperator.
            3.2.2 3 метода (Возведение в целую степень дробного положительного числа, Модуль числа, Корень из числа).
                Данные методы должны содержать в своём теле вызов библиотеки Math и возврат полученного результата.

 */

import home_work_3.calcs.api.ICalculator;

public class CalculatorWithMathCopy implements ICalculator {
    /**
     * Метод сложения двух чисел
     * @param a - первое слагаемое
     * @param b - второе слагаемое
     * @return результат выражения a + b
     */
    public double add(double a, double b) {
        return a + b;
    }

    /**
     * Метод вычитания одного числа из другого
     * @param a - Уменьшаемый аргумент
     * @param b - вычитаемый аргумент
     * @return результат выражения a - b
     */
    public double subtract(double a, double b) {
        return a - b;
    }

    /**
     * Метод умножения двух чисел
     * @param a - первый множитель
     * @param b - второй множитель
     * @return результат выражения a * b
     */
    public double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Метод деления первого числа на второе
     * @param a - делимое (числитель)
     * @param b - делитель (знаменатель)
     * @return результат выражения a / b
     */
    public double divide(double a, double b) {
        return a / b;

    }

    public double pow(double a, long b) {
        return Math.pow(a, b);
    }

    public double sqrt(double a) {
        return Math.sqrt(a);
    }

    public double abs(double a) {
        return Math.abs(a);
    }
}
