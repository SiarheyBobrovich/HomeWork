package hanoi.utils;

import java.util.Arrays;
import java.util.Iterator;

public class Container<T> implements Iterable<T> {

    private final T[] data;
    private int freePosition;

    public Container(T[] array, int size) {
        data = Arrays.copyOf(array, size);
        this.freePosition = size - 1;
    }

    public int getFreePosition() {
        return freePosition;
    }

    public T peekRing() {
        if (freePosition == data.length) {
            return null;
        }

        T item = data[freePosition + 1];

        if (item != null) {
            data[freePosition + 1] = null;
            freePosition++;
            return item;
        }

        return null;
    }

    /**
     * Возвращает объект с верхушки
     * @return объект
     */
    public T getFromTop() {
        return data[freePosition + 1];
    }

    /**
     * Положить фигуру
     * @param item сама фигура
     */
    public void pop(T item) {
        data[freePosition] = item;
        freePosition--;
    }

    /**
     * Проверяет пустая ли башня
     * @return true - если башня пустая, иначе false
     */
    public boolean isEmpty() {
        return freePosition == data.length - 1;
    }

    /**
     * Проверяет полная ли башня
     * @return true - если башня полная, иначе false
     */
    public boolean isFull() {
        return this.freePosition < 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < data.length;
            }

            @Override
            public T next() {
                return data[index++];
            }
        };
    }
}
