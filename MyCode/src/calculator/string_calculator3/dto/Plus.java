package calculator.string_calculator3.dto;

import calculator.string_calculator3.api.ICount;
import home_work_3.calcs.api.ICalculator;

public class Plus extends CountSecond {


    public Plus(ICount a, Value b) {
        super(a, b);
    }

    @Override
    public Value getCount(ICalculator calculator) {

        if (a instanceof CountFirst) {
            ((CountFirst) a).setC(b);
            this.b = a.getCount(calculator);
        }

        double a = Double.parseDouble(getA().getCount(calculator).getValue());
        double b = Double.parseDouble(getB().getCount(calculator).getValue());

        return new Value(calculator.add(a , b));
    }
}
