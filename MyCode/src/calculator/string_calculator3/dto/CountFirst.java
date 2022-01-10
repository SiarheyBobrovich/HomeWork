package calculator.string_calculator3.dto;

import calculator.string_calculator3.api.ICount;

public abstract class CountFirst implements ICount {

    ICount a;
    Value b;
    Value c;

    public Value getC() {
        return c;
    }

    public CountFirst(ICount a, Value b) {
        this.a = a;
        this.b = b;
    }

    public ICount getA() {
        return a;
    }

    public ICount getB() {
        return b;
    }

    public void setC(Value c) {
        this.c = c;
    }
}
