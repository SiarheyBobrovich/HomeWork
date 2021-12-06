package home_work_1;

import java.util.Scanner;

/*
5.3 Разбираемся с операторами ветвления. Используя статью https://metanit.com/java/tutorial/2.9.php запросить у пользователя его имя. В данном задании у вас должно получиться 3 класса.
	Что в итоге надо сделать (общее условие):
		1. Если имя будет равно имени "Вася" тогда в консоль должно вывести сообщение "Привет!" на одной строке, а на второй "Я тебя так долго ждал".
		2. Если имя будет равно имени "Анастасия" тогда в консоль должно вывести сообщение "Я тебя так долго ждал".
		3. В случае если это будет другое имя то вывести сообщение "Добрый день, а вы кто?".
	Как это сделать:
		5.3 Написать в отдельном классе в отдельном main код который будет выполнять общее условие при помощи switch
 */

public class WelcomSwitch {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String name = console.nextLine();
        String welcom = "Я тебя так долго ждал";

        switch (name) {
            case "Вася" :
                System.out.println("Привет!");
                System.out.println(welcom);
                break;
            case "Анастасия" :
                System.out.println(welcom);
                break;
            default:
                System.out.println("Добрый день, а вы кто?");
        }
    }
}
