package com.github.chptr_one;

public class NaiveFizzBuzz implements FizzBuzz {

    @Override
    public void print(int upperLimitIncluded) {

        for (int i = 1; i <= upperLimitIncluded; i++) {
            boolean divisibleBy3 = (i % 3 == 0);
            boolean divisibleBy5 = (i % 5 == 0);

            if (divisibleBy3 && divisibleBy5) {
                System.out.println("FizzBuzz");
            } else if (divisibleBy3) {
                System.out.println("Fizz");
            } else if (divisibleBy5) {
                System.out.println("Buzz");
            } else
                System.out.println(i);
        }
    }
}
