package com.wani.java8study.functional;

public class BigDecimal {

    public static void main(String[] args) {

        BigDecimalToCurrency bigDecimalToCurrency = bd -> "$" + bd.toString();
        String s = bigDecimalToCurrency.toCurrency(new java.math.BigDecimal("120.00"));
        System.out.println("s = " + s);



        /*final InvalidFunctionalInterface invalidFunctionalInterface = value -> value.toString();
        String s1 = invalidFunctionalInterface.mkString(123);
        System.out.println("s1 = " + s1);*/

    }
}
