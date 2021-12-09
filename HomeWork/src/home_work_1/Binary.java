package home_work_1;

/*
7.** Создать СТАТИЧЕСКИЙ метод String toBinaryString(byte number) и возвращает двоичное представление числа. В методе можно использовать только обычную математику которая описана в теории. Если число отрицательное то вернуть дополнительный код. Теория https://planetcalc.ru/747. Пример:
7.1 Вводим: 42.  Возвращает: 00101010
7.2 Вводим: 15.  Возвращает: 00001111
7.3 Вводим: -42. Возвращает: 11010110
7.4 Вводим: -15. Возвращает: 11110001
*/

public class Binary {

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



    public static String toBinaryString(byte number) {
        //Если число отрицательное, то устанавливаем  isMinus и меняем знак (-1 бит)
        boolean isMinus = number < 0;
        if(isMinus) {
            number = (byte) (++number * -1);
        }

        //собираем строку
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < 8; i++) {
            result.insert(0, !isMinus ? number % 2 : 1 - number % 2);
            number /= 2;
        }

        return result.toString();
    }
}
