package com.tanis138.exceptions;

public class ILessTenException extends Exception {
    private int i;

    public ILessTenException(String message, int i) {
        super(message);
        this.i = i;
    }

    public int getI() {
        return i;
    }

    @Override
    public String toString() {
        return String.format("%s (i = %d)", super.toString(), i);
    }
}
