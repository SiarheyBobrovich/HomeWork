package home_work_4.dbo;

/*
1. Создать класс DataContainer у которого есть один дженерик (обобщение). Например литерал T.
    Данный класс как раз и будет решать задачу поставленную перед нами:
    хранить неограниченное количество передаваемых объектов обобщённого типа.

 */

import java.util.*;

public class DataContainer<T> implements Iterable<T> {
    private T[] data;
    private int size;

    public DataContainer(T[] data) {
        this.data = data;
        this.size = data.length;
    }

    public int getSize() {
        return size;
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

        data = Arrays.copyOf(data, size + 1);
        data[size] = item;

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

        T[] newContainer = Arrays.copyOf(data, size - 1);

        if (size - (index + 1) >= 0) {
            System.arraycopy(data, index + 1, newContainer, index, size - (index + 1));
        }

        size--;
        data = newContainer;

        return true;
    }

    /**
     * Метод удаления первого найденого элемента по значению
     * @param item - значение элемента
     * @return true - если элемент был найден и удалён, иначе false
     */
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

    /**
     * Метод сортировки DataContainer по переданной реализации сортировки
     * @param comparator - реализация сортировки
     */
    public void sort(Comparator<T> comparator) {
        boolean sorted;

        do {
            sorted = true;

            for (int i = 0; i < size - 1; i++) {
                T o1 = data[i];
                T o2 = data[i + 1];

                if (comparator.compare(o1, o2) > 0) {
                    data[i + 1] = o1;
                    data[i] = o2;
                    sorted = false;
                }
            }

        } while (!sorted);
    }

    /**
     * Статический метод сортировки DataContainer в котором хранятся объекты-потомки Comparable
     * @param dataContainer объект сортировки
     */
    public static void sort(DataContainer<? extends Comparable> dataContainer) {
        boolean sorted;

        do {
            sorted = true;

            for (int i = 0; i < dataContainer.size - 1; i++) {
                if (dataContainer.data[i].compareTo(dataContainer.data[i + 1]) > 0) {
                    dataContainer.changePlaces(dataContainer.getItems(), i);
                    sorted = false;
                }
            }

        } while (!sorted);
    }

    /**
     * Метод смены позиции
     * @param data - массив в котором будем менять
     * @param index - позиция в которую будет производиться запись
     * @param <E> - класс-потомок Comparable
     */
    private <E extends Comparable> void changePlaces(E[] data, int index) {
        E buffer = data[index];
        data[index] = data[index + 1];
        data[index + 1] =  buffer;
    }

    /**
     * Переопределение метода toString() класса Object
     * @return строка из элементов DataContainer без null элементров
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < size; i++) {
            T tmp = data[i];

            if (tmp != null) {
                result.append(tmp);
                if (i != size - 1) {
                    result.append(", ");
                }
            }

        }

        return result.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {

            private int index = 0;
            private boolean isException = true;

            /**
             * Method of checks index
             * @return index's less than size
             */
            @Override
            public boolean hasNext() {
                return this.index < size;
            }

            /**
             *
             * @return <T> next item
             * @throws NoSuchElementException if index's larger than size
             */
            @Override
            public T next() throws NoSuchElementException{
                isException = false;

                if (index >= size) {
                    throw new NoSuchElementException();
                }

                return data[index++];
            }

            /**
             * Deletes last item which were returned by method next()
             * @throws IllegalStateException if method next() hasn't been called before
             */
            @Override
            public void remove() throws IllegalStateException {

                if (isException) {
                    throw new IllegalStateException();
                }

                delete(--index);
                isException = true;
            }
        };
    }

}
