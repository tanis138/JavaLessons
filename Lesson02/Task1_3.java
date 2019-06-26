import java.util.Scanner;

public class Task1_3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        int number = in.nextInt();
        System.out.printf("Вы ввели число: %d%n", number);
        in.close();
    }
}