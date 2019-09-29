package com.tanis138.cashdesk.entity;

import java.util.ArrayList;

public class CashDesks {
    private final ArrayList<CashDesk> cashDesks;

    public CashDesks(ArrayList<CashDesk> cashDesks) throws IllegalArgumentException{
        if (cashDesks == null) throw new IllegalArgumentException("Desks count must be positive.");
        this.cashDesks = cashDesks;
    }

    int count() {
        return cashDesks.size();
    }

    CashDesk getLeastBusyCashDesk() {
        if (cashDesks.size() == 0) return null;

        CashDesk result = null;
        int min = Integer.MAX_VALUE;

        for (CashDesk cashDesk : cashDesks) {
            if (cashDesk.getQueueLength() < min) {
                min = cashDesk.getQueueLength();
                result = cashDesk;
            }
        }

        return result;
    }

}
