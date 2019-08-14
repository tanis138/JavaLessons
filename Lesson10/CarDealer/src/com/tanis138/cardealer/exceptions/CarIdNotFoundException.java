package com.tanis138.cardealer.exceptions;

public class CarIdNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;
    private int id;

    public CarIdNotFoundException(String message, int id) {
        super(message);
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
