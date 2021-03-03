package com.example.covergrabber;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @org.junit.jupiter.api.Test
    void getMake() {
        Car c = new Car("YO!");
        assertEquals("YO!", c.getMake());
    }

    @org.junit.jupiter.api.Test
    void setMake() {
        fail();
    }
}