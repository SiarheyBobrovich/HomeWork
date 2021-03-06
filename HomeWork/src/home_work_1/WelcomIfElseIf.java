package home_work_1;

import java.util.Objects;
import java.util.Scanner;
/*
5.2 Разбираемся с операторами ветвления. Используя статью https://metanit.com/java/tutorial/2.9.php запросить у пользователя его имя. В данном задании у вас должно получиться 3 класса.
	Что в итоге надо сделать (общее условие):
		1. Если имя будет равно имени "Вася" тогда в консоль должно вывести сообщение "Привет!" на одной строке, а на второй "Я тебя так долго ждал".
		2. Если имя будет равно имени "Анастасия" тогда в консоль должно вывести сообщение "Я тебя так долго ждал".
		3. В случае если это будет другое имя то вывести сообщение "Добрый день, а вы кто?".
	Как это сделать:
	    5.2 Написать в отдельном классе в отдельном main код который будет выполнять общее условие при помощи if else if
	ВНИМАНИЕ! В примерах if и else if для сравнения имён использовать код вида Objects.equals("Имя1", "Имя2").
 */

public class WelcomIfElseIf {

    public static void main(String[] args) {
        String friend = "Вася";
        String girlfriend = "Анастасия";
        Scanner console = new Scanner(System.in);

        String name = console.nextLine();

        boolean isFriend = Objects.equals(name, friend);
        boolean isGirlFriend = Objects.equals(name, girlfriend);

        if (isFriend) {
            System.out.println("Привет!\nЯ тебя так долго ждал");
        }else if (isGirlFriend) {
            System.out.println("Я тебя так долго ждал");
        }else {
            System.out.println("Добрый день, а вы кто?");
        }
    }
}
