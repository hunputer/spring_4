package com.choa.s4.board;

import java.util.List;

import com.choa.s4.util.Pager;

public interface BoardService {

	//insert
		public int setInsert(BoardDTO boardDTO) throws Exception;
		
		//update
		public int setUpdate(BoardDTO boardDTO) throws Exception;
		
		//delete
		public int setDelete(BoardDTO boardDTO) throws Exception;
		
		//list
		public List<BoardDTO> getList(Pager pager) throws Exception;
	
		//one
		public BoardDTO getOne(BoardDTO boardDTO) throws Exception;
		
}
