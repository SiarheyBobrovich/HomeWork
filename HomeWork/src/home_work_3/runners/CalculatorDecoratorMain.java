package home_work_3.runners;

/*
        11.5 Создать класс CalculatorDecoratorMain в котором будет точка входа (main метод).
             Cоздать переменную типа ICalculator записав в неё новый экземпляр класса CalculatorWithCounterAutoDecorator которому
             в конструктор был передан новый экземпляр класса CalculatorWithMemoryDecorator которому в конструтор был передан
             новый экземпляр класса CalculatorWithMathExtends. Используя созданную переменную посчитать выражения из задания 1.

        11.6 Вывести в консоль результат. Вывести количество использований калькулятора.
             Вывести последнее сохранённое значение в памяти. Поможет выполнить instanceof
 */

import home_work_3.calcs.api.ICalculator;
import home_work_3.calcs.additional.CalculatorWithCounterAutoDecorator;
import home_work_3.calcs.simple.CalculatorWithMathExtends;
import home_work_3.calcs.additional.CalculatorWithMemoryDecorator;

public class CalculatorDecoratorMain {

    public static void main(String[] args) {

        ICalculator calc =
                new CalculatorWithCounterAutoDecorator(
                    new CalculatorWithMemoryDecorator(
                        new CalculatorWithMathExtends()));

        double first = calc.divide(28, 5); //5.6
        double second = calc.pow(first, 2);   //31.36

        memory(calc);                            // сохраняем 31.36

        double third = calc.multiply(15, 7);//105

        System.out.println("Возвращаем сохранённый результат: " + getMemory(calc));
        System.out.println("Проверяем обнуление памяти : " + getMemory(calc));

        double fourth = calc.add(4.1, third);//109.1

        memory(calc);                         //memory = 109.1


        double result = calc.add(fourth, second);

        System.out.println("Колличество использованых калькуляторов: "+ getCountOperation(calc));
        System.out.println("4.1 + 15 * 7 + (28 / 5) ^ 2 = " + result);
        System.out.println("Было сохранено: " + getMemory(calc));//должно быть 109.1 ;
    }

    /**
     * Метод сохраняет значение если это возможно
     * @param calc - сам калькулятор
     */
    public static void memory(ICalculator calc) {

        if (calc instanceof CalculatorWithCounterAutoDecorator) {

            if (((CalculatorWithCounterAutoDecorator) calc).getCalculator() instanceof CalculatorWithMemoryDecorator) {

                ((CalculatorWithMemoryDecorator) ((CalculatorWithCounterAutoDecorator) calc).getCalculator()).memory();
            }
        }
    }

    /**
     * Метод возвращает сохранённые данные, если калькулятор позволяет иначе Double.NaN
     * @param calc - сам калькулятор
     * @return - сохранённые данные
     */
    public static double getMemory(ICalculator calc) {

        if (calc instanceof CalculatorWithCounterAutoDecorator) {

            if (((CalculatorWithCounterAutoDecorator) calc).getCalculator() instanceof CalculatorWithMemoryDecorator) {
                return  ((CalculatorWithMemoryDecorator) ((CalculatorWithCounterAutoDecorator) calc).getCalculator()).getMemory();
            }
        }

        return Double.NaN;
    }

    /**
     * Метод возаращает сколько раз пользовались калькулятором иначе 0
     * @param calc - сам калькулятор
     * @return количество использований
     */
    public static long getCountOperation(ICalculator calc) {

        if (calc instanceof CalculatorWithCounterAutoDecorator) {

            return ((CalculatorWithCounterAutoDecorator) calc).getCountOperation();
        }

        return 0;
    }



}
