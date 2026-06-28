package com.tw.readit.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getSameResponse() {
        User user = new User();
        String response = user.getSameResponse("hello");
        assertEquals("hello", response);
    }
}