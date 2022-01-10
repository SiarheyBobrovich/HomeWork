package calculator.string_calculator3.test;

import calculator.string_calculator3.dto.CalculatorStringExpression;
import home_work_3.calcs.simple.CalculatorWithMathExtends;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CalculatorStringExpressionTest {

    CalculatorStringExpression calc = new CalculatorStringExpression(new CalculatorWithMathExtends());


    @Test
    void calculate() {
        Assertions.assertEquals( "10.0", calc.calculate("12 - 2 + 2 - 2"));
        Assertions.assertEquals( "4.0", calc.calculate("12 - 2 * 3 - 2"));

    }


}