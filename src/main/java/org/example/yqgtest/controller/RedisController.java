package org.example.yqgtest.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.yqgtest.redis.RedisUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RequestMapping("/redis")
@RestController
public class RedisController {

  @Resource
  private RedisUtil redisUtil;

  @RequestMapping("set")
  public boolean redisSet(String key, String value){
    System.out.println(key+"--"+value);
    return redisUtil.set(key,value);
  }

  @RequestMapping("get")
  public Object redisGet(String key){
    System.out.println(redisUtil.get(key));
    return redisUtil.get(key);
  }

  @RequestMapping("expire")
  public boolean expire(String key,long ExpireTime){
    return redisUtil.expire(key,ExpireTime);
  }

}
