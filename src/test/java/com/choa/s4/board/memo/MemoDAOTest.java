package com.choa.s4.board.memo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class MemoDAOTest {
	
	@Autowired
	private MemoDAO memoDAO;
	
	@Test
	public void setInsertTest()throws Exception{
		for(int i=0;i<100;i++) {
			MemoDTO memoDTO = new MemoDTO();
			memoDTO.setWriter("writer"+i);
			memoDTO.setContents("contents"+i);
			memoDAO.setInsert(memoDTO);
			if(i%10==0) {
				Thread.sleep(1000);
			}
		}
		System.out.println("Insert Finish");
	}
}
