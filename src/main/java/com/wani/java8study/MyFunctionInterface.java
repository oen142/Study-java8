package com.wani.java8study;

public class MyFunctionInterface {

    public static void main(String[] args) {
        println("Area is ", 12, 20, (message, length, width) -> message + (length * width));
    }

    private static <T1, T2, T3> void println(T1 t1, T2 t2, T3 t3, Function3<T1, T2, T3, String> function) {
        System.out.println(function.apply(t1, t2, t3));
    }

    /*
     * 제너릭 공부
     * 스태틱에서 스태틱 참조 불가능 이유
     * 박싱 언박싱 오토언박싱
     * */
}
