package com.itheima.test;

import com.itheima.Application;
import com.itheima.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * springboot整合junit+
 */
@RunWith(SpringJUnit4ClassRunner.class )
@SpringBootTest(classes = Application.class)//属性:用于指定引导类
public class SpringBootJunitTest{
    @Autowired
    private IUserService userService;

    @Test
    public void testFindAll(){
        List list=userService.findAll();
        System.out.println(list);
    }
    @Resource
    private Environment env;
    @Test
    public void testReadSpringBootConfig(){
        System.out.println(env.getProperty("spring.datasource.password"));
    }
    @Test
    public  void testRedisStringJava(){
        Jedis jedis=new Jedis("localhost");
        System.out.println("连接成功");
        //设置redis 字符串
        jedis.set("key88","hello reids");
        //获取存储的数据并输出
        System.out.println("redis 存储的字符串为："+jedis.get("key88"));
    }
   @Test
    public void testRedisListJava(){
        Jedis jedis=new Jedis("localhost");
        System.out.println("连接成功");
        //存储数据到list列表中
        jedis.rpush("site-list","Runoob");
        jedis.rpush("site-list","Google");
        jedis.rpush("site-list","taobao");
        jedis.rpush("site-list","Tianmao");
        //获取存储的数据并输出
        List<String>list=jedis.lrange("site-list",0,3);
        for (int i=0;i<list.size();i++){
            System.out.println("列表项为："+list.get(i));
        }

    }
    @Test
    public void testRedisJavaKeys(){
        Jedis jedis=new Jedis("localhost");
        System.out.println("连接成功");
        Set<String>keys=jedis.keys("*");
        Iterator<String>it=keys.iterator();
        while (it.hasNext()){
            String key=it.next();
            System.out.println(key);
        }
    }


}

