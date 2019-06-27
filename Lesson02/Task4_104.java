import java.util.Scanner;

public class Task4_104 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите номер дня недели (1..7): ");
        int nDow = in.nextInt();
        String sDow = "Это ";

        switch (nDow) {
            case 1:
                sDow += "понедельник";
                break;
            case 2:
                sDow += "вторник";
                break;
            case 3:
                sDow += "среда";
                break;
            case 4:
                sDow += "четверг";
                break;
            case 5:
                sDow += "пятница";
                break;
            case 6:
                sDow += "суббота";
                break;
            case 7:
                sDow += "воскресенье";
                break;
            
            default:
                sDow = "Это НЕ день недели";
                break;
        }
        System.out.println(sDow + "!");

        in.close();
    }
}