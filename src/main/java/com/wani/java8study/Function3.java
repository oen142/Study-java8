package com.wani.java8study;

@FunctionalInterface
public interface Function3<T1 ,T2 ,T3 , R>{
    R apply(T1 t1, T2 t2, T3 t3);

    //void print(int i);
}
