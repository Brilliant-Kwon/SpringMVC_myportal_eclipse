package com.bitacademy.myportal.repository;

import com.bitacademy.myportal.vo.UserVo;

public interface UserDao {

    public int insert(UserVo vo);

    public UserVo selectUser(String email);

    public UserVo selectUser(String email, String password);
}
