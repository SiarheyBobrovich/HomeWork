package home_work_2.Loops;

public class MultiplicationTable {
    public static void main(String[] args) {
        int j = 2;
        for (int i = 1; i <= 10; i++) {
            for (int k = j; k < 10; k++) {
                System.out.printf("%d * %d = %d\t", k, i, k * i);
                if ((k % 5 == 0 || k % 9 == 0) && i != 10) {
                    System.out.println();
                    break;
                }else if (i == 10 && k == 5){
                    System.out.println("\n");
                    i = 1;
                    j = 6;
                    break;
                }
            }
        }
    }
}
