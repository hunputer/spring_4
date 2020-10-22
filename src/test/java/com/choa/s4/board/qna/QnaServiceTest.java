package com.choa.s4.board.qna;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.choa.s4.board.BoardDTO;
import com.choa.s4.util.Pager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class QnaServiceTest {
	
	@Autowired
	private QnaService qnaService;
	
	@Test
	public void QnaListTest() throws Exception{
		Pager pager = new Pager();
		List<BoardDTO> ar = qnaService.getList(pager);
		System.out.println(ar.size());
	}
}
