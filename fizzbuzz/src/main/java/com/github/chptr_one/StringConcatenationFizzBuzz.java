package com.github.chptr_one;

public class StringConcatenationFizzBuzz implements FizzBuzz{
    @Override
    public void print(int upperLimitIncluded) {
        for (int i = 1; i <= upperLimitIncluded; i++) {
            boolean divisibleBy3 = (i % 3 == 0);
            boolean divisibleBy5 = (i % 5 == 0);

            String result = "";
            if (divisibleBy3) {
                result = "Fizz";
            }
            if (divisibleBy5) {
                result += "Buzz";
            }
            if (result.isEmpty()) {
                result = String.valueOf(i);
            }

            System.out.println(result);
        }
    }
}
