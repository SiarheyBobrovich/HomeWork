package home_work_3.calcs.simple;

/*
    4. Создать класс CalculatorWithMathExtends.
    4.1 Все методы объявленные в данном классе НЕ статические (не имеют модификатор static).
    4.2 Данный класс должен наследовать класс CalculatorWithOperator.
    4.3 Условия:
        4.3.1 4 базовых математических метода (деление, умножение, вычитание, сложение)
                НЕ ДОЛЖНЫ быть объявлены напрямую в классе, а должны быть унаследованы от родительского класса (4.2).
        4.3.2 3 метода (Возведение в целую степень дробного положительного числа, Модуль числа, Корень из числа).
                Данные методы должны ПЕРЕОПРЕДЕЛЯТЬ методы родительского класса (4.2)
                и должны содержать в своём теле вызов библиотеки Math и возврат полученного результата.
 */

import home_work_3.calcs.api.ICalculator;

public class CalculatorWithMathExtends extends CalculatorWithOperator {

    @Override
    public double abs(double a) {
        return Math.abs(a);
    }

    @Override
    public double sqrt(double a) {
        return Math.sqrt(a);
    }

    @Override
    public double pow(double a, long b) {
        return Math.pow(a, b);
    }
}
