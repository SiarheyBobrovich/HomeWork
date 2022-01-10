package collections.service;

import collections.dto.Student;

import java.util.*;
import java.util.stream.Collectors;

public class StudentService {

    public void run() {

        List<Student> students = new ArrayList<>();

        for (int i = 1; i < 10_0; i++) {
            students.add(getStudent(i));
        }

        //3. Отфильтровать студентов по нескольким признакам. По возрасту (тем кому 12 и выше), по оценке (выше 8).
        //    Отфильтрованных студентов поместить в отдельный список. Старый список дожен остаться неизменным.
        List<Student> sortedAgeAndPointStudents = students.stream().filter(x -> x.getAge() >= 12 && x.getPoint() > 8).collect(Collectors.toList());

        List<Student> sortedAgeStudents = new ArrayList<>();
        List<Student> sortedPointStudents = new ArrayList<>();

        Spliterator<Student> spliterator = students.spliterator();
        spliterator.forEachRemaining(item -> {
            if (item.getAge() > 11) {
                sortedAgeStudents.add(item);
            }
            if (item.getPoint() > 8) {
                sortedPointStudents.add(item);
            }
        });

        //4. Вывести средний возраст отфильтрованных студентов
        System.out.println("Средний возраст sortedAgeAndPointStudents: " + getAverageAge(sortedAgeAndPointStudents));
        System.out.println("Средний возраст sortedAgeStudents: " + getAverageAge(sortedAgeStudents));
        System.out.println("Средний возраст sortedPointStudents: " + getAverageAge(sortedPointStudents));

        //5. Отсортировать отфильтрованных студентов по имени, от меньшему к большему. Выести топ 10
        Comparator<Student> sortByName = Comparator.comparing(Student::getName);

        print("Топ 10 по имени для sortedAgeStudents", sortedAgeStudents, sortByName);
        print("Топ 10 по имени для sortedPointStudents", sortedPointStudents, sortByName);
        print("Топ 10 по имени для sortedAgeAndPointStudents", sortedAgeAndPointStudents, sortByName);

        //6. Отсортировать отфильтрованных студентов по оценке, от большего к меньшему. Выести топ 10
        Comparator<Student> sortByPoint = ((o1, o2) -> Double.compare(o2.getPoint(), o1.getPoint()));

        print("Топ 10 по оценке для sortedAgeStudents", sortedAgeStudents, sortByPoint);
        print("Топ 10 по оценке для sortedPointStudents", sortedPointStudents, sortByPoint);
        print("Топ 10 по оценке для sortedAgeAndPointStudents", sortedAgeAndPointStudents, sortByPoint);


        //7. Отсортировать отфильтрованных студентов по возрасту и оценке одновременно.
        //      Вывести топ 10 в каждом возрасте

        Comparator<Student> sortByNamePoint = ((o1, o2) -> {
            int result = Byte.compare(o2.getAge(), o1.getAge());
            if (result == 0) {
                result = Double.compare(o2.getPoint(), o1.getPoint());
            }

            return result;
        });

        print("Топ 10 по имени и оценке для sortedAgeStudents", sortedAgeStudents, sortByNamePoint);
        print("Топ 10 по имени и оценке для sortedPointStudents", sortedPointStudents, sortByNamePoint);
        print("Топ 10 по имени и оценке для sortedAgeAndPointStudents", sortedAgeAndPointStudents, sortByNamePoint);

    }

    public void print(String message, List<Student> students, Comparator  comparator) {
        System.out.println("\n" + message);
        students.sort(comparator);

        for (int i = 0; i < students.size() && i < 11; i++) {
            Student student = students.get(i);
            System.out.println(student);
        }
    }
    /**
     * Метод подсчета среднего возраста студентов из переданного списка
     * @param students список студентов
     * @return средний возраст
     */
    public double getAverageAge(List<Student> students) {
        double result = 0;

        for (Student student : students) {
            result += student.getAge();
        }

        return result / students.size();
    }

