/**
 * ATM
 */
public class ATM {
    public static final int BILL100 = 100;
    public static final int BILL50 = 50;
    public static final int BILL20 = 20;

    int bill100 = 0; // $100 bill
    int bill50 = 0; // $50 bill
    int bill20 = 0; // $20 bill

    public void addBill100(int bill100) {
        if (bill100 <= 0) return;
        this.bill100 += bill100;
    }

    public void addBill50(int bill50) {
        if (bill50 <= 0) return;
        this.bill50 += bill50;
    }
    
    public void addBill20(int bill20) {
        if (bill20 <= 0) return;
        this.bill20 += bill20;
    }

    public void addBills(int bill100, int bill50, int bill20) {
        if (bill100 < 0) bill100 = 0;
        if (bill50 < 0) bill50 = 0;
        if (bill20 < 0) bill20 = 0;
        addBill100(bill100);
        addBill50(bill50);
        addBill20(bill20);
        System.out.printf("Добавлено купюр: $100x%d $50x%d $20x%d%n", bill100, bill50, bill20);
        System.out.printf("Остаток: $100=%d $50=%d $20=%d%n", this.bill100, this.bill50, this.bill20);
    }

    public ATM(int bill100, int bill50, int bill20) {
        this.bill100 = bill100;
        this.bill50 = bill50;
        this.bill20 = bill20;
    }

    public boolean withdrawCash(int sum) {
        if (sum <= 0)
            return false;

        int curr_sum = sum;

        // $100
        int cnt100 = curr_sum / BILL100;
        if (cnt100 <= bill100) {
            curr_sum %= BILL100;
        } else {
            cnt100 = bill100;
            curr_sum -= cnt100 * BILL100;
        }

        // $50
        int cnt50 = curr_sum / BILL50;
        if (cnt50 <= bill50) {
            curr_sum %= BILL50;
        } else {
            cnt50 = bill50;
            curr_sum -= cnt50 * BILL50;
        }

        // $20
        int cnt20 = curr_sum / BILL20;
        if (cnt20 <= bill20) {
            curr_sum %= BILL20;
        } else {
            cnt20 = bill20;
            curr_sum -= cnt20 * BILL20;
        }

        String strResult = String.format("Сумма к выдаче: $%d%n", sum);
        boolean res = false;
        if (curr_sum != 0) {
            strResult += String.format("Выдано: $0 (недостаточно купюр либо нет номинала)", sum);
        } else {
            strResult += String.format("Выдано:", sum);
            if (cnt100 != 0) {
                bill100 -= cnt100;
                strResult += String.format(" $100x%d", cnt100);
            }
            if (cnt50 != 0) {
                bill50 -= cnt50;
                strResult += String.format(" $50x%d", cnt50);
            }
            if (cnt20 != 0) {
                bill20 -= cnt20;
                strResult += String.format(" $20x%d", cnt20);
            }
            res = true;
        }

        strResult += String.format("%nОстаток: %s", getBills()); 
        System.out.println(strResult);
        return res;
    }

    public String getBills() {
        return String.format("$100=%d $50=%d $20=%d", bill100, bill50, bill20);
    }

    @Override
    public String toString() {
        return "ATM [" + getBills() + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + bill100;
        result = prime * result + bill20;
        result = prime * result + bill50;
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
        ATM other = (ATM) obj;
        if (bill100 != other.bill100)
            return false;
        if (bill20 != other.bill20)
            return false;
        if (bill50 != other.bill50)
            return false;
        return true;
    }
}
