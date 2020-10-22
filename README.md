
## Spring MVC 
- `Model` : 데이터 처리
- `View`: 화면 담당
- `Controller` : 요청을 처리하는 부분으로 뷰와 모델 사이의 통신, 주로 사용자의 요청을 처리 한 후 지정된 뷰에 모델 객체를 넘겨주는 역할을 한다.

## Spring Derectory 구조
### src.main.java.hello.hellospring.(controller/comain/repository/service)
- controller : 외부 요청을 받음, 어떤 주소에서 어떤 방식으로 무엇을 요청하고 응답할 것인지
- domain : Member Class, getter/setter
- repository : 데이터 저장
    - MemberRepository(Interface)
    - MemoryMemberRepository(Class) : Member 객체를 store에 어떻게 저장, 검색, 리스트, 초기화 할 것인지
- service : MemberRepository를 이용하여 Member를 어떻게 가입시키고, 조회할 것인지 (서비스 차원), MemoryMemberRepository의 함수들 이용


                                      
## Spring Annotations
- bean : 스프링 컨테이너에 의해 만들어진 자바 객체
- @ : java annotation 
- @Controller : 해당 클래스를 controller로 지정
- @GetMapping : @RequestMapping(method = RequestMethod.GET) 의 축약형으로써, Get method 요청 지정
    - `@GetMapping("요청주소")`
- @RequestParam : 가져올 데이터의 이름 명시
    - `@RequestParam("가져올 데이터의 이름") [데이터타입] [가져온데이터를 담을 변수]`
- @ResponseBody : 서버에서 클라이언트로 응답 데이터를 전송하기 위해서 @ResponseBody 를 사용하여 자바 객체를 HTTP 응답 본문의 객체로 변환하여 클라이언트로 전송시키는 역할을 합니다.
- @RequestBody : 클라이언트에서 서버로 필요한 데이터를 전송하기 위해서 JSON이라는 데이터를 요청 본문에 담아서 서버로 보내면, 서버에서는 @RequestBody 어노테이션을 사용하여 HTTP 요청 본문에 담긴 값들을 자바 객체로 변환 시켜, 객체에 저장시킵니다.
- @Test : Junit을 사용한 단위 테스트 제공
- @BeforeEach, @AfterEach : 각각의 단위테스트 전,후에 처리될 메소드
- @Service,@Controller,@Repository : @Component의 특수한 케이스
- @Autowired : 

## Java Classes
### Optional
- NullPointException을 방지할 수 있도록 하는 클래스
- 빈 객체를 다음과 같이 생성할 수 있음
- `Optional<Object> obj=Optional.of("String)`
- `Optional<Object> obj=Optional.empty()`
- `.ifPresent()` : 객체가 있다면
- `.ofNullable(value)` : value가 null이 아니라고 확신할 수 없을 때

### List
- 리스트는 인터페이스이고 ArrayList, LinkedList 들은 List에 상속된 클래스

### Map, HashMap
- {key,value} 로 구성됨
- map.put(key,value)
- map.get(key)->지정된 key에 매핑된 value 반환
- map.values() -> Hashmap에 저장된 모든 값을 컬렉션 형태로 반환
- Map<K,V> is an interface, HashMap<K,V> is a class that implements Map
- ex) `private static Map<Long,Member> store = new HashMap<>();`


## functions
### assertThat
- import static org.assertj.core.api.Assertions.*;
- `assertThat(somthing1).isEqualto(somthing2)` 두 값이 동일한지 체크
- build.gradle의 dependencies에 `testCompile("org.assertj:assertj-core:3.11.1")` 추가해야 함

## Java 문법
### access modifier (접근 제어자)
- public : public 접근제어자가 붙은 변수, 메소드는 `어떤 클래스에서라도` 접근이 가능하다.
- private :  private 이 붙은 변수, 메소드는 `해당 클래스에서만` 접근이 가능하다.
- protected : protected가 붙은 변수, 메소드는 `동일 패키지내의 클래스` 또는 해당 `클래스를 상속받은 외부 패키지의 클래스`에서 접근이 가능하다.
- default : 접근제어자를 별도로 설정하지 않는다면 접근제어자가 없는 변수, 메소드는 default 접근제어자가 되어 `해당 패키지 내에서만` 접근이 가능하다.
### static, final
- static
    - 클래스 레벨에서 통용되는 변수, 함수
    - static 변수 (정적 변수) : 메모리에 고정적으로 할당되어 프로그램이 종료될 때 해체되는 변수, 클래스 변수이며 객체를 생성하지 않고도 접근 가능
    - static 메소드 (정적 메소드) : 객체의 생성 없이 호출 가능, 여러 객체가 하나의 메모리 참조   
- final
    - 객체 생성 이후에 객체에 한번만 할당되며 이후에 변경할 수 없음 // 즉 setter로 다시 변경 불가
    - 다른 클래스가 상속할 수 없음
- static final
    - 인스턴스가 만들어질 때마다 새로 메모리를 잡고 초기화시키지 말고, 클래스 레벨에서 한 번만 잡아서 하나의 메모리 공간을 사용하기 위해

### lambda
- 익명 함수
- python lambda와 비슷
```java
new Thread(new Runnable() { 
    public void run() {
        System.out.println("Annoymous Thread");
    }
}).start();
```
```java
new Thread(()->System.out.println("Lambda Thread")).start();
```