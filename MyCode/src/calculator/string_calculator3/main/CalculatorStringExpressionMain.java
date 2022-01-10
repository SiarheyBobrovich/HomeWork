package calculator.string_calculator3.main;

import calculator.string_calculator3.dto.CalculatorStringExpression;
import home_work_3.calcs.simple.CalculatorWithMathExtends;

public class CalculatorStringExpressionMain {
    public static void main(String[] args) {
        CalculatorStringExpression calc = new CalculatorStringExpression(new CalculatorWithMathExtends());
        String[] expressions = {

//                "2+3+4",
//                "9 + 7 + 5 + 5"
                "12 - 2 * 3 - 2 ",
//                "2 * 3 * 4",
//                "2 / 3 / 4"

        };

        for (String expression : expressions) {
            System.out.println(expression + " = " + calc.calculate(expression));
        }
    }
}
