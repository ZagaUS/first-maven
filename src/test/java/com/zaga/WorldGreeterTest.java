package com.zaga;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class WorldGreeterTest {

    @Test
    void worldGreeterInstance() {
        WorldGreeter greeter = new WorldGreeter();
        assertTrue(greeter != null);
    }

    @Test
    void worldGreeterGreets() {
        WorldGreeter greeter = new WorldGreeter();
        String greeting = greeter.greet("Bob");
        assertTrue(greeting.equals("Hello Bob!"));
    }

}
