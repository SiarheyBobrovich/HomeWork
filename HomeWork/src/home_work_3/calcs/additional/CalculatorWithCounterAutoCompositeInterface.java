package home_work_3.calcs.additional;

/*
    9. Создать класс CalculatorWithCounterAutoCompositeInterface.
        9.1 Внутри класса нельзя создавать объекты, можно пользоваться только тем что передал вам пользователь вашего класса.
        9.2 Все методы объявленные в данном классе НЕ статические (не имеют модификатор static).
        9.3 В данном классе должен быть только конструктор принимающий объект типа ICalculator
        9.4 Данный класс напрямую не умеет считать математику, он умеет делегировать расчёт
            математики другим калькуляторам переданным в конструктор
        9.5 В классе должны присутствовать все методы объявленные в интерфейсе.
        9.6 В классе должен быть метод long getCountOperation() который должен возвращать
            количество использований данного калькулятора. При вызове данного метода счётчик учёта не увеличивается.
 */

import home_work_3.calcs.api.ICalculator;

public class CalculatorWithCounterAutoCompositeInterface {

    private ICalculator calculator;
    private long countOperation;

    public CalculatorWithCounterAutoCompositeInterface(ICalculator calculator) {
        this.calculator = calculator;
    }

    public ICalculator getCalculator() {
        return calculator;
    }

    public long getCountOperation() {
        return countOperation;
    }

    void incrementCountOperation(){
        countOperation++;
    }

    public double add(double a, double b) {
        incrementCountOperation();

        return calculator.add(a, b);
    }

    public double subtract(double a, double b) {
        incrementCountOperation();

        return calculator.subtract(a, b);
    }

    public double multiply(double a, double b) {
        incrementCountOperation();

        return calculator.multiply(a, b);
    }

    public double divide(double a, double b) {
        incrementCountOperation();

        return calculator.divide(a, b);
    }

    public double pow(double a, long b) {
        incrementCountOperation();

        return calculator.pow(a, b);
    }

    public double sqrt(double a) {
        incrementCountOperation();

        return calculator.sqrt(a);
    }

    public double abs(double a) {
        incrementCountOperation();

        return calculator.abs(a);
    }
}
