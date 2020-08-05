package com.wani.java8study.back;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {
    public static void main(String[] args) {
        IntFunction<String> intToString = i -> "number";

        /*
         * 문자열을 넣고 문자열을 받을때
         * 하는일이 static hi랑 똑같을때
         * static 을 이렇게 쓸수 있다.
         * 콜론이 두개 찍혀있으면 메소드 레퍼런스
         * */
        UnaryOperator<String> hi = Greeting::hi;

        Greeting greeting = new Greeting();

        /*
         *
         * */
        UnaryOperator<String> hello = greeting::hello;

        hello.apply("kims");
        /*
         * 생성자를 참조 할 수 있다.
         * 생성자를 생성할때 리턴 타입은 객체의 타입이다.
         * 입력값은 없는데 결과값은 있는것
         * Supplier
         * */

        Supplier<Greeting> newGreeting = Greeting::new;
        /*
         * 아무것도 일어나지 않고, get 을 호출해야한다.
         * */
        Greeting greeting1 = newGreeting.get();
        System.out.println("greeting1 = " + greeting.getName());
        /*
         * 문자열 하나를 받고 Greeting 을 반환
         * 레퍼런스는 같아보이지만 생성자는 다른걸 쓴다.
         * */
        Function<String, Greeting> kimsGreeting = Greeting::new;
        Greeting tt = kimsGreeting.apply("tt");
        System.out.println("tt = " + tt.getName());


        String[] names = {"kim", "lee", "pack"};
        Arrays.sort(names,String::compareToIgnoreCase);
        /*
        * 임의의 객체에 인스턴스 메서드를 참조한다.
        * 인스턴스 메서드를 사용한다.
        * */
        for (String name : names) {
            System.out.println("name = " + name);
        }
        /*
         * java8부터 comparator가 functional interface 로 바꼈다
         * 람다로 대체가 가능하다.
         * */
    }
}
