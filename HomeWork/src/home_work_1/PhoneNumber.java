package home_work_1;

/*
    * 6. Создать СТАТИЧЕСКИЙ метод createPhoneNumber рядом с методом main,
    * данный метод будет принимает один параметр и будет возвращать строку в отформатированном виде.
    * В метод будет передаваться массив из 10 цифр (от 0 до 9).
    * Данные цифры должны быть помещены в строку формата: (XXX) XXX-XXXX. Например передан массив: {1,2,3,4,5,6,7,8,9,0},
    * возвращаемый результат: (123) 456-7890. (Взято с https://www.codewars.com/kata/525f50e3b73515a6db000b83/train/java).
    * В задании нельзя использовать колекции, стрима.
*/
public class PhoneNumber {
/*
    public static void main(String[] args) {

        System.out.println(createPhoneNumber(new int[] {1,2,3,4,5,6,7,8,9,0}));

        try {
            System.out.println(createPhoneNumber(null));
        }catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        try {
            System.out.println(createPhoneNumber(new int[] {-1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
        }catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

 */

    static String createPhoneNumber(int[] intArray) throws IllegalArgumentException {
        if(intArray == null || intArray.length != 10) {
            throw new IllegalArgumentException("Проверьте длину массива");
        }

        for (int i : intArray) {
            if (i < 0) {
                throw new IllegalArgumentException("В номере телефона должны содержаться только положительные числа");
            }
        }

        return String.format("(%d%d%d) %d%d%d-%d%d%d%d", intArray[0], intArray[1], intArray[2], intArray[3], intArray[4],
                                                         intArray[5], intArray[6], intArray[7], intArray[8], intArray[9]);
    }
}
