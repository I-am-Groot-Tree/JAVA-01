package work02.datasource.src.main.java.com.example.java.datasource.aop;

import com.example.java.datasource.bean.DBContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAop {
    /**
     * 只读：
     * select开头的方法  ||  get开头的方法
     */
    @Pointcut("(execution(* com.example.java.datasource.service..*.select*(..)))")
    public void readPointcut() {

    }

    /**
     * 写：
     */
    @Pointcut("execution(* com.example.java.datasource.service..*.insert*(..)) " +
            "|| execution(* com.example.java.datasource.service..*.update*(..)) " +
            "|| execution(* com.example.java.datasource.service..*.delete*(..))")
    public void writePointcut() {

    }

    @Before("readPointcut()")
    public void read() {
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write() {
        DBContextHolder.master();
    }
}
