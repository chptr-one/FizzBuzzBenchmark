package com.github.chptr_one;

public class CachedFizzBuzz implements FizzBuzz {
    private static final String[] cache = {
            null,
            null,
            "Fizz",
            null,
            "Buzz",
            "Fizz",
            null,
            null,
            "Fizz",
            "Buzz",
            null,
            "Fizz",
            null,
            null,
            "FizzBuzz"};

    @Override
    public void print(int upperLimitIncluded) {
        for (int i = 0; i < upperLimitIncluded; i++) {
            System.out.println(cache[i % 15] == null ? i + 1 : cache[i % 15]);
        }
    }
}
