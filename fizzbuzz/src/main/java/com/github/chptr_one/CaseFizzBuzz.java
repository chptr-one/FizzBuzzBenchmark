package com.github.chptr_one;

public class CaseFizzBuzz implements FizzBuzz {

    @Override
    public void print(int upperLimitIncluded) {
        for (int i = 1; i <= upperLimitIncluded; i++) {
            switch (i % 15) {
                case 0 -> System.out.println("FizzBuzz");
                case 3, 6, 9, 12 -> System.out.println("Fizz");
                case 5, 10 -> System.out.println("Buzz");
                default -> System.out.println(i);
            }
        }
    }
}
