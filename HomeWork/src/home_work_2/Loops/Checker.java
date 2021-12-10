package home_work_2.Loops;

public class Checker {

    public static void check(String number, boolean isMinus, boolean isZero, boolean isInteger) throws IllegalArgumentException {
        double num = 0;
        try{
            num = Double.parseDouble(number);
            if (num < 0 && !isMinus) {
                throw new IllegalArgumentException("Вы ввели отрицательное число");
            }else if (num == 0 && !isZero) {
                throw new IllegalArgumentException("В данном числе присутствует 0. Результат умножения на 0 = 0");
            }else if (num % 1 != 0 && isInteger) {
                throw new IllegalArgumentException("Введено не целое число");
            }
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("Введено не число");
        }
    }
    public static long isMinus(long num) {
        if (num < 0) {
            num *= -1;
        }
        return num;
    }
}
