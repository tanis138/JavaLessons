package com.tanis138.callcenter.entity;

import java.util.Objects;
import java.util.Random;

public class Client implements Runnable {
    private static final int MAX_TALK_TIME = 1_000;

    private final String name;
    private final int waitTime;
    private final int tryCount;
    private final CallCenter callCenter;

    public Client(String name, int waitTime, int tryCount, CallCenter callCenter) throws IllegalArgumentException {
        if (name == null) throw new IllegalArgumentException("Client name cannot be null");
        this.name = name;
        if (waitTime < 0) throw new IllegalArgumentException("Client waitTime cannot be negative");
        this.waitTime = waitTime;
        if (tryCount <= 0) throw new IllegalArgumentException("Client tryCount must be positive");
        this.tryCount = tryCount;
        if (callCenter == null) throw new IllegalArgumentException("Client's CallCenter cannot be null");
        this.callCenter = callCenter;
    }

//    public String getName() {
//        return name;
//    }

//    public int getWaitTime() {
//        return waitTime;
//    }

//    public int getTryCount() {
//        return tryCount;
//    }

//    public CallCenter getCallCenter() {
//        return callCenter;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return waitTime == client.waitTime &&
                tryCount == client.tryCount &&
                name.equals(client.name) &&
                callCenter.equals(client.callCenter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, waitTime, tryCount, callCenter);
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

            if (i > 1) {
                System.out.printf("%s is calling (%d try)...\n", name, i);
            } else {
                System.out.printf("%s is calling...\n", name);
            }

            if (callCenter.getOperator(waitTime)) {
                System.out.printf("%s talks to operator...\n", name);
                // разговариваем с оператором
                try {
                    Thread.sleep(new Random().nextInt(MAX_TALK_TIME));
                } catch (InterruptedException e) {
                    System.out.println(thread.getName() + " was interrupted.");
                    return;
                }
                callCenter.freeOperator();
                System.out.printf("%s finished talking.\n", name);
                return;
            } else {
                System.out.printf("%s HANGED UP after %d try.\n", name, i);

                // на последней попытке дозвона не ждём
                if (i == tryCount) break;

                System.out.println(name + " is WAITING to redial...");

                // ждём следующей попытки дозвона
                try {
                    Thread.sleep(waitTime);
                } catch (InterruptedException e) {
                    System.out.println(thread.getName() + " was interrupted.");
                    return;
                }
            }
        }
    }
}