    /**
     * Метод получения студента со случайными параметрами
     * @param index - id студента
     * @return new Student(случайные параметры)
     */
    public Student getStudent(int index) {
        Random rnd = new Random();

        int id = index;
        String name = getRandomName(rnd);
        byte age = (byte) (rnd.nextInt(8) + 10);
        double point = rnd.nextDouble() * 10;
        boolean isOlympic = rnd.nextBoolean();

        return new Student(id, name, age, point, isOlympic);
    }

    /**
     * Метод получения случайного имени
     * @param random генератор индекса
     * @return Случайное русское имя
     */
    public String getRandomName(Random random) {

        String[] names = {"Авдей", "Авксентий", "Агапит", "Агафон", "Акакий", "Александр", "Алексей", "Альберт",
                "Альвиан", "Анатолий", "Андрей", "Аникита", "Антон", "Антонин", "Анфим", "Аристарх", "Аркадий",
                "Арсений", "Артём", "Артемий", "Артур", "Архипп", "Афанасий", "Богдан", "Бор", "Вавила",
                "Вадим", "Валентин", "Валерий", "Валерьян", "Варлам", "Варсонофий", "Варфоломей", "Василий",
                "Венедикт", "Вениамин", "Викентий", "Виктор ", "Виссарион", "Виталий", "Владимир", "Владислав",
                "Владлен", "Влас", "Всеволод", "Вячеслав", "Гавриил", "Галактион", "Геласий", "Геннадий", "Георгий",
                "Герасим", "Герман", "Германн", "Глеб", "Гордей", "Григорий", "Данакт", "Даниил", "Демид", "Демьян",
                "Денис", "Дмитрий", "Добрыня", "Донат", "Дорофей", "Евгений", "Евграф", "Евдоким", "Евсей", "Евстафий",
                "Егор", "Емельян", "Еремей", "Ермолай", "Ерофей", "Ефим", "Ефрем", "Ждан", "Зиновий", "Иакинф", "Иван",
                "Игнатий", "Игорь", "Изот", "Илья", "Иннокентий", "Ираклий", "Ириней", "Исидор", "Иуда", "Иулиан",
                "Капитон", "Ким", "Кир", "Кирилл", "Климент", "Кондрат", "Константин", "Корнилий", "Кузьма", "Куприян",
                "Лаврентий", "Лев", "Леонид", "Леонтий", "Логгин", "Лука", "Лукий", "Лукьян", "Магистриан", "Макар",
                "Мамонт", "Марк", "Мартын", "Матвей", "Мелентий", "Мина", "Мирон", "Мирослав", "Митрофан", "Михаил",
                "Мстислав", "Назар", "Нестор", "Никандр", "Никанор", "Никита", "Никифор", "Никодим", "Николай", "Никон",
                "Олег", "Онисим", "Онуфрий", "Павел", "Паисий", "Панкратий", "Парфений", "Пафнутий",
                "Пахомий", "Пётр", "Платон", "Поликарп", "Порфирий", "Потап", "Пров", "Прокопий", "Протасий", "Прохор",
                "Разумник", "Родион", "Родослав", "Роман", "Ростислав", "Руслан", "Савва", "Савелий", "Самуил",
                "Святополк", "Святослав", "Севастьян", "Семён", "Серафим", "Сергей", "Сила", "Сильвестр", "Созон",
                "Софрон", "Спиридон", "Станислав", "Степан", "Тарас", "Тимофей", "Тимур", "Тит", "Тихон", "Трифон",
                "Трофим", "Урбан", "Фаддей", "Фёдор", "Федосей", "Федот", "Феликс", "Феоктист", "Филат", "Филимон",
                "Филипп", "Фирс", "Фока", "Фома", "Фотий", "Фрол", "Харитон", "Хрисанф", "Христофор"};


        return names[random.nextInt(names.length - 1)];
    }
}
