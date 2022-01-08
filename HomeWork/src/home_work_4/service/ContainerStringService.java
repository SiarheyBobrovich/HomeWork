package home_work_4.service;

import home_work_4.dbo.DataContainer;

public class ContainerStringService {

    public void run(DataContainer<String> container) {
        int index1 = container.add("Привет");
        int index2 = container.add("Как дела");
        int index3 = container.add("Работаю");
        int index4 = container.add("Давай потом");

        String text1 = container.get(index1);
        String text2 = container.get(index2);
        String text3 = container.get(index3);
        String text4 = container.get(index4);

        System.out.println(text1); //Привет
        System.out.println(text2); //Как дела
        System.out.println(text3); //Работаю
        System.out.println(text4); //Давай потом

        container.deleteItem(text1);
        System.out.println(container.get(index1)); //Как дела

        container.sort(container);
        System.out.println(container);
    }
}
