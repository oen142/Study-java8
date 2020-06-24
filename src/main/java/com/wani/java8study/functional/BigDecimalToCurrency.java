package com.wani.java8study.functional;

import java.math.BigDecimal;

@FunctionalInterface
public interface BigDecimalToCurrency {

    String toCurrency(BigDecimal value);




    /*
     * 제약사항
     * Functional Interface 람다메소드로 만들수 있기때문에
     * 작성을 해도 람다를 못쓰는 경우가 있다.
     * Functional Interface 메소드가 Genneral이면 사용 불가능
     *
     * */
}
