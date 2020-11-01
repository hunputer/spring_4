package com.choa.s4.board.boardFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choa.s4.board.BoardDTO;

@Service
public class BoardFileService {
	
	@Autowired
	private BoardFileDAO boardFileDAO;
	
	public BoardFileDTO getFile(BoardDTO boardDTO) {
		return boardFileDAO.getFile(boardDTO);
	}
}
