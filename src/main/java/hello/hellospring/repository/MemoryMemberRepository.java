package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberReopsitory{

    private static Map<Long,Member> store = new HashMap<>();
    private static long sequence =0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);//1부터 순차적으로 member id 설정
        store.put(member.getId(), member); // member의 id와 member 객체 저장
        return member; // 저장된 상태의 멤버 반환 -- 굳이 필요 없을듯?
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));//아이디와 멤버객체가 저장된 map, store에서 id로 Optional<Member> 찾기
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values()// Map string의 value들 중에서(Member 객체들),
                .stream().filter(member -> member.getName().equals(name))//getname을 했을 때 euqals(name)인 member 찾기
                .findAny(); // 하나만 찾기
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // store 객체들 반환
    }

    public void clearStore(){
        store.clear();
    }
}
