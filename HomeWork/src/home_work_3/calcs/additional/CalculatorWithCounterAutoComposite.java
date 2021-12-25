package home_work_3.calcs.additional;

/*
    7. Создать класс CalculatorWithCounterAutoComposite.
	7.0 Изучить композицию и делегирование:
		7.0.0 https://forum.itvdn.com/t/urok-2-svyazi-otnoshenij-mezhdu-klassami/3314
		7.0.1 https://dou.ua/lenta/articles/composition-vs-inheritance-in-java/
		7.0.2 https://javadevblog.com/chto-takoe-kompozitsiya-primer-kompozitsii-v-java.html
		7.0.3 https://habr.com/ru/post/354046/
		7.0.4 https://ru.stackoverflow.com/questions/229054/%D0%A0%D0%B0%D0%B7%D0%BD%D0%B8%D1%86%D0%B0-%D0%BC%D0%B5%D0%B6%D0%B4%D1%83-%D0%B4%D0%B5%D0%BB%D0%B5%D0%B3%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5%D0%BC-%D0%B8-%D0%BA%D0%BE%D0%BC%D0%BF%D0%BE%D0%B7%D0%B8%D1%86%D0%B8%D0%B5%D0%B9
	7.1 Внутри класса нельзя создавать объекты (использовать new),
	    можно пользоваться только тем что передал вам другой программист при использовании вашего класса в конструктор.
	7.2 Все методы объявленные в данном классе НЕ статические (не имеют модификатор static).
	7.3 В данном классе должны быть следующие варианты конструктора:
		7.3.1 Принимающий объект типа CalculatorWithOperator
		7.3.2 Принимающий объект типа CalculatorWithMathCopy
		7.3.3 Принимающий объект типа CalculatorWithMathExtends
	7.4 Данный класс напрямую не умеет считать математику, он умеет делегировать расчёт математики другим калькуляторам переданным в конструктор
	7.5 В классе должны присутствовать математические методы:
		7.5.1 4 базовых математических метода (деление, умножение, вычитание, сложение).
		7.5.2 3 метода (Возведение в целую степень дробного положительного числа, Модуль числа, Корень из числа).
	7.6 В классе должен быть метод long getCountOperation() который должен возвращать количество использований данного калькулятора.
	    При вызове данного метода счётчик учёта не увеличивается.
*/

import home_work_3.calcs.simple.CalculatorWithMathCopy;
import home_work_3.calcs.simple.CalculatorWithMathExtends;
import home_work_3.calcs.simple.CalculatorWithOperator;

public class CalculatorWithCounterAutoComposite {

    private long countOperation;

    private CalculatorWithOperator calculatorWithOperator;
    private CalculatorWithMathCopy calculatorWithMathCopy;
    private CalculatorWithMathExtends calculatorWithMathExtends;

    public CalculatorWithCounterAutoComposite(CalculatorWithOperator operator) {
        this.calculatorWithOperator = operator;
    }

    public CalculatorWithCounterAutoComposite(CalculatorWithMathExtends calculatorWithMathExtends) {
        this.calculatorWithMathExtends = calculatorWithMathExtends;
    }

    public CalculatorWithCounterAutoComposite(CalculatorWithMathCopy calculatorWithMathCopy) {
        this.calculatorWithMathCopy = calculatorWithMathCopy;
    }

    void incrementCountOperation(){
        countOperation++;
    }

    public long getCountOperation() {
        return countOperation;
    }

    public double abs(double a) {
        incrementCountOperation();

        if (calculatorWithOperator != null) {
            return calculatorWithOperator.abs(a);
        }else if (calculatorWithMathCopy != null) {
            return calculatorWithMathCopy.abs(a);
        }

        return calculatorWithMathExtends.abs(a);
    }

    public double sqrt(double a) {
        incrementCountOperation();

        if (calculatorWithOperator != null) {
            return calculatorWithOperator.sqrt(a);
        }else if (calculatorWithMathCopy != null) {
            return calculatorWithMathCopy.sqrt(a);
        }

        return calculatorWithMathExtends.sqrt(a);
    }

    public double pow(double a, long b) {
        incrementCountOperation();
        if (calculatorWithOperator != null) {
            return calculatorWithOperator.pow(a, b);
        }else if (calculatorWithMathCopy != null) {
            return calculatorWithMathCopy.pow(a, b);
        }

        return calculatorWithMathExtends.pow(a, b);
    }

    public double add(double a, double b) {
        incrementCountOperation();

        if (calculatorWithOperator != null) {
            return calculatorWithOperator.add(a, b);
        }else if (calculatorWithMathCopy != null) {
            return calculatorWithMathCopy.add(a, b);
        }

        return calculatorWithMathExtends.add(a, b);
    }

    public double subtract(double a, double b) {
        incrementCountOperation();

        if (calculatorWithOperator != null) {
            return calculatorWithOperator.subtract(a, b);
        }else if (calculatorWithMathCopy != null) {
            return calculatorWithMathCopy.subtract(a, b);
        }

        return calculatorWithMathExtends.subtract(a, b);
    }

    public double multiply(double a, double b) {
        incrementCountOperation();

        if (calculatorWithOperator != null) {
            return calculatorWithOperator.multiply(a, b);
        }else if (calculatorWithMathCopy != null) {
            return calculatorWithMathCopy.multiply(a, b);
        }

        return calculatorWithMathExtends.multiply(a, b);
    }

    public double divide(double a, double b) {
        incrementCountOperation();

        if (calculatorWithOperator != null) {
            return calculatorWithOperator.divide(a, b);
        }else if (calculatorWithMathCopy != null) {
            return calculatorWithMathCopy.divide(a, b);
        }

        return calculatorWithMathExtends.divide(a, b);
    }
}
