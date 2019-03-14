package com.bitacademy.myportal.repository;

import java.util.List;

import com.bitacademy.myportal.vo.BoardVo;

public interface BoardDao {
    public List<BoardVo> selectAll();

    public int insert(BoardVo vo);

    public int delete(BoardVo vo);

    public BoardVo view(BoardVo vo);

    public int update(BoardVo vo);
}
