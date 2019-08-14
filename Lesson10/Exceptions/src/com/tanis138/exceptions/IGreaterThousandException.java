package com.tanis138.exceptions;

public class IGreaterThousandException extends IGreaterHundredException {
    private static final long serialVersionUID = 1L;

    public IGreaterThousandException(String message, int i) {
        super(message, i);
    }
}
