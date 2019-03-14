package com.bitacademy.myportal.service;

import java.util.List;

import com.bitacademy.myportal.vo.BoardVo;

public interface BoardService {

    public List<BoardVo> getList();

    public boolean write(BoardVo vo);

    public boolean delete(BoardVo vo);

    public BoardVo view(BoardVo vo);

    public boolean modify(BoardVo vo);
}
