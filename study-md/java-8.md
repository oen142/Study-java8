1. Java8 in Action 정리


1. 자바 8을 눈여겨봐야하는 이유

Java8의 핵심은 간결한 코드와 멀티고어 프로세서의 간단한 활용이다.

- 왜 변화하는가?
    - 모든 언어는 장단점을 가지고 있다.
    - 진화하지 않은 기존 언어는 사장된다.
    - 새로 프로그래밍을 배우는 사람은 자연스럽게 새로운 언어를 선택하게 되며 기존 언어는 도태된다.
    
- 자바가 성공한 이유는
    - 모든것은 객체다.
    - 한번 작성하면 어디서든 실행할 수 있다. JVM위에서
    - 초빈엔 JVM으로 인해 실행 시간이 느렸지만 하드웨어가 발전하면서 프로그래머의 시간이 더 중요 요소로
    부각되었다.
    
- Java8에서 제공하는 세가지 프로그래밍 개념
    - 스트림처리
    - 동작 파라미터화로 메서드에 코드 전달하기
    - 병렬성과 공유 가변 데이터
- JAVA 함수
    -메서드와 람다를 일급 시민으로 만들자.
        - 일급 시민 : 전달할수 있는값
        - 이급 시만 : 전달할 수 없는 값. 이전 자바의 메서드 클래스등
    - 메서드 레퍼런스 ::
    - 람다 익명함수
    
- 스트림
- 디폴트 메서드
- 함수형 프로그램에서 가져온 아이디어
    - 메서드와 람다를 일급값으로 사용하자.
    - 가번 공유 상태가 없는 병렬 실행을 이용해서 효율적이고 안전하게 함수나 메서드를 호출하자.
- 람다가 몇줄 이상으로 길어진다면
    - 익명 람다보다는 코드가 수행하는 일을 잘 설명하는 이름을 가진 메서드를 정의하고 메서드 레퍼런스를 활용하는것이
    바람직하다.
    - 코드의 명확성이 더 중요하기 때문이다.
    
2. 동작 파라미터 화 코드를 전달하기
- 동작파라미터화
    - behavior parameterization
    - 아직 어떻게 실행할 것인지 결정하지 않은 코드 블럭을 의미한다.
    - 전략 디자인 패턴을 구현하는 방법
    - Predicate<t> (boolean을 반환하는 함수)를 사용해서 구현
    - 클래스나 익명 클래스로도 구현이 가능하지만 장황하다.
    - 람다로 구현하는게 유연하고 간결함.
    
- 코드의 장황함은 나쁜 특성이다.
    - 장황한 코드는 구현하고 유지보수 하는데 시간이 오래 걸릴 뿐아니라 읽는 즐거움을 빼앗는 요소로 개발자로부터 외면받는다
    

3. 람다 표현식
- 람다
    - 메서드로 전달할 수 있는 익명 함수를 단순화 한것.
    - 익명, 함수, 전달가능, 간결함
    
(String s) -> s.length();
(Apple a) -> a.getWeight > 150;

(int x , int y) ->{
    System.out.print(x+y);
}


() -> 42;
() -> new Apple(10);


함수형 인터페이스

- functional interface
- 정확히 하나의 추상 메서드만 지정하는 인터페이스
- 함수형 인터페이스를 가리키는 어노테이션 @FunctionalInterface
- 람다 표현식으로 함수형 인터페이스의 추상 메서드를 구현할수있다.
- 함수형 인터페이스를 인수로 받는 메서드에만 람다식을 표현할수 있다.
    - 자바에 함수 형식을 추가하는 방법도 고려했지만 언어를 더 복잡하게 만드는 것 같아 선택을 안했다.
    - 대부분 자바 프로그래머는 하나의 추상 메서드를 갖는 인터페이스에 이미 익숙하다는 점도 고려
- 함수 디스크립터
    - function descriptor
    - 함수형 인터페이스의 추상 메서드 시그니처
    - 함수형 인터페이스의 추상 메서드 시크니처는 람다 표현식의 시그니쳐를 가르킨다.
    - 즉 람다 표현식의 시그니처를 서술하는 메서드를 함수 디스크립터라고 부른다.
 
 
- 자바의 모든 형식은 참조형 아니면 기본형
    - 참조형
        - reference type
        - Byte , Integer , Object ,List
    - 기본형
        - primitive type
        - int , double , byte , char
        
    - 제너릭 파라미터에는 참조형만 사용 가능
        - 제네릭의 내부 규현때문에 어쩔수가 없다.
    - 기본형 -> 참조형으로 변환 : 박싱
    - 참조형 -> 기본형으로 변환 : 언박싱
    - 박싱과 언박싱이 자동으로 이루어지는 오토박싱
        -물록 변환 과정에 비용 소모
        - 박싱한 값은 기본형을 감싸는 래퍼 형태, 힙에 저장
        - 따라서 박싱한 값은 메모리를 더 소비하여 기본형을 가져올 때도 메모리를 탐색하는 과정이 필요
- 람다 표현식의 파라미터 형식 추론
    - 상황에 따라 형식을 포함하는게 좋을때도 있고 생략하는게 좋을 때도 있다.
    - 어떤게 가독성이 더 좋은지를 보고 판단하자.
    
