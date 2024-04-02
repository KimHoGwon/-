package com.marsbn.command;

import com.marsbn.dto.NoticeVO;

public class NoticeModifyCommand extends NoticeRegistCommand{
	
	
	private int n_number;
	
	

	public int getN_number() {
		return n_number;
	}
	public void setN_number(int n_number) {
		this.n_number = n_number;
	}

	   @Override
	   public NoticeVO toNoticeVO() {
	      NoticeVO notice = super.toNoticeVO();
	      notice.setN_number(this.n_number);
	      
	      return notice;
	   }
		
	
}
