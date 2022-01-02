package home_work_4.main;

import home_work_4.dbo.DataContainer;
import home_work_4.service.ContainerService;

public class DataContainerMain {
    public static void main(String[] args) {
        ContainerService service = new ContainerService();
        //метод int add(T item)
        System.out.println("Index возвращаемого объекта 1 = " + service.run(new Integer[]{1, 2, 3, null, null, null}, 777));
        System.out.println("Index возвращаемого объекта 2 = " + service.run(new Integer[]{1, 2, 3, null, null, null}, null));
        System.out.println("Index возвращаемого объекта 3 = " + service.run(new Integer[]{1, null, 3, null, null, null}, 777));
        System.out.println("Index возвращаемого объекта 4 = " + service.run(new Integer[]{}, 777));
        System.out.println("Index возвращаемого объекта 5 = " + service.run(new Integer[]{1, 2, 3}, 777));

        //T get(int index)
        System.out.println("Возвращаемы объект = " + service.run(new Integer[0], 0));
        System.out.println("Возвращаемы объект = " + service.run(new Integer[0], 1));

        //delete(int index)
        System.out.println("Равны ли контейнеры : " + service.run(3, new Integer[]{1, 2, 3}));
        System.out.println("Равны ли контейнеры : " + service.run(9, new Integer[]{1, 2, 3, 777}));
        System.out.println("Равны ли контейнеры : " + service.run(2, new Integer[]{1, 2, 777}));

        //delete(T item)
        System.out.println("Удаление элемента 777: " + service.run(777));
        System.out.println("Удаление элемента 111: " + service.run(111));
        System.out.println("Удаление элемента 3: " + service.run(3));
    }
}
