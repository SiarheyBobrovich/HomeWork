package home_work_3.runners;

import home_work_3.calcs.additional.CalculatorStringExpression;
import home_work_3.calcs.api.ICalculator;
import home_work_3.calcs.simple.CalculatorWithMathExtends;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorStringExpressionMain {
    public static void main(String[] args) {

        String[] test = {
               //"2/0",
//                "2 + 3 / (2 / 2)",
//                "-2 + 3 * 2 + 3",
//                ") 2 + 3",
//                "( 2 + 3",
//                "+ 2 + 3",
//                "2 - 3 -",
//                "|2 + 3|",
//                "|2 + 3",
//                "",
//                "3 + 3 * k",
//                "1 +-*/ 2 E PI",
//                "2+3*6^2- (2 / 0)",
                "((((2+3E3)^PI/-2)*PI/(E*2)^2*-2)/10)^2"
        };

        CalculatorStringExpression calc = new CalculatorStringExpression(new CalculatorWithMathExtends());
        for (String arg : test) {
            System.out.println(calc.calculate(arg));
            for (String s : calc.getCalculations()) {
                System.out.println(s);
            }
            System.out.println("------------------");
        }


    }
}
