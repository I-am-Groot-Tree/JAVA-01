package com.example.redis.demo.redisDemo.service;

public interface RedisDemoService {

    boolean testLock(String keyName);

    boolean setProduct(String productId, String count);

    boolean descProduct(String productId);
}
