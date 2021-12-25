package home_work_3.calcs.utils;

import java.util.Arrays;
import java.util.regex.Pattern;

public class CalcUtils {

    public static boolean isSign(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    public static boolean isValid(String expression) {

        if (expression == null) {
            return false;
        }else if (expression.length() == 0) {
            return false;
        }

        if (isSign(expression.charAt(0)) && expression.charAt(0) != '-') {
            return false;
        }else if (expression.length() > 1 && isSign(expression.charAt(expression.length() - 1))) {
            return false;
        }

        int module = 0;
        int brackets = 0;

        for (int i = 0; i < expression.length(); i++) {
            char value = expression.charAt(i);

            if (value == '(') {
                brackets ++;
            }else if (value == ')') {

                if (brackets == 0) {
                    return false;
                }else {
                    brackets--;
                }

            }else if (value == '|') {
                module++;
            }
        }

        return brackets == 0 && module % 2 == 0;
    }
}
