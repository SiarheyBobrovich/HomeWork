package home_work_3.calcs.additional.string_calculator2.main;


import home_work_3.calcs.additional.string_calculator2.dto.CalculatorStringExpression;
import home_work_3.calcs.simple.CalculatorWithMathExtends;

public class CalculatorStringExpressionMain {
    public static void main(String[] args) {
        CalculatorStringExpression calc = new CalculatorStringExpression(new CalculatorWithMathExtends());
        System.out.println(calc.calculate("((((2+3E3)^PI/-2)*PI/(E*2)^2*-2)/10)^2"));
        System.out.println(calc.calculate("2 -- 33"));
        System.out.println(calc.calculate("2 ++ 3"));
        System.out.println(calc.calculate(" 2 * * 3"));
        System.out.println(calc.calculate("2 / / 3"));
        System.out.println(calc.calculate("2 ^^ 3"));
        System.out.println(calc.calculate("()"));
        System.out.println(calc.calculate("24"));
        System.out.println(calc.calculate("2 --- 3"));
        System.out.println(calc.calculate("((((2+3E3)^PI/-2)*PI/(E*2)^2*-2)/10)^2"));
        System.out.println(calc.calculate("2 + 3 + E"));



        System.out.println(Double.parseDouble("215054407386834451.5449425269458976"));



    }
}
