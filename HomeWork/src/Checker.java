package home_work_2.Loops;

public class Checker {

    public static double check(String number, boolean isMinus, boolean isZero, boolean isInteger) throws IllegalArgumentException {
        double num = 0;
        try{
            num = Double.parseDouble(number);
            if(num < 0 && !isMinus) {
                throw new IllegalArgumentException("Вы ввели отрицательное число: \"" + number +"\"");

            }else if(num == 0 && !isZero) {
                throw new IllegalArgumentException("Вы ввели: \"" + number +"\"");
            }else if(num % 1 != 0 && isInteger) {
                throw new IllegalArgumentException("Введено не целое число: \"" + number +"\"");
            }
        }catch(NumberFormatException e) {
            throw new IllegalArgumentException("Введено не число: \"" + number +"\"");
        }
        return num;
    }
}
