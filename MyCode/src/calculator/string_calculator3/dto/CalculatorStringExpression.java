package calculator.string_calculator3.dto;

import calculator.string_calculator3.api.ICount;
import home_work_3.calcs.api.ICalculator;

public class CalculatorStringExpression {

    private final ICalculator calculator;
    DecoratorFactory factory;

    public CalculatorStringExpression(ICalculator calculator) {
        this.calculator = calculator;
    }

    public String calculate(String expression) {
        factory = new DecoratorFactory();
        expression = factory.reverse(expression);
        ICount value = factory.getNextDecorator(expression);

        return value.getCount(calculator).getValue();
    }

}
