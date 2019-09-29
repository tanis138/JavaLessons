package com.tanis138.callcenter;

import com.tanis138.callcenter.entity.CallCenter;
import com.tanis138.callcenter.entity.Client;

import java.util.Random;

public class CallCenterRunner {
    private static final int OPERATORS_COUNT = 3;
    private static final int CLIENTS_COUNT = 10;
    private static final int WAIT_TIME_DIV_2 = 500;
    private static final int TRY_COUNT_MAX = 5;
    private static final int CLIENT_GENERATION_DELAY_MAX = 100;

    public static void main(String[] args) {
        CallCenter callCenter = new CallCenter(OPERATORS_COUNT);

        Thread[] clientsThread = new Thread[CLIENTS_COUNT];
        for (int i = 0; i < CLIENTS_COUNT; i++) {
            String name = "Client" + (i + 1);
            int waitTime = WAIT_TIME_DIV_2 + new Random().nextInt(WAIT_TIME_DIV_2);
            int tryCount = 1 + new Random().nextInt(TRY_COUNT_MAX);
            clientsThread[i] = new Thread(new Client(name, waitTime, tryCount, callCenter), name + "Thread");
            clientsThread[i].start();

            try {
                Thread.sleep(new Random().nextInt(CLIENT_GENERATION_DELAY_MAX));
            } catch (InterruptedException e) {
                System.out.println("Main thread was interrupted");
                return;
            }
        }

        for (int i = 0; i < CLIENTS_COUNT; i++) {
            try {
                clientsThread[i].join();
            } catch (InterruptedException e) {
                System.out.println("Main thread was interrupted");
                return;
            }
        }
    }
}
