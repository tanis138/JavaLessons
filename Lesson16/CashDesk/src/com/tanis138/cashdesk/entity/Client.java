package com.tanis138.cashdesk.entity;

import java.util.Objects;
import java.util.Random;

public class Client implements Runnable {
    private static final int MAX_PAY_TIME = 1_500;

    private final String name;
    private final int waitTime;
    private final int tryCount;
    private final CashDesks cashDesks;
    private CashDesk cashDesk;

    public Client(String name, int waitTime, int tryCount, CashDesks cashDesks) throws IllegalArgumentException {
        if (name == null) throw new IllegalArgumentException("Client name cannot be null");
        this.name = name;
        if (waitTime < 0) throw new IllegalArgumentException("Client waitTime cannot be negative");
        this.waitTime = waitTime;
        if (tryCount <= 0) throw new IllegalArgumentException("Client tryCount must be positive");
        this.tryCount = tryCount;
        if (cashDesks == null || cashDesks.count() == 0)
            throw new IllegalArgumentException("CashDesks cannot be null or empty");
        this.cashDesks = cashDesks;
        cashDesk = cashDesks.getLeastBusyCashDesk();
    }

    private void changeCashDesk() {
        CashDesk newCashDesk = cashDesks.getLeastBusyCashDesk();

        if (newCashDesk == null || newCashDesk == cashDesk) return;

        System.out.printf("%s has changed cash desk from %s to %s.\n", name, cashDesk, newCashDesk);
        cashDesk = newCashDesk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return waitTime == client.waitTime &&
                tryCount == client.tryCount &&
                name.equals(client.name) &&
                cashDesk.equals(client.cashDesk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, waitTime, tryCount, cashDesk);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", waitTime=" + waitTime +
                ", tryCount=" + tryCount +
                '}';
    }

    @Override
    public void run() {
        final Thread thread = Thread.currentThread();

        for (int i = 1; i <= tryCount; i++) {
            if (thread.isInterrupted()) {
                System.out.println(thread.getName() + " was interrupted.");
                return;
            }

            System.out.printf("%s steps into queue of %s.\n", name, cashDesk);
            if (cashDesk.getCashier(waitTime)) {
                System.out.printf("%s pays for his order...\n", name);
                // оплата заказа
                try {
                    Thread.sleep(new Random().nextInt(MAX_PAY_TIME));
                } catch (InterruptedException e) {
                    System.out.println(thread.getName() + " was interrupted.");
                    return;
                }
                cashDesk.freeCashier();
                System.out.printf("%s leaves %s.\n", name, cashDesk);
                return;
            } else {
                if (i == tryCount) {
                    System.out.printf("%s leaves the queue of %s.\n", name, cashDesk);
                } else {
                    changeCashDesk();
                }
            }
        }
    }
}
