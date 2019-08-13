package com.sap.report.service;

/**
 * @author : Jenson.Liu
 * @date : 2019-08-13  18:05
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    private static int exprietime = 120;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void setExprietime(String key){
        stringRedisTemplate.expire( key,exprietime,TimeUnit.SECONDS );
    }

    public String getValue(String key){
        String value =  stringRedisTemplate.opsForValue().get(key);
        return value;
    }

    public void setValue(String key,String value){
        stringRedisTemplate.opsForValue().set(key,value);
    }

    public boolean existKey(String key){
        return stringRedisTemplate.hasKey( key );
    }

    public boolean delKey(String key){
        return stringRedisTemplate.delete(key);
    }

}


