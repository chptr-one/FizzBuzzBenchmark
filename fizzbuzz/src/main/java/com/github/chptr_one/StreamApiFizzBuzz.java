package com.github.chptr_one;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamApiFizzBuzz implements FizzBuzz {

    private final Map<Integer, String> replacements;
    private final List<Integer> sortedDividers;

    public StreamApiFizzBuzz() {
        this.replacements = Map.of(
                3, "Fizz",
                5, "Buzz",
                15, "FizzBuzz");

        this.sortedDividers = replacements.keySet()
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    private String numberToString(int n) {
        return sortedDividers.stream()
                .filter(div -> n % div == 0)
                .findFirst()
                .map(replacements::get)
                .orElse(String.valueOf(n));
    }

    @Override
    public void print(int upperLimitIncluded) {
        IntStream.rangeClosed(1, upperLimitIncluded)
                .mapToObj(this::numberToString)
                .forEach(System.out::println);
    }
}
