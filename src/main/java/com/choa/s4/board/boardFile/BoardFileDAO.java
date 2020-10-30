package com.choa.s4.board.boardFile;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardFileDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private String NAMESPACE = "com.choa.s4.board.boardFile.BoardFileDAO.";
	
	public int setInsert(BoardFileDTO boardFileDTO) {
		return sqlSession.insert(NAMESPACE+"setInsert",boardFileDTO);
	}
	
}
