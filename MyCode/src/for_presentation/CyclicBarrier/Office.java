package for_presentation.CyclicBarrier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

public class Office {
    public static void main(String[] args) {

        CyclicBarrier office = new CyclicBarrier(6);
        List<Thread> jobbers = new ArrayList<>();

        jobbers.add(new Thread(new Jobber("Антон", 22, office)));
        jobbers.add(new Thread(new Jobber("Вася", 21, office)));
        jobbers.add(new Thread(new Jobber("Петя", 18, office)));
        jobbers.add(new Thread(new Jobber("Инна", 54, office)));
        jobbers.add(new Thread(new Jobber("Анастасия", 23, office)));
        jobbers.add(new Thread(new Jobber("Смит", 80, office)));

        for (Thread jobber : jobbers) {
            jobber.start();
        }

        office.reset();

    }
}
