package home_work_4.service;

import home_work_4.dbo.DataContainer;

import java.util.Objects;

//Класс сделан для пробы перегрузки метода run() и Generic

public class ContainerService1<T extends Integer> {

    public int run(T[] data, T added) {
        DataContainer<T> dataContainer = new DataContainer<>(data);
        return dataContainer.add(added);
    }

    public Integer run(T[]  data, int index) {
        DataContainer<Integer> dataContainer = new DataContainer<>(data);
        dataContainer.add(9999);
        return dataContainer.get(index);
    }

    public boolean run(int index, T[] equalsData) {
        DataContainer<Integer> dataContainer = new DataContainer<>( new Integer[]{1, 2, 3, 777});
        dataContainer.delete(index);

        Integer[] in = dataContainer.getItems();
        if (in.length != equalsData.length) {
            return false;
        }

        for (int i = 0; i < equalsData.length; i++) {
            if (!Objects.equals(dataContainer.get(i), equalsData[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean run(T item) {
        DataContainer<Integer> dataContainer = new DataContainer<>(new Integer[]{1, 2, 3, 777, 3});
        return dataContainer.deleteItem(item);
    }
}