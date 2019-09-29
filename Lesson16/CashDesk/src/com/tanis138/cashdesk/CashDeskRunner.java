package com.tanis138.cashdesk;

import com.tanis138.cashdesk.entity.CashDesk;
import com.tanis138.cashdesk.entity.CashDesks;
import com.tanis138.cashdesk.entity.Client;

import java.util.ArrayList;
import java.util.Random;

public class CashDeskRunner {
    private static final int DESKS_COUNT = 3;
    private static final int CLIENTS_COUNT = 20;
    private static final int WAIT_TIME_DIV_2 = 500;
    private static final int TRY_COUNT_MAX = 2;
    private static final int CLIENT_GENERATION_DELAY_MAX = 100;

    public static void main(String[] args) {
        ArrayList<CashDesk> cashDesksArr = new ArrayList<>(DESKS_COUNT);
        for (int i = 0; i < DESKS_COUNT; i++) {
            String name = "CashDesk" + (i + 1);
            cashDesksArr.add(new CashDesk(name));
        }
        CashDesks cashDesks = new CashDesks(cashDesksArr);

        Thread[] clientsThread = new Thread[CLIENTS_COUNT];
        for (int i = 0; i < CLIENTS_COUNT; i++) {
            String name = "Customer" + (i + 1);
            int waitTime = WAIT_TIME_DIV_2 + new Random().nextInt(WAIT_TIME_DIV_2);
            int tryCount = 1 + new Random().nextInt(TRY_COUNT_MAX);
            clientsThread[i] = new Thread(new Client(name, waitTime, tryCount, cashDesks), name + "Thread");
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
