package hello.hellospring.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello"; //hello.html display
    }

    @GetMapping("hello-mvc") // 주소
    public String helloMvc(@RequestParam("name") String name, Model model ){
        model.addAttribute("name",name); //get방식으로 넘겨줌
        return "hello-template"; //hello-templete.html display

    }

    @GetMapping("hello-string")
    @ResponseBody // http의 body에 내용을 넣어 response
    public String helloString(@RequestParam("name") String name){
        return "hello "+name; // url로 보내준 데이터를 display <-StringConverter
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello=new Hello();
        hello.setName(name);
        return hello; // hello 객체 반환 (json) <- JsonConverter

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
