package com.itheima.domain;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="user")
public class User implements Serializable {
@Id
@Column(name="id")
@GeneratedValue(strategy = GenerationType.IDENTITY)//自动增长策略
 private  Long id;
@Column(name="user_name")
 private String user_name;
@Column(name="password")
 private String password;
@Column(name="name")
 private String name;

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
