package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import redis.clients.jedis.Jedis;


/**
 * springboot引导类
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    //连接本地的 redis 服务
       // Jedis jedis=new Jedis("localhost");
       // System.out.println("连接成功");
        //查看服务是否运行
      //  System.out.println("服务正在运行:"+ jedis.ping());
    }

}
