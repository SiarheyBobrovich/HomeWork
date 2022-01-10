package calculator.string_calculator3.utils;

public class Stack {
    private char[] signsStack;

    private char[] getSignsStack() {
        return signsStack;
    }

    private void setSignsStack(char[] signsStack) {
        this.signsStack = signsStack;
    }

    /**
     * Метод добавления в стак нового элемента
     * @param value новый элемент
     */
    public void pop(char value) {
        char[] newStack;

        if (getSignsStack() == null) {
            newStack = new char[1];
        }else {
            newStack = new char[getSignsStack().length + 1];
        }

        newStack[0] = value;

        for (int i = 1; i < newStack.length; i++) {
            newStack[i] = getSignsStack()[i - 1];
        }

        setSignsStack(newStack);
    }


    /**
     * Метод возвращает  первый элемент из стака
     * @return Если стак пуст возвращает '!' иначе значение 1 элемента
     */
    public char getNextSign() {
        if (isEmptyStack()) {
            return '!';
        }

        char sign = getSignsStack()[0];

        if (getSignsStack().length == 1) {
            setSignsStack(null);
        }else {

            char[] newSign = new char[getSignsStack().length - 1];

            for (int i = 0; i < newSign.length; i++) {
                newSign[i] = getSignsStack()[i + 1];
            }

            setSignsStack(newSign);
        }

        return sign;
    }

    /**
     * Проверяет первый элемент стака на степень
     * @return результат проверки
     */
    public boolean isPow() {
        return !isEmptyStack() && getSignsStack()[0] == '^';
    }

    /**
     * Проверяет первый элемент стака на модуль
     * @return результат проверки
     */
    public boolean isAbs() {
        return !isEmptyStack() && getSignsStack()[0] == '|';
    }

    /**
     * Проверяет первый элемент стака на умножение и деление
     * @return результат проверки
     */
    public boolean isMultiplyDivideInStack() {
        return !isEmptyStack() && (getSignsStack()[0] == '*' || getSignsStack()[0] == '/');
    }

    /**
     * Проверяет первый элемент стака на плюс и минус
     * @return результат проверки
     */
    public boolean isPlusMinusInStack() {
        return !isEmptyStack() && (getSignsStack()[0] == '+' || getSignsStack()[0] == '-');
    }

    /**
     * Проверяет первый элемент стака на скобку
     * @return результат проверки
     */
    public boolean isBracketInStack () {
        return !isEmptyStack() && getSignsStack()[0] == '(';
    }

    /**
     * Проверяет стак
     * @return true если стак пустой
     */
    public boolean isEmptyStack() {
        return getSignsStack() == null;
    }

    public void remove() {
        getNextSign();
    }

    public int length() {
        return signsStack == null ? 0 : signsStack.length;
    }

    public boolean isModuleInStack() {
        return !isEmptyStack() && getSignsStack()[0] == '|';
    }
}
