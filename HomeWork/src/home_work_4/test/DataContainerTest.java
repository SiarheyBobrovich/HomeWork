package home_work_4.test;

import home_work_4.dbo.DataContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataContainerTest {

    DataContainer<Integer> container;

    @Test
    void add() {
        container = new DataContainer<>(new Integer[]{1, 2, 3, null, null, null});
        Assertions.assertEquals(3, container.add(777));
        Assertions.assertEquals(-1, container.add(null));

        container = new DataContainer<>(new Integer[]{1, null, 3, null, null, null});
        Assertions.assertEquals(1, container.add(777));

        container = new DataContainer<>(new Integer[0]);
        Assertions.assertEquals(0, container.add(777));

        container = new DataContainer<>(new Integer[]{1, 2, 3});
        Assertions.assertEquals(3, container.add(777));
    }

    @Test
    void get() {
        container = new DataContainer<>(new Integer[]{});
        int i = container.add(9999);
        Assertions.assertNull(container.get(1));
        Assertions.assertEquals(9999, container.get(i));
    }

    @Test
    void getItems() {
        Integer[] ints = new Integer[2];
        container = new DataContainer<>(ints);
        Assertions.assertEquals(ints, container.getItems());
    }

    @Test
    void delete() {
        container = new DataContainer<>(new Integer[]{1, 2, 3, 777});
        Assertions.assertTrue(container.delete(3));

        container = new DataContainer<>(new Integer[]{1, 2, 3, 777});
        Assertions.assertFalse(container.delete(9));

        container = new DataContainer<>(new Integer[]{1, 2, 3, 777});
        Assertions.assertTrue(container.delete(2));
        Assertions.assertArrayEquals(new Integer[]{1, 2, 777}, container.getItems());
    }

    @Test
    void deleteItem() {
        container = new DataContainer<>(new Integer[]{1, 2, 3, 777});
        Assertions.assertTrue(container.deleteItem(777));
        Assertions.assertArrayEquals(new Integer[]{1, 2, 3}, container.getItems());

        container = new DataContainer<>(new Integer[]{1, 2, 3, 777});
        Assertions.assertFalse(container.deleteItem(111));
        Assertions.assertArrayEquals(new Integer[]{1, 2, 3, 777}, container.getItems());

        container = new DataContainer<>(new Integer[]{1, 2, 3, 777, 3});
        Assertions.assertTrue(container.deleteItem(3));
        Assertions.assertArrayEquals(new Integer[]{1, 2, 777, 3}, container.getItems());
    }
}