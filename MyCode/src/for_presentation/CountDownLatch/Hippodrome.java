package for_presentation.CountDownLatch;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hippodrome {
    public static void main(String[] args) {

        AtomicInteger number = new AtomicInteger(1);
        //Создаём объект CountDownLatch
        CountDownLatch count = new CountDownLatch(5);

        //Создаём лошадей
        List<Thread> horses = Stream.generate(() ->
                     new Thread(new Horse(count, number.getAndIncrement())))
                .limit(5)
                .collect(Collectors.toList());

        //Запускаем всех лошадей
        for (Thread horse : horses) {
            horse.start();
        }

        //Все лошади готовы и стоят у защёлки
        for (int i = 5; i > 0; i--) {
            //Отсчитываем 5 защёлок
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            count.countDown();
            System.out.println("До старта: " + count.getCount());
        }
    }
}
