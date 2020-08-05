package com.wani.java8study.inter;

public interface Bar extends Foo{
    /*
    * 기본 구현체를 제공하기 싫을때
    * 추상 메소드로 선언을 하면 된다.
    * */

    void printNameUpperCase();
}
