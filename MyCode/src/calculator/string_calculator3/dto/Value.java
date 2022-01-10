package calculator.string_calculator3.dto;

import calculator.string_calculator3.api.ICount;
import home_work_3.calcs.api.ICalculator;

public class Value implements ICount {

    String value;
    ICount iCount;

    public Value(String value) {
        this.value = value;
    }

    public Value(String value, ICount iCount) {
        this.iCount = iCount;
        this.value = value;
    }

    public Value(Double value) {
        this.value = String.valueOf(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public Value getCount(ICalculator calculator) {
        if (iCount != null) {
            return iCount.getCount(calculator);
        }
        return this;
    }
}
