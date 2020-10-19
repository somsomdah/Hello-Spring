
## Spring MVC 
- `Model` : 데이터 처리
- `View`: 화면 담당
- `Controller` : 요청을 처리하는 부분으로 뷰와 모델 사이의 통신, 주로 사용자의 요청을 처리 한 후 지정된 뷰에 모델 객체를 넘겨주는 역할을 한다.
                                             
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

 ## Controller
 ```java
@Controller
public class HelloController {
    @GetMapping("hello") //요청 주소
    public String hello(Model model){
        model.addAttribute("data","hello!!"); // hello.html의 {data} 부분에 "hello" 전달
        return "hello"; //hello.html display
    }

    @GetMapping("hello-mvc") // 주소
    public String helloMvc(@RequestParam("name") String name, Model model ){
        model.addAttribute("name",name); //get 방식으로 요청한 데이터 name을 넘겨줌
        return "hello-template"; //hello-templete.html display

    }

    @GetMapping("hello-string")
    @ResponseBody // http의 body에 내용을 넣어 response
    public String helloString(@RequestParam("name") String name){
        return "hello "+name; // get 방식으로 요청한 데이터를 넘겨주지만 html이 아닌 string 으로 보여줌 <-StringConverter
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello=new Hello();
        hello.setName(name);
        return hello; // json 객체로 보여줌 <- JsonConverter

    }

    static class Hello{
        private String name;
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name=name;
        }

    }
}

```
