package com.winterbe.java8.samples.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @author Benjamin Winterberg
 */
public class Lambda1 {

    public static void main(String[] args) {

          List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

          Collections.sort(names, new Comparator<String>() {
              @Override
              public int compare(String o1, String o2) {
                  return o1.compareTo(o2);
              }
          });

        names.forEach(System.out::println);

        Collections.sort(names, (String s1, String s2) -> {
            return s1.compareTo(s2);
        });

        names.forEach(System.out::println);

        Collections.sort(names, (String s1, String s2) ->  s1.compareTo(s2));

        names.forEach(System.out::println);

        Collections.sort(names, ( s1,  s2) ->  s1.compareTo(s2));

        names.forEach(System.out::println);

        names.sort(Collections.reverseOrder());

        names.forEach(System.out::println);

          List<String> names2 = Arrays.asList("peter", null, "anna", "mike", "xenia");

          names2.sort(Comparator.nullsLast(String::compareTo));
        names2.forEach(System.out::println);

         List<String> names3 = null;

         Optional.of(names3).ifPresent(list -> list.sort(Comparator.naturalOrder()));

        System.out.println(names3);
//
//        List<String> names3 = null;
//
//        Optional.ofNullable(names3).ifPresent(list -> list.sort(Comparator.naturalOrder()));
//
//        System.out.println(names3);
    }

}