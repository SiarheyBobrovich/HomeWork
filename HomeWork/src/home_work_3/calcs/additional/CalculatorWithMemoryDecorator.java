package home_work_3.calcs.additional;

/*
    11*. Создать класс CalculatorWithCounterAutoDecorator и CalculatorWithMemoryDecorator
        11.1 Отличие от предыдущих CalculatorWithCounterAutoCompositeInterface и CalculatorWithMemory
            в том что данные классы реализуют интерфейс ICalculator.
        11.2 Данный подход позволяет назвать данный классы "Декораторами".
            Декоратор - это популярный паттерн который позволяет комбинировать и дополнять новыми возможностями объекты
            (в нашем случае калькуляторы) не меняя код в их классе. Тем самым мы приходим к тому что мы не наследуем классы
            для их расширения и не привязываемся к реализации конкретного калькулятора.
        11.3 О декораторах можно прочитать по ссылкам:
            11.3.1 https://refactoring.guru/ru/design-patterns/decorator
            11.3.2 https://www.wikiwand.com/ru/%D0%94%D0%B5%D0%BA%D0%BE%D1%80%D0%B0%D1%82%D0%BE%D1%80_(%D1%88%D0%B0%D0%B1%D0%BB%D0%BE%D0%BD_%D0%BF%D1%80%D0%BE%D0%B5%D0%BA%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F)
        11.4 Добавить в эти классы метод ICalculator getCalculator() который будут возвращать вложенный в них калькулятор.
        11.5 Создать класс CalculatorDecoratorMain в котором будет точка входа (main метод).
            Cоздать переменную типа ICalculator записав в неё новый экземпляр класса CalculatorWithCounterAutoDecorator которому
            в конструктор был передан новый экземпляр класса CalculatorWithMemoryDecorator которому в конструтор был передан
            новый экземпляр класса CalculatorWithMathExtends. Используя созданную переменную посчитать выражения из задания 1.
        11.6 Вывести в консоль результат. Вывести количество использований калькулятора.
             Вывести последнее сохранённое значение в памяти. Поможет выполнить instanceof
 */

import home_work_3.calcs.api.ICalculator;

public class CalculatorWithMemoryDecorator implements ICalculator {

    ICalculator calculator;



    private double memory;
    private double tmp;

    public CalculatorWithMemoryDecorator(ICalculator calculator) {
        this.calculator = calculator;
    }

    public ICalculator getCalculator() {
        return calculator;
    }

    public void memory() {
        memory = tmp;
    }

    public double getMemory() {
        double tmp = memory;
        memory = 0;
        return tmp;
    }

    @Override
    public double add(double a, double b) {
        return tmp = getCalculator().add(a, b);
    }

    @Override
    public double subtract(double a, double b) {
        return tmp = getCalculator().subtract(a, b);
    }

    @Override
    public double multiply(double a, double b) {
        return tmp = getCalculator().multiply(a, b);
    }

    @Override
    public double divide(double a, double b) {
        return tmp = getCalculator().divide(a, b);
    }

    @Override
    public double pow(double a, long b) {
        return tmp = getCalculator().pow(a, b);
    }

    @Override
    public double sqrt(double a) {
        return tmp = getCalculator().sqrt(a);
    }

    @Override
    public double abs(double a) {
        return tmp = getCalculator().abs(a);
    }
}