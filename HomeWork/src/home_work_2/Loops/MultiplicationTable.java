package home_work_2.loops;

// 1.5. Вывести таблицу умножения в консоль. В консоли должно получиться также как и на картинке (динозаврика рисовать не надо): https://www.dropbox.com/s/ibakfuppvy2w32g/multiplication_table.jpeg?dl=0

public class MultiplicationTable {
    public static void main(String[] args) {

        int index = 2;

        for (int multiplier = 1; multiplier <= 10; multiplier++) {
            if (multiplier != 1) {
                System.out.println();
            }

            for (int number = index; number < 10; number++) {
                System.out.printf("%d * %d = %d", number, multiplier, number * multiplier);

                if (number % 4 == 1 && multiplier != 10) {
                    break;
                }else if (multiplier * number == 50){
                    System.out.println();
                    multiplier = 1;
                    index = 6;
                    break;
                }else if (multiplier * number != 90){
                    System.out.print("\t");
                }
            }
        }


    }
}

/*
for (int multiplier = 1; multiplier <= 10; multiplier++) {
            if (multiplier != 1) {
                System.out.println();
            }

            for (int number = index; number < 10; number++) {
                System.out.printf("%d * %d = %d", number, multiplier, number * multiplier);

                if (number % 4 == 1 && multiplier != 10) {
                    break;
                }else if (multiplier == 10 && number == 5){
                    System.out.println();
                    multiplier = 1;
                    index = 6;
                    break;
                }else {
                    System.out.print("\t");
                }
            }
        }
 */