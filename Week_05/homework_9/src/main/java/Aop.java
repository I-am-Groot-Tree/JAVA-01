import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Aop {
    
    @Pointcut(value="execution(* Klass.show(..))")
    public void point(){
        
    }
    
    @Before(value="point()")
    public void before(){
        System.out.println("========>begin klass show...");
    }
    
    @AfterReturning(value = "point()")
    public void after(){
        System.out.println("========>after klass show...");
    }
    
    @Around("point()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("========>around begin klass show");
        joinPoint.proceed();
        System.out.println("========>around after klass show");
        
    }
    
}
