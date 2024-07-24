package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service //component 자동스캔대상이라 스프링빈에 자동등록 됨
@Transactional(readOnly = true) //데이터변경은 이 어노테이션 필수
@RequiredArgsConstructor //final이 있는 필드만 가지고 생성자 자동으로 만들어줌(롬복참고)
public class MemberService {

    private final MemberRepository memberRepository;

    /*회원가입*/
    @Transactional
    public Long join(Member member){
        validateDuplicateMember(member);//중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    //중복회원검증 로직
    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());//같은 이름 있는지 확인, 유니크 제약조건 주는것도 좋은 방법(동시가입 이슈)
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //회원 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    //회원 단건 조회
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}
