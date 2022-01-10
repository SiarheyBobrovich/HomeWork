package calculator.string_calculator3.dto;

import calculator.string_calculator3.api.ICount;
import home_work_3.calcs.api.ICalculator;

public abstract class CountSecond implements ICount {

    ICount a;
    Value b;

    public CountSecond(ICount a, Value b) {
        this.a = a;
        this.b = b;
    }

    public ICount getA() {
        return a;
    }

    public Value getB() {
        return b;
    }
}
