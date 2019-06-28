import java.util.Scanner;

public class Task6_49 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите натуральное число n: ");
        int n = in.nextInt();

        int dig;
        boolean has2 = false, has3 = false, has5 = false;
        do {
            dig = n % 10;
            switch (dig) {
                case 2:
                    has2 = true;
                    break;
                case 3:
                    has3 = true;
                    break;
                case 5:
                    has5 = true;
                    break;
            }
            n /= 10;
        } while (n > 0);

        if (has2)
            System.out.println("В этом числе есть цифра 2");
        if (has3 && has5)
            System.out.println("В этом числе есть цифры 3 и 5");

        in.close();
    }
}