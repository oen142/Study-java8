package com.wani.java8study.inter;

public class App {
    public static void main(String[] args) {
        Foo foo = new DefaultFoo("kims");
        foo.printName();

        foo.printNameUpperCase();
        Foo.printAnyThing();
    }
}
