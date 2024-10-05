package com.card.card.dto;

import java.util.Random;
import java.util.UUID;

public class GenerateRandom {

    public static String generateRandomNumber() {
        return UUID.randomUUID().toString();
    }

    public static String generateCardNumber() {
        Random r = new Random();
        long randomNumber = r.nextLong() % 10000000000000000L + 1000000000000000L;
        return randomNumber + "";
    }
}
