package com.tanis138.traintunnel.entity;

import java.util.Random;

public class Train implements Runnable {
    private static final int MAX_USE_TIME = 1_500;

    private final String name;
    private final int waitTime;
    private final TrainTunnels trainTunnels;
    private final TunnelQueue tunnelQueue;
    private TrainTunnel trainTunnel;

    public Train(String name, int waitTime, TrainTunnels trainTunnels, TunnelQueue tunnelQueue) throws IllegalArgumentException {
        if (name == null) throw new IllegalArgumentException("Train name cannot be null");
        this.name = name;

        if (waitTime < 0) throw new IllegalArgumentException("Train waitTime cannot be negative");
        this.waitTime = waitTime;

        if (trainTunnels == null || trainTunnels.count() == 0) {
            throw new IllegalArgumentException("TrainTunnels cannot be null or empty");
        }
        this.trainTunnels = trainTunnels;

        if (tunnelQueue == null) throw new IllegalArgumentException("TunnelQueue cannot be null");
        this.tunnelQueue = tunnelQueue;

        trainTunnel = trainTunnels.getLeastBusyTunnel(tunnelQueue);
    }

    String getName() {
        return name;
    }

    private boolean changeTrainTunnel() {
        TrainTunnel newTrainTunnel = trainTunnels.getLeastBusyTunnel(tunnelQueue);

        if (newTrainTunnel == null) return false;

        if (newTrainTunnel != trainTunnel && newTrainTunnel.getQueueSize(tunnelQueue) != trainTunnel.getQueueSize(tunnelQueue)) {
            System.out.printf("%s is REDIRECTED from %s to %s.\n",
                    name, trainTunnel.getName(tunnelQueue), newTrainTunnel.getName(tunnelQueue));
            trainTunnel = newTrainTunnel;
            return true;
        }

        return false;
    }

    @Override
    public void run() {
        final Thread thread = Thread.currentThread();
        boolean isNewInQueue = true;

        while (true) {
            if (thread.isInterrupted()) {
                System.out.println(thread.getName() + " was interrupted.");
                return;
            }

            if (trainTunnel.tryEnterTunnel(this, waitTime, tunnelQueue, isNewInQueue)) {
                System.out.printf("%s USES   %s.\n", name, trainTunnel.getName());
                try {
                    Thread.sleep(new Random().nextInt(MAX_USE_TIME));
                } catch (InterruptedException e) {
                    System.out.println(thread.getName() + " was interrupted.");
                    return;
                }
                if (trainTunnel.leaveTunnel(this)) {
                    System.out.printf("%s LEAVES %s.\n", name, trainTunnel.getName());
                } else {
                    System.out.printf("%s FAILED TO LEAVE %s!!!\n", name, trainTunnel.getName());
                }
                return;
            } else {
                isNewInQueue = changeTrainTunnel();
            }
        }
    }
//    public void run() {
//        final Thread thread = Thread.currentThread();
//
//        while (true) {
//            if (thread.isInterrupted()) {
//                System.out.println(thread.getName() + " was interrupted.");
//                return;
//            }
//
//            System.out.printf("%s IS in  %s of %s.\n", name, tunnelQueue, trainTunnel.getName());
//            if (trainTunnel.getTunnelPass(waitTime, tunnelQueue)) {
//                System.out.printf("%s USES   %s.\n", name, trainTunnel.getName());
//                try {
//                    Thread.sleep(new Random().nextInt(MAX_USE_TIME));
//                } catch (InterruptedException e) {
//                    System.out.println(thread.getName() + " was interrupted.");
//                    return;
//                }
//                trainTunnel.freeTunnelPath(tunnelQueue);
//                System.out.printf("%s LEAVES %s.\n", name, trainTunnel.getName());
//                return;
//            } else {
//                changeTrainTunnel();
//            }
//        }
//    }

    @Override
    public String toString() {
        return String.format("%s[w=%d;t=%s;q=%s]", name, waitTime, trainTunnel, tunnelQueue);
    }
}
