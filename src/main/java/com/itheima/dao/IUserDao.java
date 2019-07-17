package com.itheima.dao;

import com.itheima.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public interface IUserDao extends JpaRepository<User,Long> {

}
