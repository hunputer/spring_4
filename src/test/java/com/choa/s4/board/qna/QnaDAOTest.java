package com.choa.s4.board.qna;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.choa.s4.board.BoardDTO;
import com.choa.s4.board.notice.NoticeDTO;
import com.choa.s4.util.Pager;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class QnaDAOTest {

	@Autowired
	private QnaDAO qnaDAO;
	
	@Test
	public void getList() throws Exception{
		Pager pager = new Pager();
		pager.makeRow();
		List<BoardDTO> ar = qnaDAO.getList(pager);
		System.out.println(ar.size());
	}

//	@Test
//	public void setInsertTest() throws Exception{
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setTitle("title test");
//		boardDTO.setWriter("writer test");
//		boardDTO.setContents("contents test");
//		int result = qnaDAO.setInsert(boardDTO);
//	}
}
