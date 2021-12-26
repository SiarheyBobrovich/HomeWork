package home_work_3.calcs.additional.string_calculator2.dto;

import home_work_3.calcs.additional.string_calculator.utils.Stack;
import home_work_3.calcs.api.ICalculator;

public class CalculatorStringExpression {

    private ICalculator calculator;
    private String[] expressions;
    private boolean isSignBefore = false;
    private Stack signs;
    StringBuilder builder;

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

        toPostfixExpression(expression);

        if (expressions.length == 0) {
            return "Не корректное выражение: Ошибка со скобками";
        }

        return calculateExpression(expressions);
    }

    /**
     * Метод преобразует выражение в постфиксную запись
     * @param expression - выражение для преобразования
     */
    private void toPostfixExpression(String expression) {
        signs = new Stack();
        expressions = new String[0];
        builder = new StringBuilder();

        int countModule = 0;

        for (int i = 0; i < expression.length(); i++) {
            char element = expression.charAt(i);

            if (isDigitOrConstant(element)) {
                forNumber(element);
                continue;

            } else if (builder.length() != 0 ) {
                if (element == '-' && builder.indexOf("-") != -1) {
                    expressions = new String[] {"Выражение не коректно: Ошибка с [-]"};
                    return;
                }
                addBuilderToPostfixExpressions();
            }

            boolean isInvalid = isSignBefore || i == 0;

            switch (element) {
                case '+' :
                case '-' :
                    if (isInvalid) {
                        expressions = new String[]{"Выражение не корректно: Ошибка с [+-]"};
                        return;
                    }
                    forPlusMinus(element);
                    break;

                case '*' :
                case '/' :
                    if (isInvalid) {
                        expressions = new String[]{"Выражение не коректно: Ошибка с [/*]"};
                        return;
                    }else {
                        forMultiplyDivide(element);
                    }
                    break;

                case '^' :
                    if (isInvalid) {
                        expressions = new String[] {"Выражение не коректно: Ошибка с [^]"};
                        return;
                    }else {
                        forPow(element);
                    }
                    break;

                case '(' :
                case ')' :
                    forBrackets(element);
                    break;

                case '|' :
                    forModule(element, countModule);
                    break;

                default:
                    expressions = new String[] {"Выражение не коректно: Ошибка с [" + element + "]"};
                    return;
            }

        }

        if (builder.toString().equals("P")) {
            expressions = new String[] {"Выражение не коректно: Ошибка в [" + builder + "]"};
            return;
        }else {
            addBuilderToPostfixExpressions();
        }

        while (!signs.isEmptyStack() && !signs.isBracketInStack() && !isSignBefore) {
            addValueToLength("" + signs.getNextSign());
        }

        expressions = signs.length() > 0 ? new String[] {"Выражение не коректно: Ошибка в знаках или скобках"} : expressions;
    }

    private void forNumber(char element) {
        builder.append(element);
        isSignBefore = false;
    }

    private void addBuilderToPostfixExpressions() {

        if (builder.toString().equals("PI")) {
            builder = new StringBuilder("" + Math.PI);
        }else if (builder.toString().equals("E")) {
            builder = new StringBuilder("" + Math.E);
        }

        addValueToLength(builder.toString());
        builder = new StringBuilder();
        isSignBefore = false;
    }


    /**
     * Метод добавления в постфиксный массив скобок
     * @param element - элемент для добавления
     */
    private void forBrackets(char element) {

        if (element == '(') {
            signs.pop(element);
        }else {

            while (!signs.isBracketInStack()) {
                char tmp = signs.getNextSign();
                if (tmp != '!') {
                    addValueToLength("" + tmp);
                }else {
                    expressions = new String[]{"Выражение не корректно: Неправильно расставлены скобки"};
                }
            }

            isSignBefore = false;
            signs.remove();

        }
    }

    /**
     *
     * @param element
     */
    private void forPlusMinus(char element) {


        if (signs.isPlusMinusInStack() || signs.isMultiplyDivideInStack()) {
            addValueToLength("" + signs.getNextSign());
        }

        signs.pop(element);
        isSignBefore = true;
    }

    private void forMultiplyDivide(char element) {

        if (signs.isEmptyStack() || signs.isBracketInStack() || signs.isPlusMinusInStack()) {
            signs.pop(element);
            isSignBefore = true;
        }else {

            while (!signs.isEmptyStack() && !signs.isBracketInStack()) {
                char tmp = signs.getNextSign();
                addValueToLength( "" + tmp);
            }

            signs.pop(element);
            isSignBefore = true;
        }
    }

    private void forPow(char element) {
        signs.pop(element);
        isSignBefore = true;
    }

    private void forModule(char element, int countModule) {
        if (isSignBefore) {
            signs.pop(element);
            countModule++;

        }else if (countModule > 0){

            while (!signs.isModuleInStack()) {
                char tmp = signs.getNextSign();

                if (tmp != '!') {
                    addValueToLength("" + tmp);
                }else {
                    expressions = new String[]{"Выражение не корректно: Ошибка с [|]"};
                }
            }

            addValueToLength("" + signs.getNextSign());
        }

        else {
            expressions = new String[] {"Выражение не корректно: Нет пары к [|]"};
        }
    }

    private boolean isDigitOrConstant(char element) {
        return Character.isDigit(element) || element == '.' || element == 'E' || element == 'P' ||
                element == 'I'  || (isSignBefore && element == '-');
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
     * @param value - добавляемый элемент
     */
    private void addValueToLength(String value) {
        String[] newArray = new String[expressions.length + 1];

        for (int i = 0; i < expressions.length; i++) {
            newArray[i] = expressions[i];
        }

        newArray[newArray.length - 1] = value;

        expressions = newArray;
    }

}
