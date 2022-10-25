# FizzBuzzBenchmark

The famous [FizzBazz](https://en.wikipedia.org/wiki/Fizz_buzz) assignment is often given for job interviews. You can
think of a huge number of approaches to solving this problem. But which one is really the best in terms of execution
speed?

I wanted to have facts when discussing the assignment with the interviewer. Therefore, I made several different
solutions and performed performance measurements.

I find it surprising that no attempts to speed up the naive algorithm have been successful. Actually all my optimized
solutions are a little slower.

A naive algorithm means this

```
for (int i = 1; i <= upperLimitIncluded; i++) {
    boolean divisibleBy3 = (i % 3 == 0);
    boolean divisibleBy5 = (i % 5 == 0);

    if (divisibleBy3 && divisibleBy5) {
        System.out.println("FizzBuzz");
    } else if (divisibleBy3) {
        System.out.println("Fizz");
    } else if (divisibleBy5) {
        System.out.println("Buzz");
    } else {
        System.out.println(i);
    }
}
```

## The project used

Java 15, Maven, [jmh](https://github.com/openjdk/jmh)

## To compile the project

1. Compile fizzbuzz project

```
cd ./fizzbuzz
mvn install
```

2. Compile benchmark to executable jar

```
cd ../test
mvn install
```

## To run a benchmark

```
java -jar target/benchmark.jar 
```

