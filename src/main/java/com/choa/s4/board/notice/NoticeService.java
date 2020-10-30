package com.choa.s4.board.notice;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.choa.s4.board.BoardDAO;
import com.choa.s4.board.BoardDTO;
import com.choa.s4.board.BoardService;
import com.choa.s4.board.boardFile.BoardFileDAO;
import com.choa.s4.board.boardFile.BoardFileDTO;
import com.choa.s4.util.FileSaver;
import com.choa.s4.util.Pager;

@Service
public class NoticeService implements BoardService {

	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private FileSaver fileSaver;
	@Autowired
	private BoardFileDAO boardFileDAO;
	
	@Override
	public int setInsert(BoardDTO boardDTO, MultipartFile file, HttpSession httpSession) throws Exception {
		
		String path = httpSession.getServletContext().getRealPath("/resources/upload/member");
		File file2 = new File(path);
		String fileName = "";
		
		if(!file2.exists()) {
			file2.mkdir();
		}
		
		BoardFileDTO boardFileDTO = new BoardFileDTO();
		boardFileDTO.setOriName(file.getOriginalFilename());
		
		
		int result = noticeDAO.setInsert(boardDTO);
		boardFileDTO.setNum(boardDTO.getNum());
		
		if(file != null) {
			fileName = fileSaver.save(file2, file);
			boardFileDTO.setFileName(fileName);
			result = boardFileDAO.setInsert(boardFileDTO);
		}
		
		return result; 
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setDelete(boardDTO);
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		pager.makeRow();
		pager.setTotalCount(noticeDAO.getCount(pager));
		pager.makePage();
		return noticeDAO.getList(pager);
	}

	@Override
	public BoardDTO getOne(BoardDTO boardDTO) throws Exception {
		return noticeDAO.getOne(boardDTO);
	}

}
