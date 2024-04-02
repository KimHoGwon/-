package com.marsbn.dao;

import java.sql.SQLException;
import java.util.List;


import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.transaction.annotation.Transactional;

import com.marsbn.command.PageMaker;
import com.marsbn.dto.NoticeVO;

public class NoticeDAOImpl implements NoticeDAO{
		
	private SqlSession sqlsession;
	public void setSqlSession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;}
	
	@Override
	public List<NoticeVO> selectSearchNoticeList(PageMaker pageMaker) throws SQLException {
	    if (sqlsession == null) {
	        throw new SQLException("SqlSession is not initialized.");
	    }

	    int offset = (pageMaker.getPage() - 1) * pageMaker.getPerPageNum();
	    int limit = pageMaker.getPerPageNum();

	    RowBounds rows = new RowBounds(offset, limit);

	    return sqlsession.selectList("Notice-Mapper.selectSearchNoticeList", pageMaker, rows);
	}
	
	@Override
	public int selectSearchNoticeListCount(PageMaker pageMaker) throws SQLException {
		return sqlsession.selectOne("Notice-Mapper.selectSearchNoticeListCount",pageMaker);
	}

	
	@Override
	public NoticeVO selectNoticeByN_number(int n_number) throws SQLException {
		return sqlsession.selectOne("Notice-Mapper.selectNoticeByN_number",n_number);

	}
	

	@Override
	public int selectNoticeSeqNext() throws SQLException {
	    int seq = sqlsession.selectOne("Notice-Mapper.selectNoticeSeqNext");
	    return seq;
	}
	
	@Override
	public void insertNotice(NoticeVO notice) throws SQLException {
		sqlsession.insert("Notice-Mapper.insertNotice",notice);
		
	}
	@Override
	public void updateNotice(NoticeVO notice) throws SQLException {
		sqlsession.update("Notice-Mapper.updateNotice", notice);

	}
	@Override
	public void deleteNotice(int n_number) throws SQLException {
		sqlsession.insert("Notice-Mapper.deleteNotice",n_number);
		
	}
	@Override
	public void increaseN_hit(int n_number) throws SQLException {
        sqlsession.update("Notice-Mapper.increaseN_hit", n_number);
	}
		
}
