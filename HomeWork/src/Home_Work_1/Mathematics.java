package Home_Work_1;

public class Mathematics {
    public static void main(String[] args) {
        //Прощадь круга
        int r = 20;
        double s = Math.PI * Math.pow(r, 2); // PI * r^2 = 1256.6370614359173

        //--a
        Math.decrementExact(123); //122

        //Припуск за один проход при поперечной подаче 0.04мм круга при шлифовке зубьев шестерни с шагом 4-5
        //поперечная подача s
        double S = 0.03;
        //угол круга
        int angle = 40;
        //припуск t
        double t = Math.sin(Math.toRadians(angle / 2)) * S;//примерно 0.0102....

        //Игра в кости:
        int dice = (int) Math.ceil(Math.random() * 6); //[1-6]

        //Сравнение чисел
        double max = Math.max(20.40, 20.13999999); //20.40
        double min = Math.min(0, -0.01); //-0.01

        //константы:
        double e = Math.E; //2.7182818284590452354
        double pi = Math.PI; //3.14159265358979323846
    }
}
