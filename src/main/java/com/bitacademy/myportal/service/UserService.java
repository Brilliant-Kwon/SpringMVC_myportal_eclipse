package com.bitacademy.myportal.service;

import com.bitacademy.myportal.vo.UserVo;

public interface UserService {

    public boolean join(UserVo vo);

    public UserVo getUser(String email);

    public UserVo getUser(String email, String password);
}
