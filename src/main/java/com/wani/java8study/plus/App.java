package com.wani.java8study.plus;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("kim");
        name.add("foo");
        name.add("bar");
        name.add("keesun");

        name.forEach(System.out::println);

        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();

        while (spliterator.tryAdvance(System.out::println)) ;
        System.out.println("==================");
        while (spliterator1.tryAdvance(System.out::println)) ;


        long k = name.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("K"))
                .count();
        System.out.println("k = " + k);

        name.removeIf(s -> s.startsWith("k"));

        System.out.println("==================");
        name.forEach(System.out::println);
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;

        //name.sort(compareToIgnoreCase.reversed().thenComparing());

        /*
        * API의 설계와 변화가 생겼다.
        *
        * */
    }
}
