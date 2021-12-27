package calculator.string_calculator.dto;

import calculator.string_calculator.utils.Stack;
import home_work_3.calcs.api.ICalculator;

public class CalculatorStringExpression {

    private ICalculator calculator;

    public CalculatorStringExpression(ICalculator calculator) {
        this.calculator = calculator;
    }

    /**
     * Метод запускает вычисление
     * @param expression выражение для вычисления
     * @return результат вычисления или ошибку
     */
    public String calculate(String expression) {
        if (expression.length() == 0) {
            return "Пустая строка";
        }
        expression = expression.replace(" ", "");

        String[] expressions = getPostfixExpression(expression);

        if (expressions.length == 0) {
            return "Не корректное выражение: Ошибка со скобками";
        }

        return calculateExpression(expressions);
    }

    /**
     * Метод преобразует выражение в постфиксную запись
     * @param expression - выражение для преобразования
     * @return постфиксное выражение или сообщение об ошибке.
     */
    private String[] getPostfixExpression(String expression) {
        Stack signs = new Stack();
        String[] expressions = new String[0];
        StringBuilder builder = new StringBuilder();

        boolean isSignBefore = false;
        int countModule = 0;

        for (int i = 0; i < expression.length(); i++) {
            char element = expression.charAt(i);


            if (Character.isDigit(element) || element == '.' || element == 'E' || element == 'P' ||
                                  element == 'I'  || (isSignBefore && element == '-')) {

                builder.append(element);
                isSignBefore = false;
                continue;

            } else if (builder.length() != 0 ) {

                if (element == '-' && builder.indexOf("-") != -1) {
                    return new String[] {"Некоректное выражение: Ошибка с [-]"};
                }else if (builder.toString().equals("PI")) {
                    builder = new StringBuilder("" + Math.PI);
                }else if (builder.toString().equals("E")) {
                    builder = new StringBuilder("" + Math.E);
                }

                expressions = addValueToLength(expressions, builder.toString());
                builder = new StringBuilder();
                isSignBefore = false;
            }


            if (element == '(') {
                signs.pop(element);

            }else if (element == ')') {

                while (!signs.isBracketInStack()) {
                    char tmp = signs.getNextSign();
                    if (tmp != '!') {
                        expressions = addValueToLength(expressions, "" + tmp);
                    }else {
                        return new String[]{"Выражение не корректно: Неправильно расставлены скобки"};
                    }
                }

                isSignBefore = false;
                signs.remove();

            } else if (element == '+' || element == '-') {

                if (isSignBefore || i == 0) {
                    return new String[] {"Выражение не корректно: Ошибка с [+-]"};
                } else if (signs.isPlusMinusInStack() || signs.isMultiplyDivideInStack()) {
                    expressions = addValueToLength(expressions, "" + signs.getNextSign());
                }

                signs.pop(element);
                isSignBefore = true;

            }else if (element == '/' || element == '*' ){

                if (isSignBefore || i == 0) {
                    return new String[] {"Выражение не корректно: Ошибка с [/*]"};
                } else if (signs.isEmptyStack() || signs.isBracketInStack() || signs.isPlusMinusInStack()) {
                    signs.pop(element);
                    isSignBefore = true;
                }else {

                    while (!signs.isEmptyStack() && !signs.isBracketInStack()) {
                        char tmp = signs.getNextSign();
                        expressions = addValueToLength(expressions, "" + tmp);
                    }

                    signs.pop(element);
                    isSignBefore = true;
                }

            }else if (element == '^') {

                if (isSignBefore || i == 0) {
                    return new String[] {"Выражение не корректно: Ошибка с [^]"};
                }else {
                    signs.pop(element);
                }

                isSignBefore = true;

            }else if (element == '|') {

                if (isSignBefore) {
                    signs.pop(element);
                    countModule++;

                }else if (countModule > 0){

                    while (!signs.isModuleInStack()) {
                        char tmp = signs.getNextSign();

                        if (tmp != '!') {
                            expressions = addValueToLength(expressions, "" + tmp);
                        }else {
                            return new String[]{"Выражение не корректно: Ошибка с [|]"};
                        }
                    }

                    expressions = addValueToLength(expressions, "" + signs.getNextSign());
                }

                else {
                    return new String[] {"Выражение не корректно: Нет пары к [|]"};
                }

            }else {
                return new String[] {"Выражение не корректно: присутствует недопустимый символ"};
            }
        }

        if (builder.length() != 0) {
            expressions = addValueToLength(expressions, builder.toString());
        }

        while (!signs.isEmptyStack() && !signs.isBracketInStack() && !isSignBefore) {
            expressions = addValueToLength(expressions, "" + signs.getNextSign());
        }

        return signs.length() > 0 ? new String[] {"Выражение не верное: Ошибка в знаках или скобках"} : expressions;
    }

    /**
     * Метод вычисления из постфиксного выражения
     * @param expressions - постфиксное выражение
     * @return результат вычисления
     */
    private String calculateExpression(String[] expressions) {
        if (expressions[0].startsWith("Выражение")) {
            return expressions[0];
        }

        String[] numbers = new String[expressions.length / 2 + 1];

        int i = 0;

        for (String element : expressions) {
            double a = 0.0;
            double b = 0.0;

            if (i >= 2) {
                a = Double.parseDouble(numbers[i - 2]);
                b = Double.parseDouble(numbers[i - 1]);
            }

            switch (element) {

                case "+" :
                    numbers[i-- - 2] = "" + calculator.add(a, b);
                    break;

                case "-" :
                    numbers[i-- - 2] = "" + calculator.subtract(a, b);
                    break;

                case "*" :
                    numbers[i-- - 2] = "" + calculator.multiply(a, b);
                    break;

                case "/" :
                    numbers[i-- - 2] = "" + calculator.divide(a, b);
                    break;

                case "^" :
                    numbers[i-- - 2] = "" + calculator.pow(a, (long)b);
                    break;

                case "|" :
                    numbers[i - 1] = "" + calculator.abs(Double.parseDouble(numbers[i - 1]));
                    break;

                default:
                    numbers[i++] = element;
                    break;
            }
        }

        return numbers[0];
    }

    /**
     * Метод добавления элемента в массив с увеличением массива
     * @param array массив для добавления элемента
     * @param value - добавляемый элемент
     * @return - новый массив
     */
    private String[] addValueToLength(String[] array, String value) {
        String[] newArray = new String[array.length + 1];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }

        newArray[newArray.length - 1] = value;

        return newArray;
    }

}
