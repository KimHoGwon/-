package com.marsbn.dao;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.marsbn.command.PageMaker;
import com.marsbn.dto.NoticeVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/marsbn/context/root-context.xml")
@Transactional
public class TestNoticeDAOImpl {

		@Autowired
		private NoticeDAO noticeDAO;
		
		@Test
		public void testSelectNoticeList()throws Exception{
			
		    PageMaker pageMaker = new PageMaker();
		    pageMaker.setPage(1); // 예시로 1페이지를 설정
		    pageMaker.setPerPageNum(10); // 예시로 페이지당 아이템 개수를 10으로 설정

			List<NoticeVO> noticeList = noticeDAO.selectSearchNoticeList(pageMaker);
			Assert.assertEquals(3, noticeList.size());
		}
		@Test
		public void testSelectNoticeByN_number()throws Exception{
			int testN_number = 1;
			NoticeVO notice = noticeDAO.selectNoticeByN_number(testN_number);
			Assert.assertEquals(notice.getN_number(), testN_number);
		}

		int insertn_number = 7;
		@Test
		@Rollback

		public void testInsertNotice() throws Exception{
			NoticeVO notice = new NoticeVO();
			notice.setN_number(insertn_number);
			notice.setN_content("공지사항 내용 7");
			notice.setN_date(new Date());
			notice.setN_hit(0);
			notice.setN_title("공지사항 제목 7");
			notice.setN_writer("66");
			
			noticeDAO.insertNotice(notice);
			
			NoticeVO getNot = noticeDAO.selectNoticeByN_number(notice.getN_number());
			
			Assert.assertEquals(notice.getN_number(), getNot.getN_number());
		}

		@Test
		@Rollback
		public void testUpdateNotice() throws Exception{
			int testn_number = 1;
			String testN_title = "wp7";
			NoticeVO targetnotice = noticeDAO.selectNoticeByN_number(testn_number);
			
			Assert.assertNotEquals(testN_title, targetnotice.getN_title());
			
			targetnotice.setN_title(testN_title);
			
			noticeDAO.updateNotice(targetnotice);
			
			NoticeVO getNot = noticeDAO.selectNoticeByN_number(testn_number);
			
			Assert.assertEquals(testN_title, getNot.getN_title());
		
		}

		@Test
		@Rollback
		public void testDeleteNotice() throws Exception{
	
			testInsertNotice();
			NoticeVO targetnotice = noticeDAO.selectNoticeByN_number(insertn_number);
			
			Assert.assertEquals(insertn_number, targetnotice.getN_number());
			
			noticeDAO.deleteNotice(insertn_number);
			
			NoticeVO deleteNotice = noticeDAO.selectNoticeByN_number(insertn_number);
			
			Assert.assertNull(deleteNotice);
		}
		
		
}
	