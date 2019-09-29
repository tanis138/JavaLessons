package com.tanis138.cashdesk.entity;

public class CashDesk {
    private final String name;
    private int queueLength;
    private boolean isFree;

    public CashDesk(String name) throws IllegalArgumentException{
        if (name == null) throw new IllegalArgumentException("CashDesk name cannot be null");
        this.name = name;

        isFree = true;
        queueLength = 0;
    }

//    public boolean isFree() {
//        return isFree;
//    }

    int getQueueLength() {
        return queueLength;
    }

    synchronized boolean getCashier(int waitTime) {
        if (waitTime < 0) return false;

        queueLength++;

        while (!isFree) {
            // ждём освобождения
            try {
                wait(waitTime);
            } catch (InterruptedException e) {
                queueLength--;
                return false;
            }

            // если не дождались
            if (!isFree) {
                queueLength--;
                return false;
            }
        }

        // занимаем кассира
        isFree = false;
        notify();

        return true;
    }

    synchronized void freeCashier() {
        queueLength--;

        if (isFree) return;

        isFree = true;

        notify();
    }

    @Override
    public String toString() {
        return String.format("%s[q=%d]", name, queueLength);
    }
}
