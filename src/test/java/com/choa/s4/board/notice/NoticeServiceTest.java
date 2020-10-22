package com.choa.s4.board.notice;

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
public class NoticeServiceTest {
	
	@Autowired
	private NoticeService noticeService;
	
	@Test
	public void getListTest() throws Exception{
		
		Pager pager = new Pager();
		List<BoardDTO> ar = noticeService.getList(pager);
		System.out.println(ar.size());
	}
}
