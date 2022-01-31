package for_presentation.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Jobber extends Human implements Runnable{
    private String diplomNumber;
    private CyclicBarrier barrier;

    public Jobber(String name, int age, CyclicBarrier barrier) {
        super(name, age);
        this.barrier = barrier;
    }

    public String getDiplomNumber() {
        return diplomNumber;
    }

    public void setDiplomNumber(String diplomNumber) {
        this.diplomNumber = diplomNumber;
    }

    @Override
    public String toString() {
        return "Jobber{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", diplomNumber='" + diplomNumber + '\'' +
                "} ";
    }

    @Override
    public void run() {

        System.out.println("Jobber \"" + this.getName() + "\" проснулся, поел, приехал на работу");
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("Jobber \"" + this.getName() + "\" начал работать.");
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("Jobber \"" + this.getName() + "\" закончил работать.");

    }

}
