package com.winterbe.java8.samples.lambda;

/**
 * @author Benjamin Winterberg
 */
public class Interface1 {

    interface Formula {
        double calculate(int a);

        default double sqrt(int a) {
            return Math.sqrt(positive(a));
        }

         static int positive(int a) {
            return a > 0 ? a : 0;
        }
    }

    public static void main(String[] args) {
        // this is the implementation of the interface formula
//        Formula formula1 = new Formula() {
//            @Override
//            public double calculate(int a) {
//                return sqrt(a * 100);
//            }
//        };

        Formula formula1 = new Formula(){

            @Override
            public double calculate(int a) {
                return sqrt(a*100);
            }
        };

          System.out.println(formula1.calculate(100));
        System.out.println(formula1.sqrt(100));
        System.out.println(formula1.calculate(-23));
        System.out.println(Formula.positive(-23));

//        Formula formula2 = (a) -> sqrt(a*100);
//
//        System.out.println(formula2.calculate(100));
//        System.out.println(formula2.sqrt(100));
//        System.out.println(formula2.calculate(-23));
//        System.out.println(Formula.positive(-23));

//        formula1.calculate(100);     // 100.0
//        formula1.sqrt(-23);          // 0.0
//        Formula.positive(-4);        // 0.0

//        Formula formula2 = (a) -> sqrt( a * 100);
    }

}