package com.wani.java8study.inter;

/*
* 충돌될때 컴파일 에러가 발생한다.
* */
public class DefaultFoo implements Foo , DeferFoo , DeFoo{
    String name;

    public DefaultFoo(String name) {
        this.name = name;
    }

    /*
    * */
    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    /*
    * 재정의
    * */
    @Override
    public void printNameUpperCase() {
        System.out.println(this.name.toUpperCase());
    }
}
