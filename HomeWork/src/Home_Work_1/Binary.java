package Home_Work_1;

/*
7.** Создать СТАТИЧЕСКИЙ метод String toBinaryString(byte number) и возвращает двоичное представление числа. В методе можно использовать только обычную математику которая описана в теории. Если число отрицательное то вернуть дополнительный код. Теория https://planetcalc.ru/747. Пример:
7.1 Вводим: 42.  Возвращает: 00101010
7.2 Вводим: 15.  Возвращает: 00001111
7.3 Вводим: -42. Возвращает: 11010110
7.4 Вводим: -15. Возвращает: 11110001
*/

public class Binary {
    /*
    private static boolean test = false;

    public static void main(String[] args) {

        //Tests:
        for (String arg : args) {
            test = arg.equalsIgnoreCase("test");
        }

        if(test) {
            System.out.println(toBinaryString((byte) 42).equals("00101010"));
            System.out.println(toBinaryString((byte) 15).equals("00001111"));
            System.out.println(toBinaryString((byte) -42).equals("11010110"));
            System.out.println(toBinaryString((byte) -15).equals("11110001"));
        }
    }

     */

    public static String toBinaryString(byte number) {
        boolean isMinus = false;

        //If a number's negative, isMinus'll be set to true and the number'll change sign (-1 bit)
        //Если число отрицательное, то устанавливаем  isMinus и меняем знак (-1 бит)
        if(number < 0) {
            isMinus = true;
            number *= -1;
            number--;
        }

        //count bits used
        //вычисляем к-во используемых бит(степень 2ки)
        byte power = 0;
        for(int value = number / 2; value > 0; value /= 2) {
            power++;
        }

        //Build a two's complement
        //собираем строку
        StringBuilder result = new StringBuilder();
        for(;power >= 0; power--) {
            byte value = (byte)(1 << power);

            if(number - value >= 0) {
                result.append(isMinus ? 0 : 1);
                number -= value;
            }else {
                result.append(!isMinus ? 0 : 1);
            }
        }

        while(result.length() % 8 != 0) {
            result.insert(0, isMinus ? 1 : 0);
        }

        return result.toString();
    }
}
