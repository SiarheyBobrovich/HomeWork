package home_work_4.test;

import home_work_4.dbo.DataContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

class DataContainerTest {

    DataContainer<Integer> container;

    @Test
    void add1() {
        container = new DataContainer<>(new Integer[]{1, 2, 3, null, null, null});
        Assertions.assertEquals(3, container.add(777));
        Assertions.assertEquals(-1, container.add(null));
    }

    @Test
    void add2() {
        container = new DataContainer<>(new Integer[]{1, null, 3, null, null, null});
        Assertions.assertEquals(1, container.add(777));
    }
    @Test
    void add3() {
        container = new DataContainer<>(new Integer[0]);
        Assertions.assertEquals(0, container.add(777));
    }

    @Test
    void add4() {
        container = new DataContainer<>(new Integer[]{1, 2, 3});
        Assertions.assertEquals(3, container.add(777));
    }

    @Test
    void get1() {
        container = new DataContainer<>(new Integer[]{});
        int i = container.add(9999);
        Assertions.assertNull(container.get(1));
    }

    @Test
    void get2() {
        container = new DataContainer<>(new Integer[]{});
        int i = container.add(9999);
        Assertions.assertEquals(9999, container.get(i));
    }

    @Test
    void getItems() {
        Integer[] ints = new Integer[2];
        container = new DataContainer<>(ints);
        Assertions.assertArrayEquals(ints, container.getItems());
    }

    @Test
    void delete1() {
        container = new DataContainer<>(new Integer[]{1, 2, 3, 777});
        Assertions.assertTrue(container.delete(3));
    }

    @Test
    void delete2() {
        container = new DataContainer<>(new Integer[]{1, 2, 3, 777});
        Assertions.assertFalse(container.delete(9));
    }

    @Test
    void delete3() {
        container = new DataContainer<>(new Integer[]{1, 2, 3, 777});
        Assertions.assertTrue(container.delete(2));
        Assertions.assertArrayEquals(new Integer[]{1, 2, 777}, container.getItems());
    }

    @Test
    void deleteItem1() {
        container = new DataContainer<>(new Integer[]{1, 2, 3, 777});
        Assertions.assertTrue(container.deleteItem(777));
        Assertions.assertArrayEquals(new Integer[]{1, 2, 3}, container.getItems());
    }

    @Test
    void deleteItem2() {
        container = new DataContainer<>(new Integer[]{1, 2, 3, 777});
        Assertions.assertFalse(container.deleteItem(111));
        Assertions.assertArrayEquals(new Integer[]{1, 2, 3, 777}, container.getItems());
    }

    @Test
    void deleteItem3() {
        container = new DataContainer<>(new Integer[]{1, 2, 3, 777, 3});
        Assertions.assertTrue(container.deleteItem(3));
        Assertions.assertArrayEquals(new Integer[]{1, 2, 777, 3}, container.getItems());
    }

    @Test
    void sort() {
        container = new DataContainer<>(new Integer[]{1, 7, 2, 3, 777, 3});
        container.sort((o1, o2) -> {
            if (o1 < o2) return 1;
            return o1.equals(o2) ? 0 : -1;
        });
        Assertions.assertArrayEquals(new Integer[]{777, 7, 3, 3, 2, 1}, container.getItems());
    }

    @Test
    void sort2() {
        container = new DataContainer<>(new Integer[]{1, 7, 2, 3, 777, 3});
        container.sort(((o1, o2) -> o1 > o2 ? 1 : o1 == o2 ? 0 : -1));
        Assertions.assertArrayEquals(new Integer[]{1, 2, 3, 3, 7, 777}, container.getItems());
        Assertions.assertEquals("1, 2, 3, 3, 7, 777", container.toString());
    }

    @Test
    void sort3() {
        DataContainer<String> newContainer = new DataContainer<>(
                new String[]{"1.0", "7.0", "2.0", "3.0", "777.0", "3.0"});
        DataContainer.sort(newContainer);
        Assertions.assertArrayEquals(new String[]{"1.0", "2.0", "3.0", "3.0", "7.0", "777.0"}, newContainer.getItems());

    }

    @Test
    void iterable() {
        container = new DataContainer<>(new Integer[]{1, 7, 2, 3, 777, 3});
        Iterator<Integer> iterator = container.iterator();

        while (iterator.hasNext()) {
            for (int i = 0; i < container.getSize(); i++) {
                Assertions.assertEquals(container.get(i), iterator.next());
            }
        }

        iterator = container.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }

        Assertions.assertEquals(0, container.getSize());
    }
}