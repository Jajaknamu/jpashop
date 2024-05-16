package jpabook.jpashop.domain.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }
    public Member findOne(Long id){
        return em.find(Member.class, id); //멤버를 찾아서 반환해줌
    }
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)//처음엔 jpql 쓰고, 두번째는 반환타입
                .getResultList(); //인라인으로 합쳐줌
    }
    //이름으로 조회하는 기능
    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
