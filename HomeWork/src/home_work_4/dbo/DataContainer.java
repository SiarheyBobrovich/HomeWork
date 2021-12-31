package home_work_4.dbo;

/*
1. Создать класс DataContainer у которого есть один дженерик (обобщение). Например литерал T.
    Данный класс как раз и будет решать задачу поставленную перед нами:
    хранить неограниченное количество передаваемых объектов обобщённого типа.

 */

import java.lang.reflect.*;
import java.util.Objects;

public class DataContainer<T> {
    private T[] data;
    private int size;

    public DataContainer(T[] data) {
        this.data = data;
        this.size = data.length;
    }

    /**
     * Дабвляет элемент в последнюю не используемую ячейку или расширяет массив на 1 ячейку
     * @param item - добавляемый элемент
     * @return - индекс ячейки или -1 при добавлении null
     */
    public int add(T item) {
        if (item == null) {
            return -1;
        }

        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = item;
                return i;
            }
        }

        T[] newContainer = (T[])Array.newInstance(data.getClass().getComponentType(), data.length + 1);

        for (int i = 0; i < data.length; i++) {
            newContainer[i] = data[i];
        }

        newContainer[size] = item;
        data = newContainer;

        return this.size++;
    }

    /**
     * Метод получает из контейнера предварительно сохранённый объект.
     * @param index - индекс объекта
     * @return объект
     */
    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }

        return data[index];
    }

    /**
     * Геттер для поля data
     * @return data
     */
    public T[] getItems() {
        return this.data;
    }

    /**
     * Метод удаления элемента по индексу
     * @param index - индекс элемента
     * @return true - если элемент удалён, иначе false
     */
    public boolean delete(int index) {
        if (index >= size || index < 0) {
            return false;
        }

        T[] newContainer = (T[])Array.newInstance(data.getClass().getComponentType(), size - 1);
        for (int i = 0, j = 0; i < size; i++) {
            if (i != index) {
                newContainer[j] = data[i];
                j++;
            }
        }

        size--;
        data = newContainer;

        return true;
    }

    public boolean deleteItem(T item) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(data[i], item)) {
                index = i;
                break;
            }
        }

        return index != -1 && delete(index);
    }
}
