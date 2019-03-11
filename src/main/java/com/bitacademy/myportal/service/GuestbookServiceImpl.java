package com.bitacademy.myportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.myportal.repository.GuestbookDao;
import com.bitacademy.myportal.vo.GuestbookVo;

@Service
public class GuestbookServiceImpl implements GuestbookService {
	@Autowired
    GuestbookDao guestbookDaoImpl;
	
    @Override
    public List<GuestbookVo> getMessageList() {
    	return guestbookDaoImpl.selectAll();
    }

    @Override
    public boolean writeMessage(GuestbookVo vo) {
        int insertedCount = guestbookDaoImpl.insert(vo);
        return insertedCount == 1;
    }

    @Override
    public boolean deleteMessage(GuestbookVo vo) {
        int deletedCount = guestbookDaoImpl.delete(vo);
        return deletedCount == 1;
    }
}