package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberReopsitory;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberReopsitory memberReopsitory=new MemoryMemberRepository(); //MemoryMemberRepository 객체 생성

    public long join(Member member) {
        validateDuplicateMember(member); // 중복된 이름이 있는지 확인
        memberReopsitory.save(member); // memorymemberripoeisory의 store에 멤버 추가(멤버 저장)
        return member.getId();//member의 id 반환
    }

    private void validateDuplicateMember(Member member){

        memberReopsitory.findByName(member.getName())//이름으로 찾았을 때
                .ifPresent(m -> { // 이미 존재하는 이름이라면
                    throw new IllegalStateException("이미 존재하는 이름입니다"); //예외처리
                });
/*
    Optional<Member> result=memberRepository.findByName(member.getName());
    result.ifPresent(m->{
        throw new IllegalStateException("이미 존재하는 이름입니다");
    });

 */
    }

    public List<Member> findMembers(){
        return memberReopsitory.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberReopsitory.findById(memberId);
    }

}

