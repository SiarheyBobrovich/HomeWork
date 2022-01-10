package collections.dto;

/*
1. Создать класс Student с полями
	1.1 Порядковый номер (int)
	1.2 Имя (Строка размером от 3 до 10 русских символов)
	1.3 возраст (7-17)
	1.4 оценка(0.0-10.0)
	1.5 признак участия в олимпиадах (bool).
 */

public class Student {

    private int id;
    private String name;
    private byte age;
    private double point;
    private boolean isOlympic;

    public Student(int id, String name, byte age, double point, boolean isOlympic) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.point = point;
        this.isOlympic = isOlympic;
    }

    public String getName() {
        return name;
    }

    public byte getAge() {
        return age;
    }

    public double getPoint() {
        return point;
    }

    @Override
    public String toString() {
        return String.format("Студент ID: %d\n" +
                "Имя : %s. " +
                "Возраст: %d. " +
                "Оценка: %f. " +
                "Участие в олимпиадах: %s.", id, name, age, point, isOlympic ? "Да" : "Нет");
    }
}
