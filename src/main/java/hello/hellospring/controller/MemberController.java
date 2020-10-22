package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired // 멤버 컨트롤러가 생성이 될 때 스프링 빈에 등록되어 있는 멤버 서비스 객체를 가져다가 넣어줌-> dependency injection (의존관계 설정)
    public MemberController(MemberService memberService){
        this.memberService=memberService;
    }
}
