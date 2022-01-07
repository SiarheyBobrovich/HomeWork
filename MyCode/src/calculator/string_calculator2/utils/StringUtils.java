package calculator.string_calculator2.utils;

public class StringUtils {


    /**
     * Проветяет строку на наличие только цифр
     * @param str проверяемая строка
     * @return true - если в строке только цифры, в противном случаем false
     */
    public static boolean isDigOnly(String str) {
        for (int i = 0; i < str.length(); i++) {
            if(Character.isDigit(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }


    /**
     * Проветяет строку на наличие не цифровых символов
     * @param str проверяемая строка
     * @return true - если в строке найден сивол, в противном случае false
     */
    public static boolean existNonDigitChars(String str) {
        return  !isDigOnly(str);
    }

    /**
     * Проветяет строку на наличие символа "." и цифр
     * @param str проверяемая строка
     * @return true - если в строке есть цифры и  ".", в противном случае false
     */
    public static boolean existOnlyDoubleChars(String str) {
        int coutnDot = 0;
        for (int i = 0; i < str.length(); i++) {
            char symbol = str.charAt(i);
            if(!Character.isDigit(symbol)) {
                if (symbol == '.' && coutnDot == 0) {
                    coutnDot++;
                }else {
                    return false;
                }
            }
        }
        return coutnDot == 1;
    }
}
