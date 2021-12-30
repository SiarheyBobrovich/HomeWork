package home_work_3.calcs.additional;

/*
    7.2 Внутри класса CalculatorWithCounterAutoComposite мы должны создавать поле хранящее объект класса калькулятор
        и инициализировать данное поле созданным (использовать new) внутри данного класса объектом калькулятора.
*/

import home_work_3.calcs.simple.CalculatorWithOperator;

public class CalculatorWithCounterAutoComposite {

    private final CalculatorWithOperator calculator;
    private long countOperation;

    public CalculatorWithCounterAutoComposite(CalculatorWithOperator calculator) {
        this.calculator = calculator;
    }

    private void incrementCountOperation(){
        countOperation++;
    }

    public long getCountOperation() {
        return countOperation;
    }

    public double abs(double a) {
        incrementCountOperation();

        return calculator.abs(a);
    }

    public double sqrt(double a) {
        incrementCountOperation();

        return calculator.sqrt(a);
    }

    public double pow(double a, long b) {
        incrementCountOperation();

        return calculator.pow(a, b);
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
}
