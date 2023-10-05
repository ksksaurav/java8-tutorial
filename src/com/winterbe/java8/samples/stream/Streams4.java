package com.winterbe.java8.samples.stream;

import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * @author Benjamin Winterberg
 */
public class Streams4 {

    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            if (i % 2 == 1) {
//                System.out.println(i);
//            }
//        }

        IntStream.range(0,10)
                        .forEach( i -> {
                            if (i%2==1) System.out.println(i);
                        });
//        IntStream.range(0, 10)
//            .forEach(i -> {
//                if (i % 2 == 1) System.out.println(i);
//            });

        IntStream.range(0,10).filter(i -> i%2==1)
                        .forEach(System.out::println);
//        IntStream.range(0, 10)
//            .filter(i -> i % 2 == 1)
//            .forEach(System.out::println);

        OptionalInt reduce = IntStream.range(0, 10).reduce((a, b) -> a + b);
//        OptionalInt reduced1 =
//            IntStream.range(0, 10)
//                .reduce((a, b) -> a + b);

        System.out.println("The value of summation " + reduce.getAsInt());

        int reduce1 = IntStream.range(0, 10).reduce(10, (a, b) -> a + b);
//        int reduced2 =
//            IntStream.range(0, 10)
//                .reduce(7, (a, b) -> a + b);
        System.out.println(reduce1);
    }
}
