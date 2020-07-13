package com.wani.java8study.back;

@FunctionalInterface
public interface RunSomething {

    int doIt(int number);

    static void printName(){
        System.out.println("Wani");
    }
    default void printAge(){
        System.out.println("25");
    }
}

