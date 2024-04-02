package com.marsbn.service;

import java.sql.SQLException;
import java.util.List;

import com.marsbn.command.PageMaker;
import com.marsbn.dao.NoticeDAO;
import com.marsbn.dto.NoticeVO;


public class NoticeServiceImpl implements NoticeService{

	private NoticeDAO noticeDAO;
	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}
	@Override
	public List<NoticeVO> searchList(PageMaker pageMaker) throws SQLException {
		List<NoticeVO> noticeList = noticeDAO.selectSearchNoticeList(pageMaker);
		
		if(noticeList !=null) {
			for(NoticeVO notice : noticeList) {
			int n_number = notice.getN_number();
		}
	}
				
		int listTotalCount = noticeDAO.selectSearchNoticeListCount(pageMaker);
		pageMaker.setTotalCount(listTotalCount);
		
		return noticeList;
	}
	

	@Override
	public void increaseN_hit(int n_number) throws SQLException {
		noticeDAO.increaseN_hit(n_number);
		
	}
	

	@Override
	public void regist(NoticeVO notice) throws SQLException {

		
		int n_number = noticeDAO.selectNoticeSeqNext();
		
		notice.setN_number(n_number);
		
		noticeDAO.insertNotice(notice);
		

		}
		
	
	@Override
	public void modify(NoticeVO notice) throws SQLException {
		noticeDAO.updateNotice(notice);
		int n_number = notice.getN_number();
		
	}
	@Override
	public void remove(int n_number) throws SQLException {
		noticeDAO.deleteNotice(n_number);
		
	}
	@Override
	public NoticeVO detail(int n_number) throws SQLException {
	    return noticeDAO.selectNoticeByN_number(n_number);
	}

}
