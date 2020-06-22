package com.wani.java8study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

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

        final Function<Integer, Integer> identity = Function.identity();
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


        Predicate<Integer> isPositive = integer -> integer > 0;

        List<Integer> numbers = Arrays.asList(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5);

        List<Integer> filter = filter(numbers, isPositive);
        System.out.println("filter = " + filter);

        List<Integer> positiveNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (isPositive.test(number)) {
                positiveNumbers.add(number);

            }
        }
        System.out.println("positive integers:" + positiveNumbers);


        final Supplier<String> helloSupplier = () -> "Hello ";

        String s = helloSupplier.get();
        System.out.println("s = " + s);


        long start = System.currentTimeMillis();

        suppliedIndex(0, FunctionalInterfaceExamples::getVeryExpensiveValue);
        suppliedIndex(-1, () -> getVeryExpensiveValue());
        suppliedIndex(-2, () -> getVeryExpensiveValue());

        System.out.println("It took " + ((System.currentTimeMillis() - start) / 1000));
    }
    /*
     * 자바에서는 함수타입을 도입한게 아니기 때문에
     * 일반 오브젝트 사용한다.
     * */


    /*
     * Predicate
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

    private static <T> List<T> filter(List<T> list, Predicate<T> filter) {
        List<T> result = new ArrayList<>();
        for (T input : list) {
            if (filter.test(input)) {
                result.add(input);
            }
        }

        return result;
    }

    /*
     * Supplier
     * */

    private static void printIfValidIndex(int number, String value) {
        if (number >= 0) {
            System.out.println("The value is " + value + ".");
        } else {
            System.out.println("Invalid");
        }
    }

    private static String getVeryExpensiveValue() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Let' just say it has very expensive calculation here;
        return "Wani";
    }

    private static void suppliedIndex(int number, Supplier<String> valueSupplier) {
        if (number >= 0) {
            System.out.println("The value is " + valueSupplier.get() + ".");
        } else {
            System.out.println("Invalid");
        }
    }
}

