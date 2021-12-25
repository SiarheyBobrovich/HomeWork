package home_work_3.calcs.additional;

/*
6. Создать класс CalculatorWithCounterAutoSuper.
	6.1 Все методы и поля объявленные в данном классе НЕ статические (не имеют модификатор static).
	6.2 Данный класс наследует класс CalculatorWithMathExtends.
	6.3 Данный класс переопределяет все методы полученные в результате наследования и в этих методах
            должен быть реализован механизм учёта их использования (учёт общий для всех методов класса),
            а вместо реализации математики при помощи ключевого слова super вызывает данный метод у родителя.
            Например вызвали метод plus(7, 3) который должен сложить два числа и вернуть результат сложения.
            Внутри метода plus() пишем реализацию учета, а после делаем вызов super.plus(7, 3).
            Использование super позволит вызвать реализацию из родительского класса.
	6.4 В классе должен быть метод long getCountOperation() который должен возвращать количество использований данного калькулятора.
	        При вызове данного метода счётчик учёта не увеличивается.
 */

import home_work_3.calcs.simple.CalculatorWithMathExtends;

public class CalculatorWithCounterAutoSuper extends CalculatorWithMathExtends {

    private long countOperation;

    public void incrementCountOperation(){
        countOperation++;
    }

    public long getCountOperation() {
        return countOperation;
    }


    @Override
    public double abs(double a) {
        incrementCountOperation();
        return super.abs(a);
    }

    @Override
    public double sqrt(double a) {
        incrementCountOperation();
        return super.sqrt(a);
    }

    @Override
    public double pow(double a, long b) {
        incrementCountOperation();
        return super.pow(a, b);
    }

    @Override
    public double add(double a, double b) {
        incrementCountOperation();
        return super.add(a, b);
    }

    @Override
    public double subtract(double a, double b) {
        incrementCountOperation();
        return super.subtract(a, b);
    }

    @Override
    public double multiply(double a, double b) {
        incrementCountOperation();
        return super.multiply(a, b);
    }

    @Override
    public double divide(double a, double b) {
        incrementCountOperation();
        return super.divide(a, b);
    }
}
