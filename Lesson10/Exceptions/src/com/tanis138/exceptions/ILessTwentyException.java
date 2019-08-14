package com.tanis138.exceptions;

public class ILessTwentyException extends Exception {
    private int i;

    public ILessTwentyException(String message, int i) {
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
