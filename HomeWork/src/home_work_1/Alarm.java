package home_work_1;

    /*
    4.* Создать СТАТИЧЕСКИЙ метод sleepIn рядом с методом main. (Взято с https://codingbat.com/prob/p187868).
        4.1 Данный метод будет принимает два параметра
        4.2 Будет отвечать на вопрос спать ли дальше (возвращать true либо false).
        4.3 Первый параметр boolean weekday обозначает рабочий день
        4.4 Второй параметр boolean vacation обозначает отпуск.
        4.5 Если у нас отпуск или не рабочий день то мы можем спать дальше
        4.6 На основании ответа от метода sleepIn вывести сообщение можем спать дальше или пора идти на работу
    */

public class Alarm {

    /*
    public static void main(String[] args) {
        boolean weekday = false;
        boolean vacation = false;

        if (sleepIn(weekday, vacation)) {
            System.out.println("Можем спать дальше");
        }else {
            System.out.println("Пора идти на работу");
        }
    }

     */

    static boolean sleepIn(boolean weekday, boolean vacation) {
        return vacation || !weekday;
    }
}