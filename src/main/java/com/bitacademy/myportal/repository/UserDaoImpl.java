package com.bitacademy.myportal.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.myportal.vo.UserVo;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    SqlSession sqlSession;

    @Override
    public int insert(UserVo vo) {
        return sqlSession.insert("users.insert", vo);
    }

    @Override
    public UserVo selectUser(String email) {
        return sqlSession.selectOne("users.selectEmail", email);
    }

    @Override
    public UserVo selectUser(String email, String password) {
        Map map = new HashMap();
        map.put("email",email);
        map.put("password",password);
        return sqlSession.selectOne("users.selectUser", map );
    }
}
