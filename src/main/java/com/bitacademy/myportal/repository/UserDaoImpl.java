package com.bitacademy.myportal.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.myportal.exception.UserDaoException;
import com.bitacademy.myportal.vo.UserVo;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    SqlSession sqlSession;

    @Override
    public int insert(UserVo vo) throws UserDaoException {
        int insertedCount = 0;
        try {
            insertedCount = sqlSession.insert("users.insert", vo);
        } catch (Exception e) {
            System.err.println("DAO:Error : " + e.getMessage());
            UserDaoException ex = new UserDaoException("회원 가입 중 오류");
            ex.setVo(vo);
            throw ex;
        }
        return insertedCount;
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
