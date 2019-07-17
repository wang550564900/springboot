package com.itheima.service.impl;

import com.itheima.dao.IUserDao;
import com.itheima.dao.IUserMapper;
import com.itheima.domain.User;
import com.itheima.service.IUserService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("userService")
public class UserServiceImpl implements IUserService {
  /* @Autowired//spring data jpa的实现
    private IUserDao userDao;


*/
  @Autowired
    RedisTemplate redisTemplate;

   @Autowired
   private IUserMapper userMapper;
    public List<User> findAllUser(String name) {
        return userMapper.findUserByName(name);
    }
    @Cacheable(value = "findAllCache",key="'user.findAll'")//表示当前方法使用缓存，并存入redis数据库中
                        //value属性：表示存入redis数据库的key
                        //key属性：用于指定方法执行返回值的key，该属性是spring用的，不写也有默认值
    public List<User>findAll(){
      System.out.println("执行去数据库查询");
        return userMapper.findAll();
    }
}
