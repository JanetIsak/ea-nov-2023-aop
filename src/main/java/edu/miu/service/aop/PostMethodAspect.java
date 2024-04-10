package edu.miu.service.aop;

import edu.miu.service.exception.AopIsAwesomeHeaderException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
public class PostMethodAspect {

    @Pointcut("execution(* edu.miu.service..*(..)) && @annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void postPointcut(){

    }

    @Before(value = "postPointcut()")
    public void beforePostMethod(){

        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if(servletRequestAttributes.getRequest().getHeader("AOP-IS-AWESOME") == null) {
           throw new AopIsAwesomeHeaderException("Error thrown successfully");
        }


    }
}
