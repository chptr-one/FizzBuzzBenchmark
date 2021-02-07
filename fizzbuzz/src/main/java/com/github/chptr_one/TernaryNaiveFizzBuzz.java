package com.github.chptr_one;

public class TernaryNaiveFizzBuzz implements FizzBuzz {

    @Override
    public void print(int upperLimitIncluded) {
        for (int i = 1; i <= upperLimitIncluded; i++) {
            System.out.println(
                    (i % 15 == 0) ? "FizzBuzz" :
                            (i % 3 == 0) ? "Fizz" :
                                    (i % 5 == 0) ? "Buzz" :
                                            i);
        }
    }
}
