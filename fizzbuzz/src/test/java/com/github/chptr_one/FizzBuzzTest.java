package com.github.chptr_one;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class FizzBuzzTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    private static final String expectedOutput = """
            1
            2
            Fizz
            4
            Buzz
            Fizz
            7
            8
            Fizz
            Buzz
            11
            Fizz
            13
            14
            FizzBuzz
            16
            """;

    private static final int N = 16;

    private void testFizzBuzz(FizzBuzz fb) {
        fb.print(N);
        String actualOutput =  outContent.toString();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void naiveFizzBuzzTest() {
        testFizzBuzz(new NaiveFizzBuzz());
    }

    @Test
    public void ternaryNaiveFizzBuzzTest() {
        testFizzBuzz(new TernaryNaiveFizzBuzz());
    }

    @Test
    public void caseFizzBuzzTest() {
        testFizzBuzz(new CaseFizzBuzz());
    }

    @Test
    public void streamApiFizzBuzzTest() {
        testFizzBuzz(new StreamApiFizzBuzz());
    }

    @Test
    public void cachedFizzBuzzTest() {
        testFizzBuzz(new CachedFizzBuzz());
    }

    @Test
    public void stringConcatenationOptimizedFizzBuzz() {
        testFizzBuzz(new StringConcatenationFizzBuzz());
    }
}
