package hello.hellospring.repository;
import hello.hellospring.domain.Member;
import java.util.*;

public interface MemberReopsitory {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();

}
