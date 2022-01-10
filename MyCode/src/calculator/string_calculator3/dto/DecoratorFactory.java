package calculator.string_calculator3.dto;

import calculator.string_calculator3.api.ICount;

public class DecoratorFactory {

    /**
     * Фабрика по преобразованию выражения в отдельные классы
     * @param expression выражение для преобразования
     * @return связный класс всего выражения
     */
    public ICount getNextDecorator(String expression) {

        StringBuilder a = new StringBuilder();

        boolean isDigitBefore = false;
        for (int i = 0; i < expression.length(); i++) {
            char tmp = expression.charAt(i);

            if (Character.isDigit(tmp) || tmp == '.' || (isDigitBefore && tmp == 'E')) {
                isDigitBefore = true;
                a.append(tmp);
                continue;
            }

            switch (tmp) {
                case '+' :
                    return new Plus(getNextDecorator(expression.substring(i + 1)),
                            new Value(a.toString()));
                case '-' :
                    return new Minus(getNextDecorator(expression.substring(i + 1)),
                            new Value(a.toString()));
                case '*' :
                    return new Multiply(getNextDecorator(expression.substring(i + 1)),
                            new Value(a.toString()));
            }



        }

        return new Value(expression);
    }

    public String reverse(String expression) {
        StringBuilder digit = new StringBuilder();
        StringBuilder result = new StringBuilder();

        boolean isDigitBefore = false;
        for (char c: expression.toCharArray()) {
            if (Character.isDigit(c) || c == 'E') {
                digit.append(c);
                isDigitBefore = true;
                continue;
            }else if (isDigitBefore) {
                result.insert(0, digit);
                isDigitBefore = false;
                digit = new StringBuilder();
            }

            result.insert(0, c);

        }
        result.insert(0, digit.length() == 0 ? "" : digit);

        return result.toString();
    }
}
