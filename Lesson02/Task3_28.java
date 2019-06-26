import java.util.Scanner;

public class Task3_28 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("\nВведите целые числа A, B и C через пробел: ");
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        System.out.printf("а) каждое из чисел А и В больше 100: %b%n", (a > 100 && b > 100));
        System.out.printf("б) только одно из чисел А и В четное: %b%n", (a % 2 == 0 ^ b % 2 == 0));
        System.out.printf("в) хотя бы одно из чисел А и В положительно: %b%n", (a > 0 || b > 0));
        System.out.printf("г) каждое из чисел А, В, С кратно трем: %b%n", (a % 3 == 0 && b % 3 == 0 && c % 3 == 0));
        // Тут пришлось попотеть. Специально хотел решить задачу через xor, а не через ((a & !b & !c) || ...). Но три xor не работают в случае, 
        // когда все три операнда истинны. Для этого пришлось добавить проверку этого условия. Зато теперь работает :)
        System.out.printf("д) только одно из чисел А, В и С меньше 50: %b%n", (a < 50 ^ b < 50 ^ c < 50) && !(a < 50 && b < 50 && c < 50));
        System.out.printf("е) хотя бы одно из чисел А, В, С отрицательно: %b%n", (a < 0 || b < 0 || c < 0));

        in.close();
    }
}