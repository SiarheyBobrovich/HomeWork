package home_work_3.calcs.api;

/*
    8.  Создать интерфейс ICalculator. Данный интерфейс создайте в пакете calcs.api.
        Можете прогуглить слово API, оно очень универсально. Такие пакеты обычно содержат интерфейсы,
        перечисления и в некоторых случаях абстрактные классы.
        8.1 В данном интерфейсе должны быть объявлены методы:
            8.1.1 4 базовых математических метода (деление, умножение, вычитание, сложение).
            8.1.2 3 метода (Возведение в целую степень дробного положительного числа, Модуль числа, Корень из числа).
        8.2 На данный момент данный интерфейс вы должны прописать во всех классах
            калькуляторов созданныхнами в пакетах calcs.simple

        Данный интерфейс позволит использовать композицию так чтобы это всё-таки было удобно.
 */

public interface ICalculator {
//
//    ICalculator getCalculator();
//    void memory();
//    double getMemory();
//    long getCountOperation();

    /**
     * Method a + b
     * @param a - first term
     * @param b - second term
     * @return result
     */
    double add(double a, double b);

    /**
     * Method a - b
     * @param a - number
     * @param b - subtracted
     * @return result
     */
    double subtract(double a, double b);

    /**
     * Method a * b
     * @param a - first multiply
     * @param b - second multiply
     * @return result
     */
    double multiply(double a, double b);

    /**
     * Method a / b
     * @param a - number
     * @param b - denominator
     * @return result
     */
    double divide(double a, double b);

    /**
     * Method a ^ b
     * @param a (double) - number
     * @param b - the exponent
     * @return result
     */
    double pow(double a, long b);

    /**
     * Method √a
     * @param a - value
     * @return
    the positive square root of a
     */
    double sqrt(double a);

    /**
     * Method |a|
     * @param a - value
     * @return only positive result
     */
    double abs(double a);
}
