import java.util.Scanner;

public class Task6_82 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите натуральное число n: ");
        int n = Math.abs(in.nextInt());
        

        int dig, digMax = 0, digMin = 9;
        do {
            dig = n % 10;
            if (dig > digMax)
                digMax = dig;
            if (dig < digMin)
                digMin = dig;
            n /= 10;
        } while (n > 0);

        int digDelta = digMax - digMin;
        String str = String.format("Разность максимальной и минимальной цифр (%d - %d = %d) - ", digMax, digMin,
                digDelta);
        str += (digDelta % 2 == 0) ? "чётное число" : "нечётное число";

        System.out.println(str);

        in.close();
    }
}