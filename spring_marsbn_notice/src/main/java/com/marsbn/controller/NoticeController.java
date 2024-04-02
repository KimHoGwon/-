package com.marsbn.controller;


import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.marsbn.command.NoticeModifyCommand;
import com.marsbn.command.NoticeRegistCommand;
import com.marsbn.command.PageMaker;
import com.marsbn.dto.NoticeVO;
import com.marsbn.service.NoticeService;




@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@GetMapping("/list")
	public ModelAndView list(PageMaker pageMaker, ModelAndView mnv) throws Exception {
		String url="/notice/list";
		
		List<NoticeVO> noticeList = noticeService.searchList(pageMaker);
		
		mnv.addObject("noticeList",noticeList);
		mnv.setViewName(url);
		return mnv;
	}
	

	@GetMapping("/registForm")
	public ModelAndView registForm(ModelAndView mnv) throws Exception {
		String url = "/notice/regist";
		mnv.setViewName(url);
		return mnv;
	}

	@PostMapping(value = "/regist", produces = "text/plain;charset=utf-8")
	public ModelAndView regist(NoticeRegistCommand regCommand, ModelAndView mnv) throws Exception {
		String url = "/notice/regist_success";
	
		
		NoticeVO notice = regCommand.toNoticeVO();

	    notice.setN_date(new Date());
		
		noticeService.regist(notice);
		mnv.setViewName(url);

		return mnv;
	}

	@GetMapping("/detail")
	public ModelAndView detail(int n_number, HttpSession session, String from, ModelAndView mnv) throws Exception {
	    String url = "/notice/detail";

	    NoticeVO notice = null;
	    noticeService.increaseN_hit(n_number);
        
	  
	    notice = noticeService.detail(n_number);
	  
	    mnv.addObject("notice", notice);
	    mnv.setViewName(url);
	    return mnv;
	}
	
	@GetMapping("/modifyForm")
	public ModelAndView modifyForm(int n_number,ModelAndView mnv)throws Exception{
		String url = "/notice/modify";

		NoticeVO notice = noticeService.detail(n_number);

		mnv.addObject("notice", notice);
		mnv.setViewName(url);
		return mnv;
	}
	
	@PostMapping("/modify")
	public ModelAndView modify(NoticeModifyCommand modifyCommand, ModelAndView mnv)throws Exception{
			String url = "/notice/modify_success";

			NoticeVO notice = modifyCommand.toNoticeVO();

			noticeService.modify(notice);
			
			mnv.setViewName(url);
			
			return mnv;
	}
	
	@GetMapping("/remove")
	public ModelAndView remove(int n_number, ModelAndView mnv)throws Exception{
		String url="/notice/remove_success";
		
	    ModelAndView notice = new ModelAndView();
		noticeService.remove(n_number);
		
		mnv.setViewName(url);
		return mnv;
	}
}



	




