package com.tanis138.traintunnel.entity;

public class TrainTunnel {
    private final String name;
    private boolean isFree;
    private int queueIn;
    private int queueOut;

    public TrainTunnel(String name) throws IllegalArgumentException {
        if (name == null) throw new IllegalArgumentException("TrainTunnel name cannot be null");
        this.name = name;

        isFree = true;
        queueIn = queueOut = 0;
    }

    final int getQueue(TunnelQueue tunnelQueue) {
        return tunnelQueue == TunnelQueue.QUEUE_IN ? queueIn : queueOut;
    }

    String getName() {
        return name;
    }

    String getName(TunnelQueue tunnelQueue) {
        return String.format("%s[q=%d]", name, getQueue(tunnelQueue));
    }


    synchronized boolean getTunnelPass(int waitTime, TunnelQueue tunnelQueue) {
        if (waitTime < 0) return false;

        if (tunnelQueue == TunnelQueue.QUEUE_IN) {
            queueIn++;
        } else {
            queueOut++;
        }

        while (!isFree) {
            // ждём освобождения туннеля
            try {
                wait(waitTime);
            } catch (InterruptedException e) {
                if (tunnelQueue == TunnelQueue.QUEUE_IN) {
                    queueIn--;
                } else {
                    queueOut--;
                }
                return false;
            }

            // если не дождались
            if (!isFree) {
                if (tunnelQueue == TunnelQueue.QUEUE_IN) {
                    queueIn--;
                } else {
                    queueOut--;
                }
                return false;
            }
        }

        // бронируем проезд
        isFree = false;
        notify();

        return true;
    }

    synchronized void freeTunnelPath(TunnelQueue tunnelQueue) {
        if (tunnelQueue == TunnelQueue.QUEUE_IN) {
            queueIn--;
        } else {
            queueOut--;
        }

        if (isFree) return;

        isFree = true;

        notify();
    }

    @Override
    public String toString() {
        return String.format("%s[in=%d;out=%d]", name, queueIn, queueOut);
    }
}
