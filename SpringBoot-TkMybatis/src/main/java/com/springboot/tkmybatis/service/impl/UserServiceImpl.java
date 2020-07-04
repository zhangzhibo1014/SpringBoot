package com.springboot.tkmybatis.service.impl;

import com.springboot.tkmybatis.domain.User;
import com.springboot.tkmybatis.mapper.UserMapper;
import com.springboot.tkmybatis.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }
}












