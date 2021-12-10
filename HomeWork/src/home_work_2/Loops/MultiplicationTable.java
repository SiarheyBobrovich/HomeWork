package home_work_2.loops;

// 1.5. Вывести таблицу умножения в консоль. В консоли должно получиться также как и на картинке (динозаврика рисовать не надо): https://www.dropbox.com/s/ibakfuppvy2w32g/multiplication_table.jpeg?dl=0

public class MultiplicationTable {
    public static void main(String[] args) {
        int j = 2;

        for (int i = 1; i <= 10; i++) {
            System.out.println();

            for (int k = j; k < 10; k++) {
                System.out.printf("%d * %d = %d\t", k, i, k * i);

                if ((k % 5 == 0 || k % 9 == 0) && i != 10) {
                    break;
                }else if (i == 10 && k == 5){
                    System.out.println();
                    i = 1;
                    j = 6;
                    break;
                }
            }
        }
    }
}
