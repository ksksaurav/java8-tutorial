package com.winterbe.java8.samples.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Benjamin Winterberg
 */
public class Streams1 {

    public static void main(String[] args) {

        //List<String> stringCollection = new ArrayList<>();
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");
        stringCollection.add("eee1");


        // filtering
        //Filtering
        stringCollection
                .stream()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);

//        stringCollection
//                .stream()
//                .filter((s) -> s.startsWith("a"))
//                .forEach(System.out::println);

        // "aaa2", "aaa1"


        // sorting
        System.out.println("Operation 2 ");
        stringCollection
                .stream()
                .sorted()
                .filter((s)-> s.startsWith("a"))
                .forEach(System.out::println);
//        stringCollection
//                .stream()
//                .sorted()
//                .filter((s) -> s.startsWith("a"))
//                .forEach(System.out::println);

        // "aaa1", "aaa2"


        // mapping
        System.out.println("Operation 3 starts");
        stringCollection
                .stream()
                        .map(String::toUpperCase)
                                .sorted((a,b) -> a.compareTo(b))
                                        .forEach(System.out::println);
//        stringCollection
//                .stream()
//                .map(String::toUpperCase)
//                .sorted((a, b) -> b.compareTo(a))
//                .forEach(System.out::println);

        // "DDD2", "DDD1", "CCC", "BBB3", "BBB2", "AAA2", "AAA1"

        System.out.println("Operation 3 ends here ");
        // matching

        System.out.println("Operation 4 start here ");

        boolean anyStartWithA = stringCollection
                .stream()
                .anyMatch((s) -> s.startsWith("a"));

//        boolean anyStartsWithA = stringCollection
//                .stream()
//                .anyMatch((s) -> s.startsWith("a"));

        System.out.println(anyStartWithA);      // true

        boolean allStartWithA = stringCollection
                .stream()
                .allMatch((s) -> s.startsWith("a"));
//        boolean allStartsWithA = stringCollection
//                .stream()
//                .allMatch((s) -> s.startsWith("a"));

        System.out.println(allStartWithA);      // false

        boolean noneStartsWithZ = stringCollection
                .stream()
                .noneMatch((s) -> s.startsWith("z"));
//        boolean noneStartsWithZ = stringCollection
//                .stream()
//                .noneMatch((s) -> s.startsWith("z"));

        System.out.println(noneStartsWithZ);      // true


        // counting
        long countofb = stringCollection
                .stream()
                .filter((s) -> s.startsWith("b"))
                .count();
//        long startsWithB = stringCollection
//                .stream()
//                .filter((s) -> s.startsWith("b"))
//                .count();

        System.out.println("Count of b "+ countofb);    // 3


        // reducing

        Optional<String> reduce = stringCollection
                .stream()
                .sorted()
                .reduce((s1, s2) -> s1 + "##" + s2);

//        Optional<String> reduced =
//                stringCollection
//                        .stream()
//                        .sorted()
//                        .reduce((s1, s2) -> s1 + "#" + s2);

        reduce.ifPresent(System.out::println);

//        reduced.ifPresent(System.out::println);
        // "aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2"


    }

}
