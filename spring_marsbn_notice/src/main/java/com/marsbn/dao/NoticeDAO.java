package com.marsbn.dao;

import java.sql.SQLException;
import java.util.List;

import com.marsbn.command.PageMaker;
import com.marsbn.dto.NoticeVO;

public interface NoticeDAO {
	
	List<NoticeVO> selectSearchNoticeList(PageMaker pageMaker)throws SQLException;
	int selectSearchNoticeListCount(PageMaker pageMaker)throws SQLException;
	NoticeVO selectNoticeByN_number(int n_number)throws SQLException;
	int selectNoticeSeqNext()throws SQLException;
	
	void insertNotice(NoticeVO notice)throws SQLException;
	void updateNotice(NoticeVO notice)throws SQLException;
	void deleteNotice(int n_number)throws SQLException;
	void increaseN_hit(int n_number)throws SQLException;


	

}
