package com.wani.java8study.functional;

@FunctionalInterface
public interface InvalidFunctionalInterface {

    <T> String mkString(T value);
}
