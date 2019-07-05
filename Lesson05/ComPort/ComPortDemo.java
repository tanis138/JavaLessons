/**
 * ComPortDemo
 */
public class ComPortDemo {

    public static void main(String[] args) {
        byte cpNum = 1;
        ComPort cp = new ComPort(cpNum, ComPort.BR_57600);
        System.out.println(cp);

        cp.open();

        byte aByte = 0x2B;
        cp.write(aByte);
        cp.write((byte) 0x0A);

        byte[] byteArr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        cp.write(byteArr);

        cp.read(byteArr);

        cp.close();

        // System.out.print("byteArr = ");
        // for (byte b : byteArr) {
        //     System.out.printf("0x%02X ", b);
        // }
    }
}