/**
 * ComPort
 */
public class ComPort {
    public static final int BR_9600 = 9600;
    public static final int BR_57600 = 57600;
    public static final int BR_115200 = 115200;

    private byte comPort = 0; // № COM-порта
    private int baudRate = 0; // скорость обмена (протокол RS-232)
    private boolean isOpen = false; // открыт ли порт
    private boolean isCalledForArray = false; // вызван ли метод write() для массива данных

    public byte getComPort() {
        return comPort;
    }

    public void setComPort(byte comPort) {
        this.comPort = (comPort < 0) ? 0 : comPort;
    }

    public int getBaudRate() {
        return baudRate;
    }

    public void setBaudRate(int baudRate) {
        switch (baudRate) {
            case BR_9600:
            case BR_57600:
            case BR_115200:
                break;
            default:
                baudRate = 0;
                break;
        }

        this.baudRate = baudRate;
    }

    public ComPort(byte comPort, int baudRate) {
        setComPort(comPort);
        setBaudRate(baudRate);
    }

    public boolean open() {
        if (comPort == 0 || baudRate == 0) {
            return false;
        }

        if (isOpen) {
            close();
        }

        // do some work

        isOpen = true;

        return isOpen;
    }

    public void close() {

        // do some work

        isOpen = false;
    }

    public boolean read(byte[] data) {
        if (data.length == 0) {
            return false;
        }

        System.out.print("<- [ ");

        for (int i = 0; i < data.length; i++) {
            data[i] = (byte) (Math.random() * 256);
            System.out.printf("0x%02X ", data[i]);
        }

        System.out.println("]");

        return true;
    }

    public boolean write(byte data) {
        if (isOpen = false) {
            return false;
        }

        // do some work

        if (isCalledForArray) {
            System.out.printf("0x%02X ", data);
        } else {
            System.out.printf("-> [ 0x%02X ]%n", data);
        }

        return true;
    }

    public boolean write(byte[] data) {
        System.out.print("-> [ ");

        isCalledForArray = true;
        for (byte b : data) {
            if (!write(b)) {
                isCalledForArray = false;
                return false;
            }
        }
        isCalledForArray = false;

        System.out.println("]");

        return true;
    }

    @Override
    public String toString() {
        return "ComPort [baudRate=" + baudRate + ", comPort=" + comPort + ", isOpen=" + isOpen + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + baudRate;
        result = prime * result + comPort;
        result = prime * result + (isOpen ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ComPort other = (ComPort) obj;
        if (baudRate != other.baudRate)
            return false;
        if (comPort != other.comPort)
            return false;
        if (isOpen != other.isOpen)
            return false;
        return true;
    }
}