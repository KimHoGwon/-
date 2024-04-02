package com.marsbn.dto;

import java.util.Date;

public class NoticeVO {
	
	private int n_number;
	private String n_content;
	private Date n_date;
	private int n_hit;
	private String n_title;
	private String n_writer;
	
	
	public int getN_number() {
		return n_number;
	}
	public void setN_number(int n_number) {
		this.n_number = n_number;
	}
	public String getN_content() {
		return n_content;
	}
	public void setN_content(String n_content) {
		this.n_content = n_content;
	}
	public Date getN_date() {
		return n_date;
	}
	public void setN_date(Date n_date) {
		this.n_date = n_date;
	}
	public int getN_hit() {
		return n_hit;
	}
	public void setN_hit(int n_hit) {
		this.n_hit = n_hit;
	}
	public String getN_title() {
		return n_title;
	}
	public void setN_title(String n_title) {
		this.n_title = n_title;
	}
	public String getN_writer() {
		return n_writer;
	}
	public void setN_writer(String n_writer) {
		this.n_writer = n_writer;
	}


}
