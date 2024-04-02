package com.marsbn.service;

import java.sql.SQLException;
import java.util.List;

import com.marsbn.command.PageMaker;
import com.marsbn.dto.NoticeVO;

public interface NoticeService {
	//목록
	List<NoticeVO> searchList(PageMaker pageMaker)throws SQLException;
	//읽기
	void increaseN_hit(int n_number) throws SQLException;
	
	NoticeVO detail(int n_number)throws SQLException;
	//등록
	void regist(NoticeVO notice)throws SQLException;
	//수정
	void modify(NoticeVO notice)throws SQLException;
	//삭제
	void remove(int n_number)throws SQLException;


}
