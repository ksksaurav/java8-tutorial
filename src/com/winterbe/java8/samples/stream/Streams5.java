package com.winterbe.java8.samples.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;
import static java.lang.System.*;

/**
 * Testing the order of execution.
 *
 * @author Benjamin Winterberg
 */
public class Streams5 {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("d2", "a2", "b1", "b3", "c");
//        List<String> strings =
//            Arrays.asList("d2", "a2", "b1", "b3", "c");

       // test1(strings);
//        test2(strings);
//        test3(strings);
//        test4(strings);
//        test5(strings);
//        test6(strings);
//        test7(strings);
        test8(strings);
    }

    private static void test8(List<String> stringCollection) {


        Supplier<Stream<String>> streamSupplier = () -> stringCollection
                .stream()
                .filter((s -> s.startsWith("a")));


//        Supplier<Stream<String>> streamSupplier =
//            () -> stringCollection
//                .stream()
//                .filter(s -> s.startsWith("a"));

        boolean d = streamSupplier.get().anyMatch(s -> {
            out.println(s);
            return s.startsWith("d");
        });

        boolean l = streamSupplier.get().noneMatch(s -> {
            out.println(s);
            return s.startsWith("k");
        });

         out.println(" The value of b and l " + d + " :"+l );
//        streamSupplier.get().anyMatch(s -> true);
//        streamSupplier.get().noneMatch(s -> true);
    }

    // stream has already been operated upon or closed
    private static void test7(List<String> stringCollection) {

        stringCollection.stream().forEach(out::println);

        Stream<String> stream = stringCollection
                .stream()
                .filter(s -> s.startsWith("a"));
//        Stream<String> stream = stringCollection
//            .stream()
//            .filter(s -> s.startsWith("a"));
//         Stream<String> out = stream;
          out.println(" The value of anyMatch is  " +stream.anyMatch(s->{
              out.println(s);return true;}));
        Stream<String> stream1 = stringCollection
                .stream()
                .filter(s -> s.startsWith("a"));
          out.println("The value of nonematch " + stream1.noneMatch(s-> {
              out.println(s);
              return s.startsWith("b");
          }));
//        stream.anyMatch(s -> true);
//        stream.noneMatch(s -> true);
    }

    // short-circuit
    private static void test6(List<String> stringCollection) {

        stringCollection
                .stream()
                        .map(s->{
                            out.println("map : %s "+s);
                            return s.toUpperCase();
                        })
                                .anyMatch(s-> {
                                    out.println("anyMatch : "+s);
                                    return s.startsWith("A");
                                });

//        stringCollection
//            .stream()
//            .map(s -> {
//                System.out.println("map:      " + s);
//                return s.toUpperCase();
//            })
//            .anyMatch(s -> {
//                System.out.println("anyMatch: " + s);
//                return s.startsWith("A");
//            });
    }

    private static void test5(List<String> stringCollection) {



        stringCollection
            .stream()
            .filter(s -> {
                System.out.println("filter:  " + s);
                return s.toLowerCase().startsWith("a");
            })
            .sorted((s1, s2) -> {
                System.out.printf("sort:    %s; %s\n", s1, s2);
                return s1.compareTo(s2);
            })
            .map(s -> {
                System.out.println("map:     " + s);
                return s.toUpperCase();
            })
            .forEach(s -> System.out.println("forEach: " + s));
    }

    // sorted = horizontal
    private static void test4(List<String> stringCollection) {

        stringCollection
            .stream()
            .sorted((s1, s2) -> {
                System.out.printf("sort:    %s; %s\n", s1, s2);
                return s1.compareTo(s2);
            })
            .filter(s -> {
                System.out.println("filter:  " + s);
                return s.toLowerCase().startsWith("a");
            })
            .map(s -> {
                System.out.println("map:     " + s);
                return s.toUpperCase();
            })
            .forEach(s -> System.out.println("forEach: " + s));
    }

    private static void test3(List<String> stringCollection) {


        stringCollection
            .stream()
            .filter(s -> {
                System.out.println("filter:  " + s);
                return s.startsWith("a");
            })
            .map(s -> {
                System.out.println("map:     " + s);
                return s.toUpperCase();
            })
            .forEach(s -> System.out.println("forEach: " + s));
    }

    private static void test2(List<String> stringCollection) {
        stringCollection
                .stream()
                        .map(s -> {
                            System.out.println("Map :  "+ s);
                            return s.toUpperCase();
                        })
                                .filter(s->{
                                    System.out.println("Filter is : "+ s);
                                    return  s.startsWith("A");
                                })
                                        .forEach(s -> System.out.println("ForEach : "+s));


//        stringCollection
//            .stream()
//            .map(s -> {
//                System.out.println("map:     " + s);
//                return s.toUpperCase();
//            })
//            .filter(s -> {
//                System.out.println("filter:  " + s);
//                return s.startsWith("A");
//            })
//            .forEach(s -> System.out.println("forEach: " + s));
    }

    private static void test1(List<String> stringCollection) {
        stringCollection
                .stream()
                        .filter(s->{
                            //System.out.println("filter : "+ s);
                            return true;
                        })
                                .forEach(s-> System.out.println("ForEach : "+ s));
//        stringCollection
//            .stream()
//            .filter(s -> {
//                System.out.println("filter:  " + s);
//                return true;
//            })
//            .forEach(s -> System.out.println("forEach: " + s));
    }

}