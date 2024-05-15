package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "memebr_id")
    private Long id;
    private String name;

    @Embedded //@Embeddable이거나 둘중 하나만 있어도 됨.둘다 쓰는걸 권장. 내장타입인지 확인용
    private Address address;
    @OneToMany(mappedBy = "member") //읽기 전용이 된다는 거
    private List<Order> orders = new ArrayList<>();
}
