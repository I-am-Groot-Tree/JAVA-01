package com.example.redis.demo.redisDemo.service.impl;

import com.example.redis.demo.redisDemo.service.RedisDemoService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @ClassName DescProductServiceImpl
 * @description
 */
@Slf4j
@Service
public class RedisDemoServiceImpl implements RedisDemoService {

    private static final String DEFAULT_CACHE_PREFIX = "product_";

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public boolean testLock(String keyName) {
        String key = "test_lock_" + keyName;
        RLock lock = redissonClient.getLock(key);
        try {
            //加锁 操作很类似Java的ReentrantLock机制
            lock.lock();
            //模拟业务
            Thread.sleep(10000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //解锁
            lock.unlock();
        }
        return true;

    }

    @Override
    public boolean setProduct(String productId, String count) {
        set(productId, count);
        return true;
    }

    @Override
    public boolean descProduct(String productId) {
        String key = "desc_lock_" + productId;
        RLock lock = redissonClient.getLock(key);
        try {
            //加锁 操作很类似Java的ReentrantLock机制
            lock.lock();
            //模拟业务
            String count = get(productId);
            if (count == null) {
                log.warn("暂无该商品{}", productId);
                return false;
            }
            if (Integer.parseInt(count) <= 0) {
                log.warn("商品已抢光{}", productId);
                return false;
            }
            decr(productId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //解锁
            lock.unlock();
        }
        return true;
    }

    private void set(String key, String value) {
        try {
            redisTemplate.opsForValue().set(this.getCacheKey(key), value);
        } catch (Exception e) {
            log.error("redis缓存{}数据[{}]异常", this.getCacheKey(key), value, e);
        }
    }

    private void decr(String key) {
        try {
            redisTemplate.opsForValue().decrement(this.getCacheKey(key));
        } catch (Exception e) {
            log.error("redis自增数据[{}]异常", this.getCacheKey(key), e);
        }
    }

    private String get(String key) {
        try {
            return redisTemplate.opsForValue().get(this.getCacheKey(key));
        } catch (Exception e) {
            log.error("redis获取缓存[{}]异常", this.getCacheKey(key), e);
        }
        return null;
    }

    private String getCachePrefix() {
        return DEFAULT_CACHE_PREFIX;
    }

    private String getCacheKey(String key) {
        return StringUtils.startsWithIgnoreCase(key, getCachePrefix()) ? key : getCachePrefix() + key;
    }
}
