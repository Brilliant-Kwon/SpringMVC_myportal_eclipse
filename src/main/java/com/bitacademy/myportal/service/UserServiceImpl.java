package com.bitacademy.myportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.myportal.repository.UserDao;
import com.bitacademy.myportal.vo.UserVo;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDaoImpl;

    @Override
    public boolean join(UserVo vo) {
        return userDaoImpl.insert(vo) == 1;
    }

    @Override
    public UserVo getUser(String email) {
        return userDaoImpl.selectUser(email);
    }

    @Override
    public UserVo getUser(String email, String password) {
        return userDaoImpl.selectUser(email,password);
    }
}
