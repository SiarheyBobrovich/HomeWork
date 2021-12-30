package home_work_3.calcs.additional;

import home_work_3.calcs.simple.CalculatorWithMathCopy;
import home_work_3.calcs.simple.CalculatorWithMathExtends;
import home_work_3.calcs.simple.CalculatorWithOperator;

public class CalculatorWithCounterAutoAgregation {
    private long countOperation;

    private final CalculatorWithOperator calculatorWithOperator;
    private final CalculatorWithMathCopy calculatorWithMathCopy;
    private final CalculatorWithMathExtends calculatorWithMathExtends;

    public CalculatorWithCounterAutoAgregation(CalculatorWithOperator operator) {
        this.calculatorWithOperator = operator;
        this.calculatorWithMathCopy = null;
        this.calculatorWithMathExtends = null;
    }

    public CalculatorWithCounterAutoAgregation(CalculatorWithMathExtends calculatorWithMathExtends) {
        this.calculatorWithMathExtends = calculatorWithMathExtends;
        this.calculatorWithMathCopy = null;
        this.calculatorWithOperator = null;
    }

    public CalculatorWithCounterAutoAgregation(CalculatorWithMathCopy calculatorWithMathCopy) {
        this.calculatorWithMathCopy = calculatorWithMathCopy;
        this.calculatorWithOperator = null;
        this.calculatorWithMathExtends = null;
    }

    private void incrementCountOperation(){
        countOperation++;
    }

    public long getCountOperation() {
        return countOperation;
    }

    public double abs(double a) {
        incrementCountOperation();

        if (calculatorWithOperator != null) {
            return calculatorWithOperator.abs(a);
        }else if (calculatorWithMathCopy != null) {
            return calculatorWithMathCopy.abs(a);
        }

        return calculatorWithMathExtends.abs(a);
    }

    public double sqrt(double a) {
        incrementCountOperation();

        if (calculatorWithOperator != null) {
            return calculatorWithOperator.sqrt(a);
        }else if (calculatorWithMathCopy != null) {
            return calculatorWithMathCopy.sqrt(a);
        }

        return calculatorWithMathExtends.sqrt(a);
    }

    public double pow(double a, long b) {
        incrementCountOperation();
        if (calculatorWithOperator != null) {
            return calculatorWithOperator.pow(a, b);
        }else if (calculatorWithMathCopy != null) {
            return calculatorWithMathCopy.pow(a, b);
        }

        return calculatorWithMathExtends.pow(a, b);
    }

    public double add(double a, double b) {
        incrementCountOperation();

        if (calculatorWithOperator != null) {
            return calculatorWithOperator.add(a, b);
        }else if (calculatorWithMathCopy != null) {
            return calculatorWithMathCopy.add(a, b);
        }

        return calculatorWithMathExtends.add(a, b);
    }

    public double subtract(double a, double b) {
        incrementCountOperation();

        if (calculatorWithOperator != null) {
            return calculatorWithOperator.subtract(a, b);
        }else if (calculatorWithMathCopy != null) {
            return calculatorWithMathCopy.subtract(a, b);
        }

        return calculatorWithMathExtends.subtract(a, b);
    }

    public double multiply(double a, double b) {
        incrementCountOperation();

        if (calculatorWithOperator != null) {
            return calculatorWithOperator.multiply(a, b);
        }else if (calculatorWithMathCopy != null) {
            return calculatorWithMathCopy.multiply(a, b);
        }

        return calculatorWithMathExtends.multiply(a, b);
    }

    public double divide(double a, double b) {
        incrementCountOperation();

        if (calculatorWithOperator != null) {
            return calculatorWithOperator.divide(a, b);
        }else if (calculatorWithMathCopy != null) {
            return calculatorWithMathCopy.divide(a, b);
        }

        return calculatorWithMathExtends.divide(a, b);
    }
}
