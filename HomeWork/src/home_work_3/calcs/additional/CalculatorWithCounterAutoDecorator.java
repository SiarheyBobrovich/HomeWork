package home_work_3.calcs.additional;

/*
    11*. Создать класс CalculatorWithCounterAutoDecorator и CalculatorWithMemoryDecorator

        11.1 Отличие от предыдущих CalculatorWithCounterAutoCompositeInterface и CalculatorWithMemory
             в том что данные классы реализуют интерфейс ICalculator.

        11.2 Данный подход позволяет назвать данные классы "Декораторами".
             Декоратор - это популярный паттерн который позволяет комбинировать и дополнять новыми возможностями объекты
             (в нашем случае калькуляторы) не меняя код в их классе. Тем самым мы приходим к тому что мы не наследуем классы
             для их расширения и не привязываемся к реализации конкретного калькулятора.

        11.3 О декораторах можно прочитать по ссылкам:
             11.3.1 https://refactoring.guru/ru/design-patterns/decorator
             11.3.2 https://www.wikiwand.com/ru/%D0%94%D0%B5%D0%BA%D0%BE%D1%80%D0%B0%D1%82%D0%BE%D1%80_(%D1%88%D0%B0%D0%B1%D0%BB%D0%BE%D0%BD_%D0%BF%D1%80%D0%BE%D0%B5%D0%BA%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F)

        11.4 Добавить в эти классы метод ICalculator getCalculator() который будут возвращать вложенный в них калькулятор.
 */

import home_work_3.calcs.api.ICalculator;

public class CalculatorWithCounterAutoDecorator implements ICalculator {

    ICalculator calculator;
    private long countOperation;

    void incrementCountOperation(){
        countOperation++;
    }

    public long getCountOperation() {
        return countOperation;
    }

    public CalculatorWithCounterAutoDecorator(ICalculator calculator) {
        this.calculator = calculator;
    }

    public ICalculator getCalculator() {
        return calculator;
    }

    @Override
    public double add(double a, double b) {
        incrementCountOperation();

        return getCalculator().add(a, b);
    }

    @Override
    public double subtract(double a, double b) {
        incrementCountOperation();

        return getCalculator().subtract(a, b);
    }

    @Override
    public double multiply(double a, double b) {
        incrementCountOperation();

        return getCalculator().multiply(a, b);
    }

    @Override
    public double divide(double a, double b) {
        incrementCountOperation();

        return getCalculator().divide(a, b);
    }

    @Override
    public double pow(double a, long b) {
        incrementCountOperation();

        return getCalculator().pow(a, b);
    }

    @Override
    public double sqrt(double a) {
        incrementCountOperation();

        return getCalculator().sqrt(a);
    }

    @Override
    public double abs(double a) {
        incrementCountOperation();

        return getCalculator().abs(a);
    }
}
