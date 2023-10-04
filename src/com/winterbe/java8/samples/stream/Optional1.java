package com.winterbe.java8.samples.stream;

import java.util.Optional;

/**
 * @author Benjamin Winterberg
 */
import static java.lang.System.*;
public class Optional1 {


    public static void main(String[] args) {
        Optional<String> optional = Optional.ofNullable(null);

        optional.isPresent();           // true
        out.println(optional.isPresent() + " present or absent "+ optional.get() + " Or Else part "
        + optional.orElse("fallback"));
        optional.get();                 // "bam"
        optional.orElse("fallback");    // "bam"

        optional.ifPresent((s) -> out.print("Hello there "+s));
        optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"
    }

}