package jpabook.jpashop.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j //로그찍는 어노테이션
public class HomeController {

    @RequestMapping("/") //첫번째화면 여기로 잡힘
    public String home() {
        log.info("home controller");
        return "home"; //home.html 파일로 타임리프가 찾아들어감
    }
}
