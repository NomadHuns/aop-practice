package shop.mtcoding.aopexam.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.aopexam.model.User;

@Component
@Aspect
@RequiredArgsConstructor
public class LoginAdvice {

    @Pointcut("@annotation(shop.mtcoding.aopexam.handler.aop.LoginUser)")
    public void loginUser() {
    }

    @Around("execution(* shop.mtcoding.aopexam.controller..*.*(..))")
    public Object loginUserAdvice(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("테스트 : 1");
        // Object result = null;
        System.out.println("테스트 : 2");
        Object[] param = new Object[1];
        Object[] args = jp.getArgs();
        for (Object arg : args) {
            if (arg instanceof User) {
                HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                        .getRequest();
                HttpSession session = req.getSession();
                User principal = (User) session.getAttribute("principal");
                param[0] = principal;
                Object result = jp.proceed(param);
                return result;
            }
        }
        System.out.println("테스트 : 3");
        return jp.proceed();
    }

}
