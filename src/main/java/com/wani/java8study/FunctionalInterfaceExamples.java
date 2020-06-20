package com.wani.java8study;

import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionalInterfaceExamples {

    /*
     * 2.md
     *
     * T -> R
     * 매퍼 펑션
     *
     * T -> T
     * identity function
     * 그 타입을 받아서 바로 리턴하면 identity function
     * */



    public static void main(String[] args) {
        final Function<String, Integer> toInt = value -> Integer.parseInt(value);
        Integer apply = toInt.apply("100");
        System.out.println("apply = " + apply);

        final Function<Integer ,Integer> identity = Function.identity();
        Integer apply1 = identity.apply(999);
        System.out.println("apply1 = " + apply1);

        final Consumer<String> print = value -> {
            System.out.println("s = " + value);
            System.out.println("s = " + value);
            System.out.println("s = " + value);
            System.out.println("s = " + value);
        };
//        final Function<String , Void> print2 = value -> System.out.println("value = " + value);
        print.accept("tttt");
    }
    /*
     * 자바에서는 함수타입을 도입한게 아니기 때문에
     * 일반 오브젝트 사용한다.
     * */

    public int toInt(String value) {
        return Integer.parseInt(value);
    }

    //not identity function
    public String f(String value) {
        return "value is " + value;
    }

    //identity function
    /*
     * 그냥 쓰면 되지
     *
     * */
    public String identity(String value) {
        return value;
    }
}
