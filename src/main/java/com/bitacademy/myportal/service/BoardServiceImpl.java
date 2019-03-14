package com.bitacademy.myportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.myportal.repository.BoardDao;
import com.bitacademy.myportal.vo.BoardVo;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    BoardDao boardDaoImpl;

    @Override
    public List<BoardVo> getList() {
        return boardDaoImpl.selectAll();
    }

    @Override
    public boolean write(BoardVo vo) {
        int insertedCount = boardDaoImpl.insert(vo);
        return insertedCount == 1;
    }

    @Override
    public boolean delete(BoardVo vo) {
        int deletedCount = boardDaoImpl.delete(vo);
        return deletedCount == 1;
    }

    @Override
    public BoardVo view(BoardVo vo) {
        return boardDaoImpl.view(vo);
    }

    @Override
    public boolean modify(BoardVo vo) {
        System.out.println("service : " + vo.toString());
        return 1 == boardDaoImpl.update(vo);
    }
}
