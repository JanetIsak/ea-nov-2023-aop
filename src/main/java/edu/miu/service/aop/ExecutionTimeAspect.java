package edu.miu.service.aop;

import edu.miu.service.domain.ActivityLog;
import edu.miu.service.domain.ActivityLogRepo;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Aspect
@RequiredArgsConstructor
public class ExecutionTimeAspect {

    private final ActivityLogRepo activityLogRepo;
    @Pointcut("@annotation(edu.miu.service.domain.ExecutionTime)")
    private void executionTimePointcut() {
    }

    @SneakyThrows
    @Around(value = "executionTimePointcut()")
    public Object calculateTimeTaken(ProceedingJoinPoint joinPoint){
        long startingTime = System.currentTimeMillis();
        Object runningJoinPoint = joinPoint.proceed();
        long endingTime = System.currentTimeMillis();
        long executionTimeDuration = (endingTime - startingTime);
        ActivityLog activityLog = new ActivityLog();
        activityLog.setDate(LocalDate.now());
        activityLog.setOperation(joinPoint.getSignature().getName());
        activityLog.setDuration(executionTimeDuration);

        activityLogRepo.save(activityLog);



        return runningJoinPoint;
    }
}
