package com.example.carRent.Car.Mark;

public enum Capacity {

    SMALL("1.0-1.5"), MEDIUM("1.5-2.0"), BIG("2.0-2.5");
    private String value;

    Capacity(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}






