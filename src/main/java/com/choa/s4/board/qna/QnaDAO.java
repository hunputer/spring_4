package com.choa.s4.board.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.choa.s4.board.BoardDAO;
import com.choa.s4.board.BoardDTO;
import com.choa.s4.util.Pager;

@Repository
public class QnaDAO implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.choa.s4.board.qna.QnaDAO.";
	
	@Override
	public int setInsert(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE+"setInsert", boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE+"setUpdate",boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"setDelete", boardDTO);
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+"getList",pager);
	}

	@Override
	public BoardDTO getOne(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getOne", boardDTO);
	}

	@Override
	public long getCount(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"getCount",pager);
	}
	
	public int setReply(BoardDTO boardDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setReply", boardDTO);
	}
	
	public int setReplyUpdate(BoardDTO boardDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setReplyUpdate", boardDTO);
	}

}
