package com.wani.java8study.inter;

public interface Foo {
    /*
     * 요구 사항 추가 할경우
     * 모든 클래스에서 컴파일 에러가 발생함
     * default로 추가 가능
     *
     * */

    void printName();

    /*
    * 기능이 제대로 동작할 생각하지 마라
    * */

    /*
    * @implSpec 이 구현체는 getName() 으로 가져온 문자열을 대문자로 출력한다.
    * */
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }
    /*
    * 재정의 가 가능하다.
    * */

    String getName();

    /*
    *
    *   Interface Collection
    *   default boolean removeIf(Predicate<? super E> filter) {
        Objects.requireNonNull(filter);
        boolean removed = false;
        final Iterator<E> each = iterator();
        while (each.hasNext()) {
            if (filter.test(each.next())) {
                each.remove();
                removed = true;
            }
        }
        return removed;
    }

    * */

    /*
    * Default method 'toString' overrides a member of 'java.lang.Object'
    * */
    String toString();
    /*
    * 인터페이스에서 선언한 toString은  Object가 제공하는것이랑은 다르다.
    * */

    static void printAnyThing(){
        System.out.println("FOO");
    }
}
