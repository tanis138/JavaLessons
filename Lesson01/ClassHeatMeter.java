public class ClassHeatMeter {

    public static void main(String[] args) {
        // класс Теплосчётчик
        String name = "Теплосчётчик ТС-1";
        int num = 357; // № прибора
        int chanNum = 2; // кол-во каналов расхода
        byte busAddr = 0; // сетевой адрес на шине RS-485 (0..127)
        int busSpeed = 9600; // скорость обмена (байт/с)
        int fwVersion = 102; // версия прошивки
        boolean isToutMeasured = true; // измеряется ли температура наружного воздуха

        System.out.printf("%s №%08d (каналов расхода: %d, версия ПО: %d.%02d)%n", name, num, chanNum, fwVersion / 100,
                fwVersion % 100);
        System.out.printf("Параметры подключения: СА = %d, скорость = %d б/с%n", busAddr, busSpeed);
        System.out.printf("Тнар.воздуха: " + (isToutMeasured == true ? "измеряется" : "не измеряется") + "%n");
        System.exit(0);
    }
}