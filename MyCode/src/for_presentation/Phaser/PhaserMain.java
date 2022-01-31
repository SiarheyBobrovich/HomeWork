package for_presentation.Phaser;

import java.util.concurrent.Phaser;

public class PhaserMain {
    public static void main(String[] args) {

        Phaser phaser = new Phaser(1);
        new Thread(new PhaseThread(phaser, "PhaseThread 1")).start();
        new Thread(new PhaseThread(phaser, "PhaseThread 2")).start();

        // ждем завершения фазы 0
        int phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");
        // ждем завершения фазы 1
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        // ждем завершения фазы 2
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        phaser.arriveAndDeregister();
    }
}

class PhaseThread implements Runnable{
    private Phaser phaser;
    private String name;

    PhaseThread(Phaser p, String n){
        this.phaser=p;
        this.name=n;
        phaser.register();
    }

    @Override
    public void run(){

        System.out.println(name + " выполняет фазу " + phaser.getPhase());
        // сообщаем, что первая фаза достигнута
        phaser.arriveAndAwaitAdvance();

        System.out.println(name + " выполняет фазу " + phaser.getPhase());
        // сообщаем, что вторая фаза достигнута
        phaser.arriveAndAwaitAdvance();

        System.out.println(name + " выполняет фазу " + phaser.getPhase());
        // сообщаем о завершении фаз и удаляем с регистрации объекты
        phaser.arriveAndDeregister();
    }
}