1. 형식검사 , 형식추론, 제약

    - 람다가 사용되는 context를 이용해서 람다의 type을 추론할수있음.
    - 익명 함수처럼 람다도 자유 변수를 활용할 수 있음
        - 이와 같은 동작을 람다 캡쳐링이라고 부른다.
        - 자유변수
            - free variable
            - 파라미터로 넘겨진 변수가 아닌 외부에서 정의된 변수
        - 단 final 변수와 똑같이 사용해야한다.
            - 인스턴스 변수는 힙에 저장.
            - ㅈ반면 지역변수는 스택에 위치
            - 람다에서 지역변수에 바로 접근하는 경우
                - 변수를 할당한 스레드가 사라지면 변수도 해제되는데
                - 람다를 실행하는 스레드에서 변수에 접근하려는 시도가 있을수도 잇음.
                - 따라서 제약을 만들었다.
                
                    
        
메서드 레퍼런스
- 특정 메서드만을 호출하는 람다의 축약형
- 가독성을 높일수 있다.
- 메서드명 앞에 구분자 :: 를 붙이는 방식


(Apple a) -> a.getWeight
Apple::getWeight

() -> Thread.currentThread().dumpStack()
Thread.currentThread()::dumpStack

(str,i) -> str.substring(i)
String::subString

(String s) -> System.out.println(s)
System.out::println

() -> expensiveTransaction.getValue()
expensiveTransaction::getValue

Apple::new;


4. 스트림 소개
- 스트림이란 데이터 처리 연산을 지원하는 소스에서 추출된 연속된 요소
- 중간연산
- 최종연산

5. 스트림 활용

- 필터링과 슬라이싱
    - filter
        - .filter(Dish::isVegetarian)
        - .filter(i -> i%2 ==0)
    - distinct
        - 고유한 요소 필터링
        - .distinct
        
    - limit
        - 스트림 축소
        - .limit(3)
    - skip
        - 요소 건너뛰기
        - .skip(2)
        
- 매핑
    - map
        - 스트림의 각 요소에 함수 적용하기
        - .map(Dish::getName)
        - .map(String::length)
        - .map(n -> n*n)
        
    - flapMap
        - 스트림 평면화
        - 스트림의 각 값을 다른 스트림으로 만든 다음에 모든 스트림을 하나의 스트림으로 연결
        - .flapMap(Arrays::stream)
        
- 검색과 매칭
    - anyMatch
        - 적어도 한 요소와 일치하는지 검사
        - 최종연산
        - .anyMatch(Dish::isVegetarian)
    - allMatch
        - 모든 요소와 일치하는지 검사
        - 최종연산
        - .allMatch(d -> d.getCalories() < 1000)
        
    - noneMatch
        - 일치하는 요소가 없는지 검사
        - 최종 연산
        - .nonMatch(d -> d.getCalories() < 1000)
    - 쇼트서킷
        - 자바의 && , || 같은 연산
        - 하나라도 거짓이라는 결과가 나오면 나머지 표현식은 평가하지 않고 결과를 반환하는 상황을 부르는 말
        - anyMatch, allMatch , noneMatch , limit 등은 쇼트 서킷
    - findAny
        - 임의의 요소를 반환, 랜덤
        - 최종 연산
        - .findAny()
        - 아무 요소도 반환하지 않을 수 있음
        - 그래서 null 대신 Optional<T> 를 반환
    - Optional
        - null은 쉽게 에러를 만들 수 있으므로 대신 사용
        - isPresent() : 값이 있는가 여부
        - ifPresent(Consumer<T> block) : 값이 있으면 주어진 블록 실행
        - T get() : 값이 있으면 반환, 없으면 NoSuchElementException
        - T orElse(T other) : 값이 있으면 반환 , 없으면 기본값 반환
        
            menu.stream()
                .filter(Dish::isVegetarian)
                .findAny
                .ifPresent(d -> System.out.println(d.getName()));
                
    - findFirst
        - 첫번째 요소 찾기
        - Optional<T>를 반환
        - .findFirst()
        
리듀싱
- 모든 스트림 요소를 처리해서 값을 도출
    - 함수형 프로그래밍 언어로는 종이를 작은 조각이 될 때까지 반복해서 접는 것과 비슷하다는 의미로 폴드 fold라고 부름
- 합 구하기
    int sum = numbers.stream().reduce(0 , (a,b)->a +b);
    - 초기값이 없으면
        Optional<Integer> sum = numbers.stream()
                                    .reduce((a,b) -> a+b);

- 최대값 구하기
    Optional<Integer> max = numbers.stream()
                                    .reduce(Integer::max);


숫자 스트림
- 기본형 특화 스트림
    - 박싱 비용을 피하기 위해 제공
    - IntStream , DoubleStream, LongStream
    - .mapToInt(Dish::getCalories)
    - max, mim, average 등 다양한 유틸리티 메서드 지원
    - 객체 스트림으로 복원하려면
        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> stream = intStream.boxed();
    - 스트림에 요소가 없을때 기본값
    - OptionalInt , OptionalDouble , OptionalLong
        OptionalInt maxCalories = menu.stream().mapToInt(Dish::getCalories).max();
        int max = maxCalories.orElse(1);
- 숫자 범위
    - .range(1 , 100) : 1과 100은 미포함
    - .rangeClosed(1, 100) : 모두 포함
- 스트림 만들기
    - 값으로 만들기
        Stream.of("java8" , "lambdas" , "in" , "action")
        Stream.empty()
    - 배열로 만들기
        int[]  numbers = {2,3,5,7,11,13}
        int sum = Arrays.stream(numbers).sum();
    - 파일로 만들기
        Stream<String> line = Files.lines(Paths.get("data.txt"), Charset.defaultCharset());
        long uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                              .distinct()
                              .count();
    - 함수로 만들기
        - 무한스트림 infinite stream 즉 크기가 고정되지 않은 스트림
        - 언바운드 스트림 unbound stream 이라고 표현                                
    