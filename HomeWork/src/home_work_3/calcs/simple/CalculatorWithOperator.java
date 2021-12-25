package home_work_3.calcs.simple;

/*
    2. Создать класс CalculatorWithOperator.

        2.1 Все методы объявленные в данном классе НЕ статические (не имеют модификатор static).

        2.2 В классе должны присутствовать математические методы:

            2.2.1 4 базовых математических метода (деление, умножение, вычитание, сложение) каждый из этих методов
        должен принимать два параметра (определитесь с их типами) и должны возвращать результат
        (определиться с возвращаемым типом результата) при помощи ключевого слово return.

            2.2.2 3 метода (Возведение в целую степень дробного положительного числа, Модуль числа, Квадратный корень из числа).

        2.3 В методах можно использовать любые арифметические операторы.

        2.4 Использование библиотеки Math ЗАПРЕЩЕНО! (кроме извлечения корня).
            Если у Вас плохо с математикой, то для реализации метода "Квадратный корень из числа" можно воспользоваться библиотекой Math.
 */

import home_work_3.calcs.api.ICalculator;

public class CalculatorWithOperator implements ICalculator {

    /**
     * Метод сложения двух чисел
     * @param a - первое слагаемое
     * @param b - второе слагаемое
     * @return результат выражения a + b
     */
    public double add(double a, double b) {
        return a + b;
    }

    /**
     * Метод вычитания одного числа из другого
     * @param a - Уменьшаемый аргумент
     * @param b - вычитаемый аргумент
     * @return результат выражения a - b
     */
    public double subtract(double a, double b) {
        return a - b;
    }

    /**
     * Метод умножения двух чисел
     * @param a - первый множитель
     * @param b - второй множитель
     * @return результат выражения a * b
     */
    public double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Метод деления первого числа на второе
     * @param a - делимое (числитель)
     * @param b - делитель (знаменатель)
     * @return результат выражения a / b
     */
    public double divide(double a, double b) {
        return a / b;
    }

    /**
     * Метод извлечениея квадратного корня
     * @param a - число
     * @return квадратный корень числа a, если число отрицательное или ноль, возвращает Double.NAN
     */
    //0.125
    public double sqrt(double a) {

        if ( a <= 0) {
            return Double.NaN;
        }else if (a < 1.0) {
            return countFractionalPart(0, a);
        }else if (a == 1.0) {
            return a;
        }
        double result = countIntPart(a);

        return result + countFractionalPart(result,a - pow(result, 2));

        //return countIntPart(a);
    }


    /**
     * Метод вычисления корня из целой части
     * @param number - число
     * @return корень из целой части
     */
    private double countIntPart(double number) {
        double numberTmp = number;  //сохраняем число
        int pow = 0;                //считаем степень

        while (numberTmp > 1) {
            numberTmp /= 10;
            pow++;
        }
        pow -= pow % 2 == 0 ? 2 : 1;    // для чётной степени чисел забираем 2 нуля, для нечётных 1.
                                        // т.к там нужно чётное количество цифр слева.
                                        // Число уменьшается на 10^2 за проход до запятой

        double result = 0.0;

            while (pow >= 0) {                      //пока степень положительная

            for (int i = 0; ; i++) {
                int j = i + 1;                      //введено для удобства условия в строках 89 - 93

                if ((result * 2 + j) * j * pow(10, pow) > number || i == 9) {  //если true, тогда i является множителем

                    number -= (result * 2 + i) * i * pow(10, pow);  // отнимаем от числа самое близкое число в квадрате
                    pow -= 2;                                           //убираем из числа 2 нуля
                    result = (result + i) * (pow >= 0 ? 10 : 1);        //записываем результат. Если будем продолжать, оставляем 0 в конце для цифры
                    break;
                }

            }
        }

        return result;
    }

    /**
     * Метод считает дробную часть числа
     * @param intPart - целая часть числа
     * @param fractionalPart - остаток от вычисления корня целой части
     * @return возвращает результат в виде корня из числа
     */
    private double countFractionalPart(double intPart, double fractionalPart) {

        double tmpIntPart = intPart;
        double result = 0.0;
        double tmp = 1.0;      //хранит запятую

        for (int j = 0; j < 17 && fractionalPart != 0; j++) {

            fractionalPart *= 100;//считаем дробную часть
            tmpIntPart *= 10;
            tmp *= 10;

            for (int i = 0;; i++) {
                double power = (tmpIntPart * 2 + i + 1) * (i + 1);

                if (power > fractionalPart || i == 9) {

                    fractionalPart -= (tmpIntPart * 2 + i) * i ;
                    tmpIntPart += i;
                    result += i / tmp;
                    break;
                }
            }
        }

        return result;
    }

    /**
     * Метод возведение в целую степень дробного положительного числа
     * @param a - возводимое число(дробное число)
     * @param b - степень(целое число)
     * @return число равное a в степени b (a^b)
     */
    public double pow(double a, long b) {
        if(b == 0) {
            return 1;
        }

        boolean isMinus = b < 0;
        double result = a;

        if (isMinus) {
            b *= -1;
            result = 1 / result;
        }

        for (long i = 1; i < b; i++) {
            result = !isMinus ? result * a : result / a;
        }

        return result;
    }

    /**
     * Метод вычисления модуля числа
     * @param a - число
     * @return модуль числа(всегда положительное число)
     */
    public double abs(double a) {
        return a >= 0 ? a : 0.0 - a;
    }
}
