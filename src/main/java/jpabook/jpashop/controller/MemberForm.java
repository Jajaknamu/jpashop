package jpabook.jpashop.controller;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.EnableMBeanExport;

@Getter @Setter
public class MemberForm {

    @NotEmpty(message = "회원이름은 필수 기재")
    private String name;

    private String city;
    private String street;
    private String zipcode;
}
