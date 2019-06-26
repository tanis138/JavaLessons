import java.util.Scanner;

public class Task3_6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        boolean x = false;
        boolean y = false;
        boolean z = true;

        System.out.printf("X = %b, Y = %b, Z = %b%n", x, y, z);
        System.out.println("1) X или Y и не Z;      4) X и не Y или Z;");
        System.out.println("2) не X и не Y;         5) X и (не Y или Z);");
        System.out.println("3) не (X и Z) или Y;    6) X или (не (Y или Z))");

        int n = 1;
        while (n != 0) {
            System.out.println("Введите номер логического выражения (1..6) или 0 для выхода: ");
            n = in.nextInt();
            switch (n) {
            case 0:
                break;

            case 1:
                System.out.printf("X или Y и не Z = %b%n", x || y && !z);
                break;

            case 2:
                System.out.printf("не X и не Y = %b%n", !x && !y);
                break;

            case 3:
                System.out.printf("не (X и Z) или Y = %b%n", !(x && z) || y);
                break;

            case 4:
                System.out.printf("X и не Y или Z = %b%n", x && !y || z);
                break;

            case 5:
                System.out.printf("X и (не Y или Z) = %b%n", x && (!y || z));
                break;

            case 6:
                System.out.printf("X или (не (Y или Z)) = %b%n", x || !(y || z));
                break;

            default:
                System.out.println("Введён неправильный номер выражения!");
                break;
            }
        }

        in.close();
    }
}