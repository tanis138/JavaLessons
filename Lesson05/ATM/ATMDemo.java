/**
 * ATMDemo
 */
public class ATMDemo {

    public static void main(String[] args) {
        ATM atm = new ATM(12, 31, 52);
        System.out.println(atm);
        System.out.println();

        atm.withdrawCash(1570);
        System.out.println();

        atm.addBills(1, 0, 24);
        System.out.println();

        atm.withdrawCash(90);
        System.out.println();

        atm.withdrawCash(110);
        System.out.println();

        atm.withdrawCash(2000);
    }
}