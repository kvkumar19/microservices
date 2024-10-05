package com.accounts.accounts.dto;

import java.util.Random;
import java.util.UUID;
import java.util.random.RandomGenerator;

public class GenerateRandom {

    public static String generateRandomNumber() {
        return UUID.randomUUID().toString();
    }

    public static String generateAccountNumber() {
        Random r = new Random();
        long randomNumber = r.nextLong() % 90000000000L + 10000000000L;
        return randomNumber + "";
    }
}
