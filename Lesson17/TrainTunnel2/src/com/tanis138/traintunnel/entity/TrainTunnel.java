package com.tanis138.traintunnel.entity;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TrainTunnel {
    private final String name;
    private final BlockingQueue<Train> tunnel;
    private AtomicInteger queueInSize;
    private AtomicInteger queueOutSize;

    public TrainTunnel(String name) throws IllegalArgumentException {
        if (name == null) throw new IllegalArgumentException("TrainTunnel name cannot be null");
        this.name = name;

        queueInSize = new AtomicInteger(0);
        queueOutSize = new AtomicInteger(0);
        tunnel = new ArrayBlockingQueue<>(1, true);
    }

    final int getQueueSize(TunnelQueue tunnelQueue) {
        return tunnelQueue == TunnelQueue.QUEUE_IN ? queueInSize.get() : queueOutSize.get();
    }

    String getName() {
        return name;
    }

    String getName(TunnelQueue tunnelQueue) {
        String strQ = tunnelQueue == TunnelQueue.QUEUE_IN ? "in" : "out";
        return String.format("%s[%s=%d]", name, strQ, getQueueSize(tunnelQueue));
    }

    boolean tryEnterTunnel(Train train, int waitTime, TunnelQueue tunnelQueue, boolean isNewInQueue) {
        if (waitTime < 0 || train == null) return false;

        if (tunnelQueue == TunnelQueue.QUEUE_IN) {
            queueInSize.incrementAndGet();
        } else {
            queueOutSize.incrementAndGet();
        }

        if (isNewInQueue) {
            System.out.printf("%s ENTERS %s of %s.\n", train.getName(), tunnelQueue, this);
        }
//        else {
//            System.out.printf("%s STAYS in %s of %s.\n", train.getName(), tunnelQueue, this);
//        }

        try {
            return tunnel.offer(train, waitTime, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted.");
            return false;
        } catch (Exception e) {
            System.out.println(Thread.currentThread().getName() + " exception: " + e.getLocalizedMessage());
            return false;
        } finally {
            if (tunnelQueue == TunnelQueue.QUEUE_IN) {
                queueInSize.decrementAndGet();
            } else {
                queueOutSize.decrementAndGet();
            }
        }
    }

    boolean leaveTunnel(Train train) {
        try {
            tunnel.remove(train);
            return true;
        } catch (Exception e) {
            return false;
        }

//        Train queueTrain = tunnel.peek();
//        if (queueTrain == null || queueTrain != train) return false;
//        return tunnel.poll() != null;
    }

    @Override
    public String toString() {
        return String.format("%s[in=%d;out=%d]", name, queueInSize.get(), queueOutSize.get());
    }
}
