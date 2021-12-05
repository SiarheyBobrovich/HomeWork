package Home_Work_1;

/*
    * 2. Изучить приоритетность операторов по таблице. Сначала посчитать результаты всех ниже приведённых примеров устно,
    *       а потом проверить в IDE (в случае ошибок свериться с таблицей приоритетов, повторять просчёт примеров до полного соответствия). Результатом МОЖЕТ БЫТЬ ОШИБКА компиляции, может быть ошибка выполнения программы или корректный результат. Все значения в этих переменных должны быть записаны в int и boolean переменные. Напротив каждой строчки нужно написать комментарий с результатом и объяснением почему вы получили такой результат.
	* 2.0 ВНИМАНИЕ --8 значит что вам нужно создать переменную, например а, и проинициализировать её 8,
	*       а дальше её использовать как --а. Данная переменная во всех выражениях должна равняться 8;
	* 2.1 5 + 2 / 8
	* 2.2 (5 + 2) / 8
	* 2.3 (5 + 2++) / 8
	* 2.4 (5 + 2++) / --8
	* 2.5 (5 * 2 >> 2++) / --8
	* 2.6 (5 + 7 > 20 ? 68 : 22 * 2 >> 2++) / --8
	* 2.7 (5 + 7 > 20 ? 68 >= 68 : 22 * 2 >> 2++) / --8
	* 2.8 6 - 2 > 3 && 12 * 12 <= 119
	* 2.9 true && false
*/

public class Calculations {

    public static void main(String[] args) {
        int a = 5;
        int b = 2;
        int c = 8;

        //2.1  5 + 2 / 8
        int result1 = a + b / c;    //2 / 8 = 0; 5 + 0 = 5

        //2.2 (5 + 2) / 8
        int result2 = (a + b) / c;  //5 + 2 = 7; 7 / 8 = 0

        //2.3 (5 + 2++) / 8
        int result3 = (a + b++) / c; //5 + 2 = 7; 7 / 8 = 0; b = 3

        //2.4 (5 + 2++) / --8
        b = 2;
        int result4 = (a + b++) / --c; //5 + 2 = 7; 7 / 7 = 1; b = 3, c = 7

        //2.5 (5 * 2 >> 2++) / --8
        b = 2;
        c = 8;
        int result5 = (a * b >> b++) / --c; //5 * 2 = 10; 1010(10) >> 2 = 0010(2); 2 / 7 = 0; b = 3, c = 7

        //2.6 (5 + 7 > 20 ? 68 : 22 * 2 >> 2++) / --8
        b = 2;
        c = 8;
        int result6 = (a + 7 > 20 ? 68 : 22 * b >> b++) / --c; //5 + 7 = 12; 12 > 20 = false = 22 * 2 >> 2; 0010 1100(22 * 2 = 44) >> 2 = 1011(11); 11 / 7 = 1

        //2.7 (5 + 7 > 20 ? 68 >= 68 : 22 * 2 >> 2++) / --8
        b = 2;
        c = 8;

        //Java является строго типизированным языком программирования: Ошибка компиляции не определённое значение в тернарном операторе int или boolean
        //int result7 = (a + 7 > 20 ? 68 >= 68 : 22 * b >> b++) / --c;


        //2.8 6 - 2 > 3 && 12 * 12 <= 119
        boolean result8 = 6 - b > 3 && 12 * 12 <= 119; //6 - 2 = 4; 4 > 3 = true; 12 * 12 = 144; 144 <= 119 = false; true && false = false

        //2.9 true && false
        boolean result9 = true && false; // true && false = false
    }
}