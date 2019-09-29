package com.tanis138.traintunnel;

import com.tanis138.traintunnel.entity.Train;
import com.tanis138.traintunnel.entity.TrainTunnel;
import com.tanis138.traintunnel.entity.TrainTunnels;
import com.tanis138.traintunnel.entity.TunnelQueue;

import java.util.ArrayList;
import java.util.Random;

public class TrainTunnelRunner {
    private static final int TUNNELS_COUNT = 2;
    private static final int TRAINS_COUNT = 15;
    private static final int WAIT_TIME_DIV_2 = 200;
    private static final int TRAIN_GENERATION_DELAY_MAX = 50;

    public static void main(String[] args) {
        System.out.println("TrainTunnel using ArrayBlockingQueue(1) and AtomicInteger\n");

        ArrayList<TrainTunnel> trainTunnelsArr = new ArrayList<>(TUNNELS_COUNT);
        for (int i = 0; i < TUNNELS_COUNT; i++) {
            String name = "Tunnel" + (i + 1);
            trainTunnelsArr.add(new TrainTunnel(name));
        }
        TrainTunnels trainTunnels = new TrainTunnels(trainTunnelsArr);

        Thread[] clientsThread = new Thread[TRAINS_COUNT];
        for (int i = 0; i < TRAINS_COUNT; i++) {
            String name = String.format("Train%-2d", (i + 1));
            int waitTime = WAIT_TIME_DIV_2 + new Random().nextInt(WAIT_TIME_DIV_2);
            TunnelQueue tunnelQueue = new Random().nextBoolean() ? TunnelQueue.QUEUE_IN : TunnelQueue.QUEUE_OUT;
            clientsThread[i] =
                    new Thread(new Train(name, waitTime, trainTunnels, tunnelQueue), name + "Thread");
            clientsThread[i].start();

            try {
                Thread.sleep(new Random().nextInt(TRAIN_GENERATION_DELAY_MAX));
            } catch (InterruptedException e) {
                System.out.println("Main thread was interrupted");
                return;
            }
        }

        for (int i = 0; i < TRAINS_COUNT; i++) {
            try {
                clientsThread[i].join();
            } catch (InterruptedException e) {
                System.out.println("Main thread was interrupted");
                return;
            }
        }
    }

}
