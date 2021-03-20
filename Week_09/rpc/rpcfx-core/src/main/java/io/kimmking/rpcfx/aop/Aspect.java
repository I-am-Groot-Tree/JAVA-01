package io.kimmking.rpcfx.aop;

import io.kimmking.rpcfx.api.RpcfxRequest;
import io.kimmking.rpcfx.api.RpcfxResponse;
import io.kimmking.rpcfx.client.Rpcfx;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @ClassName Aspect
 * @description
 */
@Component
@org.aspectj.lang.annotation.Aspect
@Slf4j
public class Aspect {

    @Pointcut("execution(* io.kimmking.rpcfx.demo.api.*.*(..))")
    public void pointCut() {
    }

    @Around("pointCut()")
    public RpcfxResponse createService(ProceedingJoinPoint jp) {
        RpcfxResponse response = null;
        RpcfxRequest request = new RpcfxRequest();
        request.setServiceClass(jp.getTarget().getClass().getName());
        request.setMethod(jp.getSignature().getName());
        request.setParams(jp.getArgs());

        try {
            response = Rpcfx.post(request,"http://localhost:8080/");
            if (response.isStatus()){
                return response;
            }
        } catch (Exception e) {
            log.error("调用异常");
        }
        return response;
    }
}
