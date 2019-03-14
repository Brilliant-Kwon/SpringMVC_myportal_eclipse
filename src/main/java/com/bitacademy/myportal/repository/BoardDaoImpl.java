package com.bitacademy.myportal.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.myportal.vo.BoardVo;

@Repository
public class BoardDaoImpl implements BoardDao {
    @Autowired
    SqlSession sqlSession;

    @Override
    public List<BoardVo> selectAll() {
        List<BoardVo> list = null;
//        try {
            list = sqlSession.selectList("board.selectAll");
//        } finally {
//            sqlSession.close();
//        }
        return list;
    }

    @Override
    public int insert(BoardVo vo) {
        int insertedCount = 0;
//        try {
            insertedCount = sqlSession.insert("board.insert", vo);
//        } finally {
////            sqlSession.commit();
//            sqlSession.close();
//        }

        return insertedCount;
    }

    @Override
    public int delete(BoardVo vo) {
        int deletedCount = 0;
//        try {
            deletedCount = sqlSession.delete("board.delete", vo);
//        } finally {
////            sqlSession.commit();
//            sqlSession.close();
//        }

        return deletedCount;
    }

    @Override
    public BoardVo view(BoardVo vo) {
        BoardVo boardVo = null;
//        try {
            boardVo = sqlSession.selectOne("board.view", vo);
//        } finally {
////            sqlSession.commit();
//            sqlSession.close();
//        }

        return boardVo;
    }

    @Override
    public int update(BoardVo vo) {
        int updatedCount = 0;
//        try {
            updatedCount = sqlSession.update("board.modify", vo);
//        }finally {
////            sqlSession.commit();
//            sqlSession.close();
//        }

        System.out.println("dao : " + vo.toString());
        return updatedCount;
    }
}
