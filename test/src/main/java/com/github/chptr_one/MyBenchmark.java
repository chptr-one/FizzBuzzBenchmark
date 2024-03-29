/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.github.chptr_one;

import org.openjdk.jmh.annotations.*;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

@Fork(value = 2)
@Warmup(iterations = 3)
@Measurement(iterations = 3)
@OutputTimeUnit(TimeUnit.SECONDS)

@SuppressWarnings("unused")
public class MyBenchmark {

    private final static int N = 1000;

    @State(Scope.Benchmark)
    public static class MyState {
        private PrintStream originalOut;

        @Setup
        public void doSetup() {
            originalOut = System.out;
            PrintStream dummyStream = new PrintStream(new OutputStream() {
                public void write(int b) {
                    // do nothing
                }
            });
            System.setOut(new PrintStream(dummyStream));
        }

        @TearDown
        public void doTearDown() {
            System.setOut(originalOut);
        }
    }

    @Benchmark
    public void naiveTest(MyState state) {
        new NaiveFizzBuzz().print(N);
    }

    @Benchmark
    public void ternaryNaiveTest(MyState state) {
        new TernaryNaiveFizzBuzz().print(N);
    }

    @Benchmark
    public void caseTest(MyState state) {
        new CaseFizzBuzz().print(N);
    }

    @Benchmark
    public void cachedTest(MyState state) {
        new CachedFizzBuzz().print(N);
    }

    @Benchmark
    public void streamApiTest(MyState state) {
        new StreamApiFizzBuzz().print(N);
    }

    @Benchmark
    public void stringConcatenationOptimizedTest(MyState state) {
        new StringConcatenationFizzBuzz().print(N);
    }
}