package shop.mtcoding.aopexam.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.aopexam.handler.aop.LoginUser;
import shop.mtcoding.aopexam.handler.aop.SessionUser;
import shop.mtcoding.aopexam.model.User;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final HttpSession session;

    @GetMapping("/login")
    public String login() {
        User user = new User(1, "ssar", "1234", "01012341234");
        session.setAttribute("principal", user);

        return "login ok";
    }

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();

        return "logout ok";
    }

    @GetMapping("/user/1") // 인증 필요없음
    public String userInfo() {

        return "ok";
    }

    @GetMapping("/auth/1")
    public String authInfo(@SessionUser User principal) {
        System.out.println("자동으로 값 주입됨");
        System.out.println(principal.getUsername());

        return "auth ok";
    }
}
