package shop.mtcoding.aopexam.handler;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class HelloAdvice {

    // 깃발에 별칭주기
    @Pointcut("@annotation(shop.mtcoding.aopexam.handler.aop.Hello)")
    public void hello() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void getMapping() {
    }

    // @Before("hello()")
    // public Object helloAdvice() {
    //     System.out.println("hi!");
    //     return null;
    // }

    // @After("getMapping() || hello()")
    // public Object getMappingAdvice() {
    // System.out.println("헉헉");
    // return null;
    // }

    // @Around("hello()")
    // public Object helloAdvice(ProceedingJoinPoint jp) throws Throwable {
    // Object[] args = jp.getArgs();
    // System.out.println("파라메터 사이즈 : " + args.length);
    // for (Object arg : args) {
    // if (arg instanceof String) {
    // String username = (String) arg;
    // System.out.println(username + "님 안녕");
    // }
    // }
    // return jp.proceed();
    // }
}
