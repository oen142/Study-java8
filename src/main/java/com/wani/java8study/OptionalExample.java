package com.wani.java8study;

import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {
        Optional<String> cls1 = Optional.empty(); //널값을 주입한다. 초기화 목적
        String str = null;
        Optional<String> cls2 = Optional.ofNullable(str);//널값도 허용한다.

        System.out.println("cls1 = " + cls1.isPresent());
        System.out.println("cls2 = " + cls2.isPresent()); //널값이 있는지 확인


        System.out.println("cls1 orElse : " + cls1.orElse("null")); //optional 변수의 널값이 있으면  null 스트링 출력
        System.out.println("cls2 orElseGet : " + cls2.orElseGet(() -> {
            int i = 0;
            return "i";
        }));


    }

    /*
     * 널포인터 익셉션
     * 널값을 최대한 없애보고자 하는 노력을 했다.
     *
     * */
}
