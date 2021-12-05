package Home_Work_1;


public class Tests {

    public static void main(String[] args) {

        //Тестируем 4 задание:
        boolean weekday = false;
        boolean vacation = false;
        Alarm alarm = new Alarm();

        if (alarm.sleepIn(weekday, vacation)) {
            System.out.println("Можем спать дальше");
        } else {
            System.out.println("Пора идти на работу");
        }

        //Тестируем задание 6
        System.out.println(PhoneNumber.createPhoneNumber(new int[] {1,2,3,4,5,6,7,8,9,0}));

        try {
            System.out.println(PhoneNumber.createPhoneNumber(null));
        }catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        try {
            System.out.println(PhoneNumber.createPhoneNumber(new int[] {-1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
        }catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        //Тестируем задание 7
        System.out.println(Binary.toBinaryString((byte) 42).equals("00101010"));
        System.out.println(Binary.toBinaryString((byte) 15).equals("00001111"));
        System.out.println(Binary.toBinaryString((byte) -42).equals("11010110"));
        System.out.println(Binary.toBinaryString((byte) -15).equals("11110001"));

        //Тестируем задание 8
        ICommunicationPrinter[] communicationPrinters = new ICommunicationPrinter[3];
        communicationPrinters[0] = new WelcomCommunicationIf();
        communicationPrinters[1] = new WelcomCommunicationIfElseIf();
        communicationPrinters[2] = new WelcomCommunicationSwitch();

        for (ICommunicationPrinter communicationPrinter : communicationPrinters) {
            System.out.println(communicationPrinter.getClass());
            System.out.println(communicationPrinter.welcom("Вася"));
            System.out.println(communicationPrinter.welcom("Анастасия"));
            System.out.println(communicationPrinter.welcom("Вова"));
        }
    }
}
