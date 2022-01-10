package calculator.string_calculator3.dto;

import calculator.string_calculator3.api.ICount;
import home_work_3.calcs.api.ICalculator;

public class Multiply extends CountFirst {

    public Multiply(ICount a, Value b) {
        super(a, b);
    }

    @Override
    public Value getCount(ICalculator calculator) {
        double a = Double.parseDouble(getB().getCount(calculator).getValue());
        double b = Double.parseDouble(getC().getCount(calculator).getValue());
        return new Value(calculator.multiply(a , b));
    }
}
