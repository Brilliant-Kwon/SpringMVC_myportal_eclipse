package com.bitacademy.myportal.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.myportal.vo.GuestbookVo;

@Repository
public class GuestbookDaoImpl implements GuestbookDao{
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<GuestbookVo> selectAll() {
		return sqlSession.selectList("guestbook.selectAll");
	}

	@Override
	public int insert(GuestbookVo vo) {
		return 0;
	}

	@Override
	public int delete(GuestbookVo vo) {
		return 0;
	}
}
