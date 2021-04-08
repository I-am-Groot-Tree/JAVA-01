package com.example.redis.demo.redisDemo.controller;

import com.example.redis.demo.redisDemo.service.RedisDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @ClassName DescProductController
 * @description
 */
@Slf4j
@RestController
public class DescProductController {
    // 请求总数
    public static int clientTotal = 5000;
    // 同时并发执行的线程数
    public static int threadTotal = 200;

    @Autowired
    private RedisDemoService productService;

    @GetMapping("lock")
    public String lock() {
        productService.testLock("product");
        return "success";
    }

    @GetMapping("setProduct")
    public String setProduct(String productId, String count) {
        productService.setProduct(productId, count);
        return "success";
    }

    @GetMapping("descProduct")
    public String descProduct(String productId) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //信号量，此处用于控制并发的线程数
        final Semaphore semaphore = new Semaphore(threadTotal);
        //闭锁，可实现计数器递减
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal ; i++) {
            executorService.execute(() -> {
                try {
                    //执行此方法用于获取执行许可，当总计未释放的许可数不超过200时，
                    //允许通行，否则线程阻塞等待，直到获取到许可。
                    semaphore.acquire();
                    productService.descProduct(productId);
                    //释放许可
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception", e);
                }
                //闭锁减一
                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await();//线程阻塞，直到闭锁值为0时，阻塞才释放，继续往下执行
        } catch (InterruptedException e) {
            log.error("exception", e);
        }
        executorService.shutdown();
        return "success";
    }
}
