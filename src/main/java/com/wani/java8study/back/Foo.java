package com.wani.java8study.back;

import java.util.function.*;

public class Foo {
    public static void main(String[] args) {
        // 익명 내부 클래스 anonymous inner class
     /*   RunSomething runSomething = (number)-> number +10;
        System.out.println(runSomething.doIt(10));


        Plus10 plus10 = new Plus10();
        System.out.println(plus10.apply(1));*/

        Function<Integer, Integer> plus = i -> i + 10;
        Function<Integer, Integer> multiply2 = i -> i * 2;

        /*
         * 조합이 가능하다.
         * 입력값을 가지고 결과를 만들고 그 입력값으로 플러스 한다.
         * */

        Function<Integer, Integer> multiply2AndPlus10 = plus.andThen(multiply2);


        System.out.println(multiply2AndPlus10.apply(10));

        Consumer<Integer> printT = System.out::println;
        printT.accept(10);

        Supplier<Integer> supplier = () -> 10;

        Predicate<String> startsWithKims = (s) -> s.startsWith("kims");
        Predicate<Integer> isEven = (i) -> i % 2 == 0;

        UnaryOperator<Integer> plus10 = (i) -> i+10;

    }
}
