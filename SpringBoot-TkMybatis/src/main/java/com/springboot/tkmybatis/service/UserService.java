package com.springboot.tkmybatis.service;

import com.springboot.tkmybatis.domain.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
}
