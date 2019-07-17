package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface IUserMapper {
@Select("select * from user where name like'%${value}%'")
public List<User>findUserByName(String name);
@Select("select * from user")
public List<User>findAll();
}
