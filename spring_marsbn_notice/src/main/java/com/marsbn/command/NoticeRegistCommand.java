package com.marsbn.command;

import java.util.Date;

import com.marsbn.dto.NoticeVO;

public class NoticeRegistCommand {
	private String n_title;
	private String n_content;
	private String n_writer;
	

	public String getN_title() {
		return n_title;
	}

	public void setN_title(String n_title) {
		this.n_title = n_title;
	}

	public String getN_content() {
		return n_content;
	}

	public void setN_content(String n_content) {
		this.n_content = n_content;
	}

	public String getN_writer() {
		return n_writer;
	}

	public void setN_writer(String n_writer) {
		this.n_writer = n_writer;
	}




	public NoticeVO toNoticeVO(){
		NoticeVO notice = new NoticeVO();
		notice.setN_content(this.n_content);
		notice.setN_title(this.n_title);
		notice.setN_writer(this.n_writer);
		
		return notice;
	}
}



