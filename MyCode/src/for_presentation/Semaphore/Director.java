package for_presentation.Semaphore;

import java.util.concurrent.Semaphore;

public class Director {
    public static void main(String[] args) {
        Semaphore secretary = new Semaphore(1); // 1 разрешение

        new Thread(new Jobber("Антон", secretary)).start();
        new Thread(new Jobber("Илья", secretary)).start();
        new Thread(new Jobber("Евгений", secretary)).start();
    }
}

class Jobber implements Runnable {
    private Semaphore sem;
    private String name;

    Jobber(String name, Semaphore sem) {
        this.sem = sem;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " ожидает разрешение войти");
            sem.acquire();

            for (int i = 0; i < 2; i++) {
                System.out.println(this.name + ": получает нагоняй у начальника");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(name + " выходит из кабинета");
        sem.release();
    }
}

