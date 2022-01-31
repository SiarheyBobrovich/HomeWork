package for_presentation.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class Horse implements Runnable{

    private int number;
    private CountDownLatch count;

    public Horse(CountDownLatch count, int number) {
        this.count = count;
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Запрягаем и ведём на старт лошадь №" + number);
        System.out.println("Лошадка " + number + " готова к забегу");
        try {
            count.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Лошадка " + number + " побежала....");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Лошадка " + number + " пересекла финиш!");
    }
}
