package com.choa.s4.board.boardFile;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.choa.s4.board.BoardDAO;
import com.choa.s4.board.BoardDTO;
import com.choa.s4.board.notice.NoticeDTO;

@Repository
public class BoardFileDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private String NAMESPACE = "com.choa.s4.board.boardFile.BoardFileDAO.";
	
	public int setInsert(BoardFileDTO boardFileDTO) {
		return sqlSession.insert(NAMESPACE+"setInsert",boardFileDTO);
	}
	
	public BoardFileDTO getFile(BoardDTO boardDTO) {
		return sqlSession.selectOne(NAMESPACE+"getFile", boardDTO);
	}
}
