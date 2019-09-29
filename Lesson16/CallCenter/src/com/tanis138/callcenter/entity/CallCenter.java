package com.tanis138.callcenter.entity;

public class CallCenter {
    private final int operatorsCount;
    private int operatorsFree;

    public CallCenter(int operatorsCount) {
        this.operatorsCount = operatorsCount;
        operatorsFree = operatorsCount;
    }

//    public int getOperatorsCount() {
//        return operatorsCount;
//    }

    synchronized boolean getOperator(int waitTime) {
        if (waitTime < 0) return false;

        // если все операторы заняты - ждём
        while (operatorsFree == 0) {
            try {
                wait(waitTime);
            } catch (InterruptedException e) {
                return false;
            }

            // если не дождались
            if (operatorsFree == 0) return false;
        }

        // занимаем 1 оператора
        operatorsFree--;
        notify();

        return true;
    }

    synchronized void freeOperator() {
        // если все операторы и так свободны
        if (operatorsFree == operatorsCount) return;

        operatorsFree++;
        notify();
    }
}
