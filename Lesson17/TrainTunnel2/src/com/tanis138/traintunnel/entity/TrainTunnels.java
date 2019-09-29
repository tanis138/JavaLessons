package com.tanis138.traintunnel.entity;

import java.util.ArrayList;

public class TrainTunnels {
    private final ArrayList<TrainTunnel> trainTunnels;

    public TrainTunnels(ArrayList<TrainTunnel> trainTunnels) throws IllegalArgumentException{
        if (trainTunnels == null) throw new IllegalArgumentException("Tunnels count must be positive.");
        this.trainTunnels = trainTunnels;
    }

    int count() {
        return trainTunnels.size();
    }

    TrainTunnel getLeastBusyTunnel(final TunnelQueue tunnelQueue) {
        if (trainTunnels.size() == 0) return null;

        TrainTunnel result = null;
        int min = Integer.MAX_VALUE;

        for (TrainTunnel trainTunnel : trainTunnels) {
            if (trainTunnel.getQueueSize(tunnelQueue) < min) {
                min = trainTunnel.getQueueSize(tunnelQueue);
                result = trainTunnel;
            }
        }

        return result;
    }

}
