package home_work_3.calcs.additional;

/*
        12**. Написать класс CalculatorStringExpression. Данное задание направлено на изучение паттера Адаптер.
    	12.0 О адаптерах можно прочитать по ссылкам:
    		12.0.1 https://refactoring.guru/ru/design-patterns/adapter
    		12.0.2 https://www.wikiwand.com/ru/%D0%90%D0%B4%D0%B0%D0%BF%D1%82%D0%B5%D1%80_(%D1%88%D0%B0%D0%B1%D0%BB%D0%BE%D0%BD_%D0%BF%D1%80%D0%BE%D0%B5%D0%BA%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F)
    	12.1 реализующий разбор (парсинг) СТРОКИ с математическим выражением:
    	12.2 Класс должен понимать операторы: + - \ * ^ ||
    	12.3 Класс должен понимать ( )
    	12.4 Класс должен строго учитывать приоритеты в данном выражении
    	12.5 Класс должен уметь парсить в строке константные значение: PI, E (Экспонента)
    	12.6 Класс должен контролировать что в строке могут быть только допустие символы (числа, операторы, скобки, константы)
    	12.7 Класс должен контролировать чтобы выражение было валидным (2 + 2 - хорошо, 2 + - плохо)
 */

import home_work_3.calcs.api.ICalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import home_work_3.calcs.utils.CalcUtils;


public class CalculatorStringExpression {

    private boolean isReturn = false;
    String[] calculations;
    ICalculator calculator;

    public CalculatorStringExpression(ICalculator calculator) {
        this.calculator = calculator;
    }

    public String[] getCalculations() {
        return calculations;
    }

    /**
     * Метод запуска вычисления
     * @param expression Выражение для вчисления
     * @return результат вычисления
     */

    public String calculate(String expression) {
        expression = expression.replace(" ", "");
        Matcher m  = Pattern.compile("[^\\d]{1}E[^\\d]{1}").matcher(expression);

        while (m.find()) {
            expression = expression.replace(m.group(), m.group().replace("E", "" + Math.E));
        }

        expression = expression.replace("PI", "" + Math.PI);

        String doubleNumber = "-?\\d+\\.?\\d*(E-?\\d+)?";
        String[] str =  {
                doubleNumber + "[\\^]" + doubleNumber,
                doubleNumber + "[*/]" + doubleNumber,
                doubleNumber + "[+\\-]" + doubleNumber,
        };

        Matcher powerInBracket = Pattern.compile("\\({1}[^(]+?\\)\\^" + doubleNumber).matcher(expression);
        Matcher isInvalid = Pattern.compile("[^-.+*/\\d|)(^E]").matcher(expression);

        while (powerInBracket.find()) {
            expression = expression.replace(powerInBracket.group(), "(" + powerInBracket.group() + ")");
        }

        calculations = new String[] {expression};

        if (isInvalid.find()) {
            return "Не корректный символ! \"" + isInvalid.group() + "\"";
        }

        if (!CalcUtils.isValid(expression)) {
            return "Выражение не коректно!";
        }

        for (int i = 0; i < str.length && !isReturn ;) {
            Matcher nextExpression = Pattern.compile(str[i]).matcher(expression);

            if (nextExpression.find()) {
                String replacement = nextExpression.group();
                expression = expression.replace(replacement, calculateOperations(replacement));
                addExpression(expression);
            }else {
                i++;
            }

            if (isReturn) {
                return "Введите правильное выражение";
            }

            int expressionLength = expression.length();
            expression = findBracketsAndModule(expression);

            if (expressionLength != expression.length()) {
                i = 0;
            }
        }

        Matcher nextExpression = Pattern.compile(doubleNumber).matcher(expression);
        boolean isValid = nextExpression.find();

        if (isValid && nextExpression.group().length() == expression.length()) {
            return expression;
        }

        return "Введите правильное выражение";
    }

    /**
     * Метод вычисления конкретной операции
     * @param mathExpression конкретное математическое выражение
     * @return результат выражения
     */
     private String calculateOperations(String mathExpression) {
         double a = 0;
         double b = 0;
         for(int i = 1; i < mathExpression.length() -1; i++) {

            if (CalcUtils.isSign(mathExpression.charAt(i))) {
                a = Double.parseDouble(mathExpression.substring(0, i));
                b = Double.parseDouble(mathExpression.substring(i + 1));

                switch (mathExpression.charAt(i)) {

                    case '^':
                        return "" + calculator.pow(a, (long) b);

                    case '/':
                        if (b == 0) {
                            isReturn = true;
                            return  "Обнаружено деление на 0!";
                        }
                        return "" + calculator.divide(a, b);

                    case '*':
                        return "" + calculator.multiply(a, b);

                    case '+':
                        return "" + calculator.add(a, b);

                    case '-':
                        return "" + calculator.subtract(a, b);

                }
            }
        }

        return "Выражение не имеет решения!";
    }

    /**
     * Метод поиска числа в скобках или модуль числа
     * @param expression - всё выражение для поиска
     * @return выражение с раскрытыми скобками или с вычисленным модулем
     */
    private String findBracketsAndModule(String expression) {
        Matcher module = Pattern.compile("[|]-?\\d+\\.?\\d*(E-?\\d+)?[|]").matcher(expression);

        if (module.find()) {
            String replacement = module.group();
            expression = expression.replace(replacement, removeBracketsAndModule(replacement));
            addExpression(expression);
        }

        Matcher brackets = Pattern.compile("\\(-?\\d+\\.?\\d*(E-?\\d+)?\\)").matcher(expression);

        if (brackets.find()) {
            String replacement = brackets.group();
            expression = expression.replace(replacement, removeBracketsAndModule(replacement));
            addExpression(expression);
        }
        return expression;
    }

    /**
     * Метод раскрытия скобок или вычисления модуля числа
     * @param replacement - выражение для раскрытия скобок или вычисления модуля числа
     * @return результат раскрытия скобок или вычисления модуля числа
     */
    private String removeBracketsAndModule(String replacement) {

        if (replacement.startsWith("(")) {
            return replacement.substring(1, replacement.length() - 1);
        }else {
            return "" + Math.abs(Double.parseDouble(replacement.substring(1, replacement.length() - 1)));
        }
    }

    /**
     * Метод добавления операции в базу
     * @param expression - выражение для добавления
     */
    private void addExpression(String expression) {
        String[] newCalculations = new String[calculations.length + 1];

        for (int i = 0; i < calculations.length; i++) {
            newCalculations[i] = calculations[i];
        }

        newCalculations[newCalculations.length - 1] = expression;
        calculations = newCalculations;
    }
}
